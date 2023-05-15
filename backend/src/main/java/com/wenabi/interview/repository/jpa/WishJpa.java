package com.wenabi.interview.repository.jpa;

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
public class WishJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @NotNull
    @Column(name = "created_date", nullable = false)
    private ZonedDateTime createdDate;

    @ManyToOne
    private ProfileJpa volunteerProfile;

    @ManyToOne
    private InitiativeJpa initiative;

    public Long getId() {
        return id;
    }

    public WishJpa setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public WishJpa setStatus(String status) {
        this.status = status;
        return this;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public WishJpa setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public ProfileJpa getVolunteerProfile() {
        return volunteerProfile;
    }

    public WishJpa setVolunteerProfile(ProfileJpa volunteerProfile) {
        this.volunteerProfile = volunteerProfile;
        return this;
    }

    public InitiativeJpa getInitiative() {
        return initiative;
    }

    public WishJpa setInitiative(InitiativeJpa initiative) {
        this.initiative = initiative;
        return this;
    }

}
