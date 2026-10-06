package com.project.gallery.dao;

import java.util.List;

import com.project.gallery.entity.Media;
import com.project.gallery.entity.MediaType;
import com.project.gallery.utility.EntityManagerUtil;

import jakarta.persistence.EntityManager;

public class MediaDaoImpl implements IMediaDao {

    @Override
    public void saveMedia(Media media) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            try {
                em.getTransaction().begin();
                em.persist(media);
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
    public Media getMediaByMediaId(Integer mediaId) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            return em.find(Media.class, mediaId);
        }
    }

    @Override
    public List<Media> getAllMedia() {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            return em.createQuery("SELECT m FROM Media m", Media.class)
                    .getResultList();
        }
    }

    @Override
    public List<Media> getMediaByUserId(Integer userId) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            return em.createQuery("SELECT m FROM Media m WHERE m.user.userId = :userId", Media.class)
                    .setParameter("userId", userId)
                    .getResultList();
        }
    }

    @Override
    public List<Media> getMediaByAlbumId(Integer albumId) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            return em.createQuery("SELECT m FROM Media m WHERE m.album.albumId = :albumId", Media.class)
                    .setParameter("albumId", albumId)
                    .getResultList();
        }
    }

    @Override
    public List<Media> getMediaByMediaType(MediaType mediaType) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            return em.createQuery("SELECT m FROM Media m WHERE m.mediaType = :mediaType", Media.class)
                    .setParameter("mediaType", mediaType)
                    .getResultList();
        }
    }

    @Override
    public void updateMedia(Media media) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            try {
                em.getTransaction().begin();
                em.merge(media);
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
    public void deleteMedia(Integer mediaId) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            try {
                em.getTransaction().begin();
                Media media = em.find(Media.class, mediaId);
                if (media != null) {
                    em.remove(media);
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
