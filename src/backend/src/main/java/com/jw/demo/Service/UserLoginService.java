package com.jw.demo.Service;


public interface UserLoginService {

    boolean checkAvailableUser(String email, String pwd) throws  Exception;

}
