package com.example.webflux.system.router;

import com.example.webflux.system.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author LiuPeiQing
 * @version 1.0
 * @date 2020/1/19 16:55
 * @File RoutingConfiguration
 * @Software IntelliJ IDEA
 * @description 路由信息 类似于controller中的requestMapping
 */
@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler){
        return route(GET("/system/findUserByIdRouter").and(accept(MediaType.APPLICATION_JSON)),userHandler :: getUserByUserId)
                .andRoute(GET("system/findAllRouter"),userHandler :: getAllUser);
    }
}
