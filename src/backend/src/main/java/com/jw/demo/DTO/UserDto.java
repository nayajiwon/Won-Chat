package com.jw.demo.DTO;

import com.jw.demo.Model.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private String userName;
    private String password;
    private String location;
    private String phoneNumber;
    private String oauth_from;
    private String nickname;
    private String email;
    private String id;

    @Builder
    public UserDto(String id, String userName, String password, String location, String phoneNumber, String oauth_from, String nickname, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.oauth_from = oauth_from;
        this.nickname = nickname;
        this.email = email;

        System.out.println("INSIDE dto builder -> userName" + userName);

    }

    //User 클래스에서 생성자 위에 @Builder 를 선언해야 builder()를 사용할 수 있음.
    public User toEntity() {
        System.out.println("INSIDE dto toEntity() -> userName" + userName);

        //user 생성자 채우기
        User user = User.builder()
                .id(id)
                .userName(userName)
                .password(password)
                .location(location)
                .phoneNumber(phoneNumber)
                .oauth_from(oauth_from)
                .nickname(nickname)
                .email(email)
                .build();

        return user;
    }
}
