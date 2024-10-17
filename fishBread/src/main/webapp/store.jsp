<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="java.util.ArrayList, java.util.HashMap, java.util.Map, java.util.List"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>

<html>
<head>
<title>가게 상세정보</title>
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, user-scalable=no" />
   
<link rel="stylesheet" href="${path}/assets/css/main.css" />
<link rel="stylesheet" href="${path}/assets/css/pagination.css">
<link rel="stylesheet" href="${path}/resources/assets/css/store.css">

<!-- dropdown 박스 style -->
<style>
        .dropdown {
            width: 250px;
            margin: 20px;
        }
        .dropdown select {
            width: 100%;
            padding: 4px; /* 패딩 줄이기 */
           font-size: 16px; /* 폰트 크기 줄이기 */
        }
</style>

</head>
<body class="subpage">
   <div id="page-wrapper">

      <custom:header />

      <!-- Content -->
		<div class="container">
			<!-- 페이지 제목-->
			<div class="row text-center">
				<div class="col-12">
					<h2>가게 상세 정보</h2>
					<hr>
				</div>
			</div>

			<!-- 상세 페이지 내용-->
			<div class="row">
				<div class="col-12">
					<!-- 가게 상세 -->
					<div class="row view-container">
						<div class="col-12 col-md-6">
							<!-- 왼쪽 부분 -->
							<div class="row">
								<div class="col-12">
									<!-- 가게 이름 -->
									<h4 class="store-name">
										${storeData.storeName}{가게이름} <span class="tag" id="openStore">영업중</span>
										<span class="tag" id="closedStore">폐업</span>
									</h4>
									<br>
									<!-- 별점 플러그인 -->
								</div>
							</div>

							<div class="row">
								<div class="col-12">
									<!-- 영업 요일 -->
									<h5>
										<img class="icon"
											src="resources\assets\images\calander_icon.png" alt="달력 이미지">
										영업 요일
									</h5>
									<div class="tag-container2">
										<ul class="week-list">
											<li class="list-value"><span class="tag"><span
													class="week">월요일</span><span class="time">시작시간 ~
														종료시간</span></span></li>
											<li class="list-value"><span class="tag"><span
													class="week">월요일</span><span class="time">시작시간 ~
														종료시간</span></span></li>
										</ul>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-12">
									<!-- 메뉴 -->
									<h5>
										<img class="icon"
											src="resources\assets\images\calander_icon.png" alt="달력 이미지">
										메뉴
									</h5>
									<div class="tag-container">
										<span class="tag">팥/슈크림</span> <span class="tag">야채/김치/만두</span>
										<span class="tag">팥/슈크림</span> <span class="tag">팥/슈크림</span>
										<span class="tag">팥/슈크림</span> <span class="tag">팥/슈크림</span>
										<span class="tag">팥/슈크림</span>

									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-12">
									<!-- 결제 방식 -->
									<h5>
										<img class="icon"
											src="resources\assets\images\calander_icon.png" alt="달력 이미지">
										결제방식
									</h5>
									<div class="tag-container">
										<span class="tag">카드결제</span> <span class="tag">계좌이체</span>
									</div>
								</div>
							</div>

						</div>
						<div class="col-12 col-md-6">
							<!-- 오른쪽 부분-->
							<div class="row map-height justify-content-center">
								<div class="col-9">
									<!-- 지도 -->
									<div class="map">
										<img class="map-value"
											src="resources\assets\images\map_sample.png" alt="맵 이미지">
									</div>
								</div>
							</div>

							<div class="row  data-height justify-content-center">
								<div class="col-9 text-center">
									<!-- 주소, 전화번호 -->
									<div class="store-data">
										<div class="store-data-content">
											<img class="icon"
												src="resources\assets\images\address_icon.png" alt="주소 아이콘">
											<span>${storeData.storeDefaultAddress} <br>
												${store.detail.address}
											</span>
											<button class="copy" id="copy">복사</button>
										</div>
										<div class="store-data-content">
											<img class="icon"
												src="resources\assets\images\address_icon.png"
												alt="전화번호 아이콘"> <span>${store.phone}</span>
											<button class="copy" id="copy">복사</button>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

      <custom:footer />

   </div>

   <!-- Scripts -->
   <script src="assets/js/jquery.min.js"></script>
   <script src="assets/js/browser.min.js"></script>
   <script src="assets/js/breakpoints.min.js"></script>
   <script src="assets/js/util.js"></script>
   <script src="assets/js/main.js"></script>

   <script>        
        // 복사하기 버튼 눌렀을 때 수행 되는 함수
           function copyStorePhoneNumber(storeContact) {
               navigator.clipboard.writeText(storeContact).then(function() {
                   alert('전화 번호를 복사 했습니다!');
               }, function(err) {
                   alert('복사에 실패 했습니다..: ', err);
               });
           }
           
        function viewStore(storeNum){
               window.location.href = 'updateStorePage.do?storeNum=' + encodeURIComponent(storeNum);
        }
      
    </script>

</body>
</html>