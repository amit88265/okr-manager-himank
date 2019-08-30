package com.xebia.okr.domain;

import javax.persistence.*;

@Entity
@Table(name = "key_results")
public class KeyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private int percentageFinished;

    private KeyResultStatus status;

    private int confidenceScore;

    @ManyToOne
    @JoinColumn(name = "objective_id")
    private Objective objective;

    KeyResult() {
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public KeyResult(String title, int percantageFinished, KeyResultStatus status, int confidenceScore) {
        this.title = title;
        this.percentageFinished = percantageFinished;
        this.status = status;
        this.confidenceScore = confidenceScore;
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPercentageFinished() {
        return percentageFinished;
    }

    public void setPercentageFinished(int percentageFinished) {
        this.percentageFinished = percentageFinished;
    }

    public KeyResultStatus getStatus() {
        return status;
    }

    public void setStatus(KeyResultStatus status) {
        this.status = status;
    }

    public int getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(int confidenceScore) {
        this.confidenceScore = confidenceScore;
    }


}
