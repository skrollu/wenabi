package com.wenabi.interview.web.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProfileOutputDto {
    private Long id;
    private String firstName;
    private String lastName;
    private CompanyOutputDto company;
}