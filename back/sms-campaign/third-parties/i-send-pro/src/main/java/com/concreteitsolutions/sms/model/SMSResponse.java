package com.concreteitsolutions.sms.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SMSResponse {

	@JsonProperty(value = "etat", required = true)
	private SMSResponseState state;

	@Data
	@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
	@AllArgsConstructor
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class SMSResponseState {

		@JsonProperty(value = "etat", required = true)
		private SMSResponseStateContent smsResponseStateContent;

		@Data
		@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
		@AllArgsConstructor
		@JsonIgnoreProperties(ignoreUnknown = true)
		public class SMSResponseStateContent {

			private Content content;
		}

		@Data
		@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
		@AllArgsConstructor
		@JsonIgnoreProperties(ignoreUnknown = true)
		public class Content {

			@JsonProperty(value = "code", required = true)
			private SMSStatusCode statusCode;

			@JsonProperty(value = "tel", required = true)
			private String telNumber;

			@JsonProperty("smslong")
			private String longSMS;

			@JsonProperty("message")
			private String statusCodeDescription;
		}
	}
}
