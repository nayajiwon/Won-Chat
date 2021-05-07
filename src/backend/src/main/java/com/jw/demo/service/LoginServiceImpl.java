package com.jw.demo.service;

import com.jw.demo.controller.OauthProperties;
import com.jw.demo.dto.NaverUserDto;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    OauthProperties oauthProperties;
    String NAVER_OAUTH_BASE_URL = "https://nid.naver.com/oauth2.0/authorize?";
    //String NAVER_OAUTH_BASE_URL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    String NAVER_ACCESS_TOKEN_BASE_URL = "https://nid.naver.com/oauth2.0/token";
    String NAVER_ACCESS_API_BASE_URL = "https://openapi.naver.com/v1/nid/me";

    //http 말고 responseEntity쓰면 http 과정 대신 할 수 있대.
    //꼭 해보기
    @Override
    public StringBuffer httpConnectwithAPI(int responseCode, HttpURLConnection con) {
        StringBuffer httpResult = new StringBuffer();
        httpResult.append("");

        try {
            BufferedReader br;
            System.out.print("responseCode=" + responseCode);
            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer res = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                res.append(inputLine);
            }
            br.close();
            if (responseCode == 200) {
                httpResult.append(res.toString());
                System.out.println(res.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return httpResult;
    }

    @Override
    public StringBuffer requestUrlforNaverLogin(String apiUrl) {
        StringBuffer ERROR = new StringBuffer();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            return httpConnectwithAPI(responseCode, con);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ERROR.append("error");
    }

    @Override
    public StringBuffer requestUrlforUserInfo(String apiUrl, String access_Token) {
        StringBuffer ERROR = new StringBuffer();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            //요청에 필요한 Header에 포함될 내용
            con.setRequestProperty("Authorization", "Bearer " + access_Token);
            int responseCode = con.getResponseCode();

            return httpConnectwithAPI(responseCode, con);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ERROR.append("error");
    }

    @Override
    public String requestNaverLoginScreenUrl() {
        String loginUrl;

        //url의 쿼리문을 key, value 형식으로 url 저장
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("response_type", "code");/**인증 과정에 대한 내부 구분값으로 'code'로 전송해야 함, 기본값 "code"**/
        queryParams.add("client_id", oauthProperties.getClientId());
        queryParams.add("redirect_uri", oauthProperties.getRedirectUri());
        /**
         * ##아직안함!!
         * 사이트 간 요청 위조(cross-site request forgery) 공격을 방지하기 위해 애플리케이션에서 생성한 상태 토큰값으로 URL 인코딩을 적용한 값을 사용
         */
        queryParams.add("state", "110");

        //UriComponentsBuilder : 여러개의 파라미터들을 하나로 연결하여 uri 형태로 만들어줌
        URI uri = UriComponentsBuilder.fromUriString(NAVER_OAUTH_BASE_URL)
                .queryParams(queryParams)
                .build().encode()
                .toUri();
        loginUrl = uri.toString();

        //로그인 메뉴를 네아로api로 얻기 위한 http 통신
        requestUrlforNaverLogin(NAVER_ACCESS_TOKEN_BASE_URL);
        System.out.println("loginUrl : " + loginUrl);

        return loginUrl;
    }

    @Override
    public NaverUserDto requestNaverUserAccessToken(String authCode, String state) {
        String toGetAccessTokenURI;
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("grant_type", "authorization_code");
        queryParams.add("client_id", oauthProperties.getClientId());
        queryParams.add("client_secret", oauthProperties.getClientSecret());
        queryParams.add("code", authCode);
        queryParams.add("state", state);

        URI uri = UriComponentsBuilder.fromUriString(NAVER_ACCESS_TOKEN_BASE_URL)
                .queryParams(queryParams)
                .build().encode()
                .toUri();

        toGetAccessTokenURI = uri.toString();

        StringBuffer GetAccessTokenURIRes = new StringBuffer();

        //http통신을 통해 access_token정보를 포함한 json 형식 return
        //json을 stringBuffer형태로 바꿈
        GetAccessTokenURIRes.append(requestUrlforNaverLogin(toGetAccessTokenURI));
        //stringBuffer를 string형태로 바꿈
        String accessRes = GetAccessTokenURIRes.toString();

        System.out.println(accessRes);
        //Return 받은 json형식 중에서 (key : access_token, value : ?) 값을 얻음
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(accessRes);
            Object access_token = jsonObject.get("access_token");
            return requestNaverUserInfo(access_token.toString());

        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }
    //http://nid.naver.com/nidlogin.logout
    public NaverUserDto requestNaverUserInfo(String access_token) {
        //access_token 을 사용해 api 생성후 사용자 정보를 가져옴
        StringBuffer userInfo = requestUrlforUserInfo(NAVER_ACCESS_API_BASE_URL, access_token);
        System.out.println("USER INFO : " + userInfo);

        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(userInfo.toString());
            String company = "N_";

            JSONObject response = (JSONObject) jsonObject.get("response"); //네이버 사용자마다 다른 Id 제공
            String id = response.get("id").toString();
            String email = response.get("email").toString();
            String ID = company.concat(id);

            NaverUserDto newUser = NaverUserDto.builder()
                    .id(ID)
                    .email(email)
                    .build();
            return newUser;
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }

    }
}
