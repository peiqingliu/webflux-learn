package com.example.webflux.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/1/19 14:40
 * @File User
 * @Software IntelliJ IDEA
 * @description todo
 */
@Builder
@Data
@Entity(name = "t_user")
@Table(name="t_user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    private String id;

    @Column(name="username",length = 200)
    private String username;

    private String password;

    private int age;

    private int sex;
}
