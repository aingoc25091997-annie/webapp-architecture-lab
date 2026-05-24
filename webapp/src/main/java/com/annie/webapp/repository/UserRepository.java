package com.annie.webapp.repository;

import com.annie.webapp.model.User;

import java.util.Optional;

public interface UserRepository{
    int save(User user);
    Optional<User> findByUser(String username);
}
