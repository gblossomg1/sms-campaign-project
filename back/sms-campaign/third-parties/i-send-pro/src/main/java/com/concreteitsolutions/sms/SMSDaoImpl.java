package com.concreteitsolutions.sms;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import com.concreteitsolutions.commonframework.core.exceptions.tmp.LOG;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.concreteitsolutions.sms.model.MultipleSMS;
import com.concreteitsolutions.sms.model.SMSResponse;
import com.concreteitsolutions.sms.model.SingleSMS;

@Component
public class SMSDaoImpl implements SMSDao {

    private RestTemplate iSendProClient;

    private static final String KEY_ID = "8129be2a2bd7e774a9604b1c0e591df5";

    private static final String HOST = "https://apirest.isendpro.com/cgi-bin";

    private static final String SINGLE_SMS_PATH = "/sms";

    private static final String MULTIPLE_SMS_PATH = "/smsmulti";

    // To place in IsendProTestFactory class
    public static final String MOCK_URL = "http://demo8280665.mockable.io";

    @Autowired
    public SMSDaoImpl(RestTemplate iSendProClient) {
        this.iSendProClient = iSendProClient;
    }

    public void sendOne(final String telNumber, final String smsContent, final String sender) {

        SingleSMS singleSms = new SingleSMS(KEY_ID, smsContent, telNumber, sender);

        try {

            RequestEntity<SingleSMS> singleSMSRequest = RequestEntity.post(createURI(HOST + SINGLE_SMS_PATH))
                    .contentType(MediaType.APPLICATION_JSON).body(singleSms);

            ResponseEntity<SMSResponse> smsResponseResponseEntity = iSendProClient.exchange(singleSMSRequest, SMSResponse.class);

            LOG.debug("sms response: ", smsResponseResponseEntity.toString());

        } catch (HttpClientErrorException e) {
            LOG.debug("Request error, sending technical exception ...");
            LOG.debug(e.getResponseBodyAsString());

            SMSResponse smsResponseError = null;

            smsResponseError = retrieveSMSResponseErrorFromJson(e.getResponseBodyAsString());

            e.printStackTrace();
            throw new SMSCoreTechnicalException(SMSCoreTechnicalException.Error.UNIQUE_SMS_SEND_ERROR, "Code d'erreur de isendpro : "+smsResponseError.getState().getSmsResponseStateContent().getContent());
        }
    }

    public void sendMultiple(final List<String> phoneNumberList, final String smsContent, final String sender) {
        LOG.debug("Sending multiple sms");

        MultipleSMS multipleSMS = new MultipleSMS(KEY_ID, phoneNumberList, smsContent, sender);

        try {

            RequestEntity<MultipleSMS> multipleSMSRequest = RequestEntity.post(URI.create(HOST + MULTIPLE_SMS_PATH))
                    .contentType(MediaType.APPLICATION_JSON).body(multipleSMS);

            ResponseEntity<SMSResponse> smsResponse = iSendProClient.exchange(multipleSMSRequest, SMSResponse.class);

            LOG.debug("Sms response : " + smsResponse.toString());

        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            throw new SMSCoreTechnicalException(SMSCoreTechnicalException.Error.CAMPAIGN_CREATION_ERROR);

        }
    }

    /**
     * ------------------------
     * <p>
     * PRIVATE FUNCTIONS
     * <p>
     * ------------------------
     */

    private URI createURI(final String uri) {

        try {
            URI newURI = new URI(uri);

            return newURI;

        } catch (URISyntaxException e) {
            throw new SMSCoreTechnicalException(SMSCoreTechnicalException.Error.URI_CREATION_ERROR, "URL passé = "+ uri);
        }
    }

    private SMSResponse retrieveSMSResponseErrorFromJson(String smsResponseString) {
        ObjectMapper objectMapper = new ObjectMapper();
        SMSResponse smsResponse = new SMSResponse();

        try {

            LOG.debug("Deserializing .. :" + smsResponse);
            smsResponse = objectMapper.readValue(smsResponseString, SMSResponse.class);

        } catch (IOException e) {
            throw new SMSCoreTechnicalException(SMSCoreTechnicalException.Error.I_SEND_PRO_RESPONSE_DESERIALIZATION_ERROR);
        }


        return smsResponse;
    }
}
