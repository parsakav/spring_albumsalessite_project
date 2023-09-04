package com.springproject.albumproject.service;

import com.springproject.albumproject.model.Vote;
import com.springproject.albumproject.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService{
    @Autowired
    private VoteRepository voteRepository;
    @Override
    public Vote saveVote(Vote vote) {
        return voteRepository.save(vote);
    }
}
