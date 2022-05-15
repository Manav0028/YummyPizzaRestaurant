package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class JobVacancy {

    @Id
    private Integer id ;

    private String positionName ;
    private String jobDescription ;
    private Integer numberOfPositions ;
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

    public String getPositionName() {
        return positionName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public Integer getNumberOfPositions() {
        return numberOfPositions;
    }

    public Date getLastDateToApply() {
        return lastDateToApply;
    }
}
