package com.wenabi.interview.repository.jpa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profile")
public class ProfileJpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @ManyToOne
    private CompanyJpa company;

    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private UserJpa user;

    public Long getId() {
        return id;
    }

    public ProfileJpa setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ProfileJpa setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ProfileJpa setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CompanyJpa getCompany() {
        return company;
    }

    public ProfileJpa setCompany(CompanyJpa company) {
        this.company = company;
        return this;
    }

    public UserJpa getUser() {
        return user;
    }

    public ProfileJpa setUser(UserJpa user) {
        this.user = user;
        return this;
    }
}
