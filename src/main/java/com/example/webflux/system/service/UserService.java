package com.example.webflux.system.service;

import com.example.webflux.system.entity.User;

import java.util.List;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/1/19 14:46
 * @File UserService
 * @Software IntelliJ IDEA
 * @description todo
 */
public interface UserService {

    User save(User user);

    List<User> findAll();

    User findUserById(String id);
}
