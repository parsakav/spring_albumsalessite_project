package com.springproject.albumproject.service;


import com.springproject.albumproject.model.Role;
import com.springproject.albumproject.model.User;
import com.springproject.albumproject.repository.RoleRepository;
import com.springproject.albumproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


   private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
private RoleService roleService;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService) {
this.roleService=roleService;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return         userRepository.save(user);

    }



}