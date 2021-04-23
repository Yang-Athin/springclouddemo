package com.yang.repository;

import com.yang.entity.Menu;

import java.util.List;

public interface MenuRepository {
    public Menu findById(long id);
}
