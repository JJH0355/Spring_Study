$(document).ready(function() {
	toggleTimeInput();
});

// 영업시간에서 체크하지 않은 요일은 시작시간과 종료시간 input이 비활성화 되도록 하는 함수
function toggleTimeInput() {
	console.log('storeRegister.js : toggleTimeInput 시작');
	// weekTable 내부의 checkbox에 변화가 생긴다면
	// weekTable에 변화 확인
	document.getElementById("weekTable").addEventListener("change", function(event) {
		// 그 변화가 checkbox라면
		if (event.target.type === "checkbox") {
			// 이벤트가 일어난 checkbox의 id값 가져오기
			const week = event.target.id;
			console.log('storeRegister.js : week : [' + week + ']');

			// 체크박스의 요소, 해당 체크박스의 startTime-, endTime- 뒤에 체크박스의 id가 붙은 값의 요소를 가져와라
			// 체크박스 요소
			const checkbox = event.target;
			// 시작시간 요소
			const startTime = document.getElementById(`startTime-${week}`);
			// 종료시간 요소
			const endTime = document.getElementById(`endTime-${week}`);
			console.log('storeRegister.js : checkbox : [' + checkbox + ']');
			console.log('storeRegister.js : startTime : [' + startTime + ']');
			console.log('storeRegister.js : endTime : [' + endTime + ']');

			// 만약 체크박스가 체크되어 있다면
			if (checkbox.checked) {
				// 시작시간, 종료시간 입력 방지를 해제, 입력 강제
				startTime.disabled = false;
				startTime.required = true;
				endTime.disabled = false;
				endTime.required = true;
			} else {
				// 시작시간, 종료시간 입력 방지, 입력 강제 해제
				startTime.disabled = true;
				startTime.required = false;
				endTime.disabled = true;
				endTime.required = false;
			}
		}
	});
}

// 메뉴와 결제방법 테이블의 체크박스가 체크 될 때 hidden input 요소는 제거하는 함수
// 가져올 테이블이 2개이므로 변화 확인 이벤트는 따로 작성하고, 공통으로 들어가는 hidden input 제거 함수만 사용
function deleteHiddenCheck(event) {
	console.log('storeRegister.js : deleteHiddenCheck 시작');

	// 만약 그 변화가 checkbox라면
	if (event.target.type === "checkbox") {
		// 이벤트가 일어난 checkbox의 id 가져오기
		const id = event.target.id;
		console.log('storeRegister.js : id : [' + id + ']');
		
		// 이벤트가 일어난 checkbox의 name 값 가져오기
		const name = event.

		// 제거할 hidden 요소의 id값으로 요소 가져오기
		// hidden 요소의 id : nonChecked-${id}
		const hiddenInputId = `nonChecked-${id}`;
		// hiddenInputId 값으로 요소 가져오기
		const hiddenInput = document.getElementById(hiddenInputId);
		console.log('storeRegister.js : hiddenInput : [' + hiddenInput + ']');

		// 만약 체크박스가 체크되어 있다면
		if (checkbox.checked) {
			// hiddentInput 요소 지우기
		}
		// 체크박스가 해제되어있고, hiddentInput 요소가 존재하지 않는다면
		else if(!document.contains(hiddenInput)) {
			// 숨겨진 요소 추가
			// input 타입 요소 추가
			const newHiddenInput = document.createElement('input');
			// type 요소는 hidden으로 설정
			newHiddenInput.type = 'hidden';
			// name 요소는 hidden으로 설정
			newHiddenInput.name = 'storePaymentCard';
			// type 요소는 hidden으로 설정
			newHiddenInput.value = 'N';
			// type 요소는 hidden으로 설정
			checkbox.parentNode.appendChild(newHiddenInput);
		}
	}
}