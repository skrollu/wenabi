package com.wenabi.interview.repository;

import com.wenabi.interview.repository.jpa.UserJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserJpa, Long> {
    Optional<UserJpa> findByUsername(String username);
}