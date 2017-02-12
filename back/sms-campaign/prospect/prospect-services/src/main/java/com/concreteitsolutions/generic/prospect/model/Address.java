package com.concreteitsolutions.generic.prospect.model;

import lombok.*;

@Data
@Builder
public class Address {

	private final String country;

	private final long postalCode;

	private final String town;

	private final String firstLine;

	private final String complementaryInformations;

}
