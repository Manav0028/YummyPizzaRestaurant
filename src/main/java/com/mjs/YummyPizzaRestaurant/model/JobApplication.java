package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.*;

@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;


    @Column
    private String firstName ;
    @Column
    private String lastName ;
    @Column
    private String email ;
    @Column
    private Integer phoneNumber ;
    @Column
    private Integer jobVacancyId ;

    public JobApplication() {
    }

    public JobApplication(Integer id, String firstName, String lastName, String email, Integer phoneNumber, Integer jobVacancyId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobVacancyId = jobVacancyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getJobVacancyId() {
        return jobVacancyId;
    }

    public void setJobVacancyId(Integer jobVacancyId) {
        this.jobVacancyId = jobVacancyId;
    }
}
