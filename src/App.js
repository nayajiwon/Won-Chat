import React from 'react';
import GlobalStyle from './globalStyles'; 
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Navbar from './components/Navbar/Navbar.js';

function App() {
  return (
    <Router>
      <GlobalStyle/>
      <Navbar />
      <Switch></Switch>
    </Router>
  );
}

export default App;

