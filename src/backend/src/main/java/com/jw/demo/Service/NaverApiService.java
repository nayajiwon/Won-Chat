package com.jw.demo.Service;

import com.jw.demo.DemoApplication;
import com.jw.demo.DTO.UserDto;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration //@autowired를 위한건가?
public class NaverApiService extends DemoApplication {
    //@Autowired
    //private UserRepository userRepository;

    public void saveDto(UserDto userDto){
        //naverUserDto.toEntity() : Db 에 직접 저장하는 User Class에 데이터를 초기화 하는 함수
        //repository를 통해 jpa로 데이터를 저장함.
        //userRepository.save(naverUserDto.toEntity());
        return;
    }
}
