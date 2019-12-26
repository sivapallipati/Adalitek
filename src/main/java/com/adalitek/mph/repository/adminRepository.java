package com.adalitek.mph.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adalitek.mph.model.admin;



@Repository
public interface adminRepository extends JpaRepository<admin, Integer> {
    public admin findByAdmin(String admin);
}
