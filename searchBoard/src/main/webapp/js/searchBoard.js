// 페이지가 로드 되었을 때 실행
$(document).ready(function() {
	// 검색어 상태가 유지되는 함수 실행
	saveSearchValue();

	// 검색어 버튼을 클릭할 때 함수 실행
	$('#btn').on('click', function() {
		// boardSearch() 실행
		boardSearch();
	});
	// enter-key를 눌렀을 때 함수 실행
	// 이벤트 발생 시 처리하기 위한 on(function(){})
	$(document).on('keydown', function(event) {
		// 만약 눌린키가 enter라면
		if (event.key == 'Enter') {
			// boardSearch() 실행
			boardSearch();
		}
	});

	// 검색어 상태 유지 함수
	function saveSearchValue() {
		var searchCate = "${searchCate}";
		console.log("searchCate : [" + searchCate + "]");

		if (searchCate != null && searchCate.length > 0) {
			console.log("if : true");
			$('#searchCateSelect').val(searchCate);
		} else {
			console.log("if : false");
		}
	}

	// 비동기 : 게시물 검색 함수
	function boardSearch() {
		// 카테고리와 검색어 값 가져오기
		var searchCate = $('#search-cate-select').val();
		var searchKeyword = $('#search-keyword-input').val();
		//로그
		console.log('searchCate : [' + searchCate + ']');
		console.log('searchKeyword : [' + searchKeyword + ']');

		// searchKeyword 태그에 값이 존재했을 때
		if (searchKeyword) {
			// 비동기 코드
			$.ajax({
				// searchBoard.do로 이동
				url: 'searchBoard.do',
				// POST 전송방식
				type: 'POST',
				// 요청 데이터 application/json
				contentType: 'application/json',
				// JSON 문자열화
				data: JSON.stringify({
					searchCate: searchCate,
					searchKeyword: searchKeyword
				}),
				// 데이터 타입 json
				dataType: 'json',
				// 성공 시
				success: function(data) {
					// 기존의 데이터 리스트를 가져옴
					// 데이터가 변경될 것이므로 객체 자체를 가져옴
					var dataList = $('#data-list');
					console.log('dataList.length : ' + data.length);
					console.log('dataList : ');
					console.log('[' + dataList + ']');

					// 기존 리스트를 초기화 함
					dataList.empty();

					if (data.length <= 0) {
						dataList.append('<tr> <td colspan="4" align="center">검색 결과가 없습니다.</td><tr>');
					}
					else {
						// 검색 결과 반복해서 하나씩 데이터를 전달
						// 한 열씩 나열해서 전달
						data.forEach(function(item) {
							dataList.append(
								'<tr>'
								+ '<td align="center">' + item.bNum + '</td>'
								+ '<td align="center">' + item.title + '</td>'
								+ '<td align="center">' + item.writer + '</td>'
								+ '<td align="left">' + item.content + '</td>'
								+ '</tr>'
							)
						})
					}
				}
			});
		}
		else {
			// 태그에 값이 존재하지 않을 때
			// 알랏창 출력
			alert("검색어를 입력하세요.");
			// 로그
		}
	}
});
