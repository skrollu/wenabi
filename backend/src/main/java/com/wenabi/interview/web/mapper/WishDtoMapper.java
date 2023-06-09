package com.wenabi.interview.web.mapper;

import com.wenabi.interview.domain.Wish;
import com.wenabi.interview.domain.WishByStatusStats;
import com.wenabi.interview.web.response.WishByStatusStatOutputDto;
import com.wenabi.interview.web.response.WishOutputDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface WishDtoMapper {

    WishOutputDto mapToWishOutputDto(Wish wish);
    WishByStatusStatOutputDto mapToWishByStatusStatOutputDto(WishByStatusStats wishByStatusStats);
}
