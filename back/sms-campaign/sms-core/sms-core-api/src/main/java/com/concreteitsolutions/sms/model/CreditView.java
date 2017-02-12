package com.concreteitsolutions.sms.model;

import com.concreteitsolutions.sms.credit.model.Credit;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditView {

    private final String credit;

    private final long remainingSMSQuantity;

    public static CreditView from(Credit credit){
        return CreditView.builder()
                .credit(credit.getCredit())
                .remainingSMSQuantity(credit.getRemainingSMSQuantity())
                .build();
    }
}
