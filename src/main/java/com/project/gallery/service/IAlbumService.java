package com.project.gallery.service;

import java.util.List;

import com.project.gallery.entity.Album;

public interface IAlbumService {

    void saveAlbum(Album album);

    Album getAlbumByAlbumId(Integer albumId);

    List<Album> getAllAlbums();

    List<Album> getAlbumsByUserId(Integer userId);

    void updateAlbum(Album album);

    void deleteAlbum(Integer albumId);
}
