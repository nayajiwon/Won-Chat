import React from 'react';
import styled from 'styled-components';
import {Container} from '../../globalStyles.js';
import {FaMagento} from 'react-icons/fa';
import {Link} from 'react-router-dom'; 

//display: inline - flex 를 할 경우에 컨테이너끼릴 수평 나열, 내부 요소에는 영향을 주지 않음 
//justify-content: center; 아이템들을 가운데로 정렬 

export const Nav = styled.nav`
    background: black;
    height: 80px;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.2rem;
    position: sticky:
    top: 0;
    z-index: 999;
    
`;

//space-between 아이템들의 사이에 균일한 간격을 만들어줌 
export const NavbarContainer = styled(Container)`
    display: flex;
    justify-content: space-between; 
    height: 80px; 

    $(Container)
`;

export const NavLogo = styled(Link)`
color: #fff;
jutify-self: flex-start;
cursor: cursor;
text-decoration: none; 
font-size: 2rem;
display: flex;
align-items: center;
`

export const NavIcon = styled(FaMagento)`
margin-right: 0.5rem; 
`

//display: none; display를 숨기기
//transform: translate(-100%, 60%); x축 y축으로 옮기기 
export const MobileIcon = styled.div`
    display: none;

    @media screen and (max-width: 960px){
        display: block;
        position: absolute;
        top: 0;
        right: 0;
        transform: translate(-100%, 60%);
        font-size: 1.8rem;
        cursor: pointer;
    }
`

