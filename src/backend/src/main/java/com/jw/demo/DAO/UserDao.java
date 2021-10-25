package com.jw.demo.DAO;

import com.jw.demo.DTO.UserDto;
import com.jw.demo.Model.Entity.User;
import com.jw.demo.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
@Slf4j
public class UserDao implements UserDaoInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getUserListDao() {
        List<User> users = userRepository.findAll();
        User user;
        UserDto userDto = new UserDto();
        List<UserDto> userDtoList = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            //dto클래스에 매핑
            user = users.get(i);
            userDto.builder()
                    .password(user.getPassword())
                    .email(user.getEmail())
                    .build();

            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    //아이디를 이용해서 회원의 정보를 가져오는 쿼리
//    @Override
//    public UserDto getUserInfobyId(String id) {
//        User user = userRepository.findbyUserId(id);
//        if (user == null) { //회원이 아님
//            System.out.println("똑같은거 못찾음!! ");
//            return null;
//        }
//
//        UserDto loginUserDto = UserDto.builder()
//                .id(user.getId())
//                .build();
//
//        return loginUserDto;
//    }

//    @Override
//    public void insertUser(int id, String email, String age) {
//        UserDto userDto = UserDto.builder()
//                .id(id)
//                .email(email)
//                .build();
//        userRepository.save(userDto.toEntity()); //db에 새로 회원가입 한 사람 정보 저장
//    }

    /*로그인시 입력되는 email을 이용하여 회원인지 확인
    * Args : email(String) - 사용자가 입력한 email / input_pwd(String) - 사용자가 입력한 password
    * Return : boolean - True = 회원가입 된 사용자 / False = 회원가입이 확인되지 않는 사용자
    * */
    @Override
    public boolean isValidUser(String input_email, String input_pwd) {
        AtomicBoolean return_val = new AtomicBoolean(false);
        /*동일 아이디가 존재할경우 에러 발생 때문에 회원가입 할 때 아이디 중복 검사 필수*/
        Optional<User> user = userRepository.findByUserEmail(input_email);
        user.ifPresent(avaUser -> {
            String avaUserpwd = avaUser.getPassword();
            //비밀번호 암호화 필요
            if (avaUserpwd.equals(input_pwd)) {
                return_val.set(true);
            }
        });
        log.info(return_val.toString());
        return return_val.get();
    }
}