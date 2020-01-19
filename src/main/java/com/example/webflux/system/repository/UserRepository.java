package com.example.webflux.system.repository;

import com.example.webflux.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/1/19 14:45
 * @File UserRepository
 * @Software IntelliJ IDEA
 * @description todo
 */
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
}
