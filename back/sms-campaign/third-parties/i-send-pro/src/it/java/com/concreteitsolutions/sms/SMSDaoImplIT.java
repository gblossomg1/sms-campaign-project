package com.concreteitsolutions.sms;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
//import org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ISendProClientConfiguration.class, SMSDaoImpl.class })
public class SMSDaoImplIT {

	@Autowired
	private SMSDaoImpl smsDaoImpl;

	@Autowired
	RestTemplate client;

	@Test
	public void should_send_one_sms() throws IOException {
		// Given
		String phoneNumber = IsendProTestFactory.UNIQUE_SMS_TEL_ME;
		String sms = IsendProTestFactory.UNIQUE_SMS_CONTENT;
		String sender = IsendProTestFactory.UNIQUE_SMS_SENDER;
		// When
		smsDaoImpl.sendOne(phoneNumber,sms, sender);

		//Assert

	}

	@Test
	public void should_send_multiple_sms(){
		// Given
		List<String> phoneNumberList = IsendProTestFactory.createPhoneNumberList();
		String smsContent = IsendProTestFactory.UNIQUE_SMS_CONTENT;
		String smsSender = IsendProTestFactory.UNIQUE_SMS_SENDER;

		smsDaoImpl.sendMultiple(phoneNumberList, smsContent, smsSender);
	}
}
