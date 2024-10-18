<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>장바구니</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .cart-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .cart-products {
            border-top: 1px solid #ccc;
            padding-top: 20px;
        }

        .product-item {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 20px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .product-info {
            display: flex;
            align-items: center;
        }

        .product-image {
            width: 100px;
            height: 60px;
            background-color: #eee;
            margin-right: 15px;
        }

        .product-quantity select {
            width: 80px;
        }

        .cart-footer {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-top: 20px;
            padding-top: 20px;
            border-top: 1px solid #ccc;
        }

        .cart-footer .total-price {
            font-size: 1.5em;
            font-weight: bold;
        }

        .btn-custom {
            background-color: #555;
            color: white;
            border: none;
            padding: 10px 20px;
        }

        .btn-custom:hover {
            background-color: #333;
        }
    </style>
</head>

<body>

    <div class="container mt-5">
        <div class="row">
            <h2 class="text-center">장바구니</h2>
        </div>

        <!-- 2행: 상단 선택, 포인트, 충전하기 버튼 -->
        <div class="row cart-header">
            <div class="col-md-6 d-flex align-items-center">
                <input type="checkbox" id="selectAll"> <label for="selectAll" class="ms-2">전체선택</label>
            </div>
            <div class="col-md-6 text-end">
                <span>현재 포인트: <strong><%= 128000 %>P</strong></span>
                <button class="btn btn-outline-secondary ms-3">충전하기</button>
            </div>
        </div>

        <div class="cart-products">
            <!-- 상품 1 -->
            <div class="product-item">
                <div class="product-info">
                    <input type="checkbox" class="form-check-input me-2">
                    <div class="product-image"></div>
                    <div>
                        <strong>물건 이름</strong><br>
                        10,000P / <span class="product-quantity">
                            <select>
                                <option value="1">1개</option>
                                <option value="2">2개</option>
                                <option value="3">3개</option>
                            </select>
                        </span>
                    </div>
                </div>
                <button class="btn btn-light">X</button>
            </div>

            <div class="product-item">
                <div class="product-info">
                    <input type="checkbox" class="form-check-input me-2">
                    <div class="product-image"></div>
                    <div>
                        <strong>물건 이름</strong><br>
                        10,000P / <span class="product-quantity">
                            <select>
                                <option value="1">1개</option>
                                <option value="2">2개</option>
                                <option value="3">3개</option>
                            </select>
                        </span>
                    </div>
                </div>
                <button class="btn btn-light">X</button>
            </div>
        </div>

        <div class="cart-footer">
            <div class="col-md-6">
                <h5>주문 금액</h5>
            </div>
            <div class="col-md-6 text-end">
                <span class="total-price">20,000P</span>
                <button class="btn btn-custom ms-3">구매하기</button>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
