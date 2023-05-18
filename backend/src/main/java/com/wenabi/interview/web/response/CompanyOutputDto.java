package com.wenabi.interview.web.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CompanyOutputDto {
    private Long id;
    private String name;
}