package com.wenabi.interview.adapter;

import com.wenabi.interview.domain.Wish;
import com.wenabi.interview.domain.WishByStatusStats;
import com.wenabi.interview.repository.WishRepository;
import com.wenabi.interview.repository.mapper.WishMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WishAdapterImpl implements WishAdapter {

    private final WishRepository wishRepository;
    private final WishMapper wishMapper;

    @Override
    public Page<Wish> getWishesByPageAndUserId(@NonNull Pageable pageable, @NonNull Long userId) {
        List wishes = wishRepository.findByInitiativeCoordinatorProfileUserId(pageable, userId).stream().map(wishMapper::mapToWish).collect(Collectors.toList());
        return new PageImpl<>(wishes, pageable, pageable.getPageSize());
    }

    @Override
    public List<WishByStatusStats> countWishesByStatusAndUserId(@NonNull Long userId) {
        return wishRepository.countWishesByStatusAndUserIdCountedAndGroupedByStatus(userId).stream().map(wishMapper::mapToWishByStatusStats).collect(Collectors.toList());
    }
}
