<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>결제 내역</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }

        .small-font {
            font-size: 2rem;
        }

        .small-select {
            font-size: 0.85rem;
            width: 10%;
            padding: 0.25rem 0.5rem;
        }

        .order-history {
            width: 100%;
            max-height: 400px;
            overflow-y: scroll;
        }

        th, td {
            padding: 15px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .scrollable-table {
            display: block;
            max-height: 400px;
            overflow-y: scroll;
            border: 1px solid #ccc;
        }

        .scrollable-table thead th {
            position: sticky;
            top: 0;
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<div class="row mb-4">
    <div class="col-md-6">
        <label for="orderFilter" class="small-font">결제 상태</label>
        <select id="orderFilter" class="form-control small-select">
            <option value="recent">최근 결제순</option>
            <option value="status">결제 상태</option>
            <option value="method">결제 방식</option>
        </select>
    </div>
    <div class="col-md-6 text-right">
        <h5>현재 포인트: <span id="points"><%= 1230 %>P</span></h5>
        <small class="text-muted">* 1년이 지나면 포인트 사용내역이 사라집니다.</small>
    </div>
</div>

<div class="scrollable-table">
    <table class="table table-bordered order-history">
        <thead>
            <tr>
                <th>구매일자</th>
                <th>상품번호</th>
                <th>상품명</th>
                <th>결제 상태</th>
                <th>사용 금액</th>
            </tr>
        </thead>
        <tbody id="orderTable">
            <!-- 예시 데이터, 서버에서 동적으로 로드된 값으로 변경 가능 -->
            <tr>
                <td>2024.10.09.</td>
                <td>4</td>
                <td>붕어빵 키링</td>
                <td>결제 완료</td>
                <td>-10,000원</td>
            </tr>
            <tr>
                <td>2024.10.07.</td>
                <td>3</td>
                <td>붕어빵 모자 세트</td>
                <td>결제 완료</td>
                <td>-25,000원</td>
            </tr>
            <tr>
                <td>2024.10.04.</td>
                <td>2</td>
                <td>붕어빵 가방 블랙</td>
                <td>결제 취소</td>
                <td>+10,000원</td>
            </tr>
            <!-- 동적으로 데이터를 표시할 수 있도록 서버에서 데이터 로드 -->
        </tbody>
    </table>
</div>

<script>
    document.querySelector('.scrollable-table').addEventListener('scroll', function() {
        var table = document.querySelector('#orderTable');
        if (this.scrollTop + this.clientHeight >= this.scrollHeight) {
            // 여기에 서버에서 더 많은 데이터를 가져오는 코드를 추가합니다.
            // 현재는 더미 데이터를 추가하는 예시입니다.
            for (var i = 0; i < 5; i++) {
                var newRow = table.insertRow();
                var cell1 = newRow.insertCell(0);
                var cell2 = newRow.insertCell(1);
                var cell3 = newRow.insertCell(2);
                var cell4 = newRow.insertCell(3);
                var cell5 = newRow.insertCell(4);
                
                cell1.innerHTML = '2024.10.0' + (5 + i);
                cell2.innerHTML = (5 + i);
                cell3.innerHTML = '추가된 상품 ' + (5 + i);
                cell4.innerHTML = '결제 완료';
                cell5.innerHTML = '-10,000원';
            }
        }
    });
</script>

</body>
</html>
