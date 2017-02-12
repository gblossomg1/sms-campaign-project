package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.smscampaign.exceptions.SMSCampaignFunctionalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concreteitsolutions.smscampaign.model.SMSCampaign;

import java.util.List;

@Component
public class SMSCampaignServiceImpl implements SMSCampaignService {

    private final SMSCampaignRepository smsCampaignRepository;

    private final SMSCampaignCustomRepository smsCampaignCustomRepository;

    @Autowired
    public SMSCampaignServiceImpl(SMSCampaignRepository smsCampaignRepository, SMSCampaignCustomRepository smsCampaignCustomRepository) {
        this.smsCampaignRepository = smsCampaignRepository;
        this.smsCampaignCustomRepository = smsCampaignCustomRepository;
    }

    public SMSCampaign findById(Long reference) {

        SMSCampaign smsCampaign = smsCampaignRepository.findByReference(reference);

        if (smsCampaign != null) {
            return smsCampaign;
        }
        throw new SMSCampaignFunctionalException(SMSCampaignFunctionalException.Error.SMS_CAMPAIGN_RESOURCE_NOT_FOUND, "Id de la campagne : " + reference);
    }

    public long create(SMSCampaign smsCampaign) {
        return smsCampaignRepository.save(smsCampaign).getReference();
    }

    public SMSCampaign edit(SMSCampaign smsCampaign) {

        return smsCampaignRepository.save(smsCampaign);
    }

    public long delete(long reference) {

        smsCampaignRepository.delete(reference);

        return reference;
    }

    public List<SMSCampaign> search(SMSCampaign smsCampaign) {
        //TODO: Use criteria
        return smsCampaignCustomRepository.search(smsCampaign);
    }
}
