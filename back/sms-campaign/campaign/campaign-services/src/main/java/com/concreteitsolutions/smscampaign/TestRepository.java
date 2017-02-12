package com.concreteitsolutions.smscampaign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TestRepository extends JpaRepository<Test, Integer> {

    Test save(Test test);

    List<Test> findAll();
}
