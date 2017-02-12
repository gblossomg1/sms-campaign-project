package com.concreteitsolutions.sms.credit;

import java.net.URI;
import java.net.URISyntaxException;

import com.concreteitsolutions.sms.credit.model.CreditResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.concreteitsolutions.sms.credit.model.Credit;

@Component
public class CreditDaoImpl implements CreditDao {

	private RestTemplate iSendProClient;

	private static final String KEY_ID = "8129be2a2bd7e774a9604b1c0e591df5";

	private static final String HOST = "https://apirest.isendpro.com/cgi-bin";

	public static final String CREDIT_AND_QUANTITY_PATH = "/setlistenoire?keyid=" + KEY_ID + "&credit=2";

	@Autowired
	public CreditDaoImpl(RestTemplate iSendProClient) {
		this.iSendProClient = iSendProClient;
	}

	public Credit findRemainingCreditAndSMS() {

		try {
			ResponseEntity<CreditResponse> creditResponseResponseEntity =
					iSendProClient.getForEntity(new URI(HOST + CREDIT_AND_QUANTITY_PATH), CreditResponse.class);

			System.out.println(creditResponseResponseEntity.getBody());
			return CreditResponse.toCredit(creditResponseResponseEntity.getBody());

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}
}
