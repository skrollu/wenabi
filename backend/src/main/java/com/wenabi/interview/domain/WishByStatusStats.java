package com.wenabi.interview.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class WishByStatusStats {

    private String status;
    private Long count;
}
