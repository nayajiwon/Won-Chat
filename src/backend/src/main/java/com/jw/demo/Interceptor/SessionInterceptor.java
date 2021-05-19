package com.jw.demo.Interceptor;

import com.jw.demo.DAO.SessionDao;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Interceptor :
 *  - 컨트롤러가 수행되기 이전, 이후 시점에서 어떠한 로직이 수행되어야 할 때 사용
 *  - Interceptor 를 상속받지 않는다면 중복되는 코드가 많이 생기고, 중복 호출이 늘어날 것임
 */

/**
 * 로그인 과정 ->
 * 1. 로그인 해 (api, 내부 자체)
 * 2. api => 인증코드가 승인된다면 => 정보를 가지고 db에 확인
 *    2-1) 있을 때 : 서버에서 클라이언트로 세션을 부여
 *    2-2) 없을 때 : 회원가입 여부 묻고 동의시 세션 부여
 *    자체 로그인
 *    2-1) 있을 때 : 서버에서 클라이언트로 세션을 부여(setAttribute)
 *    2-1) 없을 때 : 로그인 창으로 리다이렉트
 * 3. interceptor로 모든 컨트롤러 이전에 세션 확인
 *    3-1) 접속한 클라이언트에 세션값이 없을 때 = httpreques.getAttribute("") == null : 로그인 창 리다이렉트
 *    3-2) 진행
 */

@Component
public class SessionInterceptor implements HandlerInterceptor {

    //controller 수행 이전에 시행되는 Interceptor
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(); //요청받은 클라이언트의 세션을 가져와
        SessionDao userSession = (SessionDao) session.getAttribute("userId"); //key : "userId"로 검색, 세션을 부여받은 적이 없으면 null

        if(userSession == null){ //현재 클라이언트가 로그인 하여 서버로부터 세션을 부여받은 상태가 아님 == 비정상적인 접근
            System.out.println("preHandle ::  서버로부터 세션을 부여받은 상태가 아님");
            response.sendRedirect("/");
            return false;
        }
        return true;
    }


}
