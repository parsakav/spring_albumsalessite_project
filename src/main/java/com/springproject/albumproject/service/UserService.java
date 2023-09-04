package com.springproject.albumproject.service;

import com.springproject.albumproject.model.Role;
import com.springproject.albumproject.model.User;

import java.util.Set;

public interface UserService {

    public User findUserByUsername(String userName);

    public User saveUser(User user);
}
