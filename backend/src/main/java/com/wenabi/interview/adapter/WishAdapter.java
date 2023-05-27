package com.wenabi.interview.adapter;

import com.wenabi.interview.domain.Wish;
import com.wenabi.interview.domain.WishByStatusStats;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface WishAdapter {

    /**
     * @param pageable
     * @return wishes in a {@link Page}
     */
    Page<Wish> getWishesByPageAndUserId(Pageable pageable, Long userId);

    /**
     * @return all wishes counted and grouped by status
     */
    List<WishByStatusStats> countWishesByStatusAndUserId(@NonNull Long userId);
}
