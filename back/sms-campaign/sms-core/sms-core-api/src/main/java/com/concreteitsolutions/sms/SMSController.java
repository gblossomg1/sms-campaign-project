package com.concreteitsolutions.sms;

import com.concreteitsolutions.sms.model.CreditView;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
@CrossOrigin
public interface SMSController {

	@RequestMapping(path = "/credit", method = RequestMethod.GET)
	CreditView findRemainingCredit();
}
