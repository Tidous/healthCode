(function(){
	var requestColumn = [];
	var ref = document.referrer;
	var url = document.location.href;
	var domain = document.domain;
	requestColumn.push('UnitId=verify');
	requestColumn.push('Url=' + encodeURIComponent(url));
	requestColumn.push('Domain=' + domain);
	requestColumn.push('Ref=' + encodeURIComponent(ref));
	requestColumn.push('RandomNum=' + Math.random());
	var img = new Image;
	img.src = "http:\/\/stat-y.xywy.com\/pv_verify.png?" + requestColumn.join('&');
})();