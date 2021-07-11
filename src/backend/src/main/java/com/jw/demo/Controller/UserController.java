package com.jw.demo.Controller;

import com.jw.demo.DTO.UserDto;
import com.jw.demo.Service.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/signUp")
public class UserController {
    @Autowired
    private final SignUpService signUpService;

    @PostMapping
    public ResponseEntity<String> signUp(@RequestBody UserDto userDto) throws Exception{
        signUpService.signUp(userDto);
        log.info("회원가입:"+userDto);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }
}
