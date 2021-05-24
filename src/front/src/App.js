import React from 'react';
import GlobalStyle from './globalStyles'; 
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Navbar from './components/Navbar/Navbar.js';
import Chatting from './components/Chatting/Chatting';
import SignPage from './pages/SignPage.js';
import JoinUsers from './pages/JoinUser.js';
import NaverCallback from './pages/NaverCallback.js'

function App() {
  return (
    <Router>
      <GlobalStyle/>
      <Navbar />
      <Switch>
        <Route exact path = '/' component = {Chatting}/>
        <Route path ='/login' component={SignPage}/>
        <Route path = '/join' component ={JoinUsers}/>
        <Route path = '/api/login/oauth2/code/naver' component ={NaverCallback}/>
      
      </Switch>   
    </Router>
  );
}

export default App;

