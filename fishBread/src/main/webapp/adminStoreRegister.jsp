<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>가게 등록 페이지</title>
<meta content="width=device-width, initial-scale=1.0, shrink-to-fit=no"
	name="viewport" />
<link rel="icon" href="../resources\assets\images\logo.png"
	type="image/x-icon" />

<!-- Fonts and icons -->
<script src="/resources/assets/js/plugin/webfont/webfont.min.js"></script>
<script>
	WebFont.load({
		google : {
			families : [ "Public Sans:300,400,500,600,700" ]
		},
		custom : {
			families : [ "Font Awesome 5 Solid", "Font Awesome 5 Regular",
					"Font Awesome 5 Brands", "simple-line-icons", ],
			urls : [ "/resources/assets/css/fonts.min.css" ],
		},
		active : function() {
			sessionStorage.fonts = true;
		},
	});
</script>

<!-- CSS Files -->
<link rel="stylesheet" href="../resources/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../resources/assets/css/plugins.min.css" />
<link rel="stylesheet" href="../resources/assets/css/kaiadmin.min.css" />
<link rel="stylesheet" href="../resources/assets/css/admin.css">
</head>

<body>
	<div class="wrapper">
		<!-- 전체 페이지를 감싸는 wrapper -->
		<!-- Sidebar -->
		<div class="sidebar" data-background-color="dark">
			<!-- 어두운 배경의 사이드바 -->
			<!-- 사이드바의 로고 -->
			<div class="sidebar-logo">
				<!-- Logo Header -->
				<div class="logo-header" data-background-color="dark">
					<!-- 로고 헤더 -->
					<a href="main.do" class="logo"> <!-- 메인 페이지로 이동하는 링크 --> <img
						src="../resources/assets/images/logo_name.png" alt="navbar brand"
						class="navbar-brand" height="40" /> <!-- 로고 이미지 -->
					</a>
					<!-- 로고 옆에 사이드바 줄이는 버튼 -->
					<div class="nav-toggle">
						<button class="btn btn-toggle toggle-sidebar">
							<!-- 사이드바 토글 버튼 -->
							<i class="gg-menu-right"></i>
							<!-- 아이콘 -->
						</button>
						<button class="btn btn-toggle sidenav-toggler">
							<!-- 사이드바 축소 버튼 -->
							<i class="gg-menu-left"></i>
							<!-- 아이콘 -->
						</button>
					</div>
					<button class="topbar-toggler more">
						<!-- 추가 옵션 버튼 -->
						<i class="gg-more-vertical-alt"></i>
						<!-- 아이콘 -->
					</button>
				</div>
				<!-- End Logo Header -->
			</div>
			<!-- 사이드바 내용 -->
			<div class="sidebar-wrapper scrollbar scrollbar-inner">
				<div class="sidebar-content">
					<ul class="nav nav-secondary">
						<!-- 사이드바 내비게이션 메뉴 -->
						<li class="nav-item">
							<!-- 네비게이션 항목 --> <a data-bs-toggle="collapse" href="#dashboard"
							class="collapsed" aria-expanded="false"> <i
								class="fas fa-store"></i>
							<!--집모양 아이콘--> <!-- 첫 번째 토글 이름 -->
								<p>제보받은 가게</p> <span class="caret"></span> <!-- ▼ 아이콘 -->
						</a>
							<div class="collapse" id="dashboard">
								<!-- 가게 제보 하위 목록 -->
								<ul class="nav nav-collapse">
									<li><a href="등록 제보 링크"> <span class="sub-item">가게
												등록 제보</span>
									</a></li>
									<li><a href="폐점 제보 링크"> <span class="sub-item">가게
												폐점 제보</span>
									</a></li>
								</ul>
							</div>
						</li>

						<!-- 가게 정보 등록 -->
						<li class="nav-item"><a href="../widgets.html">
								<!-- 가게 등록 페이지 링크 --> <i class="fas fa-plus-square"></i>
							<!-- + 아이콘 -->
								<p>가게 등록</p>
						</a></li>

						<!-- 주문받은 상품 -->
						<li class="nav-item"><a
							href="../../../documentation/index.html"> <!-- 주문받은 상품 페이지 링크 -->
								<i class="fas fa-receipt"></i> <!-- 문서 아이콘 -->
								<p>주문받은 상품</p>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- End Sidebar -->

		<!-- 페이지의 메인 부분 -->
		<div class="main-panel">
			<div class="container">
				<div class="page-inner">
					<!-- 페이지 내부 -->
					<div class="page-header">
						<h3 class="fw-bold mb-3">가게 등록</h3>
						<!-- 페이지 제목 -->
						<ul class="breadcrumbs mb-3">
							<!-- 관리자 페이지 내의 페이지 경로 -->
							<!-- 첫 번째 경로 -->
							<li class="nav-home">
								<!-- 홈 링크 --> <a href="#"> <i class="icon-home"></i>
								<!--홈 아이콘-->
							</a>
							</li>
							<li class="separator"><i class="icon-arrow-right"></i>
							<!-- > 아이콘 --></li>
							<!-- 두 번째 경로 -->
							<li class="nav-item"><a href="#">가게 등록</a></li>
						</ul>
					</div>
					<!-- 메인 작성 부분-->
					<div class="row">
						<div class="col-md-12">
							<!-- 하얀 배경 부분-->
							<div class="card">
								<!-- 카드 내용 부분 시작-->
								<div class="card-body">
									<br>

									<!--1. 상호명 입력란-->
									<div class="row">
										<section>
											<h3>
												<b>가게 이름</b>
											</h3>
											<div>
												<input type="text" required placeholder="가게 이름을 입력해주세요."></input>
											</div>
										</section>
									</div>

									<!--2. 전화번호 입력란-->
									<div class="row">
										<section>
											<h3>
												<b>전화번호(선택)</b>
											</h3>
											<div>
												<input type="tel" required placeholder="전화번호를 입력해주세요."></input>
											</div>
										</section>
									</div>

									<!--3. 주소 입력란-->
									<div class="row">
										<section>
											<!--1행 주소검색 -->
											<div class="container-fluid d-flex justify-content-between">
												<!-- 컨테이너로 좌우 정렬 -->
												<h3 class="pull-left">
													<b>주소 입력</b>
												</h3>
												<div class="copyright"></div>
												<div>
													<button type="button" class="btn btn-black" id="">주소
														검색</button>
												</div>
											</div>
											<!--2행 주소검색데이터 불러오기-->
											<div>
												<input type="text" required placeholder="주소검색버튼을 눌러주세요."></input>
												<br>
												<br> <input type="text" required placeholder="우편번호 입력"></input>
												<br>
												<br> <input type="text" required placeholder="상세주소 입력"></input>
											</div>
										</section>
									</div>

									<!--메뉴, 결제방식 선택란-->
									<div class="row">
										<!--4. 메뉴 선택란-->
										<div class="col-6">
											<section>
												<h3>
													<b>메뉴 선택</b>
												</h3>
												<div class="col-6">
													<table>
														<tr>
															<td><input type="checkbox" name="menu" value="팥/슈크림">팥/슈크림</td>
															<td><input type="checkbox" value="아이스크림/초코">아이스크림/초코</td>
														</tr>
														<tr>
															<td><input type="checkbox" name="menu"
																value="야채/김치/만두">야채/김치/만두</td>
															<td><input type="checkbox" value="치즈">치즈</td>
														</tr>
														<tr>
															<td><input type="checkbox" name="menu" value="미니">미니
																붕어빵</td>
															<td><input type="checkbox" value="패스츄리">패스츄리</td>
														</tr>
														<tr>
															<td><input type="checkbox" name="menu" value="고구마">고구마</td>
															<td><input type="checkbox" value="기타">기타</td>
														</tr>
													</table>
											</section>
										</div>
										<!--5. 결제방식 선택란-->
										<div class="col-6"></div>
										<section>
											<h3>
												<b>메뉴 선택</b>
											</h3>
											<table>
												<tr>
													<td><input type="checkbox" name="pay" value="현금결제">현금결제</td>
												</tr>
												<tr>
													<td><input type="checkbox" name="pay" value="카드결제">카드결제</td>
												</tr>
												<tr>
													<td><input type="checkbox" name="pay" value="계좌이체">계좌이체</td>
												</tr>
											</table>
										</section>
									</div>

									<!--6. 영업요일-->
									<div class="row">
										<table>
											<tr>
												<td><input type="checkbox" name="pay" value="월요일">월요일</td>
												<td><input type="time" id="start-time" name="startTime"
													required></td>
												<td><input type="time" id="end-time" name="endTime"
													required></td>
											</tr>
											<tr>
												<td><input type="checkbox" name="pay" value="화요일">화요일</td>
												<td><input type="time" id="start-time" name="startTime"
													required></td>
												<td><input type="time" id="end-time" name="endTime"
													required></td>
											</tr>
											<tr>
												<td><input type="checkbox" name="pay" value="수요일">수요일</td>
												<td><input type="time" id="start-time" name="startTime"
													required></td>
												<td><input type="time" id="end-time" name="endTime"
													required></td>
											</tr>
											<tr>
												<td><input type="checkbox" name="pay" value="묙요일">목요일</td>
												<td><input type="time" id="start-time" name="startTime"
													required></td>
												<td><input type="time" id="end-time" name="endTime"
													required></td>
											</tr>
											<tr>
												<td><input type="checkbox" name="pay" value="금요일">금요일</td>
												<td><input type="time" id="start-time" name="startTime"
													required></td>
												<td><input type="time" id="end-time" name="endTime"
													required></td>
											</tr>
											<tr>
												<td><input type="checkbox" name="pay" value="토요일">토요일</td>
												<td><input type="time" id="start-time" name="startTime"
													required></td>
												<td><input type="time" id="end-time" name="endTime"
													required></td>
											</tr>
											<tr>
												<td><input type="checkbox" name="pay" value="일요일">일요일</td>
												<td><input type="time" id="start-time" name="startTime"
													required></td>
												<td><input type="time" id="end-time" name="endTime"
													required></td>
											</tr>
										</table>
									</div>
									<div class="row">
										<input type="submit" value="등록하기">
									</div>
								</div>
								<!--카드 내용 부분 끝-->
							</div>
						</div>
					</div>
				</div>
			</div>

			<footer class="footer">
				<!-- 페이지 하단 푸터 -->
				<div class="container-fluid d-flex justify-content-between">
					<!-- 푸터 내용, 플루이드 컨테이너로 좌우 정렬 -->
					<nav class="pull-left">
						<!-- 왼쪽 내비게이션 -->
					</nav>
					<div class="copyright">
						<!-- 저작권 정보 -->
						<img src="../resources/assets/images/favicon.png"> <a
							href="local...">갈빵질빵링크넣어야돼요</a>
						<!-- ThemeKita 링크 -->
					</div>
					<div>
						<!-- 추가 정보 -->
						붕어빵원정대
						<!-- 배포 정보 -->
					</div>
				</div>
			</footer>
		</div>
		<!-- 메인 패널 종료 -->
	</div>
	<!-- 전체 wrapper 종료 -->

	<!-- Core JS Files -->
	<script src="../resources/assets/js/core/jquery-3.7.1.min.js"></script>
	<!-- jQuery 라이브러리 -->
	<script src="../resources/assets/js/core/popper.min.js"></script>
	<!-- Popper.js (툴팁 및 팝오버를 위한 라이브러리) -->
	<script src="../resources/assets/js/core/bootstrap.min.js"></script>
	<!-- Bootstrap JavaScript -->

	<!-- jQuery Scrollbar -->
	<script
		src="../resources/assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<!-- jQuery 스크롤바 플러그인 -->
	<!-- Datatables -->
	<script
		src="../resources/assets/js/plugin/datatables/datatables.min.js"></script>
	<!-- DataTables 플러그인 -->

	<!-- Kaiadmin JS -->
	<script>
		$(document)
				.ready(
						function() { // 문서가 준비되면 실행되는 함수
							$("#basic-datatables").DataTable({}); // 기본 DataTable 초기화

							$("#multi-filter-select")
									.DataTable(
											{ // 다중 필터 선택 DataTable 초기화
												pageLength : 5, // 페이지당 항목 수
												initComplete : function() { // 초기화 완료 후 실행되는 함수
													this
															.api()
															// DataTable API 호출
															.columns()
															// 모든 열에 대해
															.every(
																	function() { // 각 열에 대해 반복
																		var column = this; // 현재 열을 변수에 저장
																		var select = $(
																				'<select class="form-select"><option value=""></option></select>' // 필터 선택 박스 생성
																		)
																				.appendTo(
																						$(
																								column
																										.footer())
																								.empty())
																				// 열의 푸터에 추가
																				.on(
																						"change",
																						function() { // 선택 박스 변경 시
																							var val = $.fn.dataTable.util
																									.escapeRegex($(
																											this)
																											.val()); // 선택된 값 정규 표현식으로 변환

																							column
																									// 현재 열에 대해
																									.search(
																											val ? "^"
																													+ val
																													+ "$"
																													: "",
																											true,
																											false)
																									// 선택된 값으로 검색
																									.draw(); // 테이블 다시 그리기
																						});

																		column
																				// 현재 열의 데이터에 대해
																				.data()
																				// 데이터 가져오기
																				.unique()
																				// 고유한 값만 가져오기
																				.sort()
																				// 정렬
																				.each(
																						function(
																								d,
																								j) { // 각 데이터에 대해 반복
																							select
																									.append( // 선택 박스에 옵션 추가
																									'<option value="' + d + '">'
																											+ d
																											+ "</option>");
																						});
																	});
												},
											});

							// Add Row
							$("#add-row").DataTable({ // 추가 행 DataTable 초기화
								pageLength : 5, // 페이지당 항목 수
							});

							var action = // 행에 추가할 액션 버튼 HTML
							'<td> <div class="form-button-action"> <button type="button" data-bs-toggle="tooltip" title="" class="btn btn-link btn-primary btn-lg" data-original-title="Edit Task"> <i class="fa fa-edit"></i> </button> <button type="button" data-bs-toggle="tooltip" title="" class="btn btn-link btn-danger" data-original-title="Remove"> <i class="fa fa-times"></i> </button> </div> </td>';

							$("#addRowButton").click(function() { // 추가 버튼 클릭 시
								$("#add-row") // 추가 행 DataTable에
								.dataTable() // DataTable API 호출
								.fnAddData([ // 데이터 추가
								$("#addName").val(), // 이름 입력값
								$("#addPosition").val(), // 직위 입력값
								$("#addOffice").val(), // 사무실 입력값
								action, // 액션 버튼
								]);
								$("#addRowModal").modal("hide"); // 모달 닫기
							});
						});
	</script>
</body>

</html>