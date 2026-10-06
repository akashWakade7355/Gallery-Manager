package com.project.gallery.service;

import java.util.List;

import com.project.gallery.dao.AlbumDaoImpl;
import com.project.gallery.dao.IAlbumDao;
import com.project.gallery.entity.Album;
import com.project.gallery.entity.User;

public class AlbumServiceImpl implements IAlbumService {

    private IAlbumDao albumDao = new AlbumDaoImpl();

    @Override
    public void saveAlbum(Album album) {
        validateAlbum(album);
        albumDao.saveAlbum(album);
    }

    @Override
    public Album getAlbumByAlbumId(Integer albumId) {
        validateAlbumId(albumId);
        return albumDao.getAlbumByAlbumId(albumId);
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumDao.getAllAlbums();
    }

    @Override
    public List<Album> getAlbumsByUserId(Integer userId) {
        validateUserId(userId);
        return albumDao.getAlbumsByUserId(userId);
    }

    @Override
    public void updateAlbum(Album album) {
        validateAlbum(album);
        validateAlbumId(album.getAlbumId());

        if (albumDao.getAlbumByAlbumId(album.getAlbumId()) == null) {
            throw new IllegalArgumentException("Album not found with id: " + album.getAlbumId());
        }
        albumDao.updateAlbum(album);
    }

    @Override
    public void deleteAlbum(Integer albumId) {
        validateAlbumId(albumId);
        if (albumDao.getAlbumByAlbumId(albumId) == null) {
            throw new IllegalArgumentException("Album not found with id: " + albumId);
        }
        albumDao.deleteAlbum(albumId);
    }

    private void validateAlbum(Album album) {
        if (album == null) {
            throw new IllegalArgumentException("Album cannot be null");
        }
        validateAlbumName(album.getAlbumName());
        validateUser(album.getUser());
    }

    private void validateAlbumId(Integer albumId) {
        if (albumId == null || albumId <= 0) {
            throw new IllegalArgumentException("Album id must be a positive number");
        }
    }

    private void validateAlbumName(String albumName) {
        if (albumName == null || albumName.trim().isEmpty()) {
            throw new IllegalArgumentException("Album name cannot be empty");
        }
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Album user cannot be null");
        }
        validateUserId(user.getUserId());
    }

    private void validateUserId(Integer userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("User id must be a positive number");
        }
    }
}
