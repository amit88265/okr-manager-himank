package com.xebia.okr.model;

import javax.persistence.*;

@Entity
public class KeyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int keyresult_id;
    private String description;
    private int percantage_complete;
    private int confidence_level;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objective_id")
    private Objective objective_id;
    private String status;

    public int getId() {
        return keyresult_id;
    }

    public void setId(int id) {
        this.keyresult_id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPercantage_complete() {
        return percantage_complete;
    }

    public void setPercantage_complete(int percantage_complete) {
        this.percantage_complete = percantage_complete;
    }

    public int getConfidence_level() {
        return confidence_level;
    }

    public void setConfidence_level(int confidence_level) {
        this.confidence_level = confidence_level;
    }

    public Objective getObjective() {
        return objective_id;
    }

    public void setObjective(Objective objective_id) {
        this.objective_id = objective_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
