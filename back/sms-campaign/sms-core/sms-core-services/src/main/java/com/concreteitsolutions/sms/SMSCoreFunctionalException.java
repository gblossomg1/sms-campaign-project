package com.concreteitsolutions.sms;

import com.concreteitsolutions.commonframework.core.exceptions.CustomError;
import com.concreteitsolutions.commonframework.core.exceptions.CustomException;

import lombok.Getter;

public class SMSCoreFunctionalException extends CustomException {

	public SMSCoreFunctionalException(CustomError error) {
		super(error);
	}

	public SMSCoreFunctionalException(CustomError error, String message) {
		super(error, message);
	}

	@Getter
	public enum Error implements CustomError {

		EMPTY_LOGIN_FIELD("Le champ login est vide"),
		EMPTY_PASSWORD_FIELD("Le champ password est vide"),
		MT_CREDIT_USED_UP("Votre crédit SMS est épuisé. Veuillez recharger SVP.");

		public final String message;

		Error(String message) {
			this.message = message;
		}

		public String message() {
			return message;
		}
	}

}
