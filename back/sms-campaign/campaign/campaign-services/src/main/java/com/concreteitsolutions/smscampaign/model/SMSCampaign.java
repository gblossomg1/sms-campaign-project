package com.concreteitsolutions.smscampaign.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class SMSCampaign {

    public static final String NAME = "name";
    public static final String REFERENCE = "reference";
    public static final String CUSTOMER_NAME = "customerName";
    public static final String SMS_CONTENT = "smsContent";
    public static final String PROSPECT_QUANTITY = "prospectQuantity";
    public static final String STATE = "state";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reference;

    private String name;

    private String customerName;

    private String smsContent;

    private Long prospectQuantity;

    @Enumerated(EnumType.STRING)
    private CampaignState state;

    private final Date creationDate;

    //TODO: private Date lastEditDate;

    public SMSCampaign(final Date date) {
        this.creationDate = date;
    }
}
