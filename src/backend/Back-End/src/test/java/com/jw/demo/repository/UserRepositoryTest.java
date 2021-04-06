package com.jw.demo.repository;

import com.jw.demo.DemoApplication;
import com.jw.demo.model.entity.User;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest extends DemoApplication {


    //Dipendency Injection : 의존성 주입을 위해 제공 (DI)
    //스프링에서 처음 시작할 때 autowored 가 선언된 객체를 먼저 관리함.
    //따로 객체를 선언 할 필요가 없게됨.
    // UserRepository = new UserRepository 식으로 선언하지 않아도 됨.
    //DI 의 기본 핵심은 싱글톤.

    //@Autowired
    //private UserRepository userRepository;

    // bean에 주입
    @Autowired
    private UserRepository userRepository;

    //test위한 어노테이션
    @Test
    public void create(){

        /*주의 : primary key 에 auto increment표시가 돼있지 않으면 에러 날 수 있음!!
        * */
        User user = new User();
        user.setLocation("seoul");
        user.setUserName("Jws");
        user.setPhoneNumber("01085442051");
        User newUser = userRepository.save(user);
        return;
    }

    @Test
    @Transactional
    /** @Transactional 을 사용할 경우 업뎃,삭제 되는 것 확인 한 후 roll back을 통해 원상복귀 시킴!!
     *      test를 통해 잘 작동하는지 확인하고 싶을 때 많이 사용함
     */
    //public void read(@RequestParam Long id){
    public void read(){
        //Optional은 generic의 래퍼 클래스, -> null체크를 함수(ifPresent) 를 사용해서 간단히 체크 가능
        Optional<User> user = userRepository.findById(11L);
        user.ifPresent(selectUser ->{
           System.out.println("user : "+selectUser);
        });
    }

    @Test  //test 를 위한 코드에는 test어노테이션 코드를 반듯이 작성해줄 것
    public void update(){
        Optional<User> user = userRepository.findById(11L);
        user.ifPresent(selectUser -> {
            /*** selectUser.setUser"Id();
             * pk는 update 하지 말 것!! 다른 pk가 없뎃 될수도!!!
             * **/
            selectUser.setUserName(LocalDateTime.now().toString());
            selectUser.setLocation("idw");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        //삭제됐는지 디버깅??
        Optional<User> deleteUser = userRepository.findById(11L);
        if(deleteUser.isPresent()){
            System.out.println("존재" + deleteUser.get());
        }else{
            System.out.println("존재 안함");
        }

        System.out.println("##########");

        /** assert : 디버깅용 함수
         *      만약 assert.check() 의 인자가 false라면 컴파일 에러를 이르킴.
         *
         * **/

        Assert.check(!(deleteUser.isPresent()));
    }
}
