package com.springproject.albumproject.service;

import com.springproject.albumproject.model.Singer;
import com.springproject.albumproject.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService{
    @Autowired
   private SingerRepository singerRepository;
    @Override
    public Singer saveSinger(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public List<Singer> getAllSinger() {
        return singerRepository.findAll();
    }

    @Override
    public Singer getSingerById(Long id) {
        return singerRepository.findSingerById(id);
    }
}
