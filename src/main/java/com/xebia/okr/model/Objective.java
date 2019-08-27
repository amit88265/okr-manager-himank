package com.xebia.okr.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int objective_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan_id;
    private String description;
    private String category;
    private Date quarter;
    @OneToMany(targetEntity = KeyResult.class,mappedBy = "objective_id",cascade = CascadeType.ALL)
    private List<KeyResult> kr_list;
    private Date last_updated_timestamp;
    private String status;

    public int getObjective_id() {
        return objective_id;
    }

    public void setObjective_id(int objective_id) {
        this.objective_id = objective_id;
    }

    public Plan getPlan() {
        return plan_id;
    }

    public void setPlan(Plan plan_id) {
        this.plan_id = plan_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getQuarter() {
        return quarter;
    }

    public void setQuarter(Date quarter) {
        this.quarter = quarter;
    }

    public List<KeyResult> getKr_list() {
        return kr_list;
    }

    public void setKr_list(List<KeyResult> kr_list) {
        this.kr_list = kr_list;
    }

    public Date getLast_updated_timestamp() {
        return last_updated_timestamp;
    }

    public void setLast_updated_timestamp(Date last_updated_timestamp) {
        this.last_updated_timestamp = last_updated_timestamp;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
