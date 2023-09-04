package com.springproject.albumproject.repository;

import com.springproject.albumproject.model.Album;
import com.springproject.albumproject.model.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {
    public Album findAlbumById(Long id);
}
