package com.jw.demo.controller;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;

/***
 *         String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
 *         apiURL += "&client_id=" + oauthProperties.getClientId();
 *         apiURL += "&redirect_uri=" + oauthProperties.getRedirectUri();
 *         apiURL += "&state=" + 110;
 *
 ***/

@RestController
@RequestMapping("/login")
public class OauthController {
    //네이버 로그인 api 순서
    /**
     * 1) 네이버 로그인 창을 통해 로그인 함
     * 2) 로그인 성공시에 call back 발생하여 등록한 call back url 로 state 와 code 발행
     * 3) code 로 접근토큰 발행 api 호출
     * 4) 접근토큰을 통해 사용자 정보 받는 api 호출
     */

    //.properties 파일에 있는 정보 가져오기, 이렇게 해도 되는지 모르겠음
    @Autowired
    OauthProperties oauthProperties;

    String NAVER_OAUTH_BASE_URL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    String NAVER_ACCESS_TOKEN_BASE_URL = "https://nid.naver.com/oauth2.0/token";
    String NAVER_ACCESS_API_BASE_URL = "https://openapi.naver.com/v1/nid/me";

    /***
     * 네이버 로그인 메뉴로 리다이렉트
     *     http://localhost:8080/login/naver/menu*
     */
    @GetMapping("/naver/menu")
    public RedirectView getNaverLoginScreen(){
        String loginUrl;

        //url의 쿼리문을 key, value 형식으로 url 저장
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("client_id", oauthProperties.getClientId());
        queryParams.add("redirect_uri", oauthProperties.getRedirectUri());
        queryParams.add("state", "110");

        //UriComponentsBuilder : 여러개의 파라미터들을 하나로 연결하여 uri 형태로 만들어줌
        URI uri = UriComponentsBuilder.fromUriString(NAVER_OAUTH_BASE_URL)
                .queryParams(queryParams)
                .build().encode()
                .toUri();
        loginUrl = uri.toString();

        //로그인 메뉴를 네아로api로 얻기 위한 http 통신
        GetNaverLoginMenu getNaverLoginMenu = new GetNaverLoginMenu();
        getNaverLoginMenu.requestUrlforNaverLogin(NAVER_ACCESS_TOKEN_BASE_URL);
        return new RedirectView(loginUrl);
    }

    /***
     * 네이버 로그인 완료시 자동으로 요청되는 call back url
     * 주어진 권한코드와 상태코드를 사용해 api 호출 -> access_token받아옴
     */
    @GetMapping("/oauth2/code/naver")
    public void getNaverCallBack(@RequestParam(value="code") String authCode, @RequestParam(value="state") String state) throws ParseException {

        String toGetAccessTokenURI;
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("grant_type", "authorization_code");
        queryParams.add("client_id", oauthProperties.getClientId());
        queryParams.add("client_secret", oauthProperties.getClientSecret());
        queryParams.add("code", authCode);
        queryParams.add("state", "110");

        URI uri = UriComponentsBuilder.fromUriString(NAVER_ACCESS_TOKEN_BASE_URL)
                .queryParams(queryParams)
                .build().encode()
                .toUri();

        toGetAccessTokenURI = uri.toString();

        StringBuffer GetAccessTokenURIRes= new StringBuffer();

        //http통신을 통해 access_token정보를 포함한 json 형식 return
        GetNaverLoginMenu getNaverLoginMenu = new GetNaverLoginMenu();
        //json을 stringBuffer형태로 바꿈
        GetAccessTokenURIRes.append(getNaverLoginMenu.requestUrlforNaverLogin(toGetAccessTokenURI));
        //stringBuffer를 string형태로 바꿈
        String accessRes = GetAccessTokenURIRes.toString();

        System.out.println(accessRes);
        //Return 받은 json형식 중에서 (key : access_token, value : ?) 값을 얻음
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(accessRes);
        Object access_token = jsonObject.get("access_token");

        //access_token 을 사용해 api 생성후 사용자 정보를 가져옴
        getNaverLoginMenu.requestUrlforUserInfo(NAVER_ACCESS_API_BASE_URL, access_token.toString());

        return;

    }
}
