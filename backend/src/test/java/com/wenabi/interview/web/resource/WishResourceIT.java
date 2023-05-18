package com.wenabi.interview.web.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class WishResourceIT {

    private static final String BASE_URL = "/api/wishes";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getWishesByPageAndSortedByStatus_withoutParams_givesAnAscendingSortedPageOfSize10ByDefault() throws Exception {
        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size", is(10)))
                .andExpect(jsonPath("$.content[0].status", is("APPLICATION")))
                .andExpect(jsonPath("$.content[9].status", is("USER_HAS_PARTICIPATED")))
        ;
    }

    @Test
    void getWishesByPageAndSortedByStatus_withASortParam_givesTheAccordingPage() throws Exception {
        mockMvc.perform(get(BASE_URL + "?sort=id"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size", is(10)))
                .andExpect(jsonPath("$.content[0].id", is(1)))
                .andExpect(jsonPath("$.content[1].id", is(2)))
                .andExpect(jsonPath("$.content[2].id", is(3)))
                .andExpect(jsonPath("$.content[3].id", is(4)))
                .andExpect(jsonPath("$.content[4].id", is(5)))
                .andExpect(jsonPath("$.content[5].id", is(6)))
                .andExpect(jsonPath("$.content[6].id", is(7)))
                .andExpect(jsonPath("$.content[7].id", is(8)))
                .andExpect(jsonPath("$.content[8].id", is(9)))
                .andExpect(jsonPath("$.content[9].id", is(10)))
        ;
    }

    @Test
    void getWishesByPageAndSortedByStatus_withASortParamWithDescendingDirection_givesTheAccordingPage() throws Exception {
        mockMvc.perform(get(BASE_URL + "?sort=id,DESC"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size", is(10)))
                .andExpect(jsonPath("$.content[0].id", is(12)))
                .andExpect(jsonPath("$.content[1].id", is(11)))
                .andExpect(jsonPath("$.content[2].id", is(10)))
                .andExpect(jsonPath("$.content[3].id", is(9)))
                .andExpect(jsonPath("$.content[4].id", is(8)))
                .andExpect(jsonPath("$.content[5].id", is(7)))
                .andExpect(jsonPath("$.content[6].id", is(6)))
                .andExpect(jsonPath("$.content[7].id", is(5)))
                .andExpect(jsonPath("$.content[8].id", is(4)))
                .andExpect(jsonPath("$.content[9].id", is(3)))
        ;
    }

    @Test
    void getWishesByPageAndSortedByStatus_withCombinedParams_givesTheAccordingPage() throws Exception {
        mockMvc.perform(get(BASE_URL + "?page=1&sort=id,ASC"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size", is(2)))
                .andExpect(jsonPath("$.content[0].id", is(11)))
                .andExpect(jsonPath("$.content[1].id", is(12)))
        ;
    }
}
