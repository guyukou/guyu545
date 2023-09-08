package com.example.springboot.controller;

import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author guyu06
 * @date 2023/4/19 10:35
 */
@Lazy
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/**")
    public String xxx(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getRequestURI();
    }

    @GetMapping("getUserName")
    public String getUserName(Long userId) {
        var userId_to_username = Map.of(
                1L, "garry",
                2L, "tom"
        );

        return userId_to_username.get(userId);
    }
}
