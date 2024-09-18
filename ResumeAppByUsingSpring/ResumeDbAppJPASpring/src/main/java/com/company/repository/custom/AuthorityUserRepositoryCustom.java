package com.company.repository.custom;

import com.company.entity.Authority;

public interface AuthorityUserRepositoryCustom {

    public Authority findAuthorityByUserId(int userId);

}
