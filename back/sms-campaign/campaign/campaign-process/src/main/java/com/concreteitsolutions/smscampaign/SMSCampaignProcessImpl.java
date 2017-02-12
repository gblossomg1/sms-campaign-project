package com.concreteitsolutions.smscampaign;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.concreteitsolutions.commonframework.core.exceptions.tmp.LOG;
import com.concreteitsolutions.smscampaign.exceptions.SMSCampaignFunctionalException;
import com.concreteitsolutions.smscampaign.model.CampaignState;
import com.concreteitsolutions.smscampaign.model.SMSCampaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concreteitsolutions.generic.prospect.ProspectProcess;
import com.concreteitsolutions.generic.prospect.model.Prospect;
import com.concreteitsolutions.sms.SMSService;
import com.concreteitsolutions.sms.credit.model.Credit;

@Component
public class SMSCampaignProcessImpl implements SMSCampaignProcess {

    private final SMSService smsService;

    private final SMSCampaignService smsCampaignService;

    private final ProspectProcess prospectProcess;

    @Autowired
    public SMSCampaignProcessImpl(SMSService smsService,
                                  SMSCampaignServiceImpl smsCampaignService,
                                  ProspectProcess prospectProcess) {
        this.smsService = smsService;
        this.smsCampaignService = smsCampaignService;
        this.prospectProcess = prospectProcess;
    }

    public long create(SMSCampaign smsCampaign) {

        smsCampaign.setState(CampaignState.CREATED);
        LOG.debug("Check state change", smsCampaign);

        return smsCampaignService.create(smsCampaign);
    }

    public SMSCampaign edit(long reference, SMSCampaign smsCampaign) {

        SMSCampaign smsCampaignToEdit = smsCampaignService.findById(reference);

        if(smsCampaignToEdit.getState() == CampaignState.IN_PROGRESS) {
            throw new SMSCampaignFunctionalException(SMSCampaignFunctionalException.Error.CAN_NOT_EDIT_CAMPAIGN_WHILE_BEING_SENT);
        }
        smsCampaignToEdit.setProspectQuantity(smsCampaign.getProspectQuantity());
        smsCampaignToEdit.setName(smsCampaign.getName());
        smsCampaignToEdit.setCustomerName(smsCampaign.getCustomerName());
        smsCampaign.setSmsContent(smsCampaign.getSmsContent());
        smsCampaign.setReference(smsCampaignToEdit.getReference());

        smsCampaignService.edit(smsCampaignToEdit);

        return smsCampaignToEdit;
    }


    public long delete(long reference) {
        return 0;
    }

    public void send(final Long reference) {

		/* 1. Get the sms campaign by reference */
        SMSCampaign smsCampaign = smsCampaignService.findById(reference);

        if(smsCampaign.getState() == CampaignState.SENT) {
            throw new SMSCampaignFunctionalException(SMSCampaignFunctionalException.Error.SMS_ALREADY_SENT, "Cette campagne a déja été envoyée.");
        }

        smsCampaign.setState(CampaignState.IN_PROGRESS);
        smsCampaignService.edit(smsCampaign);

		/* 2. Credit check */
        Credit credit = smsService.findRemainingCreditAndSMS();
        if (credit.getRemainingSMSQuantity() < smsCampaign.getProspectQuantity()) {
            throw new SMSCampaignFunctionalException(SMSCampaignFunctionalException.Error.SMS_CREDIT_USED_UP, "Crédit insuffisant pour cette campagne. Le crédit dont vous disposez vous permet d'envoyer jusqu'à  " + credit.getRemainingSMSQuantity() + " sms");
        }

		/* 3. */
        List<Prospect> prospectList = prospectProcess.find(null, smsCampaign.getProspectQuantity());
        LOG.debug("Prospect list : ", prospectList.toString());
        /* 4. Send the campaign */

        List<String> phoneNumberList = phoneNumbersFromProspects(prospectList);
        LOG.debug("phone Number list : " + phoneNumberList.toString());
        smsService.sendMultiple(phoneNumberList, smsCampaign.getSmsContent(), smsCampaign.getCustomerName());

        /* Update campaign status */
        smsCampaign.setState(CampaignState.SENT);
        smsCampaignService.edit(smsCampaign);

    }


    /**
     * ------------------------------
     * <p>
     * PRIVATE FUNCTIONS
     * <p>
     * ------------------------------
     */
    private List<String> phoneNumbersFromProspects(List<Prospect> prospects) {
        List<String> phoneNumbers = new ArrayList<String>();
        for (Prospect p : prospects) {
            phoneNumbers.add(p.getPhoneNumber());
        }
        return phoneNumbers;
    }
}
