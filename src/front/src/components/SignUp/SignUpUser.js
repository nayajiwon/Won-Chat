import React from 'react';
import useInput from '../hooks/useInput';

const SignUpUser = () => {

    const [userName, onChangeUserName] = useInput('');
    const [id, onChangeId] = useInput('');
    const [password, onChangePassword] = useInput('');
    const [location, onChangeLocation] = useInput('');
    const [phoneNumber, onChangephoneNumber] = useInput('');

    const submitForm = () => {
        console.log("회원가입 성공");
        console.log(userName, id, password, location, phoneNumber);
       
    };
    return (
        <div>
            <h1>회원가입</h1>
            <form onSubmit={submitForm}>
                <div>
                <label htmlFor="userName">이름</label>
                <input name = "userName" value ={userName} required onChange={onChangeUserName}/><br />
                <label htmlFor="id">아이디</label>
                <input name = "id" value ={id} required onChange={onChangeId}/><br />
                <label htmlFor="password">비밀번호</label>
                <input name = "password" value ={password} type="password" required onChange={onChangePassword}/><br />
                <label htmlFor="location">지역</label>
                <input name = "location" value ={location} required onChange={onChangeLocation}/><br />
                <label htmlFor="phoneNumber">핸드폰번호</label>
                <input name = "phoneNumber" value ={phoneNumber} required onChange={onChangephoneNumber}/><br />
                </div>
                <div style ={{marginTop : 10}}>
                <button type="submit" htmlFor ="submit" onClick={submitForm}>가입하기</button>
                </div>
            </form>
        </div>
    )
};

export default SignUpUser;