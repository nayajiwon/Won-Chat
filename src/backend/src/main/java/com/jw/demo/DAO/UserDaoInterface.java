package com.jw.demo.DAO;

import com.jw.demo.DATO.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDaoInterface {
    public List<UserDto> getUserListDao();
    public UserDto getUserbyId(String id);
    public void insertUser(String id, String email, String age);
}
