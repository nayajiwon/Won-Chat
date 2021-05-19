package com.jw.demo.Service.Impl;

import com.jw.demo.DAO.UserDaoInterface;
import com.jw.demo.Service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserDaoInterface userDaoInterface;

    @Override
    public boolean checkAvailableUser(String input_id, String input_pwd) throws Exception {
        if (userDaoInterface.isValidUser(input_id, input_pwd)) {
            log.info(input_id + ": Login Success");
            return true;
        } else {
            log.info(input_id + ": Login Fail");
            return false;
        }
    }
}

