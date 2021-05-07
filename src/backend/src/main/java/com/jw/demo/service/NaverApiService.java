package com.jw.demo.service;

import com.jw.demo.DemoApplication;
import com.jw.demo.dto.NaverUserDto;
import com.jw.demo.model.entity.User;
import com.jw.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration //@autowired를 위한건가?
public class NaverApiService extends DemoApplication {
    //@Autowired
    //private UserRepository userRepository;

    public void saveDto(NaverUserDto naverUserDto){
        //naverUserDto.toEntity() : Db 에 직접 저장하는 User Class에 데이터를 초기화 하는 함수
        //repository를 통해 jpa로 데이터를 저장함.
        //userRepository.save(naverUserDto.toEntity());
        return;
    }
}
