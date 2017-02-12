package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.commonframework.core.database.MainPersistenceConfiguration;
import com.concreteitsolutions.commonframework.core.exceptions.tmp.LOG;
import com.concreteitsolutions.smscampaign.model.SMSCampaign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MainPersistenceConfiguration.class})
public class SMSCampaignRepositoryIT {

    @Autowired
    private SMSCampaignRepository smsCampaignRepository;

    @Test
    public void should_save_sms_campaign(){
        //Given
        SMSCampaign smsCampaign = SMSCampaignTestFactory.createValidSMSCampaign();

        //When
        SMSCampaign result = smsCampaignRepository.save(smsCampaign);

        //Assert
        if(result != null) {
            LOG.debug("SMS Campaign well created with id : ", result.getReference());
        }
    }

    @Test
    public void should_find_sms_campaign(){

        SMSCampaign smsCampaign = smsCampaignRepository.findOne(4L);

        LOG.debug("Result : ", smsCampaign.toString());
    }

    public void should_edit_sms_campaign(){

        SMSCampaign smsCampaign = smsCampaignRepository.findByReference(4L);

        smsCampaign.setProspectQuantity(new Long("20"));

        smsCampaignRepository.save(smsCampaign);
    }
}
