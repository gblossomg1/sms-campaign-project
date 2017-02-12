package com.concreteitsolutions.sms.credit;

import com.concreteitsolutions.sms.credit.model.Credit;

public interface CreditDao {

	Credit findRemainingCreditAndSMS();

}
