package com.meli.Quasar.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ApiError {
	private Integer status;
	private String error;
	private String message;
}
