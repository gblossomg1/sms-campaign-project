package com.concreteitsolutions.generic.externaldata;


import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.generic.externaldata.model.ExternalData;

import java.io.InputStream;
import java.util.List;

public interface ExternalDataService {

    List<ExternalData> retrieveDataFromExternalFile(InputStream inputStream, ExternalDataSource externalDataSource);

    List<ExternalDataSource> searchExternalData(ExternalDataSource externalDataSource);

    ExternalDataSource findById(Long id);

    void saveExternalData(ExternalDataSource externalDataSource);
}
