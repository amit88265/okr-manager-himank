package com.xebia.okr.repositories;

import com.xebia.okr.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PlanRepository extends JpaRepository<Plan, Long> {

    List<Plan> findByTitle(String title);

}