/*global kakao*/
const marker = [
    {
        name:"서울",
        areas:
        [
            {
                name: "강남구",
                position : new kakao.maps.LatLng(37.49602641461988, 127.06158745633789)
            },
            {
                name: "강동구",
                position : new kakao.maps.LatLng(37.55106348501704, 127.14642697744497)
            }
        ]
    }
]
module.exports = marker;