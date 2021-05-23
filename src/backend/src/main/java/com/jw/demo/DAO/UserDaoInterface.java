package com.jw.demo.DAO;

import com.jw.demo.DTO.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDaoInterface {
    List<UserDto> getUserListDao();
    UserDto getUserInfobyId(String id);
    void insertUser(String id, String email, String age);
    boolean isValidUser(String input_email, String input_pwd);
}
