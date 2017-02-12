package com.concreteitsolutions.smscampaign.model;

import com.concreteitsolutions.smscampaign.DateUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SMSCampaignView {

    private String reference;

    private String name;

    private String customerName;

    private String smsContent;

    private String prospectQuantity;

    private CampaignState state; // TODO: Create view for this...

    private String creationDate;

    public static SMSCampaign toSMSCampaign(SMSCampaignView smsCampaignView) {

        SMSCampaign smsCampaign = new SMSCampaign(new Date());

        if (smsCampaignView.getReference() != null && !smsCampaignView.getReference().equals("")) {
            smsCampaign.setReference(Long.parseLong(smsCampaignView.getReference()));
        }
        if (smsCampaignView.getName() != null && !smsCampaignView.getName().equals("")) {
            smsCampaign.setName(smsCampaignView.getName());
        }
        if (smsCampaignView.getCustomerName() != null && !smsCampaignView.getCustomerName().equals("")) {
            smsCampaign.setCustomerName(smsCampaignView.getCustomerName());
        }
        if (smsCampaignView.getProspectQuantity() != null && !smsCampaignView.getProspectQuantity().equals("")) {
            smsCampaign.setProspectQuantity(Long.parseLong(smsCampaignView.getProspectQuantity()));
        }
        if (smsCampaignView.getState() != null) {
            smsCampaign.setState(smsCampaignView.getState());
        }
        if (smsCampaignView.getSmsContent() != null && !smsCampaignView.getSmsContent().equals("")) {
            smsCampaign.setSmsContent(smsCampaignView.getSmsContent());
        }


        return smsCampaign;
    }

    public static SMSCampaignView from(final SMSCampaign smsCampaign) {
        System.out.println("SMS Campaign  that is being returned : " + smsCampaign.toString());
        SMSCampaignView view = new SMSCampaignView(Long.toString(smsCampaign.getReference()), smsCampaign.getName(), smsCampaign.getCustomerName(), smsCampaign.getSmsContent(), Long.toString(smsCampaign.getProspectQuantity()), smsCampaign.getState(), DateUtils.parseDate(smsCampaign.getCreationDate(), DateUtils.DEFAULT_FRENCH_PATTERN));

        System.out.println("SMS Campaign view that is being returned : " + view.toString());
        return view;
    }

    public static List<SMSCampaignView> from(final List<SMSCampaign> smsCampaigns) {
        List<SMSCampaignView> smsCampaignResultList = new ArrayList<>();

        for (SMSCampaign smsCampaign : smsCampaigns) {
            smsCampaignResultList.add(SMSCampaignView.from(smsCampaign));
        }
        return smsCampaignResultList;
    }
}
