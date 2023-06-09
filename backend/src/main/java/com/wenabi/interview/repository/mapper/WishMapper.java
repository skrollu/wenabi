package com.wenabi.interview.repository.mapper;

import com.wenabi.interview.domain.Wish;
import com.wenabi.interview.domain.WishByStatusStats;
import com.wenabi.interview.repository.jpa.WishJpa;
import com.wenabi.interview.repository.model.WishByStatusStatsModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface WishMapper {

    Wish mapToWish(WishJpa wishJpa);
    WishByStatusStats mapToWishByStatusStats(WishByStatusStatsModel wishByStatusStatsModel);
}
