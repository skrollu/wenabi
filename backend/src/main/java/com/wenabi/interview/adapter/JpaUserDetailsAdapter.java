package com.wenabi.interview.adapter;

import com.wenabi.interview.repository.UserRepository;
import com.wenabi.interview.repository.jpa.UserJpa;
import com.wenabi.interview.repository.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsAdapter implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserJpa> optionalUserJpa = userRepository.findByUsername(username);
        return optionalUserJpa
                .orElseThrow(() -> new UsernameNotFoundException("User not found : " + username));
    }
}