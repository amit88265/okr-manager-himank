package com.xebia.okr.repositories;

import com.xebia.okr.domain.KeyResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface KeyResultRepository extends JpaRepository<KeyResult, Long> {

    List<KeyResult> findByTitle(String title);

}