package com.jw.demo.Service;
import com.jw.demo.DTO.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    List<UserDto> getUserListService();
    UserDto getUserbyId(String id);
    void InsertUser(String id, String email, String nickname);
}
