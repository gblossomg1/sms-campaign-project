package com.concreteitsolutions.generic.externaldata;


import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalDataRepository extends JpaRepository<ExternalDataSource, Long> {

    ExternalDataSource save(ExternalDataSource externalDataSource);
}
