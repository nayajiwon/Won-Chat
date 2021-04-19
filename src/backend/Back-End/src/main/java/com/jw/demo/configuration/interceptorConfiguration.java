package com.jw.demo.configuration;


import com.jw.demo.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class interceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new SessionInterceptor())
        //        .excludePathPatterns("/css/**", "/fonts/**", "/plugin/**", "/scripts/**", "login/naver/menu"); //로그인 중에는 인터셉터 작동 안함
        return;
    }

}