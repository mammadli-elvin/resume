package com.company.service.impl;

import com.company.entity.Authority;
import com.company.repository.AuthorityUserRepository;
import com.company.service.inter.AuthorityUserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorityUserServiceImpl implements AuthorityUserServiceInter {
    @Autowired
    private AuthorityUserRepository authorityUserRepo;

    @Override
    public Authority findAuthorityByUserId(int userId) {
        return authorityUserRepo.findAuthorityByUserId(userId);
    }
}

