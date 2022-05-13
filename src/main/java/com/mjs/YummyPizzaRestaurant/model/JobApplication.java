package com.mjs.YummyPizzaRestaurant.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobApplication {

    @Id
    private Integer id ;

    private String firstName ;
    private String lastName ;
    private String email ;
    private Integer phoneNumber ;
    private Integer jobVacancyId ;

    private JobApplication(String text, String txtLastNameText, String txtEmailText, String txtPhoneNumberText) {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getJobVacancyId() {
        return jobVacancyId;
    }
}
