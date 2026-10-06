package com.project.gallery.dao;

import java.util.List;

import com.project.gallery.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import com.project.gallery.utility.EntityManagerUtil;

public class UserDaoImpl implements IUserDao {

    @Override
    public void saveUser(User user) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            try {
                em.getTransaction().begin();
                em.persist(user);
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
    public User getUserById(Integer userId) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            return em.find(User.class, userId);
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            return em.createQuery("SELECT u FROM User u", User.class)
                    .getResultList();
        }
    }

    @Override
    public void updateUser(User user) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            try {
                em.getTransaction().begin();
                em.merge(user);
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
    public void deleteUser(Integer userId) {
        try (EntityManager em = EntityManagerUtil.getEntityManager()) {
            try {
                em.getTransaction().begin();
                User user = em.find(User.class, userId);
                if (user != null) {
                    em.remove(user);
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
