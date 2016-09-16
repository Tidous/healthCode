//进来的统计
window.Quan_X = 0;
window.Quan_Y = 0;
var im=new Image; im.src="http://stat-z.xywy.com/test.png?t_c=1&tt"+Math.random();
function getPos(callback){
	
	var longitude = 0, //经度
		latitude = 0, //纬度
		options;
	
	options = {
	   enableHighAccuracy:true,
	   maximumAge: 10000
	};
	
	if(typeof callback != 'function'){
		//alert('callback参数须为函数');
		return false;
	}
	
	if(localStorage.longitude && localStorage.latitude){
		callback(localStorage.longitude, localStorage.latitude); //直接传入本地存储的经度和纬度
		return false;
	}
	
	if(navigator.geolocation){
	   navigator.geolocation.getCurrentPosition(showPosition, showError, options);
	}
	
	function showPosition(position){
		localStorage.longitude = longitude = position.coords.longitude; //经度
		localStorage.latitude = latitude = position.coords.latitude; //纬度
		callback(longitude, latitude);//传入经纬度
	}
	
	function showError(error){
		//定位失败的统计
		im=new Image; im.src="http://stat-z.xywy.com/test.png?t_c=3&tt"+Math.random();
		 switch(error.code) {
			case error.PERMISSION_DENIED:
				//alert("定位失败,用户拒绝请求地理定位");
				break;
			case error.POSITION_UNAVAILABLE:
				//alert("定位失败,位置信息是不可用");
				break;
			case error.TIMEOUT:
				//alert("定位失败,请求获取用户位置超时");
				break;
			case error.UNKNOWN_ERROR:
				//alert("定位失败,定位系统失效");
				break;
		}
	}
}
