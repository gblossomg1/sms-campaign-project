package com.concreteitsolutions.generic.externaldata;


import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSourceFormat;
import com.concreteitsolutions.generic.externaldata.exceptions.ExternalDataTechnicalException;
import com.concreteitsolutions.generic.externaldata.model.ExternalData;
import com.sun.tools.doclets.internal.toolkit.util.Extern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class ExternalDataServiceImpl implements ExternalDataService {

    private final ExternalDataDao externalDataDao;

    private final ExternalDataRepository externalDataRepository;

    private final ExternalDataCustomRepository externalDataCustomRepository;

    @Autowired
    public ExternalDataServiceImpl(ExternalDataDao externalDataDao, ExternalDataRepository externalDataRepository, ExternalDataCustomRepository externalDataCustomRepository) {
        this.externalDataDao = externalDataDao;
        this.externalDataRepository = externalDataRepository;
        this.externalDataCustomRepository = externalDataCustomRepository;
    }

    public List<ExternalData> retrieveDataFromExternalFile(InputStream inputStream, ExternalDataSource externalDataSource) {

        if(externalDataSource.getFormat() == ExternalDataSourceFormat.EXCEL) {
            return externalDataDao.retrieveExternalDataFromExternalFile(inputStream);
        }
        throw new ExternalDataTechnicalException(ExternalDataTechnicalException.ExternalDataError.EXTERNAL_DATA_FORMAT_NOT_SUPPORTED);
    }

    public List<ExternalDataSource> searchExternalData(ExternalDataSource externalDataSource) {
        return externalDataCustomRepository.searchExternalData(externalDataSource);
    }

    public ExternalDataSource findById(Long id) {
        return externalDataRepository.getOne(id);
    }

    public void saveExternalData(ExternalDataSource externalDataSource) {
        externalDataRepository.save(externalDataSource);
    }
}