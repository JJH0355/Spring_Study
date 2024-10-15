<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="java.util.ArrayList, java.util.HashMap, java.util.Map, java.util.List"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>

<html>
<head>
<title>가게 목록</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/resources/assets/css/test.css">
    <link rel="stylesheet" href="/resources/assets/css/searchvalue.css">
    <link rel="stylesheet" href="/resources/assets/css/pagination.css">

    <!-- bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<style type="text/css">
.custom-checkbox {
   display: inline-block;
   position: relative;
   padding-left: 35px; /* 체크박스와 라벨 텍스트 사이의 여백 */
   cursor: pointer;
   font-size: 16px; /* 텍스트 크기 조정 */
}

.custom-checkbox input {
   position: absolute;
   opacity: 0;
   cursor: pointer;
}

.checkmark {
   position: absolute;
   top: 0;
   left: 0;
   height: 25px; /* 체크박스 높이 */
   width: 25px; /* 체크박스 너비 */
   background-color: #eee;
   border-radius: 5px; /* 둥근 모서리 */
}

.custom-checkbox input:checked ~ .checkmark {
   background-color: #2196F3;
}

.checkmark:after {
   content: "";
   position: absolute;
   display: none;
}

.custom-checkbox input:checked ~ .checkmark:after {
   display: block;
   left: 9px;
   top: 5px;
   width: 5px;
   height: 10px;
   border: solid white;
   border-width: 0 3px 3px 0;
   transform: rotate(45deg);
}

</style>
   
