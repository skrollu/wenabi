package com.wenabi.interview.service;

import com.wenabi.interview.domain.Wish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface WishService {

    /**
     * @param pageable
     * @return wishes in a {@link Page}
     */
    Page<Wish> getWishesByPageAndUserId(Pageable pageable, Long userId);
}
