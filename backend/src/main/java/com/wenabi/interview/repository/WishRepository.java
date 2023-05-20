package com.wenabi.interview.repository;

import com.wenabi.interview.repository.jpa.UserJpa;
import com.wenabi.interview.repository.jpa.WishJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface WishRepository extends JpaRepository<WishJpa, Long> {

    /**
     * @param pageable the pageable to request a paged result, can be {@link Pageable#unpaged()}, must not be
     *          {@literal null}.
     * @return {@link WishJpa}s in a {@link Page}
     */
    Page<WishJpa> findByInitiativeCoordinatorProfileUserId(Pageable pageable, Long id);
}
