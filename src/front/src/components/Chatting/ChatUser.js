import SockJS from 'sockjs-client';

import React, { useState } from 'react';
import {Stomp} from '@stomp/stompjs';
import { connect } from 'net';

var client = null; 
class ChatUser extends React.Component {

    connect = () => {
        console.log("커넥트 완료")        
        //var socket = new SockJS("http://localhost:8080/stomp/chat");
        //var stompClient = Stomp.over(socket)         
        client = Stomp.over(function(){
            return new SockJS('http://localhost:8080/stomp/chat') //stomp 목적지는 url 형태가 아님!
        });
        /*
        client.connect({}, function () {
            this.client.subscribe('/sub/jiwon', function (msg) {
                console.log(msg.body)
            });
        });
        */
        client.connect({}, this.onConnected_callback, this.onError);
    }
    onError = (error) => {
        this.setState({
          error: '채팅 서버에 접속할 수 없습니다.'
        })  
    }


    //message 받았을 경우 callback 
    onMessage_callback = (Msgs) => {
        console.log("message 받았음")
    }
    //연결이 성공했을 경우 callback
    onConnected_callback = () => {
        client.subscribe('/sub/jiwon', this.onMessage_callback); //들어가는 채팅방 subscribe
        
    
        // Registering user to server as a public chat user
 //       stompClient.send("/app/addUser", {}, JSON.stringify({ sender: this.state.username, type: 'JOIN' }))
    
    }
    


    handleIncrease = () => {
        console.log("핸들")              
    };

    render() {
        return (
            <div>
                "커넷트",
                 <button onClick={this.connect}></button>
            </div>

        );
    }    
}

ChatUser.defaultProps = {
    name: '이름없음'
};    

export default ChatUser; 