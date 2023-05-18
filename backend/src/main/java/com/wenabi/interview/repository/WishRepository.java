package com.wenabi.interview.repository;

import com.wenabi.interview.repository.jpa.WishJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WishRepository extends JpaRepository<WishJpa, Long> {

    /**
     * @param pageable the pageable to request a paged result, can be {@link Pageable#unpaged()}, must not be
     *          {@literal null}.
     * @return {@link WishJpa}s in a {@link Page}
     */
    Page<WishJpa> findAll(Pageable pageable);
}
