
	//적용된 색의 경우 공통에서 코드로 관리할지 그냥 이렇게 할지 고민 필요
	
	//위험도  표시
	function colorcheck (data) {
		switch (data) {
			case 1 : 
				return '#002EFF'
			case 2 : 
				return '#2AFF00'
			case 3 : 
				return '#FFFF00'
			case 4 : 
				return '#FF6E00'
			case 5 : 
				return '#FF0000'
			default :
				return '#FFFFFF'
		}
	}
	
	//서울 반경 및 이벤트 등록
	$(function(){

		var seoullocation = "resources/json/seoulorigin.json";
		var sigungucdlocation = "resources/json/Sgncd.json";
		
		$.getJSON(sigungucdlocation, function(sgncdarray){
			
			var sigungucdarray = sgncdarray;
			
			$.getJSON(seoullocation, function(data) {
				$(data.features).each(function (index,item) {
					
					var latlngarray = item.geometry.coordinates[0];
					var polygonPath = new Array;
					$(latlngarray).each(function (index2,item2){
						polygonPath.push(new kakao.maps.LatLng(item2[1],item2[0]));	
					});
					
					$(sigungucdarray).each(function(index3,cd) {
						if (item.properties.SIG_CD == cd.SIG_CD) {
							$(dangerarray).each(function (index4,dg){
								if (dg.SIGUNGU_CD == item.properties.SIG_CD) {
									
									var colortemp = colorcheck (dg.DANGER_CD); 
									
									var polygon = new kakao.maps.Polygon({
										path:polygonPath, // 그려질 다각형의 좌표 배열
										strokeWeight: 1, // 선의 두께
										strokeColor: '#FFFFFF', // 선의 색
										strokeOpacity: 0.8, // 선의 불투명도 1에서 0 사이의 값이며 0에 가까울수록 투명
										strokeStyle: 'solid', // 선의 스타일
										fillColor: colortemp, // 채우기 색
										fillOpacity: 0.7, // 채우기 불투명도
										flag : cd.SIG_KOR_NM
									});
									
									polygon.setMap(map);
									
									// 다각형에 마우스오버 이벤트가 발생했을 때 변경할 채우기 옵션
									var mouseoverOption = { 
										fillColor: '#FFFFFF', // 채우기 색
										fillOpacity: 0.7 // 채우기 불투명도        
									};

									// 다각형에 마우스아웃 이벤트가 발생했을 때 변경할 채우기 옵션
									var mouseoutOption = {
										fillColor: colortemp, // 채우기 색 
										fillOpacity: 0.7 // 채우기 불투명도   
									};
									
									// 다각형에 마우스오버 이벤트를 등록
									kakao.maps.event.addListener(polygon, 'mouseover', function() { 
									// 다각형의 채우기 옵션을 변경
										polygon.setOptions(mouseoverOption);
										
									});
									
									kakao.maps.event.addListener(polygon, 'click' , function() {
										polygon.setOptions(mouseoverOption);
										kakao.maps.event.addListener(searchmarker, 'mouseover', function() {
											polygon.setOptions(mouseoverOption);
										});
										kakao.maps.event.addListener(searchmarker, 'mouseout', function() {
											polygon.setOptions(mouseoutOption);
										});

									});
									
										kakao.maps.event.addListener(polygon, 'mouseout', function() { 

										// 다각형의 채우기 옵션을 변경
										polygon.setOptions(mouseoutOption);

									}); 
								}	
							});
						}
					});
				});
			});
		});
	});