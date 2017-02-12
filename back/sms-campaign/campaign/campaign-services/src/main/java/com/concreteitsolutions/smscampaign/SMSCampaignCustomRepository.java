package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.model.SMSCampaign;

import java.util.List;

public interface SMSCampaignCustomRepository {

    List<SMSCampaign> search(SMSCampaign smsCampaign);
}
