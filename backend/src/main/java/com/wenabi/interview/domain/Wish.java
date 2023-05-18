package com.wenabi.interview.domain;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Builder
@Data
public class Wish {
    private Long id;
    private String status;
    private ZonedDateTime createdDate;
    private Profile volunteerProfile;
    private Initiative initiative;
}
