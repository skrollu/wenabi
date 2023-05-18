package com.wenabi.interview.adapter;

import com.wenabi.interview.domain.Wish;
import com.wenabi.interview.repository.WishRepository;
import com.wenabi.interview.repository.jpa.WishJpa;
import com.wenabi.interview.repository.mapper.WishMapper;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WishAdapterTest {

    @Test
    void getWishesByPage_withANullPageable_throwError() {
        WishRepository wishRepository = mock(WishRepository.class);
        // when(wishRepository.findAll((Pageable) null)).thenReturn(null);
        WishMapper wishMapper = mock(WishMapper.class);
        // when(wishMapper.mapToWish(any())).thenReturn(null);
        WishAdapter instance = new WishAdapterImpl(wishRepository, wishMapper);

        assertThrows(NullPointerException.class, () -> instance.getWishesByPage(null));
    }

    @Test
    void getWishesByPage_withAValidPageableAndRepositoryReturnAnEmptyPage_givesAnEmptyPage() {
        WishRepository wishRepository = mock(WishRepository.class);
        PageRequest pageable = PageRequest.of(0, 20, Sort.by("status"));
        when(wishRepository.findAll(pageable)).thenReturn(Page.empty());
        WishMapper wishMapper = mock(WishMapper.class);
        WishAdapter instance = new WishAdapterImpl(wishRepository, wishMapper);

        Page result = instance.getWishesByPage(pageable);

        assertThat(result).isNotNull();
        assertThat(result.isEmpty()).isTrue();
    }

    @Test
    void getWishesByPage_withAValidPageable_givesAValidPage() {
        WishRepository wishRepository = mock(WishRepository.class);
        PageRequest pageable = PageRequest.of(0, 20, Sort.by("status"));
        WishJpa wishJpa = new WishJpa().setId(1L);
        when(wishRepository.findAll(pageable)).thenReturn(new PageImpl(Arrays.asList(wishJpa)));
        WishMapper wishMapper = mock(WishMapper.class);
        when(wishMapper.mapToWish(wishJpa)).thenReturn(Wish.builder().id(1L).build());

        WishAdapter instance = new WishAdapterImpl(wishRepository, wishMapper);

        Page<Wish> result = instance.getWishesByPage(pageable);

        System.out.println(result);
        assertThat(result.getTotalElements()).isOne();
        assertThat(result.getContent().get(0).getId()).isEqualTo(1L);
    }
}
