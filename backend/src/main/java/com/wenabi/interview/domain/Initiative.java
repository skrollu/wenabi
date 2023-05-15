package com.wenabi.interview.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "initiative")
public class Initiative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String streetName;

    private String city;

    private String postalCode;

    private String country;

    @ManyToOne
    private Profile coordinatorProfile;

    public Long getId() {
        return id;
    }

    public Initiative setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Initiative setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public Initiative setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Initiative setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Initiative setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Initiative setCountry(String country) {
        this.country = country;
        return this;
    }

    public Profile getCoordinatorProfile() {
        return coordinatorProfile;
    }

    public Initiative setCoordinatorProfile(Profile coordinatorProfile) {
        this.coordinatorProfile = coordinatorProfile;
        return this;
    }
}
