package com.jw.demo.service;
import com.jw.demo.dto.NaverUserDto;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;


@Service
public interface LoginService {
    public StringBuffer httpConnectwithAPI(int responseCode, HttpURLConnection con);
    public StringBuffer requestUrlforNaverLogin(String apiUrl);
    public StringBuffer requestUrlforUserInfo(String apiUrl, String access_Token);
    public String requestNaverLoginScreenUrl();
    public NaverUserDto requestNaverUserAccessToken(String authCode, String state);
    public NaverUserDto requestNaverUserInfo(String access_token);
}