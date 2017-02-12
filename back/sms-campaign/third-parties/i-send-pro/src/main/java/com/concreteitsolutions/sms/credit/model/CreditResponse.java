package com.concreteitsolutions.sms.credit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class CreditResponse {

	@JsonProperty("etat")
	private final Content content;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
	private class Content {

		@JsonProperty("credit")
		private final String credit;

		@JsonProperty("quantite")
		private final long remainingSMSQuantity;
	}

	public static Credit toCredit(final CreditResponse creditResponse){
		return new Credit(creditResponse.getContent().getCredit(), creditResponse.getContent().getRemainingSMSQuantity());
	}
}
