/*!

=========================================================
* Paper Dashboard React - v1.3.0
=========================================================

* Product Page: https://www.creative-tim.com/product/paper-dashboard-react
* Copyright 2021 Creative Tim (https://www.creative-tim.com)

* Licensed under MIT (https://github.com/creativetimofficial/paper-dashboard-react/blob/main/LICENSE.md)

* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

*/
import React, { useState } from 'react';

// reactstrap components
import {
  Button,
  Card,
  CardHeader,
  CardBody,
  CardFooter,
  CardTitle,
  FormGroup,
  Form,
  Input,
  Row,
  Col,
} from "reactstrap";

function Login() {
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
  const handleSignUp = (event)=>{
    var link = 'SignUp';
    window.location.href=link;
  }

    return(
      <>
      <div classN ame="content">
        <Row>
          <Col md="4">
            <Card className="card-user">
              <CardHeader>
                <CardTitle tag="h5">Login</CardTitle>
                <p className="card-category">Hello!</p>
              </CardHeader>
              <div className="image">
                <img
                  alt="..."
                  src={require("assets/img/damir-bosnjak.jpg").default}
                />
              </div>
              <CardBody>
                <div className="author">
                  <a href="#pablo" onClick={(e) => e.preventDefault()}>
                    <img
                      alt="..."
                      className="avatar border-gray"
                      src={require("assets/img/default-avatar.png").default}
                    />
                  </a>
                </div>
                <Row>
                  <Col className="px-1" md="10">
                      <FormGroup>
                        <label>E-mail</label>
                        <Input
                          type="email"
                          onChange={handleEmailChange}
                        />
                        </FormGroup>
                  </Col>
                  <Col className="px-1" md="10">
                      <FormGroup>
                        <label>Password</label>
                        <Input
                          type="password"
                          onChange = {handlePWDChange}
                        />
                        </FormGroup>
                  </Col>
                  </Row>
                    
              </CardBody>
              <CardFooter>
                
              <div className="update ml-auto mr-auto">
                      <Button
                        className="btn-round"
                        color="primary"
                        type="submit"
                        onClick = {handleLogin}
                      >
                        Login
                      </Button>
                      <Button
                        className="btn-round"
                        color="primary"
                        type="submit"
                        onClick = {handleSignUp}
                      >
                        Sign Up
                      </Button>
              </div>
              </CardFooter>
            </Card>
          </Col>
        </Row>
      </div>
    </>
    );
}

export default Login;
