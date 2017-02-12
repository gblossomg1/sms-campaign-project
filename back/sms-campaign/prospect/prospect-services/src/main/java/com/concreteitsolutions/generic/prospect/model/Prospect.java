package com.concreteitsolutions.generic.prospect.model;

import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Prospect {

    public static final String DATA_MODEL_NAME = "PROSPECT";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;

	private final String firstName;

	private final String lastName;

	private final String phoneNumber;

    private final String email;

    @ManyToOne
    @JoinColumn
    private ExternalDataSource externalDataSource;

//	private final List<PreferenceCategory> preferenceCategoryList;

//	private final Address address;
}
