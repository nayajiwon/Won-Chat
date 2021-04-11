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
    public StringBuffer httpConnectwithAPI(int responseCode, HttpURLConnection con){
        StringBuffer httpResult = new StringBuffer();
        httpResult.append("");

        try {
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

    public StringBuffer requestUrlforNaverLogin(String apiUrl){
        StringBuffer ERROR = new StringBuffer();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            return httpConnectwithAPI(responseCode, con);
        }catch (IOException e) { e.printStackTrace(); }

        return ERROR.append("error");
    }

    public StringBuffer requestUrlforUserInfo(String apiUrl, String access_Token){
        StringBuffer ERROR = new StringBuffer();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            //요청에 필요한 Header에 포함될 내용
            con.setRequestProperty("Authorization", "Bearer " + access_Token);
            int responseCode = con.getResponseCode();

            return httpConnectwithAPI(responseCode, con);
        }catch (IOException e) { e.printStackTrace(); }

        return ERROR.append("error");
    }
}
