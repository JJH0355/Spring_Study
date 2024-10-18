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
        <h2>포인트 충전</h2>
    </div>
    <div class="col-md-6 text-right">
        <h5>현재 포인트: <span id="points"><%= 1230 %>P</span></h5>
        <small class="text-muted">* 1년이 지나면 포인트 사용내역이 사라집니다.</small>
    </div>
</div>

<!-- 포인트 충전 내역 테이블 -->
<div class="scrollable-table">
    <table class="table table-bordered order-history">
        <thead>
            <tr>
                <th>일자/일시</th>
                <th>내용</th>
                <th>충전포인트</th>
            </tr>
        </thead>
        <tbody id="orderTable">
            <tr>
                <td>2024.10.09.</td>
                <td>[포인트구매] 5000원권</td>
                <td>+50,000P</td>
            </tr>
            <tr>
                <td>2024.10.09.</td>
                <td>[포인트구매] 5000원권</td>
                <td>+50,000P</td>
            </tr>
            <tr>
                <td>2024.10.09.</td>
                <td>[포인트구매] 5000원권</td>
                <td>+50,000P</td>
            </tr>
            <tr>
                <td>2024.10.09.</td>
                <td>[포인트구매] 5000원권</td>
                <td>+50,000P</td>
            </tr>
            <tr>
                <td>2024.10.09.</td>
                <td>[포인트구매] 5000원권</td>
                <td>+50,000P</td>
            </tr>
            <tr>
                <td>2024.10.09.</td>
                <td>[포인트구매] 5000원권</td>
                <td>+50,000P</td>
            </tr>
        </tbody>
    </table>
</div>

<!-- 무한 스크롤을 위한 자바스크립트 -->
<script>
    document.querySelector('.scrollable-table').addEventListener('scroll', function() {
        var table = document.querySelector('#orderTable');
        if (this.scrollTop + this.clientHeight >= this.scrollHeight) {
            // 여기에 서버에서 더 많은 데이터를 가져오는 코드를 추가
            for (var i = 0; i < 5; i++) {
                var newRow = table.insertRow();
                var cell1 = newRow.insertCell(0);
                var cell2 = newRow.insertCell(1);
                var cell3 = newRow.insertCell(2);
                
                cell1.innerHTML = '2024.10.0' + (5 + i);
                cell2.innerHTML = '[포인트구매] 추가된 상품 ' + (5 + i);
                cell3.innerHTML = '+50,000P';
            }
        }
    });
</script>

</body>
</html>
