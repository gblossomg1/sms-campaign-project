package com.concreteitsolutions.smscampaign.model;

public enum CampaignState {
	CREATED("CREATED"),
	IN_PROGRESS("IN_PROGRESS"),
	SENT("SENT"),
	SUSPENDED("SUSPENDED"),
	ARCHIVED("ARCHIVED");

	private final String state;

	CampaignState(final String state) {
		this.state = state;
	}
}
