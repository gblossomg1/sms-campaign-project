package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.model.SMSCampaign;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class SMSCampaignRepositoryMockImplMock implements SMSCampaignRepositoryMock {

	public SMSCampaign save(SMSCampaign smsCampaign) {
		return null;
	}

	public List<SMSCampaign> findAll() {
		return null;
	}

	public SMSCampaign findByReference() {
		return null;
	}

	public SMSCampaign find(long reference) {
		return SMSCampaignDatabase.getSMSCampaignByReference(reference);
	}

	public long create(SMSCampaign smsCampaign) {
		return SMSCampaignDatabase.createSMSCampaign(smsCampaign);
	}

	public SMSCampaign edit(SMSCampaign smsCampaign) {
		return SMSCampaignDatabase.edit(smsCampaign);
	}

	public long delete(long reference) {
		return SMSCampaignDatabase.delete(reference);
	}
}
