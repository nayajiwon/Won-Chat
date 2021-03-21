import styled, {createGlobalStyle} from 'styled-components'

const GlobalStyle = createGlobalStyle
`
    *{
        box-sizing: border-box; 
        margin: 0;
        padding: 0;
        font-family: 'Source Sans Pro', sans-serif; 
    }
`;

// @media screen and (max-width: 991px) 반응형 웹
// screen 이 조건()에 맞는 경우에만 대괄호 안의 명령어가 실행됨  
// 화면이 991px 미만일 때 스크린에서 괄호 안의 값을 실행해라 
export const Container = styled.div
`
    z-index: 1; 
    width: 100%;
    max-width: 1300px;
    margin-right: auto;
    margin-left: auto;
    padding-right: 50px;
    padding-left: 50px;

    @media screen and (max-width: 991px){
        padding-right: 30px;
        padding-left: 30px; 
    }
`;


export default GlobalStyle