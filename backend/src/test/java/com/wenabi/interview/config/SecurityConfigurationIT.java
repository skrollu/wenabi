package com.wenabi.interview.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SecurityConfigurationIT {

    private static final String BASE_URL = "/api/wishes";
    private static final String USERNAME = "association_user";
    private static final String PASSWORD = "password";

    @Autowired
    private MockMvc mockMvc;

    private static RequestPostProcessor authorization() {
        return httpBasic(USERNAME, PASSWORD);
    }

    @Test
    void getWishesByPageAndSortedByStatus_withoutAuthentication_givesA401Response() throws Exception {
        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isUnauthorized())
        ;
    }

    @WithMockUser(roles = {"USER"})
    @Test
    void getWishesByPageAndSortedByStatus_withWrongRole_givesA403Response() throws Exception {
        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isForbidden())
        ;
    }

    @WithMockUser(roles = {"ASSOCIATION"})
    @Test
    void getWishesByPageAndSortedByStatus_withoutAuthentication_givesA200Response() throws Exception {
        mockMvc.perform(get(BASE_URL).with(authorization()))
                .andExpect(status().isOk())
        ;
    }
}
