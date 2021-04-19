package com.jw.demo.dao;

import com.jw.demo.dto.NaverUserDto;
import com.jw.demo.model.entity.User;
import com.jw.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * dao = data access object
 * 직접 db에서 데이터를 가져옴 --> dto타입으로 가져와야함
 * db에서 dto 타입으로 데이터를 가져온 뒤에 dao를 호출한 service단에 넘김
 * dao, service 는 클래스와 인터페이스로 이루어져야함!!
 */

@Repository
public class UserDao implements UserDaoInterface{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<NaverUserDto> getUserListDao(){
        List<User> users = userRepository.findAll(); //userRepository인자가 User이기떄문에 User타입으로 받음
        User user;
        NaverUserDto userDto = new NaverUserDto();
        List<NaverUserDto> userDtoList = new ArrayList<>();


        for(int i=0; i<users.size(); i++) {
            //dto클래스에 매핑
            user = users.get(i);
            userDto.builder()
                    .userName(user.getUserName())
                    .password(user.getPassword())
                    .location(user.getLocation())
                    .phoneNumber(user.getPhoneNumber())
                    .oauth_from(user.getOauth_from())
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .build();

            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    //회원인지 여부 판단하는 쿼리
    @Override
    public NaverUserDto getUserbyId(String id){
        User user = userRepository.findbyUserId(id);
        if(user == null){ //회원이 아님
            System.out.println("똑같은거 못찾음!! ");
            return null;
        }

        NaverUserDto loginUserDto = NaverUserDto.builder()
                .id(user.getId())
                .build();

        return loginUserDto;
    }

    @Override
    public void insertUser(String id, String email, String age){
        NaverUserDto naverUserDto = NaverUserDto.builder()
                .id(id)
                .email(email)
                //.age(age)
                .build();
        userRepository.save(naverUserDto.toEntity()); //db에 새로 회원가입 한 사람 정보 저장
    }

}
