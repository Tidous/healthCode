function clicktest(item) {
	var isIE = document.all ? true : false;
	var ref_click = document.referrer.replace(/#/g, "~");
	var xpoint = item.offsetLeft;
	var ypoint = item.offsetTop;
	var domid = item.id;
	var clicken = "";
	var clickType = "";
	if(isIE)
	{ 
		clicken = item.getAttribute("clicken");
		clickType = item.getAttribute("clickType");
	}else{
		clicken = item.attributes["clicken"].nodeValue;
		clickType = item.attributes["clickType"].nodeValue;
	} 
	var ue = unescape;
	
	var date = new Date();
	var s = [];
	var im = new Image;
	
	function pushValue(name, value) {
		s.push(name + '=' + value);
	}
	
	function saveToCookise(name, value, days) {
		date.setTime(date.getTime() + (days * 24 * 3600 * 1000 * 365));
		document.cookie = name + "=" + escape(value) + ((days == null) ? "" : "; expires=" + date.toGMTString()) + "; domain=.xywy.com ;path=/";
	}
	
	function getFromCookise(name) {
		if (document.cookie.length > 0) {
			var begin = document.cookie.indexOf(name + "=");
			if (begin != -1) {
				begin += name.length + 1;
				var end = document.cookie.indexOf(";", begin);
				if (end == -1)
					end = document.cookie.length;
				return ue(document.cookie.substring(begin, end));
			}
		}
		return null;
	}
	
	// 澶勭悊ref
	if (ref_click) {
		pushValue('ref', ref_click + 'ref');
	}
	
	// 澶勭悊clientID
	if (!getFromCookise('clientac')) {
		var clientID = date.getTime() + parseInt(Math.random(10, 1) * 100);
		pushValue('clientID', clientID + 'clientID');
		saveToCookise('clientac', clientID, '5');
	} else {
		pushValue('clientID', getFromCookise('clientac') + 'clientID');
	}
	
	// 澶勭悊loginID
	if (getFromCookise("cookie_user")) {
		pushValue('loginID', getFromCookise("cookie_user") + 'loginID');
	} else {
		pushValue('loginID', '' + 'loginID');
	}
	
	// 澶勭悊usertype
	if (getFromCookise("cookie_usertype")) {
		pushValue('usertype', getFromCookise("cookie_usertype") + 'usertype');
	} else {
		pushValue('usertype', '' + 'usertype');
	}

	// 澶勭悊鎭舵剰鍒锋柊 瀵艰嚧pv缁熻涓嶅噯鐨勯棶棰� 鏍规嵁cookie涓偍瀛樼殑涓婁竴涓姹傚拰璇锋眰鏃堕棿 鍒ゆ柇鏄惁闇€瑕佸彂鍑篶l.png璇锋眰
	var canSendCLpng = true;
	var acl = encodeURI(document.location.href.replace(/#/g, "~"));
	if (getFromCookise("cl_lastUrl")) {
		if (acl == getFromCookise("cl_lastUrl")) {
			if (getFromCookise("cl_lastUrl_time")) {
				var offset = parseInt(date.getTime()) - parseInt(getFromCookise("cl_lastUrl_time"));
				if (parseInt(offset) < 2000) {
					canSendCLpng = false;
				}
			}
		} else {

		}
	} else {

	}
	// 璁拌浇璁块棶url鍜屾椂闂�
	saveToCookise('cl_lastUrl', acl, '5');
	saveToCookise('cl_lastUrl_time', new Date().getTime(), '5');

	pushValue('AcT', acl + 'AcT');
	
	// 娣诲姞鏃ュ織绫诲瀷鍙傛暟
	// 姝ゆ暟鎹互鍚庣敤鏉ユ爣璇嗕笟鍔＄被鍨嬶紙瑙佷笅闈級
	// pushValue('clickType', '0' + 'clickType');
	
	// 娣诲姞xpoint
	pushValue('xPoint', xpoint + 'xPoint');
	
	// 娣诲姞ypoint
	pushValue('yPoint', ypoint + 'yPoint');
	
	// 娣诲姞domid
	pushValue('domID', domid + 'domID');
	
	// 娣诲姞clicken
	pushValue('clickEN', clicken + 'clickEN');

	// 娣诲姞clickType
	pushValue('clickType', clickType + 'clickType');

	// 娣诲姞random鍙傛暟锛屼娇璇锋眰鐪嬭捣鏉ヤ笉鍚�
	pushValue('randomNUM', Math.random(10, 1)*100 + 'randomNUM');
	
	if (canSendCLpng) {
		if (!getFromCookise('visit_dt')) {
			// 鐢ㄦ埛璁块棶缃戠珯鐨勬棩鏈熶负绌� 璇存槑涔嬪墠娌℃湁瀛樿繃杩欎釜cookie 閭ｄ箞杩欐槸涓€涓柊璁垮
			// 璁＄畻鐢ㄦ埛璁块棶鐨勬棩鏈� 浠ュぉ涓哄崟浣�
			var vd_day = new Date();
			var vd_year = vd_day.getFullYear();
			var vd_month = vd_day.getMonth();
			var vd_dt = vd_year + '-' + vd_month + '-' + vd_day;
			// 鎶妚d_dt鐨勫€� 鍔犲叆cookie
			saveToCookise('visit_dt', vd_dt, '5');
			pushValue('isNew_User', 'trueisNew_User');
		} else {
			// 宸茬粡璁板綍浜嗚闂綉绔欑殑鏃ユ湡 閭ｄ箞闇€瑕佹瘮杈冧竴涓嬪綋鍓嶆棩鏈熷拰杩欎釜鏃ユ湡 濡傛灉涓嶆槸鍚屼竴澶� 璇存槑鏄€佽瀹� 濡傛灉鏄竴澶� 璇存槑鏄柊璁垮
			var vd_day = new Date();
			var vd_year = vd_day.getFullYear();
			var vd_month = vd_day.getMonth();
			var vd_dt = vd_year + '-' + vd_month + '-' + vd_day;
			if (getFromCookise('visit_dt') == vd_dt) {
				// 鍚屼竴澶� 璇存槑鏄柊璁垮
				pushValue('isNew_User', 'trueisNew_User');
			} else {
				// 涓嶆槸鍚屼竴澶� 璇存槑鏄€佽瀹�
				pushValue('isNew_User', 'falseisNew_User');
			}
		}
		im.src = "http:\/\/stat-y.xywy.com\/cl.png?" + s.join('&');
	}
}

function buttonShow(item) {
	var ref_click = document.referrer;
	var xpoint = item.offsetLeft;
	var ypoint = item.offsetTop;
	var domid = item.id;
	var clicken = item.attributes["clicken"].nodeValue;
	var clickType = item.attributes["displayType"].nodeValue;
	var ue = unescape;
	
	var date = new Date();
	var s = [];
	var im = new Image;
	
	function pushValue(name, value) {
		s.push(name + '=' + value);
	}
	
	function saveToCookise(name, value, days) {
		date.setTime(date.getTime() + (days * 24 * 3600 * 1000 * 365));
		document.cookie = name + "=" + escape(value) + ((days == null) ? "" : "; expires=" + date.toGMTString()) + "; domain=.xywy.com ;path=/";
	}
	
	function getFromCookise(name) {
		if (document.cookie.length > 0) {
			var begin = document.cookie.indexOf(name + "=");
			if (begin != -1) {
				begin += name.length + 1;
				var end = document.cookie.indexOf(";", begin);
				if (end == -1)
					end = document.cookie.length;
				return ue(document.cookie.substring(begin, end));
			}
		}
		return null;
	}
	
	// 澶勭悊ref
	if (ref_click) {
		pushValue('ref', ref_click + 'ref');
	}
	
	// 澶勭悊clientID
	if (!getFromCookise('clientac')) {
		var clientID = date.getTime() + parseInt(Math.random(10, 1) * 100);
		pushValue('clientID', clientID + 'clientID');
		saveToCookise('clientac', clientID, '5');
	} else {
		pushValue('clientID', getFromCookise('clientac') + 'clientID');
	}
	
	// 澶勭悊loginID
	if (getFromCookise("cookie_user")) {
		pushValue('loginID', getFromCookise("cookie_user") + 'loginID');
	} else {
		pushValue('loginID', '' + 'loginID');
	}
	
	// 澶勭悊usertype
	if (getFromCookise("cookie_usertype")) {
		pushValue('usertype', getFromCookise("cookie_usertype") + 'usertype');
	} else {
		pushValue('usertype', '' + 'usertype');
	}

	// 璁拌浇璁块棶url鍜屾椂闂�
	var acl = encodeURI(document.location.href.replace(/#/g, "~"));
	saveToCookise('cl_lastUrl', acl, '5');
	saveToCookise('cl_lastUrl_time', new Date().getTime(), '5');

	pushValue('AcT', acl + 'AcT');
	
	// 娣诲姞鏃ュ織绫诲瀷鍙傛暟
	// 姝ゆ暟鎹互鍚庣敤鏉ユ爣璇嗕笟鍔＄被鍨嬶紙瑙佷笅闈級
	// pushValue('clickType', '0' + 'clickType');
	
	// 娣诲姞xpoint
	pushValue('xPoint', xpoint + 'xPoint');
	
	// 娣诲姞ypoint
	pushValue('yPoint', ypoint + 'yPoint');
	
	// 娣诲姞domid
	pushValue('domID', domid + 'domID');
	
	// 娣诲姞clicken
	pushValue('clickEN', clicken + 'clickEN');

	// 娣诲姞clickType
	pushValue('clickType', clickType + 'clickType');

	// 娣诲姞random鍙傛暟锛屼娇璇锋眰鐪嬭捣鏉ヤ笉鍚�
	pushValue('randomNUM', Math.random(10, 1)*100 + 'randomNUM');
	
	if (!getFromCookise('visit_dt')) {
		// 鐢ㄦ埛璁块棶缃戠珯鐨勬棩鏈熶负绌� 璇存槑涔嬪墠娌℃湁瀛樿繃杩欎釜cookie 閭ｄ箞杩欐槸涓€涓柊璁垮
		// 璁＄畻鐢ㄦ埛璁块棶鐨勬棩鏈� 浠ュぉ涓哄崟浣�
		var vd_day = new Date();
		var vd_year = vd_day.getFullYear();
		var vd_month = vd_day.getMonth();
		var vd_dt = vd_year + '-' + vd_month + '-' + vd_day;
		// 鎶妚d_dt鐨勫€� 鍔犲叆cookie
		saveToCookise('visit_dt', vd_dt, '5');
		pushValue('isNew_User', 'trueisNew_User');
	} else {
		// 宸茬粡璁板綍浜嗚闂綉绔欑殑鏃ユ湡 閭ｄ箞闇€瑕佹瘮杈冧竴涓嬪綋鍓嶆棩鏈熷拰杩欎釜鏃ユ湡 濡傛灉涓嶆槸鍚屼竴澶� 璇存槑鏄€佽瀹� 濡傛灉鏄竴澶� 璇存槑鏄柊璁垮
		var vd_day = new Date();
		var vd_year = vd_day.getFullYear();
		var vd_month = vd_day.getMonth();
		var vd_dt = vd_year + '-' + vd_month + '-' + vd_day;
		if (getFromCookise('visit_dt') == vd_dt) {
			// 鍚屼竴澶� 璇存槑鏄柊璁垮
			pushValue('isNew_User', 'trueisNew_User');
		} else {
			// 涓嶆槸鍚屼竴澶� 璇存槑鏄€佽瀹�
			pushValue('isNew_User', 'falseisNew_User');
		}
	}
	im.src = "http:\/\/stat-y.xywy.com\/cl.png?" + s.join('&');
}







//鎸夐挳浼犻€抜dfunction
function buttonClick(item,firstId,secondId) {
	var ref_click = document.referrer;
	var xpoint = item.offsetLeft;
	var ypoint = item.offsetTop;
	var domid = item.id;
	var clicken = item.attributes["clicken"].nodeValue+"_"+firstId+"_"+secondId;
	var clickType = item.attributes["clickType"].nodeValue;
	var ue = unescape;
	
	var date = new Date();
	var s = [];
	var im = new Image;
	
	function pushValue(name, value) {
		s.push(name + '=' + value);
	}
	
	function saveToCookise(name, value, days) {
		date.setTime(date.getTime() + (days * 24 * 3600 * 1000 * 365));
		document.cookie = name + "=" + escape(value) + ((days == null) ? "" : "; expires=" + date.toGMTString()) + "; domain=.xywy.com ;path=/";
	}
	
	function getFromCookise(name) {
		if (document.cookie.length > 0) {
			var begin = document.cookie.indexOf(name + "=");
			if (begin != -1) {
				begin += name.length + 1;
				var end = document.cookie.indexOf(";", begin);
				if (end == -1)
					end = document.cookie.length;
				return ue(document.cookie.substring(begin, end));
			}
		}
		return null;
	}
	
	// 澶勭悊ref
	if (ref_click) {
		pushValue('ref', ref_click + 'ref');
	}
	
	// 澶勭悊clientID
	if (!getFromCookise('clientac')) {
		var clientID = date.getTime() + parseInt(Math.random(10, 1) * 100);
		pushValue('clientID', clientID + 'clientID');
		saveToCookise('clientac', clientID, '5');
	} else {
		pushValue('clientID', getFromCookise('clientac') + 'clientID');
	}
	
	// 澶勭悊loginID
	if (getFromCookise("cookie_user")) {
		pushValue('loginID', getFromCookise("cookie_user") + 'loginID');
	} else {
		pushValue('loginID', '' + 'loginID');
	}
	
	// 澶勭悊usertype
	if (getFromCookise("cookie_usertype")) {
		pushValue('usertype', getFromCookise("cookie_usertype") + 'usertype');
	} else {
		pushValue('usertype', '' + 'usertype');
	}

	// 澶勭悊鎭舵剰鍒锋柊 瀵艰嚧pv缁熻涓嶅噯鐨勯棶棰� 鏍规嵁cookie涓偍瀛樼殑涓婁竴涓姹傚拰璇锋眰鏃堕棿 鍒ゆ柇鏄惁闇€瑕佸彂鍑篶l.png璇锋眰
	var canSendCLpng = true;
	var acl = encodeURI(document.location.href);
	if (getFromCookise("cl_lastUrl")) {
		if (acl == getFromCookise("cl_lastUrl")) {
			if (getFromCookise("cl_lastUrl_time")) {
				var offset = parseInt(date.getTime()) - parseInt(getFromCookise("cl_lastUrl_time"));
				if (parseInt(offset) < 2000) {
					canSendCLpng = false;
				}
			}
		} else {

		}
	} else {

	}
	// 璁拌浇璁块棶url鍜屾椂闂�
	saveToCookise('cl_lastUrl', acl, '5');
	saveToCookise('cl_lastUrl_time', new Date().getTime(), '5');

	pushValue('AcT', acl + 'AcT');
	
	// 娣诲姞鏃ュ織绫诲瀷鍙傛暟
	// 姝ゆ暟鎹互鍚庣敤鏉ユ爣璇嗕笟鍔＄被鍨嬶紙瑙佷笅闈級
	// pushValue('clickType', '0' + 'clickType');
	
	// 娣诲姞xpoint
	pushValue('xPoint', xpoint + 'xPoint');
	
	// 娣诲姞ypoint
	pushValue('yPoint', ypoint + 'yPoint');
	
	// 娣诲姞domid
	pushValue('domID', domid + 'domID');
	
	// 娣诲姞clicken
	pushValue('clickEN', clicken + 'clickEN');

	// 娣诲姞clickType
	pushValue('clickType', clickType + 'clickType');

	// 娣诲姞random鍙傛暟锛屼娇璇锋眰鐪嬭捣鏉ヤ笉鍚�
	pushValue('randomNUM', Math.random(10, 1)*100 + 'randomNUM');
	
	if (canSendCLpng) {
		if (!getFromCookise('visit_dt')) {
			// 鐢ㄦ埛璁块棶缃戠珯鐨勬棩鏈熶负绌� 璇存槑涔嬪墠娌℃湁瀛樿繃杩欎釜cookie 閭ｄ箞杩欐槸涓€涓柊璁垮
			// 璁＄畻鐢ㄦ埛璁块棶鐨勬棩鏈� 浠ュぉ涓哄崟浣�
			var vd_day = new Date();
			var vd_year = vd_day.getFullYear();
			var vd_month = vd_day.getMonth();
			var vd_dt = vd_year + '-' + vd_month + '-' + vd_day;
			// 鎶妚d_dt鐨勫€� 鍔犲叆cookie
			saveToCookise('visit_dt', vd_dt, '5');
			pushValue('isNew_User', 'trueisNew_User');
		} else {
			// 宸茬粡璁板綍浜嗚闂綉绔欑殑鏃ユ湡 閭ｄ箞闇€瑕佹瘮杈冧竴涓嬪綋鍓嶆棩鏈熷拰杩欎釜鏃ユ湡 濡傛灉涓嶆槸鍚屼竴澶� 璇存槑鏄€佽瀹� 濡傛灉鏄竴澶� 璇存槑鏄柊璁垮
			var vd_day = new Date();
			var vd_year = vd_day.getFullYear();
			var vd_month = vd_day.getMonth();
			var vd_dt = vd_year + '-' + vd_month + '-' + vd_day;
			if (getFromCookise('visit_dt') == vd_dt) {
				// 鍚屼竴澶� 璇存槑鏄柊璁垮
				pushValue('isNew_User', 'trueisNew_User');
			} else {
				// 涓嶆槸鍚屼竴澶� 璇存槑鏄€佽瀹�
				pushValue('isNew_User', 'falseisNew_User');
			}
		}
		im.src = "http:\/\/stat-y.xywy.com\/cl.png?" + s.join('&');
	}
}
