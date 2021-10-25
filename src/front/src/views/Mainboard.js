/*global kakao*/

import React, {useState} from "react";
import { Card, CardTitle, CardHeader, CardBody, CardFooter, Row, Col} from "reactstrap";
import {Pie} from "react-chartjs-2";
import { dashboardEmailStatisticsChart } from "../variables/charts";
import "../assets/css/modal-board.css"
import NotificationAlert from "react-notification-alert";

function Mainboard() {
  const notificationAlert = React.useRef();
  const [ modalOpen, setModalOpen ] = useState(false);
  const openModal = () => {
    setModalOpen(true);
  }
  const closeModal = () => {
      setModalOpen(false);
  }
  const[ email, setEmail] = useState('');
  const[ password, setPwd] = useState('');
  const [userRole, setRole] = useState(false);
  
  const handleLoginChange = (event, id, pwd) =>{
      setEmail(id);
      setEmail(pwd)
  }

  const handleSignUp = (event)=>{
    //회원가입 버튼 
  }
  const alertMessage = (message_val)=>{
    var type;
    var options = {};
    var place = "tc";
    var message;
    
    if(message_val === 0){
      message= 
        <div>
          아이디와 비밀번호를 입력해주세요. 
        </div>
      ;
      type = "info";
    }
    else if (message_val === 1){
      message = 
      <div>
        로그인에 실패했습니다.
      </div> ;
      type = "warning";
    }
    else if (message_val === 2){
      message = 
      <div>
        로그인에 성공하셨습니다.
      </div>;
      type = "success";
    }
    options = {
      place: place,
      message: message,
      type: type,
      icon: "nc-icon nc-bell-55",
      autoDismiss: 7,
    };
    notificationAlert.current.notificationAlert(options);
      
  }
  const SetLoginInformation = () =>{
    setEmail(document.getElementById("email").value);
    setPwd(document.getElementById("pwd").value);
  }
  const handleLogin = (event)=>{
    SetLoginInformation();
    console.log(document.getElementById("pwd").value);
    if (email === "" || password === "") {
      alertMessage(0);
    }
    else {
      const data = {
          body: JSON.stringify({"email" : email, "password": password}),
          headers: {"Content-Type": "application/json"},
          method: 'post'
        }
        fetch("/login", data)
          .then(res => {
              if(!res.ok) {
                  throw new Error(res.status);
              } else {
                res.text().then((value)=>{
                  if(value === "true"){
                    alertMessage(2);
                    setRole(true);
                    window.location.href = "/user/maps";
                  }
                  else{
                    alertMessage(1);
                  }
                })
              }
          })
          .catch(err =>  alertMessage(1));
      }      
  }
  const Modal = ( props ) => {
    // 열기, 닫기, 모달 헤더 텍스트를 부모로부터 받아옴
    const { open, close, header } = props;
    return (
        <div className={ open ? 'openModal modal' : 'modal' }>
            { open ? (  
                <section>
                    <header>
                        {header}
                        <button className="close" onClick={close}> &times; </button>
                    </header>
                    <main>
    
                      <input type="email" id="email" placeholder="ID ..." />
                      <p></p>
                      <input type="password" id="pwd" placeholder="Password ..."/>
                 
                    </main>
                    <footer>
                        <button className="btn btn-primary" onClick={handleLogin} > LogIn </button>
                        <button className="close" onClick={handleSignUp} > Sign Up </button>
                    </footer>
                </section>
            ) : null }
        </div>
    )
  };
  const MapWrapper = () => {
    
    const mapRef = React.useRef(null);
    React.useEffect(() => {
      
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
      mapOption = { 
          center: new kakao.maps.LatLng(36, 126.9786567), // 지도의 중심좌표
          draggable: false,
          level: 12 // 지도의 확대 레벨
      };
  
  var map = new kakao.maps.Map(mapContainer, mapOption),
      customOverlay = new kakao.maps.CustomOverlay({});
      // 지도에 영역데이터를 폴리곤으로 표시합니다 
      displayArea();
  
  // 다각형을 생상하고 이벤트를 등록하는 함수입니다
  function displayArea() {
      var path = [new kakao.maps.LatLng(41.98266027217556, 134.9278576660174),
      new kakao.maps.LatLng(32.97029838823972, 131.32434210765993),
      new kakao.maps.LatLng(32.80423652407, 122.44738926695703),
      new kakao.maps.LatLng(40.143917502536894, 118.88781915358064)]
  // 지도에 영역데이터를 폴리곤으로 표시합니다 
      var polygon = new kakao.maps.Polygon({
          map: map, // 다각형을 표시할 지도 객체
          path: path,
          strokeWeight: 0,
          strokeColor: '#004c80',
          strokeOpacity: 0.8,
          fillColor: '#fff',
          fillOpacity: 0.1
      });
      // 다각형을 생성합니다 
      
  
      // 다각형에 mouseover 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 변경합니다 
      kakao.maps.event.addListener(polygon, 'mouseover', function(mouseEvent) {
  
          customOverlay.setContent('<h1>Where are you?');
          customOverlay.setPosition(mouseEvent.latLng); 
          customOverlay.setMap(map);
      });
  
  
  
      // 다각형에 mouseout 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 원래색으로 변경합니다
      // 커스텀 오버레이를 지도에서 제거합니다 
      kakao.maps.event.addListener(polygon, 'mouseout', function() {
          polygon.setOptions({fillColor: '#fff'});
          customOverlay.setMap(null);
      }); 
  
      // 지도 클릭 시 로그인 페이지로 이동
      kakao.maps.event.addListener(polygon, 'click', function(mouseEvent) {
        openModal();
      });
      
  }
  
    }, [])
      
  
    return (
        <div style={{ height: `100%` }} ref={mapRef}></div>
    );
  };
  return (
    <>
     <NotificationAlert ref={notificationAlert} />
      <div className="content">
        <Row>
          <Col md ="9">
            <Card>
            <CardHeader>
                <CardTitle tag="h5">Welcome to Won-Chat ! </CardTitle>
                <p className="card-category">Click the map! </p>
              </CardHeader>
              <CardBody>
                <div
                  id="map"
                  className="map"
                  style={{ position: "relative", overflow: "hidden" }}
                >
                  <MapWrapper />
                </div>
              </CardBody>
            </Card>
          </Col>
          <Col lg="3" md="6" sm="6">
            <Card className="card-stats">
              <CardBody>
                <Row>
                  <Col md="4" xs="5">
                    <div className="icon-big text-center icon-warning">
                      <i className="nc-icon nc-favourite-28 text-primary" />
                    </div>
                  </Col>
                  <Col md="8" xs="7">
                    <div className="numbers">
                      <p className="card-category">Number of users</p>
                      <CardTitle tag="p">+45K</CardTitle>
                      <p />
                    </div>
                  </Col>
                </Row>
              </CardBody>
              <CardFooter>
                <hr />
                <div className="stats">
                  <i className="fas fa-sync-alt" /> Update now
                </div>
              </CardFooter>
            </Card>
          </Col>
          <Col lg="3" md="6" sm="6">
            <Card className="card-stats">
              <CardBody>
                <Row>
                  <Col md="4" xs="5">
                    <div className="icon-big text-center icon-warning">
                      <i className="nc-icon nc-globe text-warning" />
                    </div>
                  </Col>
                  <Col md="8" xs="7">
                    <div className="numbers">
                      <p className="card-category">Number of chat rooms</p>
                      <CardTitle tag="p">150</CardTitle>
                      <p />
                    </div>
                  </Col>
                </Row>
              </CardBody>
              <CardFooter>
                <hr />
                <div className="stats">
                  <i className="fas fa-sync-alt" /> Update Now
                </div>
              </CardFooter>
            </Card>
          </Col>
          <Col lg="3" md="6" sm="6">
            <Card>
              <CardHeader>
                <CardTitle tag="h5">User Age</CardTitle>
                <p className="card-category">Last Campaign Performance</p>
              </CardHeader>
              <CardBody style={{ height: "266px" }}>
                <Pie
                  data={dashboardEmailStatisticsChart.data}
                  options={dashboardEmailStatisticsChart.options}
                />
              </CardBody>
           
            </Card>
          </Col>
      </Row>
      <Modal open={modalOpen} close={closeModal} header= "로그인" />
      </div>
    </>
  );
}

export default Mainboard;
