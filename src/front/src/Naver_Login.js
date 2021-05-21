
/*
import React, { useState, useEffect } from "react";

const { naver } = window;

const naverLogin = new naver.LoginWithNaverId({
      clientId: "F1E3fXOQGtpMKPLJ2dYB",
      callbackUrl: "http://118.67.132.184/api/login/oauth2/code/naver",
      isPopup: true,
      loginButton: { color: 'green', type: 3, height: '50' },
      container: '#plusfriend-addfriend-button',
});
    


const Naver_Login = () => {
    console.log("NaverLogin1")
    
    
    useEffect(() => {
        initializeNaverLogin();
    }, []);
    
  
    //naverLogin.init();  
        
    return(
        <div id='naverIdLogin' >
            works?
        </div>
    );
}

export default Naver_Login;




const Naver_Login = () => {
    //class Navbar extends React.Component {
       
    
        return (
            <div>안녕</div>
        );
    }
                           
export default Naver_Login; 
*/
import React, {useState, useEffect} from 'react';
import {useLocation} from 'react-router-dom';
const { naver } = window;


const Naver_Login = () => {

  const location = useLocation();  //현재 머물러 있는 페이지에 대한 정보 

  const Login = () => {
    Naver();
    UserProfile();
   }
   
  //useEffect(Login, []);
  useEffect(()=>{
    Naver();
    UserProfile(); 
    console.log("렌더링 체크");
  });

  const UserProfile = () => {
    const url = window.location.href
    console.log("지원아!! : " + url)
    window.location.href.includes('access_token') && GetUser();
    function GetUser() {

      const location = window.location.href.split('=')[1];
      const token = location.split('&')[0];
      
    }
  };
  
  
  

  const Naver = () => {
    //const naverLogin = new naver.LoginWithNaverId({
    console.log("NAver : ")
    const naverLogin = new naver.LoginWithNaverId({
     clientId: "F1E3fXOQGtpMKPLJ2dYB",
     callbackUrl: "http://localhost:3000/api",
      isPopup: false,
      loginButton: {color: "green", type: 1, height: 30},
      callbackHandle: true
    });
    naverLogin.init();
  }

  return (
    <div id='naverIdLogin' /> 
  );
}

export default Naver_Login;

/*
export function Naver_Login() {
    const { naver } = window;
    
    const Login = () => {
     Naver();
     UserProfile();
    }
    
    useEffect(Login, []);
    
    const Naver = () => {
       const naverLogin = new naver.LoginWithNaverId({
        clientId: "F1E3fXOQGtpMKPLJ2dYB",
        callbackUrl: "http://118.67.132.184/api/login/oauth2/code/naver",
         isPopup: false,
         loginButton: {color: "green", type: 1, height: 30} ,
         callbackHandle: true
       });
       naverLogin.init();
     }
   
     const UserProfile = () => {
       window.location.href.includes('access_token') && GetUser();
       function GetUser() {
         const location = window.location.href.split('=')[1];
         const token = location.split('&')[0];
         console.log("token: ", token);
         fetch(`${API}/account/sign-in` , {
           method: "GET",
           headers : {
             "Content-type" : "application/json",
             "Authorization": token
           },
         })
         .then(res => res.json())
         .then(res => {
           localStorage.setItem("access_token", res.token);
           setUserData({
             nickname : res.nickname,
             image : res.image
           })
         })
         .catch(err => console.log("err : ", err));
       }
     };
     
     return (
       <SideLogin className="login">
         <UserInfo>
           <SideText>로그인</SideText>  
         </UserInfo>
         <LoginLink onClick={Login} id="naverIdLogin" /> 
       </SideLogin>
     );
   }
export default Naver_Login;
*/