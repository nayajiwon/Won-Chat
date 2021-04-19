package com.jw.demo.dto;

import com.jw.demo.model.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * db level과 view level을 분리하기 위해 dto클라스 생성
 * toEntity() 를 통해 db클래스인 User 클래스 초기화
 * 로직이 없고 데이터를 접근 하기 위한 변수들로만 이루어짐
 * dto == vo
 */
@Data
@NoArgsConstructor //파라미터가 없는 생성자를 만듦.
public class NaverUserDto {

    private Long userId;
    private String userName;
    private String password;
    private String location;
    private String phoneNumber;
    private String oauth_from;
    private String nickname;
    private String email;
    private String id;

    //@Builder 장점: 생성자의 파라미터 명을 직관적으로 알 수 있어 효과적임
    @Builder
    public NaverUserDto(String id, String userName, String password, String location, String phoneNumber, String oauth_from, String nickname, String email) {
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