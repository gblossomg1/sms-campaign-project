package com.concreteitsolutions.sms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class SingleSMS {

	@JsonProperty(value = "keyid", required = true)
	private String keyId;

	@JsonProperty(value = "sms", required = true)
	private String sms;

	@JsonProperty(value = "num", required = true)
	private String phoneNumber;

	@JsonProperty("emetteur")
	private String sender;
}
