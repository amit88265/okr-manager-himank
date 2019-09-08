package com.xebia.okr.repositories;

import com.xebia.okr.domain.KeyResult;
import com.xebia.okr.domain.KeyResultStatus;
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
public class KeyResultRepositoryTests {

    @Autowired
    private KeyResultRepository keyResultRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Test
    public void should_create_keyresult_when_i_provide_valid_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("create plan", new Date(), endDate);
        planRepository.saveAndFlush(plan);
        Objective objective = new Objective("create objective", "objective label", plan);
        objectiveRepository.saveAndFlush(objective);
        KeyResult keyResult = new KeyResult("create keyresult",30, KeyResultStatus.PARTIALLY_COMPLETED,60,objective);
        KeyResult saved = keyResultRepository.saveAndFlush(keyResult);
        assertThat(saved).isNotNull();
    }

    @Test
    public void should_update_keyresult_when_i_provide_updated_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("update plan", new Date(), endDate);
        planRepository.saveAndFlush(plan);
        Objective objective = new Objective("update objective", "objective label", plan);
        objectiveRepository.saveAndFlush(objective);
        KeyResult keyResult = new KeyResult("update keyresult",30, KeyResultStatus.PARTIALLY_COMPLETED,60,objective);
        KeyResult saved = keyResultRepository.saveAndFlush(keyResult);
        saved.setTitle("new keyresult");
        KeyResult updated = keyResultRepository.saveAndFlush(saved);
        assertThat(updated.getTitle()).isEqualTo(saved.getTitle());
}

    @Test
    public void should_delete_keyresult_when_i_provide_delete_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("delete plan", new Date(), endDate);
        planRepository.saveAndFlush(plan);
        Objective objective = new Objective("delete objective", "objective label", plan);
        objectiveRepository.saveAndFlush(objective);
        KeyResult keyResult = new KeyResult("delete keyresult",30, KeyResultStatus.PARTIALLY_COMPLETED,60,objective);
        KeyResult saved = keyResultRepository.saveAndFlush(keyResult);
        keyResultRepository.deleteById(saved.getId());
        assertThat(keyResultRepository.findById(saved.getId()).isPresent()).isFalse();
    }


    @Test
    public void should_get_keyresult_when_i_provide_required_data() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        Date endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Plan plan = new Plan("read plan", new Date(), endDate);
        planRepository.saveAndFlush(plan);
        Objective objective = new Objective("read objective", "objective label", plan);
        objectiveRepository.saveAndFlush(objective);
        KeyResult keyResult = new KeyResult("read keyresult",30, KeyResultStatus.PARTIALLY_COMPLETED,60,objective);
        KeyResult saved = keyResultRepository.saveAndFlush(keyResult);
        assertThat(keyResultRepository.findById(saved.getId()).isPresent()).isTrue();
    }


}
