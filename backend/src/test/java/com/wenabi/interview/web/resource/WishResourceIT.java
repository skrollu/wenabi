package com.wenabi.interview.web.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class WishResourceIT {

    private static final String BASE_URL = "/api/wishes";
    private static final String USERNAME = "association_user";
    private static final String PASSWORD = "password";

    @Autowired
    private MockMvc mockMvc;

    private static RequestPostProcessor authorization() {
        return httpBasic(USERNAME, PASSWORD);
    }

    @Test
    void getWishesByPageAndSortedByStatus_withoutParams_givesAnAscendingSortedPageOfSize10ByDefault() throws Exception {
        mockMvc.perform(get(BASE_URL).with(authorization()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size", is(10)))
                .andExpect(jsonPath("$.content[0].status", is("DISCUSSION")))
                .andExpect(jsonPath("$.content[1].status", is("WAITING_ASSOCIATION_VALIDATION")))
        ;
    }

    @Test
    void getWishesByPageAndSortedByStatus_withASortParam_givesTheAccordingPage() throws Exception {
        mockMvc.perform(get(BASE_URL + "?sort=id").with(authorization()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size", is(10)))
                .andExpect(jsonPath("$.content[0].id", is(1)))
                .andExpect(jsonPath("$.content[1].id", is(3)))
        ;
    }

    @Test
    void getWishesByPageAndSortedByStatus_withASortParamWithDescendingDirection_givesTheAccordingPage() throws Exception {
        mockMvc.perform(get(BASE_URL + "?sort=id,DESC").with(authorization()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size", is(10)))
                .andExpect(jsonPath("$.content[0].id", is(3)))
                .andExpect(jsonPath("$.content[1].id", is(1)))
        ;
    }

    @Test
    void getWishesByPageAndSortedByStatus_withCombinedParams_givesTheAccordingPage() throws Exception {
        mockMvc.perform(get(BASE_URL + "?page=0&sort=id,ASC&size=1").with(authorization()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size", is(1)))
                .andExpect(jsonPath("$.content[0].id", is(1)))
        ;
    }
}
