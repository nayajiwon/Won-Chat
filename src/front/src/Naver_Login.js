
import React, {useState, useEffect} from 'react';
import {useLocation} from 'react-router-dom';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
const { naver } = window;


const Naver_Login = () => {

  const location = useLocation();  //현재 머물러 있는 페이지에 대한 정보

  const Login = () => {
    Naver();
    //UserProfile();
   }

  useEffect(Login, []);
  /*
  const UserProfile = () => {
    const url = window.location.href
    console.log("지원아!! : " + url)
    window.location.href.includes('access_token') && GetUser();
    function GetUser() {

      const location = window.location.href.split('=')[1];
      const token = location.split('&')[0];

    }
  };
*/


  const Naver = () => {
    //const naverLogin = new naver.LoginWithNaverId({
    console.log("NAver : ")
    const naverLogin = new naver.LoginWithNaverId({
     clientId: "zp_RzkEFiyL1qH8HNL_G",
     //callbackUrl: "http://49.50.160.107:80/api/login/oauth2/code/naver",
     callbackUrl : "http://49.50.160.107:80/login/naver", 
     isPopup: true,
      loginButton: {color: "green", type: 1, height: 30},
      callbackHandle: true
    });
    naverLogin.init();
  }
  /*
  const Naver = () => {
    //const naverLogin = new naver.LoginWithNaverId({
    console.log("NAver : ")
    const naverLogin = new naver.LoginWithNaverId({
     clientId: "j0uDpBNjnJEH6jwlt3kn",
     callbackUrl: "http://localhost:3000/api/login/oauth2/code/naver",
      isPopup: true,
      loginButton: {color: "green", type: 1, height: 30},
      callbackHandle: true
    });
    naverLogin.init();
  }
*/

  return (
  
    <div id='naverIdLogin' />
      
  );
}

export default Naver_Login;
