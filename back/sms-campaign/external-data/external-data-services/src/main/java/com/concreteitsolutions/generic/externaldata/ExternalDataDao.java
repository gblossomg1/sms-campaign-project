package com.concreteitsolutions.generic.externaldata;

import com.concreteitsolutions.generic.externaldata.model.ExternalData;

import java.io.InputStream;
import java.util.List;

public interface ExternalDataDao {

    List<ExternalData> retrieveExternalDataFromExternalFile(final InputStream inputStream);

}
