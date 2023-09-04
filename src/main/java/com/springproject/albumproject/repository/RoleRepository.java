package com.springproject.albumproject.repository;

import com.springproject.albumproject.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
Role findById(long id);
    
}