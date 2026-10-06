package com.project.gallery.dao;

import java.util.List;

import com.project.gallery.entity.Album;
import com.project.gallery.utility.EntityManagerUtil;

import jakarta.persistence.EntityManager;

public class AlbumDaoImpl implements IAlbumDao {

    @Override
    public void saveAlbum(Album album) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            try {
                em.getTransaction().begin();
                em.persist(album);
                em.getTransaction().commit();
            } catch (RuntimeException e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw e;
            }
        }
    }

    @Override
    public Album getAlbumByAlbumId(Integer albumId) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            return em.find(Album.class, albumId);
        }
    }

    @Override
    public List<Album> getAllAlbums() {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            return em.createQuery("SELECT a FROM Album a", Album.class)
                    .getResultList();
        }
    }

    @Override
    public List<Album> getAlbumsByUserId(Integer userId) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            return em.createQuery("SELECT a FROM Album a WHERE a.user.userId = :userId", Album.class)
                    .setParameter("userId", userId)
                    .getResultList();
        }
    }

    @Override
    public void updateAlbum(Album album) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            try {
                em.getTransaction().begin();
                em.merge(album);
                em.getTransaction().commit();
            } catch (RuntimeException e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw e;
            }
        }
    }

    @Override
    public void deleteAlbum(Integer albumId) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            try {
                em.getTransaction().begin();
                Album album = em.find(Album.class, albumId);
                if (album != null) {
                    em.remove(album);
                }
                em.getTransaction().commit();
            } catch (RuntimeException e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                throw e;
            }
        }
    }
}
