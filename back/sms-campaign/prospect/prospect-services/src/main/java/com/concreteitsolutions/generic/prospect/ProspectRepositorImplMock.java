package com.concreteitsolutions.generic.prospect;

import java.util.Arrays;
import java.util.List;

import com.concreteitsolutions.generic.prospect.model.PreferenceCategory;
import com.concreteitsolutions.generic.prospect.model.Prospect;
import org.springframework.stereotype.Component;

@Component
public class ProspectRepositorImplMock {

	public List<Prospect> find() {
		Prospect prospect = new Prospect(1L,"Tahirou", "DJIBO", "0635338517", null, null); //Arrays.asList(PreferenceCategory.SPORT));

		return Arrays.asList(prospect);
	}
}
