package com.project.gallery.dao;

import java.util.List;

import com.project.gallery.entity.Album;

public interface IAlbumDao {

    void saveAlbum(Album album);

    Album getAlbumByAlbumId(Integer albumId);

    List<Album> getAllAlbums();

    List<Album> getAlbumsByUserId(Integer userId);

    void updateAlbum(Album album);

    void deleteAlbum(Integer albumId);
}
