package com.concreteitsolutions.sms;

import java.util.ArrayList;
import java.util.List;

public class IsendProTestFactory {

	public static final String UNIQUE_SMS_TEL_ME = "0635338517";

	public static final String UNIQUE_SMS_TEL_PATRICK = "0682687650";
	public static final String UNIQUE_SMS_TEL_MOUSTAPHA = "0621051368";
	public static final String UNIQUE_SMS_TEL_SAMIRA = "0603356434";

	public static final String UNIQUE_SMS_CONTENT =
			"TEST- CAMPAGNE SMS Tahirou \n Jouez à notre jeu et gagnez beaucoup de cadeaux jusqu'au 25 Décembre 2015.\n"
					+ "Rens cadeaux: http://google.fr";

	public static final String UNIQUE_SMS_SENDER = "Info 83";

	public static List<String> createPhoneNumberList() {

		List<String> phoneNumberList = new ArrayList<String>();

		phoneNumberList.add(UNIQUE_SMS_TEL_ME);
	//	phoneNumberList.add(UNIQUE_SMS_TEL_MOUSTAPHA);
	//	phoneNumberList.add(UNIQUE_SMS_TEL_ME);

		return phoneNumberList;
	}

}
