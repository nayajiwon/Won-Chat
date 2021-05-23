package com.jw.demo.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor //파라미터가 없는 생성자를 만듦.
@AllArgsConstructor //변수를 가지고 만들 수 있는 모든 생성자경우의 수를 제공.
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id") 변수의 명과 컬럼의 명이 동일하다면 어노테이션 선언하지 않아도 됨.
    private int _id;
    private String name;
    private String belong; //db 에서는 phone_number이지만 jpa가 자동 변환해줌
    private String phone; //db 에서는 phone_number이지만 jpa가 자동 변환해줌

}
