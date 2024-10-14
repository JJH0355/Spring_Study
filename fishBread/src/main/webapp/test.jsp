<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>가게 검색</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <!-- 검색 바 -->
        <div class="search-bar">
            <form action="search" method="GET">
                <button type="button" class="search-btn">가게 명 검색</button>
                <input type="text" name="query" placeholder="Search products..." value="${param.query}">
                <select name="category">
                    <option value="all">추가 옵션 설정</option>
                    <option value="icecream">팥/슈크림</option>
                    <option value="dumpling">야채/김치/만두</option>
                    <option value="bungeoppang">미니 붕어빵</option>
                    <!-- 추가 옵션들 -->
                </select>
                <button type="submit" class="search-submit">검색</button>
            </form>
        </div>

        <!-- 가게 메뉴 필터 -->
        <div class="menu-filter">
            <div class="filter-item">팥/슈크림(0)</div>
            <div class="filter-item">야채/김치/만두(0)</div>
            <div class="filter-item">미니 붕어빵(0)</div>
            <div class="filter-item">고구마(0)</div>
            <div class="filter-item">아이스크림/초코(0)</div>
            <div class="filter-item">치즈(0)</div>
            <div class="filter-item">패소츄리(0)</div>
            <div class="filter-item">기타(0)</div>
        </div>

        <!-- 결제 방법 필터 -->
        <div class="payment-options">
            <button>현금결제(0)</button>
            <button>카드결제(0)</button>
            <button>계좌이체(0)</button>
        </div>

        <!-- 운영 상태 필터 -->
        <div class="status-filter">
            <button>운영중인 가게만 보기</button>
        </div>
    </div>
</body>
</html>