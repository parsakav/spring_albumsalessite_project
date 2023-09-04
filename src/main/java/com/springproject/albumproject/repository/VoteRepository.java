package com.springproject.albumproject.repository;

import com.springproject.albumproject.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository  extends JpaRepository<Vote,Long> {
}
