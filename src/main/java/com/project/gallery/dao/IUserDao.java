package com.project.gallery.dao;

import java.util.List;

import com.project.gallery.entity.User;

public interface IUserDao {

    void saveUser(User user);

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(Integer userId);
}
