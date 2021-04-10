package com.jw.demo.controller;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@Component
@RestController
public class GetNaverLoginMenu{

    OauthProperties oauthProperties = new OauthProperties();

    //http 말고 responseEntity쓰면 http 과정 대신 할 수 있대.
    //꼭 해보기
    public StringBuffer httpConnectwithAPI(String apiUrl){
        StringBuffer httpResult = new StringBuffer();
        httpResult.append("");
        System.out.println(apiUrl);
        if(oauthProperties.getClientId()!=null)
            System.out.println(":::::::: "+oauthProperties.getClientId());

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            System.out.print("responseCode="+responseCode);
            if(responseCode==200) { // 정상 호출
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
            if(responseCode==200) {
                httpResult.append(res.toString());
                System.out.println(res.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return httpResult;
    }

    public String httpUserAccessConnect(String access_Token) {
        //요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> naverUserInfo = new HashMap<>();
        String reqURL = "https://openapi.naver.com/v1/nid/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            //요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                String result = "";
                while ((line = br.readLine()) != null) {
                    result += line;
                    System.out.println(line);
                }
            }

        }catch (IOException e) { e.printStackTrace(); }

        return "aa";
    }

    public void requestUrlforNaverLogin(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
        }catch (IOException e) { e.printStackTrace(); }
    }

    public void requestUrlforUserInfo(String access_Token){
        try {
            String reqURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            //요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);
        }catch (IOException e) { e.printStackTrace(); }
    }
}
