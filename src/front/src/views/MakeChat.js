/*global kakao*/

import React, {useState} from "react";
import { Card, CardHeader, CardBody, Row, Col} from "reactstrap";
import "../assets/css/modal-board.css";

function MakeChat(){

  const [ modalOpen, setModalOpen ] = useState(false);
  const [ currLocation, setLocation] = useState("");
  const mapRef = React.useRef(null);

  const MapWrapper = () => {
    var map;    
    const searchAddrFromCoords = (coord) =>{
      let geocoder = new kakao.maps.services.Geocoder();
      var region_1, region_2, return_region= '' ;
      let callback = function(result, status) {
          if (status === kakao.maps.services.Status.OK) {
              var addr = result[0]["address"];
              region_1 = addr["region_1depth_name"];
              region_2 = addr["region_2depth_name"];
              return_region = region_1 + " " + region_2;
              setLocation(return_region);
          }
      };
      geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
    }
    React.useEffect(() => {
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = { 
            center: new kakao.maps.LatLng(36, 126.9786567), // 지도의 중심좌표
            draggable: false,
            level: 12// 지도의 확대 레벨
        };
        map = new kakao.maps.Map(mapContainer, mapOption);
      },[])
    if (navigator.geolocation) {
        //위치 정보를 얻기
        navigator.geolocation.getCurrentPosition(function(pos) {
            var la, lo = 0;
            la = pos.coords.latitude;     // 위도
            lo = pos.coords.longitude; // 경도
            var location  =  new kakao.maps.LatLng(la, lo);
            map.setCenter(location);
            searchAddrFromCoords(map.getCenter());
            map.setLevel(8);
            openModal();
        });
      
      }  
    return (
      <div style={{ height: `100%` }} ref={mapRef}></div>
      );
  }

  
  const openModal = () => {
    setModalOpen(true);
  }
  const closeModal = () => {
      setModalOpen(false);
  }
  const moveChatList = () =>{
    window.location.href = "/user/chatList"
  }
  const moveChat = () =>{
    window.location.href = "/user/chat"
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
                    <div>
                      <p>채팅방 이름</p>
                      <input type="text" id="chat_name" placeholder="chatting room name" autocomplete="off"/>
                    </div>
                   
                    <div>
                      <p>닉네임</p>
                      <input type="text" id="nick_name" placeholder="Nick Name" autocomplete="off"/>
                    </div>
                    </main>
                    <footer>
                        <button className="btn btn-primary" onClick={moveChat}> 채팅방 생성 </button>
                        <button className="close"  onClick={moveChatList}> 생성 취소 </button>
                    </footer>
                </section>
            ) : null }
        </div>
    )
}
    return(
        <>
        <div className="content">
          <Row>
            <Col md="">
              <Card>
                <CardHeader>&nbsp; &nbsp; &nbsp; &nbsp; 현재 위치를 설정하고 있습니다.</CardHeader>
                <CardBody>
                  <div
                    id="map"
                    className="map"
                    style={{ position: "relative", overflow: "hidden" }}>
                      <span id="centerAddr"></span>
                    <MapWrapper />
                  </div>
                </CardBody>
              </Card>
            </Col>
          </Row>
        </div>
        <Modal open={modalOpen} close={closeModal} header= {currLocation + "에 채팅방을 생성합니다."} />
      </>
    );
}
export default MakeChat;