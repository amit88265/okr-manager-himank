package com.xebia.okr.repositories;

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
public class PlanRepositoryTests {

    @Autowired
    private PlanRepository planRepository;

    @Test
    public void should_create_plan_when_i_provide_valid_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("create plan", new Date(), endDate);
        Plan saved = planRepository.saveAndFlush(plan);
        assertThat(saved).isNotNull();
    }

    @Test
    public void should_update_plan_when_i_provide_updated_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("update plan", new Date(), endDate);
        Plan saved = planRepository.saveAndFlush(plan);
        saved.setTitle("new plan");
        Plan updated = planRepository.saveAndFlush(saved);
        assertThat(updated.getTitle()).isEqualTo(saved.getTitle());
}

    @Test
    public void should_delete_plan_when_i_provide_delete_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("delete plan", new Date(), endDate);
        Plan saved = planRepository.saveAndFlush(plan);
        planRepository.deleteById(saved.getId());
        assertThat(planRepository.findById(saved.getId()).isPresent()).isFalse();
    }


    @Test
    public void should_get_plan_when_i_provide_required_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("read plan", new Date(), endDate);
        Plan saved = planRepository.saveAndFlush(plan);
        assertThat(planRepository.findById(saved.getId()).isPresent()).isTrue();
    }


}
