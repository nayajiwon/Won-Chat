package com.jw.demo.DTO;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Users")
@Getter
public class RedisUserDto implements Serializable {
    private String id;
    private String usertoken;

    public void setUsertoken(String token){
        this.usertoken = token;
    }
    @Builder
    public RedisUserDto(String userid){
        this.id = userid;
    }



}
