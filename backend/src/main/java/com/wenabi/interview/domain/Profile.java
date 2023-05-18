package com.wenabi.interview.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Profile {
    private Long id;
    private String firstName;
    private String lastName;
    private Company company;
}