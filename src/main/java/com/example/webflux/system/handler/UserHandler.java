package com.example.webflux.system.handler;

import com.example.webflux.system.entity.User;
import com.example.webflux.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/1/19 16:39
 * @File UserHandler
 * @Software IntelliJ IDEA
 * @description 处理方法  类似于controller中的方法
 */
@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> getUserByUserId(ServerRequest request){
        String userId = request.queryParam("userId").get();
        User user= userService.findUserById(userId);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(user),User.class);
    }

    public Mono<ServerResponse> getAllUser(ServerRequest serverRequest){
        List<User> allUser = userService.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Flux.fromIterable(allUser),User.class);
    }


}
