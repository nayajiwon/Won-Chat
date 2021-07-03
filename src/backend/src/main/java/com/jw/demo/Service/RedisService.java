package com.jw.demo.Service;

import org.springframework.boot.configurationprocessor.json.JSONException;

public interface RedisService {
    boolean saveRedis(String email) throws JSONException;
}
