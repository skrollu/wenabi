package com.wenabi.interview.repository;

import com.wenabi.interview.repository.jpa.WishJpa;
import com.wenabi.interview.repository.model.WishByStatusStatsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WishRepository extends JpaRepository<WishJpa, Long> {

    /**
     * @param pageable the pageable to request a paged result, can be {@link Pageable#unpaged()}, must not be
     *          {@literal null}.
     * @return {@link WishJpa}s in a {@link Page}
     */
    Page<WishJpa> findByInitiativeCoordinatorProfileUserId(Pageable pageable, Long userId);

    /**
     * @param userId
     * @return a {@link List} of {@link WishByStatusStatsModel} that regroup numbers of wishes joined to a coordinatorProfile id.
     */
    @Query(value = "SELECT new com.wenabi.interview.repository.model.WishByStatusStatsModel(w.status, COUNT(w.status))" +
            " FROM WishJpa w" +
            " JOIN w.initiative i" +
            " JOIN i.coordinatorProfile p" +
            " WHERE p.id = :userId" +
            " GROUP BY w.status")
    List<WishByStatusStatsModel> countWishesByStatusAndUserIdCountedAndGroupedByStatus(@Param("userId") Long userId);
}
