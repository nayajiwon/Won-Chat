import React, {useState } from "react";
import {Link, Route} from 'react-router-dom';
import Naver_Login from '../Naver_Login';
import join from './JoinUser'

function SignPage(){
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
  
    const joinUser = () => {
      alert("Her")
      return(
        <Link to = {'./JoinUser'}/>
        )
    };
  
    return (
      <>
        <h1>Login</h1>
        <input
          value={email}
          onChange={({ target: { value } }) => setEmail(value)}
          type="text"
          placeholder="email"
        />
        <input
          value={password}
          onChange={({ target: { value } }) => setPassword(value)}
          type="password"
          placeholder="password"
        />
        <button>Login</button>
        <Link to = {'./join'}><button>Join</button></Link>
        <Naver_Login></Naver_Login>
      
      </>
    );
}

export default SignPage;