
import React, {useState} from 'react';
import {
    ChattingContainer, 
    Chat, 
    ChattingBar, 
    ChattingMessageContainer, 
    ChattingMessageBar,
    ChattingMessageButton
} from './Chatting.elements'


const Chatting = () => {
    return (
        <div>
            <Chat>
                <ChattingContainer>
                    <ChattingBar>Won Chat</ChattingBar>
                    <ChattingMessageContainer>
                        <ChattingMessageBar>
                        </ChattingMessageBar>
                        <ChattingMessageButton>
                            send
                        </ChattingMessageButton>
                    </ChattingMessageContainer>
                </ChattingContainer>
            </Chat>
        </div>
    );
}

export default Chatting; 