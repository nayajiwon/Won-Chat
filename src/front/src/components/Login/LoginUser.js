import React, { useState } from 'react';
import {Link} from 'react-router-dom';
function LoginUser(){
    const[ email, setEmail] = useState('');
    const[ password, setPwd] = useState('');

    const handleEmailChange = (event) =>{
        setEmail(event.target.value);
    }

    const handlePWDChange = (event)=>{
        setPwd(event.target.value);
    }

    const handleLogin = (event)=>{
        if (email === "" || password === "") {
            alert("아이디 또는 비밀번호를 입력해주세요.");
            return;
        }
 
        const data = {
            body: JSON.stringify({"email" : email, "password": password}),
            headers: {"Content-Type": "application/json"},
            method: 'post'
        }
        fetch("/login", data)
            .then(res => {
                if(!res.ok) {
                    throw new Error(res.status);
                } else {
                    return this.handleInitInfo();
                }
            })
            .catch(err => console.log(err));
    }
    
    return(
        <div>
            <h1>Login</h1>
            <input
            value={email}
            onChange={handleEmailChange}
            type="email"
            placeholder="User Email"/>
            <input
            value={password}
            onChange = {handlePWDChange}
            type="password"
            placeholder="Password"/>
            <button
            onClick={handleLogin}>로그인</button>
            <Link to = {'./signup'}><button>회원가입</button></Link>

        </div>

    )
}
export default LoginUser;