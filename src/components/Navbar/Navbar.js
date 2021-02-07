import React, {useState} from 'react';
import {Nav,  NavbarContainer, NavLogo, NavIcon, MobileIcon} from './Navbar.elements'; 
import {FaBars, FaTimes} from 'react-icons/fa';
import {IconContext} from 'react-icons/lib'

const Navbar = () => {
//class Navbar extends React.Component {
    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);

    return (
        <IconContext.Provider value = {{color: '#fff'}}>
            <div>
                <Nav>
                    <NavbarContainer>
                        <NavLogo to = "/">
                            <NavIcon></NavIcon>
                             원챗 
                        </NavLogo>
                        <MobileIcon onClick = {handleClick}>
                            {click ? <FaTimes /> : <FaBars />}                 
                        </MobileIcon>
                    </NavbarContainer>
                </Nav> 
            </div>
        </IconContext.Provider>
    );
}
                       
export default Navbar; 