package com.laptrinhweb.security;

import com.laptrinhweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository repository;
    private User user;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            var user = repository.findByEmail(username).orElseThrow(

            );
        return MyUserDetail.builder()
                .email(username)
                .firstname(user.getFirstname())
                .phone(user.getPhone())
                .isAccountNonExpired(true)
                .role(user.getRole())
                .isCredentialsNonExpired(true)
                .isEnabled(user.isEnabled())
                .isNonClocked(user.isNonClocked())
                .lastname(user.getLastname())
                .password(user.getPassword())
                .build();
    }

    public User getCurrentUser() {
        return user;
    }
}
