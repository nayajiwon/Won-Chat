package com.jw.demo.Controller;

import com.jw.demo.Model.Entity.User;
import com.jw.demo.Service.RedisService;
import com.jw.demo.Service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    RedisService redisSevice;
    @PostMapping
    public void loginUser(@RequestBody User user) throws Exception {
        String email = user.getEmail();
        String pwd = user.getPassword();
        log.info(email);
        log.info(pwd);
        if (userLoginService.checkAvailableUser(email,pwd)){
            redisSevice.saveRedis(email);
        };
    }
}
