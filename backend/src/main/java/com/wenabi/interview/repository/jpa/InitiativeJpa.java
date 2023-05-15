package com.wenabi.interview.repository.jpa;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "initiative")
public class InitiativeJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String streetName;

    private String city;

    private String postalCode;

    private String country;

    @ManyToOne
    private ProfileJpa coordinatorProfile;

    public Long getId() {
        return id;
    }

    public InitiativeJpa setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public InitiativeJpa setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public InitiativeJpa setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public InitiativeJpa setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public InitiativeJpa setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public InitiativeJpa setCountry(String country) {
        this.country = country;
        return this;
    }

    public ProfileJpa getCoordinatorProfile() {
        return coordinatorProfile;
    }

    public InitiativeJpa setCoordinatorProfile(ProfileJpa coordinatorProfile) {
        this.coordinatorProfile = coordinatorProfile;
        return this;
    }
}
