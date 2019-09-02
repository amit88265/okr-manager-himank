package com.xebia.okr.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "objectives")
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String label;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "plan_id")
    private Plan plan;


    @OneToMany(mappedBy = "objective")
    private List<KeyResult> keyResults;

    public Objective(String title, String label, Plan plan) {
        this.title = title;
        this.label = label;
        this.plan = plan;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Plan getPlan() {
        return plan;
    }


}
