package com.concreteitsolutions.generic.prospect.model;

public enum PreferenceCategory {
	SPORT("CAT_SPORT"),
	FOOD("CAT_FOOD"),
	SCIENCE("CAT_SCIENCE");

	/**
	 * TODO: Complete. Probably will be reference data.
	 */

	private final String category;

	PreferenceCategory(final String category){
		this.category = category;
	}
}
