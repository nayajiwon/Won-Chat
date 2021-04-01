package com.jw.demo.repository;

import com.jw.demo.DemoApplication;
import com.jw.demo.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.security.RunAs;
import java.time.LocalDateTime;

@SpringBootTest
public class UserRepositoryTest extends DemoApplication {


    //Dipendency Injection : 의존성 주입을 위해 제공 (DI)
    //스프링에서 처음 시작할 때 autowored 가 선언된 객체를 먼저 관리함.
    //따로 객체를 선언 할 필요가 없게됨.
    // UserRepository = new UserRepository 식으로 선언하지 않아도 됨.
    //DI 의 기본 핵심은 싱글톤.
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){

        /*주의 : primary key 에 auto increment표시가 돼있지 않으면 에러 날 수 있음!!
        * */
        User user = new User();  //user(db table)을 di로 선언하지 않는 이유 => bc)싱글톤이 안됨, user->홍길동,신지원,, ,.etc 가능
        user.setAccount("신");
        user.setEmail("aa");
        user.setPhoneNumber("11");
        //user.setCreatedAt(l);
        user.setCreatedBy("har");
        //user.setId(); 는 auto increment 설정을 해주었기 떄문에 선언하지 않아도 자동으로 됨.

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);
        return;
    }
    public void read(){

    }
    public void update(){

    }
    public void delete(){

    }

}
