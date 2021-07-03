package com.jw.demo.Controller;

import com.jw.demo.DTO.UserDto;
import com.jw.demo.Service.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final SignUpService signUpService;

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody UserDto userDto) throws Exception{
        signUpService.signUp(userDto);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }
}
