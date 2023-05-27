package com.wenabi.interview.service;

import com.wenabi.interview.adapter.WishAdapter;
import com.wenabi.interview.domain.Wish;
import com.wenabi.interview.domain.WishByStatusStats;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WishServiceImpl implements WishService {

    private final WishAdapter wishAdapter;

    public Page<Wish> getWishesByPageAndUserId(Pageable pageable, Long userId) {
        return wishAdapter.getWishesByPageAndUserId(pageable, userId);
    }

    public List<WishByStatusStats> countWishesByStatusAndUserId(Long userId) {
        return wishAdapter.countWishesByStatusAndUserId(userId);
    }
}
