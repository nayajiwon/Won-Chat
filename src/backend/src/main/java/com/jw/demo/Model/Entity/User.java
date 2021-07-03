package com.jw.demo.Model.Entity;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor //파라미터가 없는 생성자를 만듦.
//@AllArgsConstructor //변수를 가지고 만들 수 있는 모든 생성자경우의 수를 제공. 이미 밑에서 builder를 이용해서 생성자 제공
@Entity
@Getter //Entity 클래스는 @Setter를 설정하지 않는다!
@Table(name="user")
public class User{


    //table임을 명시해주지만 클라스명이 table명과 같을 경우 어노테이션 필요 없음.

    //변수를 선언할 때 테이블의 타입 명과 타입과 같게 선언하면됨.
    //camel_case (db) , snakeCase (Java) d
    //자바에서 snakeCase를 써도 jpa가 자동으로 camel_case 로 변형해줌.
     //table임을 명시해주지만 클라스명이 table명과 같을 경우 어노테이션 필요 없음

    @Id //PK임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int id;
    private String userName;
    private String password;
    private String email;
    @Builder
    public User( int id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
