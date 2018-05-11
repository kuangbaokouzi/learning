package com.laowuandhisfriends.springbootdemo.config;

import com.laowuandhisfriends.springbootdemo.domain.User;
import com.laowuandhisfriends.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

/**
 * Router Function
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * servlet interface:
     * ServletRequest -> HttpServletRequest
     * ServletResponse -> HttpServletResponse
     * <p>
     * Spring 5.x:
     * ServerRequest
     * ServerResponse
     */

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"), serverRequest -> {
            Flux<User> userFlux = Flux.fromIterable(userRepository.getAll());
            return ServerResponse.ok().body(userFlux, User.class);
        });
    }
}
