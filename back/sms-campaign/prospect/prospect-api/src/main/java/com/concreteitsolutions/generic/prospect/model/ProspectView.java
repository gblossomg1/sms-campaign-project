package com.concreteitsolutions.generic.prospect.model;

import lombok.Builder;
import lombok.Data;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ProspectView {

    private final long id;

    private final String firstName;

    private final String lastName;

    private final String phoneNumber;

    private final String email;

    private static ProspectView from(Prospect prospect) {

        ProspectView prospectView = ProspectView.builder()
                .firstName(prospect.getFirstName())
                .lastName(prospect.getLastName())
                .phoneNumber(prospect.getPhoneNumber())
                .email(prospect.getEmail())
                .build();

        return prospectView;
    }

    public static List<ProspectView> from(List<Prospect> prospects) {
        List<ProspectView> prospectViews = new ArrayList<ProspectView>();

        for(Prospect prospect: prospects) {
            prospectViews.add(from(prospect));
        }

        return prospectViews;
    }
}
