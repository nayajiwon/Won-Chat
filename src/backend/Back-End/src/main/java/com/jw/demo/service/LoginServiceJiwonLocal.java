package com.jw.demo.service;
import com.jw.demo.dto.NaverUserDto;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;


@Service
public interface LoginServiceJiwonLocal {
    public StringBuffer httpConnectwithAPI(int responseCode, HttpURLConnection con);
    public StringBuffer requestUrlforNaverLogin(String apiUrl);
    public StringBuffer requestUrlforUserInfo(String apiUrl, String access_Token);
    public String requestNaverLoginScreenUrl();
    public NaverUserDto requestNaverUserAccessToken(String authCode, String state);
    public NaverUserDto requestNaverUserInfo(String access_token);

    //지원 로컬 서버 네아로 테스트용 함수
    public String JiWon_Local_OnLy_requestNaverLoginScreenUrl();
    public NaverUserDto JiWon_Local_OnLy_requestNaverUserAccessToken(String authCode, String state);


}