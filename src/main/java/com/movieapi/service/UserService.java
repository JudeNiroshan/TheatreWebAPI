package com.movieapi.service;

import com.movieapi.model.User;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
public interface UserService {

    List<User> getUsersList();
    User getUserById(Long id);
    User findByUsername(String username);
    User addUser(User user);
    User editUser(User user);
    void deleteUser(Long id);
    boolean usernameExists(String username);
}
