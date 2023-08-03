package com.internship.falcon.repository;

import com.internship.falcon.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserRepository extends JpaRepository<User, Integer> , JpaSpecificationExecutor<User> {

    Page<User> findAllByUserSurname(String userSurname,Pageable pageable);
    long countByUserSurname(String userSurname);
}
