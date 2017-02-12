package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.commonframework.core.database.MainPersistenceConfiguration;
import com.concreteitsolutions.commonframework.core.exceptions.tmp.LOG;
import com.concreteitsolutions.smscampaign.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MainPersistenceConfiguration.class})
public class TestRepositoryIT {

    @Autowired
    private TestRepository testRepository;

    @Test
    public void shoud_find_all_tests(){
        List<com.concreteitsolutions.smscampaign.Test> tests = testRepository.findAll();

        LOG.debug("retrieved data", tests.toString());

    }

    @Test
    public void should_save_test(){
        com.concreteitsolutions.smscampaign.Test test = com.concreteitsolutions.smscampaign.Test.builder()
                .name("Test toto")
                .id(2)
                .build();
        testRepository.save(test);
    }
}
