package com.example.webflux.system.controller;

import com.example.webflux.system.entity.User;
import com.example.webflux.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/1/19 14:49
 * @File UserController
 * @Software IntelliJ IDEA
 * @description 基于注解方式
 */
@RestController
@RequestMapping("/system")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/hello")
    public Mono<String> hello() {   // 【改】返回类型为Mono<String>
        return Mono.just("Welcome to reactive world ~");     // 【改】使用Mono.just生成响应式数据
    }

    @GetMapping("/findUserById")
    public Mono<User> findUserById(@RequestParam(value = "userId") String userId){
        User user = userService.findUserById(userId);
        return Mono.just(user);
    }

    @GetMapping("/findAll")
    public Flux<User> findAll(){
        List<User> users = userService.findAll();
        return Flux.fromIterable(users);
    }

    @PostMapping("/save")
    public Mono<ResponseEntity<String>> save(@RequestBody User user){
        User u = userService.save(user);
        if (u != null){
            return Mono.just(new ResponseEntity<String>("添加成功", HttpStatus.CREATED));
        }
        return Mono.just(new ResponseEntity<String>("添加失败", HttpStatus.OK));
    }
}
