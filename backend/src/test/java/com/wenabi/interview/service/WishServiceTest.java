package com.wenabi.interview.service;

import com.wenabi.interview.adapter.WishAdapter;
import com.wenabi.interview.adapter.WishAdapterImpl;
import com.wenabi.interview.domain.Wish;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WishServiceTest {

    @Test
    void getWishesByPage_withANullPageable_givesNothing() {
        WishAdapter wishAdapter = mock(WishAdapterImpl.class);
        when(wishAdapter.getWishesByPage(null))
                .thenReturn(null);
        WishService instance = new WishServiceImpl(wishAdapter);

        Page<Wish> result = instance.getWishesByPage(null);

        assertThat(result).isNull();
    }

    @Test
    void getWishesByPage_withAValidPageable_givesAListOfWishes() {
        WishAdapter wishAdapter = mock(WishAdapterImpl.class);
        List<Wish> wishes = new ArrayList<>();
        wishes.add(Wish.builder().id(1L).build());
        wishes.add(Wish.builder().id(2L).build());
        Page page = new PageImpl(wishes);
        when(wishAdapter.getWishesByPage(null))
                .thenReturn(page);
        WishService instance = new WishServiceImpl(wishAdapter);

        Page<Wish> result = instance.getWishesByPage(null);

        assertThat(result.getSize()).isEqualTo(2);
        assertThat(result.getContent().get(0).getId()).isEqualTo(1L);
        assertThat(result.getContent().get(1).getId()).isEqualTo(2L);
    }
}
