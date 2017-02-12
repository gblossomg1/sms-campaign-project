package com.concreteitsolutions.sms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concreteitsolutions.sms.credit.CreditDao;
import com.concreteitsolutions.sms.credit.model.Credit;

@Component
public class SMSServiceImpl implements SMSService {

	private final SMSDao smsDao;

	private final CreditDao creditDao;

	@Autowired
	public SMSServiceImpl(SMSDao smsDao, CreditDao creditDao) {
		this.smsDao = smsDao;
		this.creditDao = creditDao;
	}

	public void sendOne(String phoneNumber, String smsContent, String sender) {
		smsDao.sendOne(phoneNumber, smsContent, sender);
	}

	public void sendMultiple(List<String> phoneNumberList, String smsContent, String sender) {
		smsDao.sendMultiple(phoneNumberList, smsContent, sender);
	}

	public Credit findRemainingCreditAndSMS() {
		return creditDao.findRemainingCreditAndSMS();
	}

}
