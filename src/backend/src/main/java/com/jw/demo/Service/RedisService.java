package com.jw.demo.Service;

import org.springframework.boot.configurationprocessor.json.JSONException;

public interface RedisService {
    void saveRedis(String email) throws JSONException;
}
