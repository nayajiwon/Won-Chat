/*global kakao*/

import React from "react";
import { Card, CardTitle, CardHeader, CardBody, Row, Col} from "reactstrap";

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
    new kakao.maps.LatLng(35.01053233553783, 123.45813131563567),
    new kakao.maps.LatLng(39.48570000085077, 122.05188134164251)]
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

        customOverlay.setContent(' <h2>Where are you?');
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
      var link = 'Login';
      window.location.href=link;
    });
    
}

  }, [])
    

  return (
      <div style={{ height: `100%` }} ref={mapRef}></div>
  );
};

function Map() {
  return (
    <>
      <div className="content">
        <Row>
          <Col md="">
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
        </Row>
      </div>
    </>
  );
}

export default Map;
