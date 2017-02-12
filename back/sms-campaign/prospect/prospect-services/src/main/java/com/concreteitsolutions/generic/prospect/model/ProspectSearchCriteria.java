package com.concreteitsolutions.generic.prospect.model;

import javafx.util.Pair;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class ProspectSearchCriteria {

	private final PreferenceCategory preferenceCategory;

	private final Pair<Integer, Integer> ageCategory;

	private final Gender gender;

}
