package com.xebia.okr.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "plans")
public class Plan {
    public Date getEndOn() {
        return endOn;
    }

    public void setEndOn(Date endOn) {
        this.endOn = endOn;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Date startOn;

    private Date endOn;

    @OneToMany(mappedBy = "plan")
    private List<Objective> objectives;

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
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

    public Date getStartOn() {
        return startOn;
    }

    public void setStartOn(Date startOn) {
        this.startOn = startOn;
    }


    public Plan(String title, Date startOn, Date endOn) {
        this.title = title;
        this.startOn = startOn;
        this.endOn = endOn;
    }

    Plan() {
    }


    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startOn=" + startOn +
                ", endOn=" + endOn +
                ", objectives=" + objectives +
                '}';
    }
}
