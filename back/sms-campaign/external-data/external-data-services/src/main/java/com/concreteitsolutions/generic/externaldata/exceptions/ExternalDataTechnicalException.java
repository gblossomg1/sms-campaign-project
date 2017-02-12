package com.concreteitsolutions.generic.externaldata.exceptions;


import com.concreteitsolutions.commonframework.core.exceptions.CustomError;
import com.concreteitsolutions.commonframework.core.exceptions.CustomException;

public class ExternalDataTechnicalException extends CustomException {

    public ExternalDataTechnicalException(CustomError error) {
        super(error);
    }

    public ExternalDataTechnicalException(CustomError error, String message) {
        super(error, message);
    }

    public enum ExternalDataError implements CustomError {

        FILE_INPUT_ERROR,
        EXTERNAL_DATA_FORMAT_NOT_SUPPORTED;

        public String message() {
            return this.name();
        }
    }
}
