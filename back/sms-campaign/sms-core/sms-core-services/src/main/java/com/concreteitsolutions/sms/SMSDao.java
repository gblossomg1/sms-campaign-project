package com.concreteitsolutions.sms;

import java.util.List;

public interface SMSDao {

	void sendOne(final String telNumber, final String smsContent, final String sender);

	void sendMultiple(final List<String> phoneNumberList, final String smsContent, final String sender);

}
