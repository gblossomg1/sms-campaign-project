package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.model.SMSCampaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SMSCampaignRepositoryMock {


	SMSCampaign find(final long reference);

	long create(final SMSCampaign smsCampaign);

	SMSCampaign edit(final SMSCampaign smsCampaign);

	long delete(final long reference);
}
