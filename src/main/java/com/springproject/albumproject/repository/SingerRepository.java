package com.springproject.albumproject.repository;

import com.springproject.albumproject.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository extends JpaRepository<Singer,Long> {
    Singer findSingerById(Long id);
}
