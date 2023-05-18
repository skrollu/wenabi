package com.wenabi.interview.adapter;

import com.wenabi.interview.domain.Wish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface WishAdapter {

    /**
     * @param pageable
     * @return wishes in a {@link Page}
     */
    Page<Wish> getWishesByPage(Pageable pageable);
}
