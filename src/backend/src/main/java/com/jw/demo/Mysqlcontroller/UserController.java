//package com.jw.demo.Mysqlcontroller;
//
//import com.jw.demo.DTO.UserDto;
//import com.jw.demo.Service.NaverApiService;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@RestController
//@RequestMapping(value = "/mysql")
//public class UserController {
//
//    @Autowired
//    private NaverApiService naverApiService;
//
//    //@RequestBody : 요청받은 html형태의 문서의 body내용으로 자바 객체로 바꿔줌
//    //@ResponseBody : @RestController 사용시에 자동으로 자바 객체로 바꿔주기 때문에 @ResponseBody 사용할 필요 없음
//
//    /**
//     * @param userDto
//     *      NaverUserDto형태로 naver api 로 로그인 한 user의 정보가 body 에 받아서 옴
//     */
//    @PostMapping(value = "/user")
//    public void save(@RequestBody UserDto userDto) {
//
//        naverApiService.saveDto(userDto);
//        return;
//    }
//}
//
