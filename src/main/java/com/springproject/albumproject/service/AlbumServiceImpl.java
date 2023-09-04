package com.springproject.albumproject.service;

import com.springproject.albumproject.model.Album;
import com.springproject.albumproject.model.Singer;
import com.springproject.albumproject.repository.AlbumRepository;
import com.springproject.albumproject.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
   private AlbumRepository albumRepository;
    @Override
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public List<Album> getAllAlbum() {
        return albumRepository.findAll();
    }

    @Override
    public Album getAlbumById(Long id) {
        return albumRepository.findAlbumById(id);
    }



}
