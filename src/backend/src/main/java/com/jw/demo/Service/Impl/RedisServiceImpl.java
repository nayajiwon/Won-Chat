package com.jw.demo.Service.Impl;

import com.jw.demo.DTO.RedisUserDto;
import com.jw.demo.JWT.JwtManager;
import com.jw.demo.Repository.RedisUserRepository;
import com.jw.demo.Service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisServiceImpl implements RedisService {
    @Autowired
    private JwtManager jwtManager;
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RedisUserRepository redisUserRepository;

    @BeforeEach
    void setUp(){

        jwtManager = new JwtManager();
    }


    public void saveRedis(String email) throws JSONException {

        // redis에 set
        final RedisUserDto user =
               RedisUserDto.builder()
                        .userid(email)
                        .build();

        final String token = jwtManager.generateJwtToken(user);
        user.setUsertoken(token);
        RedisUserDto saveUser = redisUserRepository.save(user);
        redisUserRepository.save(saveUser);
        log.info(token);

    }
}
