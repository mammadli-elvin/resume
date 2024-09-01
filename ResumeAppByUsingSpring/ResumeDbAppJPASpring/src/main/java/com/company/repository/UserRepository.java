package com.company.repository;

import com.company.repository.custom.UserRepositoryCustom;
import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

    User findByName(String name);

    User findByNameAndSurname(String name, String surname);

    @Query(value = "SELECT u FROM User u WHERE u.email= ?1")
    User foo(String email);
}
