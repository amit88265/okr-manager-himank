package com.xebia.okr.repositories;

import com.xebia.okr.domain.Objective;
import com.xebia.okr.domain.Plan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ObjectiveRepositoryTests {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Test
    public void should_create_objective_when_i_provide_valid_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("create plan", new Date(), endDate);
        planRepository.saveAndFlush(plan);
        Objective objective = new Objective("create objective", "objective label", plan);
        Objective saved = objectiveRepository.saveAndFlush(objective);
        assertThat(saved).isNotNull();
    }

    @Test
    public void should_update_objective_when_i_provide_updated_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("update plan", new Date(), endDate);
        planRepository.saveAndFlush(plan);
        Objective objective = new Objective("update objective", "objective label", plan);
        Objective saved = objectiveRepository.saveAndFlush(objective);
        saved.setTitle("new objective");
        Objective updated = objectiveRepository.saveAndFlush(saved);
        assertThat(updated.getTitle()).isEqualTo(saved.getTitle());
}

    @Test
    public void should_delete_objective_when_i_provide_delete_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("delete plan", new Date(), endDate);
        planRepository.saveAndFlush(plan);
        Objective objective = new Objective("delete objective", "objective label", plan);
        Objective saved = objectiveRepository.saveAndFlush(objective);
        objectiveRepository.deleteById(saved.getId());
        assertThat(objectiveRepository.findById(saved.getId()).isPresent()).isFalse();
    }


    @Test
    public void should_get_objective_when_i_provide_required_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("read plan", new Date(), endDate);
        planRepository.saveAndFlush(plan);
        Objective objective = new Objective("read objective", "objective label", plan);
        Objective saved = objectiveRepository.saveAndFlush(objective);
        assertThat(objectiveRepository.findById(saved.getId()).isPresent()).isTrue();
    }


}
