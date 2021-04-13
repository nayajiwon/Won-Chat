package com.jw.demo.repository;

import com.jw.demo.controller.OauthProperties;
import com.jw.demo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
crud를 사용하기 위한 디렉토리
repository를 사용하면 따로 쿼리문을 작성하지 않아도 기본적인
 //create, read(select), update, delete 사용 가능.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //<entity클래스, primary key 의 타입>



}
