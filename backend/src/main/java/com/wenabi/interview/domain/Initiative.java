package com.wenabi.interview.domain;

import lombok.Data;

@Data
public class Initiative {
    private Long id;
    private String title;
    private String streetName;
    private String city;
    private String postalCode;
    private String country;
    private Profile coordinatorProfile;
}