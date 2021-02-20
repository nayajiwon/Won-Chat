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
//$(Container) 의 역할이 뭐지 ?? - container class 를 import 함으로써 
//container의 속성을 쓸 수 있는 것 같음 
export const NavbarContainer = styled(Container)`
    display: flex;
    justify-content: space-between; 
    height: 80px; 

    $(Container)
`;

//아이콘+로고의 바탕이 됨  
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
//@media screen and (max-width: 960px) : 반응형 웹, 화면 넓이가 960px이면 괄호 안 실행
//transform: translate(-100%, 60%); x,y축으로 이동하라 
 
export const MobileIcon = styled.div`
    display: none;

    @media screen and (max-width: 960px){
        display: block;
        position: absolute;
        top: 0;
        right: 0;
        transform: translate(-100%, 60%);
        font-size: 1.2rem;
        cursor: pointer;
    }
`
//@media screen and (max-width:500px) 
//max-width 값 이하일 때만 괄호 이하의 규칙이 적용된다. 
export const NavMenu = styled.ul`
    display: flex; 
    align-item: center;
    list-style: none;
    text-align: center;

    @media screen and (max-width:500px){
        display:flex; 
        flex-direction: column;
        width:100%;
        height: 90vh;
        position: absolute;
        top: 80px;
        left: ${({click}) => (click ? 0 : '-100%')}
        opacity: 1; 
        transition: all 0.5s ease;
        background: #101522;
    }
`;

//left: ${({click}) => (click ? 0 : '-100%')}
//click하면 보여지고 안하면 없어지게 한다.  
//opacity 투명도
//transition 변화를 줌 ex) 마우스를 올렸을 경우, 색 혹은 크기가 변화하는 시간을 지정해 줄 때

export const NavItem = styled.li`
height:80px;
border-bottom: 2px solid transparent; 

&:hover{
    border-bottom: 2px solid #4b597;
}
    
@media screen and (max-width: 960px){
    width: 100%;
    
    &:hover{
        border: none; 
    }
}
`
//(Link) -> react.router 태그임 
export const NavLinks = styled(Link)`
color:#fff;
display:flex; 
align-items: center;
text-decoration: none; 
padding: 0.5rem 1rem;
height: 100%

@media screen and (max-width: 960px){
    text-align: center;
    padding: 2rem;
    width: 100%;
    display: table;

    &:hover{
        color: #4b59f7;
        transition: all 0.3s ease; 
    }
}
`;