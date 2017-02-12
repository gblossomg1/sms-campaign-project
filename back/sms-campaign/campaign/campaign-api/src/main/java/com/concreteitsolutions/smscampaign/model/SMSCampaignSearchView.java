package com.concreteitsolutions.smscampaign.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class SMSCampaignSearchView {

	private long reference;

	private String name;

	private String customerName;
}
