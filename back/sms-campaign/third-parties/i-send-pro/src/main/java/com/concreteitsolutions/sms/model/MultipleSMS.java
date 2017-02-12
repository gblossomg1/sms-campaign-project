package com.concreteitsolutions.sms.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class MultipleSMS {

	@JsonProperty(value = "keyid", required = true)
	private String keyId;

	@JsonProperty(value = "num", required = true)
	private List<String> phoneNumberList;

	@JsonProperty(value = "sms", required = true)
	private String smsContent;

	@JsonProperty("emetteur")
	private String sender;

}
