package com.company.service;

import com.company.entity.Authority;
import com.company.entity.AuthorityUser;
import com.company.entity.User;
import com.company.repository.AuthorityUserRepository;
import com.company.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepo;
    private final AuthorityUserRepository authorityUserRepo;

    public CustomUserDetailsServiceImpl(UserRepository userRepo, AuthorityUserRepository authorityUserRepo) {
        this.userRepo = userRepo;
        this.authorityUserRepo = authorityUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Authority authority = authorityUserRepo.findAuthorityByUserId(user.getId());

        return org.springframework.security.core.userdetails.User
                .withUsername(email)
                .password(user.getPassword())
                .authorities(authority.getName())
                .build();
    }
}
