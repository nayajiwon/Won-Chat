import React from 'react';
import styled from 'styled-components';

export const Chat = styled.div`
    background: white;
    height: 600px;
    display: flex;
    flex-direction: column;
    justify-content: flex-first;
    align-items: center;
    font-size: 1.2rem;
    position: sticky:
    top: 0;
    z-index: 999;
`;

export const ChattingContainer = styled.div`
    background: white;

    display: flex;
    flex-direction: column;
    justify-content: space-between; 
    height: 400px;
    width : 270px;
    margin : 30px;
    align-items: stretch;
    font-family:"굴림";
    border:1px solid #ccc;
    border-radius: 10px;
`;

export const ChattingBar = styled.div`
    background: #EDF3F4;
    height: 7%;
    font-family:"굴림";
    width: 100%;
    padding-left: 10px;
    border:1px solid #EDF3F4;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
     
`;

export const MessageSendingContainer = styled.div`
    background: white;
    height: 80%;
    display: flex;
    flex-direction: column;
    width: 100%;
    padding-left: 10px;
    border:1px solid white;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    overflow-y:scroll;
`

export const ChattingMessageContainer = styled.div`
    background: #FFF;
    display: flex;
    flex-direction: row;
    height: 13%;
    width: 100%;
    border:1px solid #EDF3F4;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
`;

//메시지 치는 창
export const ChattingMessageBar = styled.input`
    background: #FFF;
    height: 100%;
    width: 100%;
    border-radius: 10px;
    border:1px solid #FFF;
`;

export const ChattingMessageButton = styled.button`
    background: #0288D1;
    border:1px solid #5433FF; 
    margin: 3px;    
    height: 80%;
    width: 20   %;
    border-radius: 10px;
    border-radius: 10px;
`;








