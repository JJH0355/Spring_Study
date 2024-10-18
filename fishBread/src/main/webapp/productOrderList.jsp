<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }

        .order-section {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            margin-bottom: 20px;
        }

        .order-items img {
            width: 50px;
            height: 50px;
            object-fit: cover;
            margin-right: 10px;
        }

        .total-section {
            text-align: right;
        }

        .total-section span {
            font-weight: bold;
            font-size: 1.2rem;
        }

        .btn-custom {
            background-color: #f8f9fa;
            border: 1px solid #ccc;
        }
        .modal-content {
            border-radius: 10px;
        }
        .modal-body h5 {
            font-weight: bold;
            margin-bottom: 20px;
        }
        .modal-body .btn {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="row order-section">
            <div class="col-md-6">
                <h5>배송 정보</h5>
                <div>
                    <strong>이름:</strong> <%= "000" %>
                </div>
                <div class="form-group">
                    <label for="address">배송지</label>
                    <div class="input-group">
                        <input type="text" id="address" class="form-control" placeholder="배송지">
                        <div class="input-group-append">
                            <button class="btn btn-custom">변경</button>
                        </div>
                    </div>                 
                </div>
                <div class="form-group">
                    <label for="phone">전화번호</label>
                    <div class="input-group">
                        <input type="text" id="phone" class="form-control" placeholder="전화번호">
                        <div class="input-group-append">
                            <button class="btn btn-custom">변경</button>
                        </div>
                    </div>   
                </div>
            </div>
        </div>

        <div class="row order-section">
            <div class="col-md-12">
                <h5>주문 상품</h5>
                <div class="order-items">
                    <div class="d-flex align-items-center">
                        <img src="<%= request.getContextPath() %>/resources/images/sample.jpg" alt="상품 이미지">
                        <div>
                            <strong>물건 이름</strong><br>
                            10,000P / 1개
                        </div>
                    </div>
                    <hr>
                    <div class="d-flex align-items-center">
                        <img src="<%= request.getContextPath() %>/resources/images/sample.jpg" alt="상품 이미지">
                        <div>
                            <strong>물건 이름</strong><br>
                            3,000P / 3개
                        </div>
                    </div>
                </div>
                <hr>
                <div class="total-section">
                    <div>Point 합계</div>
                    <span>13,000P</span>
                </div>
            </div>
        </div>

        <!-- Submit button -->
        <div class="row">
            <div class="col-md-12 text-right">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#orderModal">주문하기</button>
            </div>
        </div>
    </div>

    <div class="modal fade" id="orderModal" tabindex="-1" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-body text-center">
              <h5>주문하시겠습니까?</h5>
              <button type="button" class="btn btn-dark w-100">주문하기</button>
              <a href="#" class="d-block mt-2">주문 취소하기</a>
            </div>
          </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
