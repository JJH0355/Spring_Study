// 페이지가 모두 준비되면 작동
$(document).ready(function() {
	var latLng = addressToLatLng('서울시 강남구 논현로87길 17');
	
	var staticMapContainer = document.getElementById('map'), // 이미지 지도를 표시할 div  
		staticMapOption = {
			center: new kakao.maps.LatLng(latLng.lat, latLng.lng), // 이미지 지도의 중심좌표
			level: 3 // 이미지 지도의 확대 레벨
		};

	// 이미지 지도를 표시할 div와 옵션으로 이미지 지도를 생성합니다
	var staticMap = new kakao.maps.StaticMap(staticMapContainer, staticMapOption);
});

// 주소를 좌표로 변경해주는 함수
function addressToLatLng(address) {
	console.log('주소를 좌표로 변경 시작');
	
	// 좌표를 담을 변수 제작
	var latLng = {};

	// 주소를 좌표로 변환 객체를 생성
	// Geocoder()은 주소를 좌표로 변환하거나, 좌표를 주소로 변환하는 역할을 함
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색
	// addressSearch(주소값, 콜백 함수) : 주소를 좌표로 변경해주는 함수
	// result : 검색된 좌표 정보가 들어있는 배열
	// status : 검색 요청의 결과 상태를 나타냄 (정상 시 ok 상태가 반환)
	geocoder.addressSearch(address, function(result, status) {

		// 정상적으로 검색이 완료됐다면
		// 만약 OK 상태가 반환돼었다면
		if (status === kakao.maps.services.Status.OK) {
			console.log('주소를 좌표로 변경 완료');
			
			// 좌표 값을 배열에 담음
			// 위도를 담음
			latLng.lat = result[0].y;
			// 경도를 담음
			latLng.lng = result[0].x;
			
			console.log('위도 값:['+latLng.lat+'], 경도 값 : ['+latLng.lng+']');
		}
	});
	
	return latLng;
}