package com.concreteitsolutions.commonframework.core.externaldata;

public enum ExternalDataSourceFormat {
    EXCEL("EXCEL"),
    CSV("CSV");

    private final String format;

    ExternalDataSourceFormat(String format) {
        this.format = format;
    }

    public static ExternalDataSourceFormat from(final String format) {
        switch(format) {

            case "EXCEL":
                return EXCEL;

            case "CSV":
                return CSV;

            default:
                //TODO: Throw new ExternalDataFunctionalException instead
                throw new IllegalArgumentException();
        }
    }

}
