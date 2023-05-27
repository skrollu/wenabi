package com.wenabi.interview.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class WishByStatusStatsModel{

    private String status;
    private Long count;
}
