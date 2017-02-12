package com.concreteitsolutions.sms;

import com.concreteitsolutions.sms.credit.CreditDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ISendProClientConfiguration.class, CreditDaoImpl.class})
public class CreditDaoImplIT {

	@Autowired
	private CreditDaoImpl creditDao;

	@Test
	public void should_retrieve_remaining_credit_and_sms_quantity(){
		creditDao.findRemainingCreditAndSMS();
	}

}
