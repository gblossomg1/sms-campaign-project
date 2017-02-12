package com.concreteitsolutions.generic.prospect;

import java.util.List;

import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.generic.prospect.model.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProspectRepository extends JpaRepository<Prospect, Long> {

	Prospect findById(final long id);

	List<Prospect> findAll();

	Prospect save(Prospect prospect);

	List<Prospect> findByExternalDataSource(final ExternalDataSource externalDataSource);
}
