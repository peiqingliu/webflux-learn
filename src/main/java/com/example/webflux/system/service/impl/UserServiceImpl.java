package com.example.webflux.system.service.impl;

import com.example.webflux.system.entity.User;
import com.example.webflux.system.repository.UserRepository;
import com.example.webflux.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/1/19 14:47
 * @File UserServiceImpl
 * @Software IntelliJ IDEA
 * @description todo
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * 2.0版本getOne 有问题 慎用
     * @param id 主键id
     * @return
     */
    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
    }
}
