package com.wenabi.interview.domain;

import lombok.Data;

@Data
public class Profile {
    private Long id;
    private String firstName;
    private String lastName;
    private Company company;
}