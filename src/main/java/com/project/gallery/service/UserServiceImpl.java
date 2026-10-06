package com.project.gallery.service;

import java.util.List;

import com.project.gallery.dao.IUserDao;
import com.project.gallery.dao.UserDaoImpl;
import com.project.gallery.entity.User;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao = new UserDaoImpl();

    @Override
    public void saveUser(User user) {
        validateUser(user);

        if (userDao.getUserByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("User already exists with email: " + user.getEmail());
        }

        userDao.saveUser(user);
    }

    @Override
    public User getUserById(Integer userId) {
        validateUserId(userId);

        return userDao.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        validateEmail(email);

        return userDao.getUserByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        validateUser(user);
        validateUserId(user.getUserId());

        if (userDao.getUserById(user.getUserId()) == null) {
            throw new IllegalArgumentException("User not found with id: " + user.getUserId());
        }

        User existingUser = userDao.getUserByEmail(user.getEmail());
        if (existingUser != null && !existingUser.getUserId().equals(user.getUserId())) {
            throw new IllegalArgumentException("User already exists with email: " + user.getEmail());
        }

        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        validateUserId(userId);

        if (userDao.getUserById(userId) == null) {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }

        userDao.deleteUser(userId);
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        validateUsername(user.getUsername());
        validateEmail(user.getEmail());
        validatePassword(user.getHashedPassword());
    }

    private void validateUserId(Integer userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("User id must be a positive number");
        }
    }

    private void validateUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
    }

    private void validatePassword(String hashedPassword) {
        if (hashedPassword == null || hashedPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
    }
}
