/*global kakao*/

import React from "react";
import { Card, CardHeader, CardBody, Row, Col } from "reactstrap";

var areas = require('../variables/koreaArea.js');
var mark = require('../variables/markArea.js');
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
    for (var i = 0, len = areas.length; i < len; i++) {
      displayArea(areas[i]);
    }

    // 다각형을 생상하고 이벤트를 등록하는 함수입니다
    function displayArea(area) {

      // 다각형을 생성합니다 
      var polygon = new kakao.maps.Polygon({
        map: map, // 다각형을 표시할 지도 객체
        path: area.path,
        strokeWeight: 0,
        strokeColor: '#004c80',
        strokeOpacity: 0.8,
        fillColor: '#fff',
        fillOpacity: 0.1
      });

      // 다각형에 mouseover 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 변경합니다 
      // 지역명을 표시하는 커스텀오버레이를 지도위에 표시합니다
      kakao.maps.event.addListener(polygon, 'mouseover', function (mouseEvent) {
        polygon.setOptions({ fillColor: '#09f' });
        // customOverlay.setContent( area.name);
        customOverlay.setPosition(mouseEvent.latLng);
        customOverlay.setMap(map);
      });

      // 다각형에 mousemove 이벤트를 등록하고 이벤트가 발생하면 커스텀 오버레이의 위치를 변경합니다 
      kakao.maps.event.addListener(polygon, 'mousemove', function (mouseEvent) {
        customOverlay.setPosition(mouseEvent.latLng);
      });

      // 다각형에 mouseout 이벤트를 등록하고 이벤트가 발생하면 폴리곤의 채움색을 원래색으로 변경합니다
      // 커스텀 오버레이를 지도에서 제거합니다 
      kakao.maps.event.addListener(polygon, 'mouseout', function () {
        polygon.setOptions({ fillColor: '#fff' });
        customOverlay.setMap(null);
      });

      // 다각형을 클릭하면 지도가 확대
      kakao.maps.event.addListener(polygon, 'click', function (mouseEvent) {
        map.setCenter(area.center);
        map.setLevel(area.level);
        polygon.setMap(null);
        customOverlay.setMap(null);

        makeCluster(area.name);

      });
    }
    function makeCluster(areaName) {
      var showMark;
      var min_level = 7;
      console.log(areaName);
      for (var i = 0, len = mark.length; i < len; i++) {
        if (mark[i].name === areaName) {
          showMark = mark[i].areas;
          break;
        }
      }

      var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: min_level, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
      });
      var markers = {};
      for (var j = 0, area_len = showMark.length; j < area_len; j++) {
        markers[j] = new kakao.maps.Marker({ position: showMark[j].position });
      }

      clusterer.addMarkers(markers);
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
              <CardHeader>채팅방 위치</CardHeader>
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
