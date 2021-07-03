package com.jw.demo.DAO;

import com.jw.demo.DTO.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDaoInterface {
    List<UserDto> getUserListDao();
 //   UserDto getUserInfobyId(int id);
  //  void insertUser(int id, String email, String age);
    boolean isValidUser(String input_email, String input_pwd);
}
