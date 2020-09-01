package com.sabi11.hometracking.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
@Builder
public class CustomErrorDetails {

    private Date timestamp;
    private String message;
    private String errorDetails;
}
