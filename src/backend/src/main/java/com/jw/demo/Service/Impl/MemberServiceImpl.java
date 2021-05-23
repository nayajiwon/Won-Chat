package com.jw.demo.Service.Impl;
import com.jw.demo.DAO.UserDao;
import com.jw.demo.DTO.UserDto;
import com.jw.demo.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * - dao, service 는 인터페이스+서비스 파일이 한 짝으로 구현
 * - 필요한 목록을 나열할 수 있는 인터페이스 생성
 */
@Service("MemberService")
public class MemberServiceImpl implements MemberService {

    //dao 클라스를 autowired로 선언함으로써 singletone-pattern을 지킬 수 있음
    //dao는 db에 접근하는 객체인데 클라이언트의 접속이 있을 때 마다 dao 객체를 생성한다면 효율적이지 않기 때문에 싱글톤 패턴으로 생성
    @Autowired
    UserDao userDao;


    @Override
    public List<UserDto> getUserListService(){
        List<UserDto> userDto = userDao.getUserListDao();
        return userDto;
    }

    @Override
    public UserDto getUserbyId(String id){
        UserDto loginUser = userDao.getUserInfobyId(id);
        return loginUser;
    }

    @Override
    public void InsertUser(String id, String email, String nickname){
        userDao.insertUser(id,email,nickname);
        return;
    }

}
