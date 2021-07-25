import React, {useState} from 'react';
import {
    Row,
    Col,
    Button,
    Form,
    FormGroup,
    Label,
    Input,
    Card,
    CardBody,
    CardHeader,
    CardTitle

} from "reactstrap";
import ReactDOM from "react-dom";
import Map from "./Map";

function SignUp() {
    const [id, setId] = useState(null);
    const [password, setPassword] = useState(null);
    const [name, setName] = useState(null);
    const [email, setEmail] = useState(null);
    const [phoneNo, setPhoneNo] = useState(null);

    const handleIdChange = (e) => setId(e.target.value);
    const handlePasswordChange = (e) => setPassword(e.target.value);
    const handlePhoneNoChange = (e) => setPhoneNo(e.target.value);
    const handleNameChange = (e) => setName(e.target.value);
    const handleEmailChange = (e) => setEmail(e.target.value);

    const handleSignUp = (event) => {
        if (!(email && password && name && email)) {
            alert("모든 값을 입력해주세요.");
            return;
        }

        const data = {
            body: JSON.stringify({"userId": id, "password": password, "phoneNo": phoneNo, "email": email, "userName": name}),
            headers: {"Content-Type": "application/json"},
            method: 'post',

        }
        fetch("/user", data)
            .then(res => {
                if (!res.ok) {
                    throw new Error(res.status);
                } else {

                    res.text().then((value) => {
                        if (value === "true") {
                            console.log("SignUp Sucess.");
                            ReactDOM.render(
                                <h1> testsetset </h1>
                            );
                        } else {
                            alert("회원가입에 실패했습니다.");
                        }
                    })
                }
            })
            .catch(err => console.log(err));

    }

    return (
        <>
            < div className="content"><Row>
                <Col md="8">
                    <Card className="card-user">
                        <CardHeader>
                            <CardTitle tag="h5">회원가입</CardTitle>
                        </CardHeader>
                        <CardBody>
                            <Form>
                                <FormGroup>
                                    <Label for="name">이름</Label>
                                    <Input type="text" id="name" onChange={handleNameChange}></Input>
                                </FormGroup>
                                <FormGroup>
                                    <Label for="id">아이디</Label>
                                    <Input type="text" id="id" onChange={handleIdChange}></Input>
                                </FormGroup>
                                <FormGroup>
                                    <Label for="pw">비밀번호</Label>
                                    <Input type="password" id="pw" onChange={handlePasswordChange}></Input>
                                </FormGroup>
                                <FormGroup>
                                    <Label for="email">이메일</Label>
                                    <Input type="text" id="email" onChange={handleEmailChange}></Input>
                                </FormGroup>
                                <FormGroup>
                                    <Label for="phoneNumber">핸드폰번호</Label>
                                    <Input type="text" id="phoneNumber" onChange={handlePhoneNoChange}></Input>
                                </FormGroup>
                                <Button color="primary" type="submit" onClick={handleSignUp}>가입하기</Button>
                            </Form>
                        </CardBody>
                    </Card>
                </Col>
            </Row></div>
        </>
    );
}

export default SignUp;