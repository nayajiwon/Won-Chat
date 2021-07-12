import React, { useState } from 'react'

import {
    ChattingContainer, 
    Chat, 
    ChattingBar, 
    MessageSendingContainer
} from './Chatting.elements'

import {
    Message
}from './Message'

import {
    MessageBoxMe,
    MessageBoxYou
} from './Message.elements'

import ChatUser from './ChatUser.js'

export const Chatting = () => {
    console.log("***INSIDE CHATTING***")
    const server_url = "http://localhost:8080/chatting"
    const [buttonclicked, setButtonclicked] = useState(0); 
    const [messageWritten, setMessageWritten] = useState(0);   
    
    //초기화
 
    const [newMsg, setNewMsg] = useState([])
    console.log(newMsg)


    return (
        <div>
            <ChatUser></ChatUser>
            <Chat>
                <ChattingContainer>
                    <ChattingBar>Won Chat</ChattingBar>                   
                    <MessageSendingContainer>
                        <div style ={{clear:"both"}}>                    

                        {newMsg.map((msg)=>(
                            <MessageBoxMe>{msg}</MessageBoxMe>
                        ))}
                        </div>  

                    </MessageSendingContainer>
                    <Message setMessage = {setNewMsg}></Message>                   
                </ChattingContainer>
            </Chat>
        </div>
    );
};
export default Chatting; 
