package com.concreteitsolutions.sms;

import com.concreteitsolutions.commonframework.core.exceptions.CustomError;
import com.concreteitsolutions.commonframework.core.exceptions.CustomException;

import lombok.Getter;

public class SMSCoreTechnicalException extends CustomException {


    public SMSCoreTechnicalException(CustomError error) {
        super(error);

    }

    public SMSCoreTechnicalException(CustomError error, String message) {
        super(error, message);
    }

    @Getter
    public enum Error implements CustomError {

        UNIQUE_SMS_SEND_ERROR("Erreur technique rencontrée lors de l'envoi unique à un numéro de téléphone"),
        CAMPAIGN_CREATION_ERROR("Erreur technique rencontrée lors de la création de la campagne"),
        I_SEND_PRO_RESPONSE_DESERIALIZATION_ERROR("Erreur technique rencontrée lors de la désérialisation de la réponse de isendpro"),
        URI_CREATION_ERROR("Erreur technique lors de la création de l'objet URI à partir de l'adresse du third party");

        public final String message;

        Error(String message) {
            this.message = message;
        }

        public String message() {
            return this.message;
        }
    }
}
