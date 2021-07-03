/*
import React, {useState} from 'react';

import {
    ChattingContainer, 
    Chat, 
    ChattingBar, 
    ChattingMessageContainer, 
    ChattingMessageBar,
    ChattingMessageButton
} from './Chatting.elements';

import {Message} from './Message';

const Chatting = () => {
    return (
        <div>
            <Chat>
                <ChattingContainer >
                    <ChattingBar>Won Chat</ChattingBar>
                    <Message />
                </ChattingContainer>
            </Chat>
        </div>
    );
}

export default Chatting; 
*/
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

import {
    Message
}from './Message'

import {
    MessageBoxMe,
    MessageBoxYou
} from './Message.elements'

export const Chatting = () => {
    console.log("***INSIDE CHATTING***")

    const [buttonclicked, setButtonclicked] = useState(0); 
    const [messageWritten, setMessageWritten] = useState(0);   
    
    //초기화
 
    const [newMsg, setNewMsg] = useState([])
    console.log(newMsg)
 
    return (
        <div>
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
