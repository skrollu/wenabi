package com.wenabi.interview.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Company {
    private Long id;
    private String name;
}