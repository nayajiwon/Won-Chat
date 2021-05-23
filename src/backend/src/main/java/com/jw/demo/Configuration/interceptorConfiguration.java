package com.jw.demo.Configuration;
import com.jw.demo.Interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class interceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * login이 성공했을 때 작동하는 url을 사용자가 직접 입력해 접근하는 것을 제한하기 위해서
         * 특정 url을 입력했을 때 로그인을 성공했을 경우 제공하는 session을 소유하고 있는지 지속적으로 체크해줌.
         *
         */
        registry.addInterceptor(new SessionInterceptor())
                //세션 체크 할 url추가
                .addPathPatterns("login/oauth2/code/naver") //네아로 성공한 후 call back url
                //세션 체크 제외 할 url
                .excludePathPatterns("/css/**", "/fonts/**", "/plugin/**", "/scripts/**", "login/naver/menu"); //로그인 중에는 인터셉터 작동 안함
        return;
    }

}