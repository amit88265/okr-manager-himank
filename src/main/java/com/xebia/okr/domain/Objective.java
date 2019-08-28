package com.xebia.okr.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="objectives")
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String labels;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;


    @OneToMany(mappedBy = "objective")
    private List<KeyResult> keyResults;

    public Objective(String title, String labels, Plan plan, List<KeyResult> keyResults) {
        this.title = title;
        this.labels = labels;
        this.plan = plan;
        this.keyResults = keyResults;
    }

    Objective() {
    }



    public long getId() {
        return id;
    }

    public List<KeyResult> getKeyResults() {
        return keyResults;
    }

    public void setKeyResults(List<KeyResult> keyResults) {
        this.keyResults = keyResults;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }


}
