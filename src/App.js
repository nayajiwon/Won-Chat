import React from 'react';
import GlobalStyle from './globalStyles'; 
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Navbar from './components/Navbar/Navbar.js';
import Chatting from './components/Chatting/Chatting';

function App() {
  return (
    <Router>
      <GlobalStyle/>
      <Navbar />
      <Switch></Switch>
      <Chatting></Chatting>
    </Router>
  );
}

export default App;

