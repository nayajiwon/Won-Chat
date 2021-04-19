package com.jw.demo.dao;

import com.jw.demo.dto.NaverUserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDaoInterface {
    public List<NaverUserDto> getUserListDao();
    public NaverUserDto getUserbyId(String id);
    public void insertUser(String id, String email, String age);
}
