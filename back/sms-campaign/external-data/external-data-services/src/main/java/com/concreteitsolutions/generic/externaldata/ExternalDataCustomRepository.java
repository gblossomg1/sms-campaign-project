package com.concreteitsolutions.generic.externaldata;

import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.generic.externaldata.model.ExternalData;

import java.util.List;

public interface ExternalDataCustomRepository {
    List<ExternalDataSource> searchExternalData(ExternalDataSource externalDataSource);
}
