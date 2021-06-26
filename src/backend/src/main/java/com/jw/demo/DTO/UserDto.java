package com.jw.demo.DTO;

import com.jw.demo.Model.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

public class UserDto {

    private String userName;
    private String password;
    private String email;
    private int id;

    @Builder
    public UserDto(int id,  String password, String email, String userName) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.userName = userName;

    }

    //User 클래스에서 생성자 위에 @Builder 를 선언해야 builder()를 사용할 수 있음.
    public User toEntity() {
        System.out.println("INSIDE dto toEntity() -> userName" + userName);

        //user 생성자 채우기
        User user = User.builder()
                .id(id)
                .password(password)
                .email(email)
                .build();

        return user;
    }
}
