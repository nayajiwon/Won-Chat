import React from 'react';
import GlobalStyle from './globalStyles'; 
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Navbar from './components/Navbar/Navbar.js';
import Chatting from './components/Chatting/Chatting';
import Naver_Logins from './Naver_Login'

function App() {
  return (
    <Router>
      <Naver_Logins></Naver_Logins>

      <GlobalStyle/>
      <Navbar />
      <Switch></Switch>
      <Chatting></Chatting>
    </Router>
  );
}

export default App;

