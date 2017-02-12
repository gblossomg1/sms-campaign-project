package com.concreteitsolutions.generic.prospect;

import java.io.InputStream;
import java.util.List;

import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.generic.prospect.model.Prospect;
import com.concreteitsolutions.generic.prospect.model.ProspectSearchCriteria;

public interface ProspectService {

    List<Prospect> findAll();

    List<Prospect> find(final ProspectSearchCriteria criteria, final Long length);

    void saveAll(final List<Prospect> prospects);

    List<Prospect> findByExternalDataSource(final ExternalDataSource externalDataSourceId);
}
