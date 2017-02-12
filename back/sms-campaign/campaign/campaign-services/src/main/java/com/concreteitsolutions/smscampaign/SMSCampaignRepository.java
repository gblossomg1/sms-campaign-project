package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.model.SMSCampaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SMSCampaignRepository extends JpaRepository<SMSCampaign, Long>{

    SMSCampaign save(SMSCampaign smsCampaign);

    List<SMSCampaign> findAll();

    SMSCampaign findByReference(final long reference);

}
