package com.concreteitsolutions.sms;

import com.concreteitsolutions.sms.credit.model.Credit;

import java.util.List;

public interface SMSService {

	void sendOne(final String phoneNumber, final String smsContent, final String sender);

	void sendMultiple(final List<String> phoneNumberList, final String smsContent, final String sender);

	Credit findRemainingCreditAndSMS();
}
