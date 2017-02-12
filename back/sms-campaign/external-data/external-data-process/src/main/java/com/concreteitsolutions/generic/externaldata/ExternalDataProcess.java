package com.concreteitsolutions.generic.externaldata;


import java.io.InputStream;

public interface ExternalDataProcess {

    void importExternalData(final InputStream file, com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource externalDataSource);
}
