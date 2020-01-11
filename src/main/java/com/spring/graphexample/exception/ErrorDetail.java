package com.spring.graphexample.exception;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Validated
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {

	private String status;
    private Integer code;
    private String message;
}
