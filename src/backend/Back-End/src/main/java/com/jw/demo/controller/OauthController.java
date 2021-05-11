
package com.jw.demo.controller;
import com.jw.demo.dao.SessionDao;
import com.jw.demo.dto.NaverUserDto;
import com.jw.demo.service.LoginServiceImpl;
import com.jw.demo.service.MemberService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/***
 *         String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
 *         apiURL += "&client_id=" + oauthProperties.getClientId();
 *         apiURL += "&redirect_uri=" + oauthProperties.getRedirectUri();
 *         apiURL += "&state=" + 110;
 *
 ***/
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

/*
    @CrossOrigin(origins = "https://nid.naver.com")
    @GetMapping("/api/login/naver/menu")
    //public RedirectView getNaverLoginScreen(){
    public String getNaverLoginScreen(){
        System.out.println("api/login/naver/menu 출력");
        String loginUrl = loginServiceImpl.requestNaverLoginScreenUrl();
        //return new RedirectView(loginUrl);
        return "good";
    }
*/

    @GetMapping("/api/login/naver/menu")
    //public RedirectView getNaverLoginScreen(){
    public void getNaverLoginScreen(HttpServletResponse httpServletResponse){

        System.out.println(" 새로운 리다이렉트 출력");
        String loginUrl = loginServiceImpl.requestNaverLoginScreenUrl();
        httpServletResponse.sendRedirect(loginUrl);
        return;
    }


    /***
     * 네이버 로그인 완료시 자동으로 요청되는 call back url
     * 주어진 권한코드와 상태코드를 사용해 api 호출 -> access_token받아옴
     */
    //로그아웃 url : http://nid.naver.com/nidlogin.logout
    //http://localhost:8080/login/oauth2/codenaver
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