package com.spring.graphexample.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({
	"status",
	"code",
	"message"
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {

	private String status;
    private Integer code;
    private String message;
}
