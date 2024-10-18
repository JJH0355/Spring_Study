<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>포인트 충전</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            padding: 20px;
        }

        .point-options {
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 8px;
            margin-top: 10px;
        }

        .point-options div {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 0;
            border-bottom: 1px solid #ddd;
        }

        .point-options div:last-child {
            border-bottom: none;
        }

        .point-options input[type="radio"] {
            margin-right: 10px;
        }

        .current-point {
            text-align: right;
            margin-top: 10px;
            font-weight: bold;
        }

        .dropdown-payment {
            border: 1px solid #ccc;
            padding: 10px;
            border-radius: 8px;
            width: 100%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            cursor: pointer;
            background-color: #f8f9fa;
        }

        .dropdown-payment .dropdown-arrow {
            font-size: 1.5rem;
            margin-left: auto;
        }

        .dropdown-payment-options {
            display: none;
            border: 1px solid #ccc;
            padding: 10px;
            border-radius: 8px;
            margin-top: 10px;
        }

        .show-options {
            display: block;
        }

        .table-aligned {
            margin: 0 auto;
            width: 60%;
        }

        .hide-options {
            display: none;
        }

        select option:disabled[selected] {
            background-color: #ffffff;
            color: #000000;
            font-weight: bold;
        }

        select:focus {
            outline: none;
            border-color: #28a745;
            box-shadow: 0 0 5px rgba(40, 167, 69, 0.5);
            transition: box-shadow 0.3s ease-in-out;
        }

        .fade-in {
            opacity: 0;
            transform: translateY(20px);
            transition: opacity 0.6s ease, transform 0.6s ease;
        }

        .fade-in.show {
            opacity: 1;
            transform: translateY(0);
        }

        .dropdown-payment-options {
            display: none;
            max-height: 0;
            overflow: hidden;
            transition: max-height 0.4s ease-in-out;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="row mb-4">
            <div class="col-2">
                <button class="btn btn-secondary">&lt; 뒤로가기</button>
            </div>
            <div class="col-10 text-center">
                <h2>포인트 충전</h2>
            </div>
        </div>

        <div class="row mb-4 table-aligned">
            <div class="col-md-12">
                <h3>충전할 포인트</h3>
                <div class="point-options">
                    <div><input type="radio" name="point" id="point1"> <span>1,000 Point</span> <span>1,000원</span></div>
                    <div><input type="radio" name="point" id="point2"> <span>3,000 Point</span> <span>3,000원</span></div>
                    <div><input type="radio" name="point" id="point3"> <span>5,000 Point</span> <span>5,000원</span></div>
                    <div><input type="radio" name="point" id="point4"> <span>10,000 Point</span> <span>10,000원</span></div>
                    <div><input type="radio" name="point" id="point5"> <span>30,000 Point</span> <span>30,000원</span></div>
                    <div><input type="radio" name="point" id="point6"> <span>50,000 Point</span> <span>50,000원</span></div>
                </div>
            </div>
        </div>

        <div class="row mb-4 table-aligned">
            <div class="col-md-12 text-right">
                <div class="current-point">
                    <p>현재 포인트: <span><%= 12000 %>P</span></p>
                    <p>충전 후 포인트: <span><%= 18000 %>P</span></p>
                </div>
            </div>
        </div>

        <div class="row mb-4 table-aligned">
            <div class="col-12">
                <h3>결제 수단</h3>
                <div class="row mb-3">
                    <div class="col-md-4">
                        <div class="form-check">
                            <label class="form-check-label" for="cardPayment">카드 결제</label>
                            <select class="form-select dropdown-payment" id="cardPayment"
                                onchange="selectPaymentMethod(this.value)">
                                <option value="" disabled selected>카드 선택</option>
                                <option value="신한카드">신한카드</option>
                                <option value="우리카드">우리카드</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-check">
                            <label class="form-check-label" for="accountPayment">계좌 결제</label>
                            <select class="form-select dropdown-payment" id="accountPayment"
                                onchange="selectPaymentMethod(this.value)">
                                <option value="" disabled selected>계좌 선택</option>
                                <option value="국민은행">국민은행</option>
                                <option value="농협은행">농협은행</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="form-check">
                            <label class="form-check-label" for="otherPayment">기타 결제 수단</label>
                            <select class="form-select dropdown-payment" id="otherPayment"
                                onchange="selectPaymentMethod(this.value)">
                                <option value="" disabled selected>기타 선택</option>
                                <option value="카카오페이">카카오페이</option>
                                <option value="네이버페이">네이버페이</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mb-4 table-aligned">
            <div class="col-md-12">
                <h3>결제 정보</h3>
                <div class="mb-3">
                    <label for="email">이메일</label>
                    <input type="email" id="email" class="form-control" placeholder="이메일을 입력하세요">
                </div>
                <div class="mb-3">
                    <label for="paymentMethodSelected">결제 방법</label>
                    <input type="text" id="paymentMethodSelected" class="form-control" value="" readonly>
                </div>
                <div class="mb-3">
                    <label for="paymentAmount">결제 금액</label>
                    <input type="text" id="paymentAmount" class="form-control" value="5,000원" readonly>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="agreeTerms">
                    <label class="form-check-label" for="agreeTerms">
                        위 내용으로 결제에 동의합니다.
                    </label>
                </div>
                <div class="final-buttons mt-3">
                    <button class="btn btn-primary">결제하기</button>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-yLpbu4Mzo26+XXFZSrdlfVEq2m5QmaFI2UR1N2GRGiZZzMbZGcyBLgdN7wm8G/ln" crossorigin="anonymous">
    </script>

    <script>
        // 결제 방법 선택 함수
        function selectPaymentMethod(method) {
            document.getElementById('paymentMethodSelected').value = method;
        }

        // 초기화 작업: 다른 드롭다운 선택 시 기존 선택값 초기화
        document.querySelectorAll('.dropdown-payment').forEach(select => {
            select.addEventListener('change', function () {
                document.querySelectorAll('.dropdown-payment').forEach(otherSelect => {
                    if (otherSelect !== this) {
                        otherSelect.selectedIndex = 0; // 다른 드롭다운의 선택을 초기화
                    }
                });
            });
        });
    </script>

</body>

</html>
