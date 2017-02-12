package com.concreteitsolutions.generic.externaldata;

import com.concreteitsolutions.commonframework.core.database.MainPersistenceConfiguration;
import com.concreteitsolutions.commonframework.core.exceptions.tmp.LOG;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.generic.prospect.model.Prospect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ExternalDataCustomRepositoryImpl.class, MainPersistenceConfiguration.class})
public class ExternalDataCustomRepositoryIT {

    @Autowired
    private ExternalDataCustomRepositoryImpl externalDataCustomRepository;

    @Test
    public void should_retrieve_all_external_datas(){
        // GIVEN datas in database
        // And ...
        ExternalDataSource externalDataSource = ExternalDataSource.builder()
                .dataModel(Prospect.DATA_MODEL_NAME)
                .id(946L)
                .build();

        // WHEN
        List<ExternalDataSource> externalDatas = externalDataCustomRepository.searchExternalData(externalDataSource);

        // ASSERT
        assertNotNull(externalDatas);
        LOG.debug("External datas retrieved : ", externalDatas);

    }
}