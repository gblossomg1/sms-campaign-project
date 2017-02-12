package com.concreteitsolutions.commonframework.core.exceptions;

public class CommonTechnicalException extends CustomException{

    public CommonTechnicalException(CustomError error) {
        super(error);
    }

    public enum CommonError implements CustomError {
        UNKNOWN_PATH;


        public String message() {
            return this.name();
        }
    }
}
