import React from 'react';
import GlobalStyle from './globalStyles'; 
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Navbar from './components/Navbar/Navbar.js';
import Chatting from './components/Chatting/Chatting';
import SignPage from './pages/SignPage.js';
import JoinUsers from './pages/JoinUser.js';

function App() {
  return (
    <Router>
      <GlobalStyle/>
      <Navbar />
      <Switch>
        <Route exact path = '/' component = {Chatting}/>
        <Route path ='/login' component={SignPage}/>
        <Route path = '/join' component ={JoinUsers}/>
      </Switch>
    
    </Router>
  );
}

export default App;

