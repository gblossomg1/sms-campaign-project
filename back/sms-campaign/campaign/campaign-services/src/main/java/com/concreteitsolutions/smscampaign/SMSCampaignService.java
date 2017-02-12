package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.model.SMSCampaign;

import java.util.List;

public interface SMSCampaignService {

	SMSCampaign findById(final Long reference);

	long create(final SMSCampaign smsCampaign);

	SMSCampaign edit(final SMSCampaign smsCampaign);

	long delete(final long reference);

	List<SMSCampaign> search(final SMSCampaign smsCampaign);
}
