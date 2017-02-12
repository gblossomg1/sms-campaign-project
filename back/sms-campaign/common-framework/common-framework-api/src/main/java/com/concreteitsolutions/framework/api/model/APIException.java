package com.concreteitsolutions.framework.api.model;

import com.concreteitsolutions.commonframework.core.exceptions.CustomError;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIException {

	private ExceptionType exceptionType;

	private CustomError code;

	private String message;

	private String developerMessage;

}
