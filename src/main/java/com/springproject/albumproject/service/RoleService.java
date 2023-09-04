package com.springproject.albumproject.service;

import com.springproject.albumproject.model.Role;

public interface RoleService {
     Role saveRole(Role role);
     Role findById(long id);

}
