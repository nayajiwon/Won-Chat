package com.jw.demo.Service.Impl;

import com.jw.demo.DTO.UserDto;
import com.jw.demo.Model.Entity.User;
import com.jw.demo.Repository.UserRepository;
import com.jw.demo.Service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private final UserRepository userRepository;

    @Transactional
    public void signUp(UserDto userDto){
        User user = userDto.toEntity();
        userRepository.save(user);
    }
}
