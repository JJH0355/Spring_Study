// 페이지가 로드 되었을 대 함수 실행
$(document).ready(function(){
	$('#mid').on('change', function(){
		var mid = $(this).val();
		console.log('['+mid+']');
		
		// 태그에 값이 존재할 때
		if(mid){
			$.ajax({
				url : 'checkMID.do',
				type : 'POST',
				data : {mid : mid},
				success : function(data){
					console.log('['+data+']');
					console.log(typeof data);
					
					if(data == 'true'){
						$('#result').text('DB에 존재하는 아이디 입니다.').css('color','red');
					}
					else{
						$('#result').text('DB에 존재하지 않는 아이디 입니다.').css('color','green');
					}
				}
			});
		}
		// 태그에 값이 존재하지 않을 때
		else{
			// result id에 아무것도 작성하지 않음
			$('#result').text('');
			console.log('값이 오지 않음');
		}
	});
});