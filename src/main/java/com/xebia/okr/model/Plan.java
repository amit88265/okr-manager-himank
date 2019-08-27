package com.xebia.okr.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int plan_id;

    private String remarks;
    private String overall_status;
    @OneToMany(targetEntity = Objective.class,mappedBy = "plan_id",cascade = CascadeType.ALL)
    private List<Objective> o_list;


    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOverall_status() {
        return overall_status;
    }

    public void setOverall_status(String overall_status) {
        this.overall_status = overall_status;
    }

    public List<Objective> getO_list() {
        return o_list;
    }

    public void setO_list(List<Objective> o_list) {
        this.o_list = o_list;
    }
}
