package com.jw.demo.controller;
import com.jw.demo.dao.SessionDao;
import com.jw.demo.dto.NaverUserDto;
import com.jw.demo.service.LoginServiceImpl;
import com.jw.demo.service.MemberService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/***
 *         String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
 *         apiURL += "&client_id=" + oauthProperties.getClientId();
 *         apiURL += "&redirect_uri=" + oauthProperties.getRedirectUri();
 *         apiURL += "&state=" + 110;
 *
 ***/
@CrossOrigin(origins = "https://nid.naver.com")
@RestController
//@RequestMapping("/login")
public class OauthController {
    //네이버 로그인 api 순서
    /**
     * 1) 네이버 로그인 창을 통해 로그인 함
     * 2) 로그인 성공시에 call back 발생하여 등록한 call back url 로 state 와 code 발행
     * 3) code 로 접근토큰 발행 api 호출
     * 4) 접근토큰을 통해 사용자 정보 받는 api 호출
     */

    @Autowired
    MemberService memberService;

    @Autowired
    LoginServiceImpl loginServiceImpl;


    /***
     * 네이버 로그인 메뉴로 리다이렉트
     *     http://localhost:8080/api/login/naver/menu
     *     http://172.30.1.48:8080/api/login/naver/menu
     *
     *
     */



    @CrossOrigin(origins = "http://49.50.160.107:80")  //요청 자원을 허락할 origin
    @GetMapping("/api/login/naver/menu")
    public RedirectView getNaverLoginScreen(){
        System.out.println("api/login/naver/menu 출력");
        //String loginUrl = loginServiceImpl.requestNaverLoginScreenUrl();

        //return new RedirectView(loginUrl);
        return new RedirectView("http://118.67.132.184:8080/api/login/naver/menu/2");
    }

    @GetMapping("/api/login/naver/menu/2")
    public void getNaverLoginScreenTest(){
        System.out.println("\n\n호출이 됨\n\n");
        String loginUrl = loginServiceImpl.requestNaverLoginScreenUrl();

        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        // parameter 세팅
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        // REST API 호출
        String result = restTemplate.postForObject(loginUrl, map, String.class);
        System.out.println("------------------ TEST 결과 ------------------");
        System.out.println(result);
        return;
    }

    // httpServletResponse.sendRedirect
    @GetMapping("/api/login/naver/menu")
    public void exRedirect3(HttpServletResponse httpServletResponse) throws IOException {
        System.out.println("\n\n호출이 됨\n\n");
        String loginUrl = loginServiceImpl.requestNaverLoginScreenUrl();

        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        // parameter 세팅
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        // REST API 호출
        String result = restTemplate.postForObject(loginUrl, map, String.class);
        System.out.println("------------------ TEST 결과 ------------------");
        System.out.println(result);
        System.out.println("api/login/naver/menu 출력-1");

        httpServletResponse.sendRedirect(loginUrl);

    }
    // httpHeaders
/*
    @GetMapping("/api/login/naver/menu")
    public ResponseEntity<Object> exRedirect5() throws URISyntaxException {
        System.out.println("api/login/naver/menu 출력-2");
        String loginUrl = loginServiceImpl.requestNaverLoginScreenUrl();

        URI redirectUri = new URI(loginUrl);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

*/
    /***
     * 네이버 로그인 완료시 자동으로 요청되는 call back url
     * 주어진 권한코드와 상태코드를 사용해 api 호출 -> access_token받아옴
     */
    //로그아웃 url : http://nid.naver.com/nidlogin.logout
    //http://localhost:8080/login/oauth2/code/naver
    @GetMapping("/api/login/oauth2/code/naver")
    public void getNaverCallBack(HttpServletRequest http,  @RequestParam(value="code") String authCode, @RequestParam(value="state") String state) throws ParseException {

        String ID, EMAIL;
        //네이버api로 부터 인증된 사용자 access_token로 user정보 가져옴
        NaverUserDto user = loginServiceImpl.requestNaverUserAccessToken(authCode, state);
        if(user == null){
            System.out.print("Error Handling 해주기");
            return; //error page로 리다이렉트 해줄것
        }
        ID = user.getId();
        EMAIL = user.getEmail();
        HttpSession session = http.getSession();

        //회원가입이 됐다면 user dto 객체 리턴
        NaverUserDto memberId = memberService.getUserbyId(ID);

        //회원가입이 되지 않았다면 회원가입 창으로 이동 -> 회원가입 성공시 세션 제공, 거부시 리턴
        if(memberId == null){
            /**
             * 회원가입 하는 창으로 이동!!
             */
            System.out.println(ID + "를 mysql에 insert 할 것! ");

            //N_42369262
            memberService.InsertUser(ID, EMAIL, ""); //회원가입 한다고 하면 db에 삽입
            System.out.println("없는 사용자 입니다");
        }
        else{ //회원가입 돼있을 때
            System.out.println("회원입니다. ");
            SessionDao sessionDao = SessionDao.builder()
                    .Id(ID) //고유의 id로 세션값 부여
                    .build();

            http.setAttribute("userSession",sessionDao); //클라이언트에게 세션 제공
        }
        return;
    }
}
