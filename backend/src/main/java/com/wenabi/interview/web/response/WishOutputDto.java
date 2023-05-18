package com.wenabi.interview.web.response;

import com.wenabi.interview.domain.Initiative;
import com.wenabi.interview.domain.Profile;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Builder
@Data
public class WishOutputDto {
    private Long id;
    private String status;
    private ZonedDateTime createdDate;
    private Profile volunteerProfile;
    private Initiative initiative;
}
