package com.wenabi.interview.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class WishByStatusStatOutputDto {

    private String status;
    private Long number;
}
