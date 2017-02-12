package com.concreteitsolutions.sms;

import com.concreteitsolutions.sms.model.CreditView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SMSControllerImpl implements SMSController {

	private final SMSService smsService;

	@Autowired
	public SMSControllerImpl(SMSService smsService) {
		this.smsService = smsService;
	}

	public CreditView findRemainingCredit() {
		return CreditView.from(smsService.findRemainingCreditAndSMS());
	}
}
