package com.concreteitsolutions.smscampaign.exceptions;

import com.concreteitsolutions.commonframework.core.exceptions.CustomError;
import com.concreteitsolutions.commonframework.core.exceptions.CustomException;
import lombok.Getter;

public class SMSCampaignFunctionalException extends CustomException {

	public SMSCampaignFunctionalException(final Error error, final String message) {
		super(error, message);
	}

	public SMSCampaignFunctionalException(final Error error) {
		super(error);
	}

	@Getter
	public enum Error implements CustomError {

		SMS_CREDIT_USED_UP("Le crédit SMS dont vous disposez ne vous permet pas de réaliser cette campagne. Veuillez recharger SVP."),
		CAN_NOT_EDIT_CAMPAIGN_WHILE_BEING_SENT("Impossible de modifier cette campagne car elle est en cours d'envoi."),
		SMS_CAMPAIGN_RESOURCE_NOT_FOUND("La campagne SMS n'existe pas"),
		SMS_ALREADY_SENT("Cette campagne a déjà été envoyée. Si vous voulez envoyer une campagne avec les mêmes caractéristiques, veuillez la dupliquer(Fonctionnalité à développer ...)");

		public final String message;

		Error(String message) {
			this.message = message;
		}

		public String message() {
			return this.name();
		}
	}
}
