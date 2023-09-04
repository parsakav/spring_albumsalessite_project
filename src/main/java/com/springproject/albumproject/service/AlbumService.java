package com.springproject.albumproject.service;



import com.springproject.albumproject.model.Album;
import com.springproject.albumproject.model.Singer;

import java.util.List;

public interface AlbumService {
    Album saveAlbum(Album singer);
    List<Album> getAllAlbum();
    Album getAlbumById(Long id);
}
