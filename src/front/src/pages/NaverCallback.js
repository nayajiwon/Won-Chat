import React, { useEffect } from 'react';
import {createBrowserHistory} from 'history';


function NaverCallback() {
    const browserHistory = createBrowserHistory();

    useEffect(()=>{
        UserProfile();
    }, []);

  
    const UserProfile = () => {
        const url = window.location.href
        console.log(url)
        window.location.href.includes('access_token') && GetUser();
        function GetUser() {

            const location = window.location.href.split('=')[1];
            const access_token = location.split('&')[0];
            console.log("위치" + location)
            console.log("토큰" + access_token)
            
            const naver_url = "http://118.67.132.184:8080/api/login/oauth2/code/naver"
            
            fetch(naver_url + "?access_token="+access_token)
        }
      };
    
  
      return (
        <div>
            <h1>Naver Callback</h1>
        </div>
        );
}

export default NaverCallback;

