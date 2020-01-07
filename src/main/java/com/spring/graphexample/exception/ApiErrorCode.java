package com.spring.graphexample.exception;

import lombok.Getter;

@Getter
public enum ApiErrorCode {
    VALIDATION_ERROR,
    NOT_FOUND,
    INTERNAL_SERVER_ERROR;
}