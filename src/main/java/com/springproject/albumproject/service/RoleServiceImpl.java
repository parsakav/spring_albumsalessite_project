package com.springproject.albumproject.service;

import com.springproject.albumproject.model.Role;
import com.springproject.albumproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RoleServiceImpl implements RoleService{
@Autowired
private RoleRepository roleRepository;


    @Override
    public Role saveRole(Role role) {


        return roleRepository.save(role);


    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id);
    }


}
