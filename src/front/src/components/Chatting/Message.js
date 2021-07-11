
import React, { useState } from 'react'

import {
    ChattingContainer, 
    Chat, 
    ChattingBar, 
    ChattingMessageContainer, 
    ChattingMessageBar,
    ChattingMessageButton,
    MessageSendingContainer
} from './Chatting.elements'

import {Chatting} from './Chatting'

import {
    MessageBoxMe,
    MessageBoxYou
} from './Message.elements'

export const Message = (props) => {
    const [buttonclicked, setButtonclicked] = useState(0); 
    const [messageWritten, setMessageWritten] = useState("");   
 
    //newMsg : 새로 입력받은 메시지 
    //Msgs : 기존의 메시지를 복사한 뒤에 새로 입력받은 메시지를 append 함 
    const onSendButtonClicked = () => {
        console.log("버튼 "+ messageWritten)
        
        props.setMessage(newMsg => [...newMsg, messageWritten])
        setMessageWritten("")
    }
    
    const handleChange = (e) => {
        setMessageWritten(e.target.value)        
    }

    return (
        <ChattingMessageContainer>
            <ChattingMessageBar
                placeholder = " 메시지입력"
                value = {messageWritten}
                onChange = {handleChange}
            />                           
            <ChattingMessageButton onClick={onSendButtonClicked}>
                send
            </ChattingMessageButton>
        </ChattingMessageContainer>
    );

};
export default Message; 
