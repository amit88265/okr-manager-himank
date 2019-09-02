package com.xebia.okr.repositories;

import com.xebia.okr.domain.Objective;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ObjectiveRepository extends JpaRepository<Objective, Long> {

    List<Objective> findByTitle(String title);

}