</head>
<body>
   <div id="page-wrapper">
      
   <!-- Header 커스터 태그 -->
   <custom:header/>
   
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
        </script>

    <div class="container">
        <!-- container01 : 1행 1열-->
        <div class="row">
            <div class="col-12">
                <!-- 검색창 -->
                <form action="filterSearchStore.do">
                    <div class="container">
                        <!-- container02 : 1행-->
                        <!-- 가게명 검색 -->
                        <div class="row align-items-center row-gap">
                            <!-- container02 : 1행 1열-->
                            <div class="col-sm-2 col-md-2">
                                <div class="category" id="categoryName">가게명 검색</div>
                            </div>
                            <!-- container02 : 1행 2열-->
                            <div class="col-10 col-md-10">
                                <div class="search-input">
                                    <img src="resources/assets/images/search_icon.png" alt="검색창 아이콘 이미지" width="40px"
                                        height="40px">
                                    <input type="text" name="storeName" placeholder="가게 이름을 입력해주세요.">
                                    <input type="submit" value="검색">
                                </div>
                            </div>
                        </div>

                        <!-- 필터 조건들 출력 부분 -->
                        <div class="row align-items-center row-gap">
                            <div class="col-sm-2 col-md-2">
                                <!-- 필터 조건들을 2번째 열에 출력하기 위한 빈 공간 -->
                            </div>
                            <div class="col-10 col-md-10">
                                <span class="filterOption">안녕<button class="filter-button">X</button></span>
                                <hr>
                            </div>
                        </div>

                        <!-- 가게 메뉴 -->
                        <div class="row align-items-center row-gap">
                            <div class="col-sm-2 col-md-2">
                                <div class="category" id="categoryMenu">가게 메뉴</div>
                            </div>
                            <div class="col-10 col-md-10">
                                <div class="row">
                                    <!-- 1. 팥/슈크림 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storeMenu"
                                                    value="팥/슈크림" id="num1-pot">
                                                <span class="checkmark hover-text">팥 / 슈크림 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                    <!-- 2. 야채/김치/만두 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storeMenu"
                                                    value="야채/김치/만두" id="num1-pot">
                                                <span class="checkmark hover-text">야채/김치/만두 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                    <!-- 3. 미니 붕어빵 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storeMenu"
                                                    value="미니" id="num1-pot">
                                                <span class="checkmark hover-text">미니 붕어빵 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                    <!-- 4. 고구마 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storeMenu"
                                                    value="고구마" id="num1-pot">
                                                <span class="checkmark hover-text">고구마 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                    <!-- 5. 아이스크림/초코 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storeMenu"
                                                    value="아이스크림/초코" id="num1-pot">
                                                <span class="checkmark hover-text">아이스크림/초코 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                    <!-- 6. 치즈 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storeMenu"
                                                    value="치즈" id="num1-pot">
                                                <span class="checkmark hover-text">치즈 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                    <!-- 7. 패스츄리 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storeMenu"
                                                    value="패스츄리" id="num1-pot">
                                                <span class="checkmark hover-text">패스츄리 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                    <!-- 8.기타 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storeMenu"
                                                    value="기타" id="num1-pot">
                                                <span class="checkmark hover-text">기타 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 결제방법 -->
                        <div class="row align-items-center row-gap">
                            <div class="col-sm-2 col-md-2">
                                <div class="category" id="categoryPayment">결제 방법</div>
                            </div>
                            <div class="col-10 col-md-10">
                                <div class="row">
                                    <!-- 1. 현금결제 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storePayment"
                                                    value="현금결제" id="num1-pot">
                                                <span class="checkmark hover-text">현금결제 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                    <!-- 2. 카드결제 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storePayment"
                                                    value="카드결제" id="num1-pot">
                                                <span class="checkmark hover-text">카드결제 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                    <!-- 3. 계좌이체 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storePayment"
                                                    value="계좌이체" id="num1-pot">
                                                <span class="checkmark hover-text">계좌이체 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 운영상태 -->
                        <div class="row align-items-center row-gap">
                            <div class="col-sm-2 col-md-2">
                                <div class="category" id="categoryState">운영 상태</div>
                            </div>
                            <div class="col-10 col-md-10">
                                <div class="row">
                                    <!-- 가게 운영 상태 -->
                                    <div class="col-3">
                                        <section>
                                            <label class="custom-checkbox"> <input type="checkbox" name="storePayment"
                                                    value="현금결제" id="num1-pot">
                                                <span class="checkmark hover-text">영업중인 가게 (0)</span>
                                            </label>
                                        </section>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <hr>
        </div>

        <!-- container01 : 2행 1열-->
        <div class="row">
            <div class="col-12">
                <!-- 검색 결과 출력 부분-->
                <div class="search-value">
                    <div class="map">
                        <!-- 임시로 넣어놓음 -->
                        <img class="map-value" src="resources\assets\images\map_sample.png" alt="맵 이미지">
                    </div>
                    <div class="store-list">
                        <!-- 후에 for문으로 작성 -->
                        <div class="store-data">
                            <div class="store-data-title">
                                <h4>${store.name}</h4>
                            </div>
                            <div class="store-data-content">
                                <img class="icon" src="resources\assets\images\address_icon.png" alt="주소 아이콘">
                                <span>${store.address} <br> ${store.detail.address}</span>
                                <button class="copy" id="copy">복사</button>
                            </div>
                            <div class="store-data-content">
                                <img class="icon" src="resources\assets\images\address_icon.png" alt="전화번호 아이콘">
                                <span>${store.phone}</span>
                                <button class="copy" id="copy">복사</button>
                            </div>
                        </div>
                        <!-- sample -->
                        <div class="store-data">
                            <div class="store-data-title">
                                <h4>${store.name}</h4>
                            </div>
                            <div class="store-data-content">
                                <img class="icon" src="resources\assets\images\address_icon.png" alt="주소 아이콘">
                                <span>${store.address} <br> ${store.detail.address}</span>
                                <button class="copy" id="copy">복사</button>
                            </div>
                            <div class="store-data-content">
                                <img class="icon" src="resources\assets\images\address_icon.png" alt="전화번호 아이콘">
                                <span>${store.phone}</span>
                                <button class="copy" id="copy">복사</button>
                            </div>
                        </div>
                        <div class="store-data">
                            <div class="store-data-title">
                                <h4>${store.name}</h4>
                            </div>
                            <div class="store-data-content">
                                <img class="icon" src="resources\assets\images\address_icon.png" alt="주소 아이콘">
                                <span>${store.address} <br> ${store.detail.address}</span>
                                <button class="copy" id="copy">복사</button>
                            </div>
                            <div class="store-data-content">
                                <img class="icon" src="resources\assets\images\address_icon.png" alt="전화번호 아이콘">
                                <span>${store.phone}</span>
                                <button class="copy" id="copy">복사</button>
                            </div>
                        </div>
                        <div class="store-data">
                            <div class="store-data-title">
                                <h4>${store.name}</h4>
                            </div>
                            <div class="store-data-content">
                                <img class="icon" src="resources\assets\images\address_icon.png" alt="주소 아이콘">
                                <span>${store.address} <br> ${store.detail.address}</span>
                                <button class="copy" id="copy">복사</button>
                            </div>
                            <div class="store-data-content">
                                <img class="icon" src="resources\assets\images\address_icon.png" alt="전화번호 아이콘">
                                <span>${store.phone}</span>
                                <button class="copy" id="copy">복사</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- container01 : 3행 1열 -->
        <div class="row">
            <div class="col-12">
                <!-- 페이지네이션 -->
                <section id="pagination">
                    <div class="pagination">
                        <!-- 이전 페이지 버튼 -->
                        <c:if test="${currentPage > 1}">
                            <a href="?page=${currentPage - 1}&storeName=${param.storeName != null ? param.storeName : ''}"
                                id="pagenationPreValue">&laquo; 이전</a>
                        </c:if>

                        <c:set var="startPage" value="${currentPage - 5}" />
                        <c:set var="endPage" value="${currentPage + 4}" />

                        <c:if test="${startPage < 1}">
                            <c:set var="startPage" value="1" />
                        </c:if>
                        <c:if test="${endPage > totalPages}">
                            <c:set var="endPage" value="${totalPages}" />
                        </c:if>

                        <c:forEach var="i" begin="${startPage}" end="${endPage}">
                            <c:choose>
                                <c:when test="${i == currentPage}">
                                    <strong>${i}</strong>
                                </c:when>
                                <c:otherwise>
                                    <a href="?page=${i}&storeName=${param.storeName != null ? param.storeName : ''}"
                                        id="pagenationValue">${i}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <c:if test="${currentPage < totalPages}">
                            <a href="?page=${currentPage + 1}&storeName=${param.storeName != null ? param.storeName : ''}"
                                id="pagenationNextValue">다음 &raquo;</a>
                        </c:if>
                    </div>
                </section>
                <!-- 페이지네이션 종료 -->
            </div>
        </div>
    </div>
   
   <!-- footer 커스텀 태그 -->
   <custom:footer/>

   </div>

   <!-- Scripts -->
   <script src="assets/js/jquery.min.js"></script>
   <script src="assets/js/browser.min.js"></script>
   <script src="assets/js/breakpoints.min.js"></script>
   <script src="assets/js/util.js"></script>
   <script src="assets/js/main.js"></script>
    
    <script>
    // 복사하기 버튼 눌렀을 때 수행 되는 함수
    function copyStorePhoneNumber(storePhoneNum) {
        navigator.clipboard.writeText(storePhoneNum).then(function() {
            alert('전화 번호를 복사 했습니다!');
        }, function(err) {
            alert('복사에 실패 했습니다..: ', err);
        });
    }
        
        // 전체 선택 클릭 했을 때 수행 되는 함수
        $(document).ready(function() {
            $('#selectAll').change(function() {
                // 전체 선택 체크박스의 상태를 가져옵니다.
                var isChecked = $(this).is(':checked');
                
                // ID에 'num1'이 포함된 모든 체크박스를 선택하거나 해제합니다.
                $('input[id*="num1"]').prop('checked', isChecked);
            });
        });
        
        function viewStore(storeNum){
            window.location.href = 'viewStorePage.do?storeNum=' + encodeURIComponent(storeNum);
        }
        
        var menu_arr = [];
        var payment_arr = [];
        var storeClosed = null;
        let checkBoxUrl = '';
        
        $("input[name=storeMenu]:checked").each(function(){
        	var menu = $(this).val().trim();
        	menu_arr.push(menu);
        	console.log("menu : "+menu);
        	console.log("menu_arr : "+menu_arr);
        })
        $("input[name=storePayment]:checked").each(function(){
        	var payment = $(this).val().trim();
        	payment_arr.push(payment);
        	console.log("payment : "+payment);
        	console.log("payment_arr : "+payment_arr);
        })
        $("input[name=storeClosed]:checked").each(function(){
        	storeClosed = $(this).val().trim();
        	console.log("storeClosed : "+storeClosed);
        })
        
        menu_arr.forEach(function(menu){
        	 checkBoxUrl += '&storeMenu=' + encodeURIComponent(menu);
        })
        payment_arr.forEach(function(payment){
        	checkBoxUrl += '&storePayment=' + encodeURIComponent(payment);
        })
        if(storeClosed != null){
        	checkBoxUrl += '&storeClosed=' + encodeURIComponent(storeClosed);
        }
        
        
        console.log("checkBoxUrl : "+checkBoxUrl);
        
        let preLink = document.getElementById('pagenationPreValue');
        let nextLink = document.getElementById('pagenationNextValue');
        let pageLinks = document.querySelectorAll('#pagination a[id^="pagenationValue"]');
        
        if (pageLinks.length > 0) {
        	pageLinks.forEach(function(link) {
           	 	link.addEventListener('click', function(event) {
               		 event.preventDefault();
               		 link.href += checkBoxUrl; // 검색 조건 추가
               		 window.location.href = link.href;
           		 });
       		 });
        }
        if (preLink) {
            preLink.addEventListener('click', function(event) {
                event.preventDefault();
                preLink.href += checkBoxUrl;	// 검색 조건 추가
                window.location.href = preLink.href;
            });
        }
        if (nextLink) {
            nextLink.addEventListener('click', function(event) {
                event.preventDefault();
                nextLink.href += checkBoxUrl; 	// 검색 조건 추가
                window.location.href = nextLink.href;
            });
        }
        
        
    </script>
</body>
</html>