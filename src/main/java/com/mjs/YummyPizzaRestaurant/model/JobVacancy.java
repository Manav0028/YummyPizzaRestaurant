package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.*;

import java.util.Date;

@Entity
public class JobVacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column
    private String positionName ;
    @Column
    private String jobDescription ;
    @Column
    private Integer numberOfPositions ;
    @Column
    private Date lastDateToApply ;

    public JobVacancy() {
    }

    public JobVacancy(Integer id, String positionName, String jobDescription, Integer numberOfPositions, Date lastDateToApply) {
        this.id = id;
        this.positionName = positionName;
        this.jobDescription = jobDescription;
        this.numberOfPositions = numberOfPositions;
        this.lastDateToApply = lastDateToApply;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Integer getNumberOfPositions() {
        return numberOfPositions;
    }

    public void setNumberOfPositions(Integer numberOfPositions) {
        this.numberOfPositions = numberOfPositions;
    }

    public Date getLastDateToApply() {
        return lastDateToApply;
    }

    public void setLastDateToApply(Date lastDateToApply) {
        this.lastDateToApply = lastDateToApply;
    }
}
