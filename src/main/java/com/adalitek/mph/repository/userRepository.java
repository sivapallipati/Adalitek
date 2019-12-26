package com.adalitek.mph.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adalitek.mph.model.user;



@Repository
public interface userRepository extends JpaRepository<user, Integer> {
    public user findByEmail(String email);
}
