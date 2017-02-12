package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.model.CampaignState;
import com.concreteitsolutions.smscampaign.model.SMSCampaign;


public class SMSCampaignTestFactory {


    public static SMSCampaign createValidSMSCampaign() {
        SMSCampaign smsCampaign = SMSCampaign.builder()
                .smsContent("Gagnez des cadeaux ...")
                .customerName("Info 83")
                .name("Test de creation de campagne")
                .prospectQuantity(new Long("2"))
                .state(CampaignState.CREATED)
                .build();

        return smsCampaign;
    }
}
