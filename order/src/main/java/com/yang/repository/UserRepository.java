package com.yang.repository;

import com.yang.entity.User;

import java.util.List;

public interface UserRepository {
    public User findById(long id);
}
