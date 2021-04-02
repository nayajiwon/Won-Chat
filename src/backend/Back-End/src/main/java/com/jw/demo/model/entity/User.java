package com.jw.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;

@Data
@NoArgsConstructor //파라미터가 없는 생성자를 만듦.
@AllArgsConstructor //변수를 가지고 만들 수 있는 모든 생성자경우의 수를 제공.
@Entity
//@Table(name="User")
public class User{
    //≈; //table임을 명시해주지만 클라스명이 table명과 같을 경우 어노테이션 필요 없음.

    //변수를 선언할 때 테이블의 타입 명과 타입과 같게 선언하면됨.
    //camel_case (db) , snakeCase (Java) d
    //자바에서 snakeCase를 써도 jpa가 자동으로 camel_case 로 변형해줌.
     //table임을 명시해주지만 클라스명이 table명과 같을 경우 어노테이션 필요 없음
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id") 변수의 명과 컬럼의 명이 동일하다면 어노테이션 선언하지 않아도 됨.

    private Long userId;
    private String userName;
    private String password;
    private String location;
    private String phoneNumber;

}
