package com.wenabi.interview.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(name = "wish")
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @NotNull
    @Column(name = "created_date", nullable = false)
    private ZonedDateTime createdDate;

    @ManyToOne
    private Profile volunteerProfile;

    @ManyToOne
    private Initiative initiative;

    public Long getId() {
        return id;
    }

    public Wish setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Wish setStatus(String status) {
        this.status = status;
        return this;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public Wish setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Profile getVolunteerProfile() {
        return volunteerProfile;
    }

    public Wish setVolunteerProfile(Profile volunteerProfile) {
        this.volunteerProfile = volunteerProfile;
        return this;
    }

    public Initiative getInitiative() {
        return initiative;
    }

    public Wish setInitiative(Initiative initiative) {
        this.initiative = initiative;
        return this;
    }

}
