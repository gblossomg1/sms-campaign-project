package com.concreteitsolutions.generic.prospect;

import java.util.List;
import com.concreteitsolutions.generic.prospect.model.Prospect;
import com.concreteitsolutions.generic.prospect.model.ProspectSearchCriteria;

public interface ProspectProcess {

	List<Prospect> find(final ProspectSearchCriteria criteria, final Long length);

	List<Prospect> find(final long length);

	void saveProspectList(List<Prospect> prospects);

	List<Prospect> findByExternalDataSource(final Long externalDataSourceId);

}
