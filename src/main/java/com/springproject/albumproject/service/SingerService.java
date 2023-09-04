package com.springproject.albumproject.service;

import com.springproject.albumproject.model.Singer;

import java.util.List;

public interface SingerService {
    Singer saveSinger(Singer singer);
    List<Singer> getAllSinger();
    Singer getSingerById(Long id);
}
