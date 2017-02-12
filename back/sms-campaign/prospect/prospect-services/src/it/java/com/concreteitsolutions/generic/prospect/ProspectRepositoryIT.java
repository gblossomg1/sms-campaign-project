package com.concreteitsolutions.generic.prospect;

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
@ContextConfiguration(classes = {MainPersistenceConfiguration.class})
public class ProspectRepositoryIT {

    @Autowired
    private ProspectRepository prospectRepository;

    @Test
    public void should_find_prospects_by_external_data_source_id() {
        // GIVEN
        ExternalDataSource externalDataSource = ExternalDataSource.builder()
                .dataModel(Prospect.DATA_MODEL_NAME)
                .id(2L)
                .build();

        // WHEN
        List<Prospect> prospects = prospectRepository.findByExternalDataSource(externalDataSource);

        //ASSERT
        assertNotNull(prospects);
        LOG.debug("Prospects result :", prospects);
    }

}