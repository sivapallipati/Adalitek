package com.adalitek.mph.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.adalitek.mph.model.admin;
import com.adalitek.mph.model.user;
import com.adalitek.mph.repository.adminRepository;
import com.adalitek.mph.repository.userRepository;



@Service
public class userServiceImpl implements userService {

    private userRepository userRepository;
    private adminRepository adminRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public userServiceImpl(userRepository userRepository, adminRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.adminRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public user findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public user saveUser(user user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        admin userAdmin =adminRepository.findByAdmin("ADMIN");
        user.setRoles(new HashSet<admin>(Arrays.asList(userAdmin)));
        return userRepository.save(user);
    }
}
