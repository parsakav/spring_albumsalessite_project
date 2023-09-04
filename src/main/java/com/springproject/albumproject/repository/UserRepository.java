package com.springproject.albumproject.repository;

import com.springproject.albumproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

   /* @Modifying
    @Query("update User u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
    void updateUserById(String firstname, String lastname, Integer userId); */
}