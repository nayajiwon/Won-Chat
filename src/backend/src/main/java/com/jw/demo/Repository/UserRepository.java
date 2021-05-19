package com.jw.demo.Repository;

import com.jw.demo.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
-crud를 사용하기 위한 디렉토리
-repository를 사용하면 따로 쿼리문을 작성하지 않아도 기본적인
-create, read(select), update, delete 사용 가능.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> { //<entity클래스, primary key 의 타입>

    //findall, findbyId 등 JpaRepository 인터페이스에서 기본적으로 제공하는 함수 이외에 사용자가 직접 정의한 쿼리를 쓰는 방법
    @Query(value = "Select * from user U Where U.id = ?1 ", nativeQuery = true)
    User findbyUserId(String Id);


}
