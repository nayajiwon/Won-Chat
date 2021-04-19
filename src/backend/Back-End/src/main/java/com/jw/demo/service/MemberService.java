package com.jw.demo.service;
import com.jw.demo.dto.NaverUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    public List<NaverUserDto> getUserListService();
    public NaverUserDto getUserbyId(String id);
    public void InsertUser(String id, String email, String nickname);
}
