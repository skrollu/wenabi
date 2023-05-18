package com.wenabi.interview.web.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InitiativeOutputDto {
    private Long id;
    private String title;
    private String streetName;
    private String city;
    private String postalCode;
    private String country;
    private ProfileOutputDto coordinatorProfile;
}