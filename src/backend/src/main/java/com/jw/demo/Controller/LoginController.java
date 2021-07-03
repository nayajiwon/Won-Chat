package com.jw.demo.Controller;

import com.jw.demo.Model.Entity.User;
import com.jw.demo.Service.RedisService;
import com.jw.demo.Service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserLoginService userLoginService;
    @Autowired
    RedisService redisSevice;
    @PostMapping //메소드에 여러 매개 변수를 전달
    public boolean loginUser(@RequestBody User user) throws Exception {
        String email = user.getEmail();
        String pwd = user.getPassword();

        if (userLoginService.checkAvailableUser(email,pwd)){
            if (redisSevice.saveRedis(email)) {
                return true;
            }
            else{
                log.info("redis failed");
            }
        };
        return false;

    }
}
