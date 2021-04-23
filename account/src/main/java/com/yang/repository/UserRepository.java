package com.yang.repository;

import com.yang.entity.User;

public interface UserRepository {
    public User login(String username, String password);

}
