import React from 'react';
import GlobalStyle from './globalStyles';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import Navbar from './components/Navbar/Navbar.js';
import SignUpUser from './components/SignUp/SignUpUser.js';
import LoginUser from './components/Login/LoginUser.js';

function App() {
    return (
        <Router>
            <GlobalStyle/>
            <Navbar/>
            <Switch>
                <Route path='/login' component={LoginUser}/>
                <Route path='/signup' component={SignUpUser}/>
            </Switch>
        </Router>
    );
}

export default App;
