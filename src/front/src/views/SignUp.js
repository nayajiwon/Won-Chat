import React from 'react';
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

function SignUp() {
    return (
        <> < div className = "content" > <Row>
            <Col md="8">
                <Card className="card-user">
                    <CardHeader>
                        <CardTitle tag="h5">회원가입</CardTitle>
                    </CardHeader>
                    <CardBody>
                        <Form>
                            <FormGroup>
                                <Label for="name">이름</Label>
                                <Input type="text" id="name"></Input>
                            </FormGroup>
                            <FormGroup>
                                <Label for="id">아이디</Label>
                                <Input type="text" id="id"></Input>
                            </FormGroup>
                            <FormGroup>
                                <Label for="pw">비밀번호</Label>
                                <Input type="password" id="pw"></Input>
                            </FormGroup>
                            <FormGroup>
                                <Label for="phoneNumber">핸드폰번호</Label>
                                <Input type="text" id="phoneNumber"></Input>
                            </FormGroup>
                            <Button color="primary"
                        type="submit" onClick="">가입하기</Button>
                        </Form>
                    </CardBody>
                </Card>
            </Col>
        </Row> </div> </>
    );
}

export default SignUp;