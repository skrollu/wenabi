package com.wenabi.interview.web.resource;

import com.wenabi.interview.repository.jpa.UserJpa;
import com.wenabi.interview.service.WishService;
import com.wenabi.interview.web.mapper.WishDtoMapper;
import com.wenabi.interview.web.response.WishByStatusStatOutputDto;
import com.wenabi.interview.web.response.WishOutputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/wishes")
@RequiredArgsConstructor
public class WishResource {

    private final WishDtoMapper wishDtoMapper;
    private final WishService wishService;

    @PreAuthorize("hasRole('ASSOCIATION')")
    @GetMapping
    ResponseEntity<Page<WishOutputDto>> getWishesByPageAndSortedByStatus(@PageableDefault(size = 10, page = 0, direction = Sort.Direction.ASC, sort = "status") Pageable pageable, Authentication principal) {
        UserJpa user = (UserJpa) principal.getPrincipal();
        List<WishOutputDto> result = wishService.getWishesByPageAndUserId(pageable, user.getId()).stream().map(wishDtoMapper::mapToWishOutputDto).collect(Collectors.toList());
        return ResponseEntity.ok(new PageImpl<WishOutputDto>(result, pageable, pageable.getPageSize()));
    }

    @PreAuthorize("hasRole('ASSOCIATION')")
    @GetMapping("/stats")
    ResponseEntity<List<WishByStatusStatOutputDto>> getWishesStats(Authentication principal) {
        UserJpa user = (UserJpa)principal.getPrincipal();
        List<WishByStatusStatOutputDto> result = wishService.countWishesByStatusAndUserId(user.getId()).stream().map(wishDtoMapper::mapToWishByStatusStatOutputDto).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

}
