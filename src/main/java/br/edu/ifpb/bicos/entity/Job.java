package br.edu.ifpb.bicos.entity;

import javax.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String jobName;
    private float  income;
    private int quantity;

    @ManyToOne
    private Event event;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobName() {
        return this.jobName;
    }

    public float getIncome() {
        return this.income;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


}
