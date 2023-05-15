package com.wenabi.interview.domain;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Wish {
    private Long id;
    private String status;
    private ZonedDateTime createdDate;
    private Profile volunteerProfile;
    private Initiative initiative;
}
