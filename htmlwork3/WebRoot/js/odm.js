function __getWord(redomain, ref) {
	var _keyword = "";
	var _elements = [];
	_elements.push([ '.baidu.', 'word' ]);
	_elements.push([ '.baidu.', 'wd' ]);
	_elements.push([ '.so.', 'q' ]);
	_elements.push([ '.haosou.', 'q' ]);
	_elements.push([ '.soso.', 'query' ]);
	_elements.push([ '.sogou.', 'query' ]);
	_elements.push([ '.sm.', 'q' ]);
	_elements.push([ '.easou.', 'q' ]);
	_elements.push([ '.chinaso.', 'q' ]);
	_elements.push([ '.google.', 'q' ]);
	_elements.push([ '.bing.', 'q' ]);
	_elements.push([ '.youdao.', 'q' ]);
	_elements.push([ '.yahoo.', 'p' ]);
	_elements.push([ '.xywy.', 'keyword' ]);
	_elements.push([ '.xywy.', 'q' ]);
	_elements.push([ '.xywy.', 'title' ]);
	ref += "&";
	try {
		for ( var element in _elements) {
			var array = _elements[element];
			if (redomain.indexOf(array[0]) != -1) {
				var reg = new RegExp("[&\?]" + array[1] + "=.*?&", "i");
				var str = ref.match(reg);
				if (str) {
					_keyword = str.toString().split("=")[1].split("&")[0];
				}
				if (_keyword != "") {
					break;
				}
			}
		}
		if (_keyword == "") {
			if (redomain.indexOf("3g.xywy.com") != -1) {
				var reg = new RegExp("title_.*?&", "i");
				var str = ref.match(reg);
				if (str) {
					_keyword = str.toString().split("_")[1].split("&")[0];
				}
			}
		}
	} catch (e) {
		_keyword = ""
	}
	return _keyword;
}

function __getFlashVersion() {
	var flashVersion = "";
	if (navigator.plugins && navigator.plugins.length) {
		for (var i = 0; i < navigator.plugins.length; i++) {
			// 鏌ヨ鍒板惈鏈塖hockwave
			if (navigator.plugins[i].name.indexOf('Shockwave Flash') != -1) {
				// 杩斿洖flash鐗堟湰
				flashVersion = navigator.plugins[i].description
						.split('Shockwave Flash ')[1];
				break;
			}
		}
	} else if (window.ActiveXObject) {
		for (var i = 10; i >= 2; i--) {
			try {
				var flash = eval_r("new ActiveXObject('ShockwaveFlash.ShockwaveFlash."
						+ i + "');");
				if (flash) {
					flashVersion = i + '.0';
					break;
				}
			} catch (e) {
			}
		}
	}
	return flashVersion;
}

function __ctryTopDomain(str) {
	var pattern = "/^aero$|^cat$|^coop$|^int$|^museum$|^pro$|^travel$|^xxx$|^com$|^net$|^gov$|^org$|^mil$|^edu$|^biz$|^info$|^name$|^ac$|^mil$|^co$|^ed$|^gv$|^nt$|^bj$|^hz$|^sh$|^tj$|^cq$|^he$|^nm$|^ln$|^jl$|^hl$|^js$|^zj$|^ah$|^hb$|^hn$|^gd$|^gx$|^hi$|^sc$|^gz$|^yn$|^xz$|^sn$|^gs$|^qh$|^nx$|^xj$|^tw$|^hk$|^mo$|^fj$|^ha$|^jx$|^sd$|^sx$/i";
	if (str.match(pattern)) {
		return 1;
	}
	return 0;
}

function __ctryDomain(str) {
	var pattern = "/^ac$|^ad$|^ae$|^af$|^ag$|^ai$|^al$|^am$|^an$|^ao$|^aq$|^ar$|^as$|^at$|^au$|^aw$|^az$|^ba$|^bb$|^bd$|^be$|^bf$|^bg$|^bh$|^bi$|^bj$|^bm$|^bo$|^br$|^bs$|^bt$|^bv$|^bw$|^by$|^bz$|^ca$|^cc$|^cd$|^cf$|^cg$|^ch$|^ci$|^ck$|^cl$|^cm$|^cn$|^co$|^cr$|^cs$|^cu$|^cv$|^cx$|^cy$|^cz$|^de$|^dj$|^dk$|^dm$|^do$|^dz$|^ec$|^ee$|^eg$|^eh$|^er$|^es$|^et$|^eu$|^fi$|^fj$|^fk$|^fm$|^fo$|^fr$|^ly$|^hk$|^hm$|^hn$|^hr$|^ht$|^hu$|^id$|^ie$|^il$|^im$|^in$|^io$|^ir$|^is$|^it$|^je$|^jm$|^jo$|^jp$|^ke$|^kg$|^kh$|^ki$|^km$|^kn$|^kp$|^kr$|^kw$|^ky$|^kz$|^la$|^lb$|^lc$|^li$|^lk$|^lr$|^ls$|^lt$|^lu$|^lv$|^ly$|^ga$|^gb$|^gd$|^ge$|^gf$|^gg$|^gh$|^gi$|^gl$|^gm$|^gn$|^gp$|^gq$|^gr$|^gs$|^gt$|^gu$|^gw$|^gy$|^ma$|^mc$|^md$|^mg$|^mh$|^mk$|^ml$|^mm$|^mn$|^mo$|^mp$|^mq$|^mr$|^ms$|^mt$|^mu$|^mv$|^mw$|^mx$|^my$|^mz$|^na$|^nc$|^ne$|^nf$|^ng$|^ni$|^nl$|^no$|^np$|^nr$|^nu$|^nz$|^om$|^re$|^ro$|^ru$|^rw$|^pa$|^pe$|^pf$|^pg$|^ph$|^pk$|^pl$|^pm$|^pr$|^ps$|^pt$|^pw$|^py$|^qa$|^wf$|^ws$|^sa$|^sb$|^sc$|^sd$|^se$|^sg$|^sh$|^si$|^sj$|^sk$|^sl$|^sm$|^sn$|^so$|^sr$|^st$|^su$|^sv$|^sy$|^sz$|^tc$|^td$|^tf$|^th$|^tg$|^tj$|^tk$|^tm$|^tn$|^to$|^tp$|^tr$|^tt$|^tv$|^tw$|^tz$|^ua$|^ug$|^uk$|^um$|^us$|^uy$|^uz$|^va$|^vc$|^ve$|^vg$|^vi$|^vn$|^vu$|^ye$|^yt$|^yu$|^za$|^zm$|^zr$|^zw$/i";
	if (str.match(pattern)) {
		return 1;
	}
	return 0;
}

function __getDomain(host) {
	// 鍘绘帀鍩熷悕鍓嶇殑www.
	var _domain = host.replace(/^www\./, "");
	// 鍘绘帀鍩熷悕鍓嶇殑3g.
	_domain = host.replace(/^3g\./, "");
	// 鍘绘帀鍩熷悕鍓嶇殑wap.
	_domain = host.replace(/^wap\./, "");
	// 鍘绘帀鍩熷悕鍓嶇殑m.
	_domain = host.replace(/^m\./, "");
	// 灏哶domain浠�.鍒嗛殧鎴愬涓瓧绗︿覆
	var _domainArray = _domain.split(".");
	// 鍒嗛殧鐨勫瓧绗︿覆涓暟(宸插幓鎺夊墠缂€)
	var _length = _domainArray.length;
	// 濡傛灉鍩熷悕鍒嗘垚浜�3娈碉紙濡俠aidu.com.cn锛�
	if (_length == 3) {
		if (__ctryTopDomain(_domainArray[1]) == 1
				&& __ctryDomain(_domainArray[2]) == 1) {
			// 濡傛灉鍦ㄤ笂闈㈠煙鍚嶅悗缂€鍜屽浗瀹跺悗缂€涓壘鍒颁簡鍖归厤鐨勫€硷紝浠€涔堥兘涓嶅仛
		} else {
			// if涓嶆垚绔嬶紙涓や釜鏉′欢涓嶈兘鍚屾椂婊¤冻锛夛紝_domain鐨勫€间负鍚庝袱娈电殑鍊硷紙濡倆hidao.baidu.com锛屽垯_domain涓篵aidu.com锛�
			_domain = _domainArray[1] + "." + _domainArray[2];
		}
	} else if (_length >= 3) {
		var _ipRes = "^[0-9]*\.[0-9]*\.[0-9]*\.[0-9]*$";
		// 濡傛灉鍖归厤鍒癷p妯″紡锛岀洿鎺ヨ繑鍥瀒p鑰岄潪鍩熷悕
		if (host.match(_ipRes)) {
			return _domain;
		}
		if (__ctryTopDomain(_domainArray[_length - 2]) == 1
				&& __ctryDomain(_domainArray[_length - 1]) == 1) {// 瀵逛簬浜岀骇鍙婁簩绾т互涓婄殑鍩熷悕妫€鏌ユ渶鍚庝袱涓覆鏄惁鍦ㄥ煙鍚嶅悗缂€鍙婂浗瀹跺悗缂€鍒楄〃涓�
			_domain = _domainArray[_length - 3] + "."
					+ _domainArray[_length - 2] + "."
					+ _domainArray[_length - 1];// 鎻愬彇鍏朵竴绾у煙鍚�
		} else {
			_domain = _domainArray[_length - 2] + "."
					+ _domainArray[_length - 1];// 鎻愬彇涓€绾у煙鍚�
		}
	}
	return _domain;
}

function __getCookie(key) {
	var _cookie = document.cookie;
	if (_cookie.length > 0) {
		var _key = key + "=";
		var _begin = _cookie.indexOf(_key);
		if (_begin < 0) {
			return "";
		}
		_begin += _key.length;
		var _end = _cookie.indexOf(";", _begin);
		if (_end < 0) {
			return unescape(_cookie.substring(_begin));
		} else {
			return unescape(_cookie.substring(_begin, _end));
		}
	}
	return "";
}

function __setCookie(key, val, cotp) {
	var _date = new Date();
	var _year = _date.getFullYear();
	var _day = _date.getDate();
	var _cookie = "";
	if (cotp == 0) {
		_cookie = key + "=" + escape(val) + ";";
	} else if (cotp == 1) {
		_day = _day + 1;
		_date.setDate(_day);
		_date.setHours(0);
		_date.setMinutes(0);
		_date.setSeconds(0);
		_cookie = key + "=" + escape(val) + ";expires=" + _date.toGMTString()
				+ ";";
	} else if (cotp == 2) {
		_year = _year + 10;
		_date.setYear(_year);
		_cookie = key + "=" + escape(val) + ";expires=" + _date.toGMTString()
				+ ";";
	}
	var _domain = __getDomain(document.domain);
	if (_domain != "") {
		_cookie += "domain=." + _domain + ";";
	}
	_cookie += "path=" + "/;";
	document.cookie = _cookie;
}

function __getCookieTime(time, cotp) {
	var _date = new Date(time);
	var _year = _date.getFullYear();
	var _day = _date.getDate();
	if (cotp == 1) {
		_day = _day + 1;
		_date.setDate(_day);
		_date.setHours(0);
		_date.setMinutes(0);
		_date.setSeconds(0);
	} else if (cotp == 2) {
		_year = _year + 10;
		_date.setYear(_year);
	}
	return parseInt(_date.getTime() / 1000);
}

function __formatDate(timeInt) {
	var _date = new Date(timeInt * 1000);
	var _year = _date.getFullYear();
	var _month = _date.getMonth() + 1;
	var _day = _date.getDate();
	var _hour = _date.getHours();
	var _minute = _date.getMinutes();
	var _second = _date.getSeconds();
	return _year + "-" + _month + "-" + _day + " " + _hour + ":" + _minute + ":" + _second;
}

function __sendVisitOdm(unitId, params) {
	var requestColumn = [];
	var cookieColumnYear = [];
	var createCookieYear = "";
	var endCookieYear = "";
	var date = new Date();
	var dataYearStr = __getCookie("XYWYDATA" + unitId);
	// 璁惧畾浜у搧id涓轰紶杩涙潵鐨勫€�
	// 璁惧畾璁块棶绫诲瀷涓簐isit
	requestColumn.push('UnitId=' + unitId);
	requestColumn.push('VisitType=visit');

	// 鑾峰彇鍙楄鍦板潃鐩稿叧
	var url = document.location.href;
	var domain = document.domain;
	var cookieDomain = __getDomain(domain);
	requestColumn.push('Url=' + encodeURIComponent(url));
	requestColumn.push('Domain=' + domain);
	requestColumn.push('CookieDomain=.' + cookieDomain);

	// 鑾峰彇璁块棶鏉ユ簮鐩稿叧
	var ref = document.referrer;
	var redomain = "";
	if (ref) {
		var redomains = ref.match(/http[s]?:\/\/(.*?)([:\/]|$)/i);
		redomain = redomains[1];
	}
	requestColumn.push('Ref=' + encodeURIComponent(ref));
	requestColumn.push('Redomain=' + redomain);

//	// 鑾峰彇clientid鐩稿叧
//	var clientId = "";
//	var clientVisitNumber = 1;
//	var newClient = "true";
//	var firstVisitTime = "";
//	if (dataYearStr == "") {
//		var rand1 = parseInt(Math.random() * 1250);
//		var rand2 = parseInt(Math.random() * 2500);
//		var rand3 = parseInt(Math.random() * 3750);
//		var rand4 = parseInt(Math.random() * 5000);
//		clientId = String(rand1) + String(rand2) + String(rand3) + String(rand4);
//		createCookieYear = parseInt(date.getTime() / 1000);
//		endCookieYear = __getCookieTime(date.getTime(), 2);
//	} else {
//		var dataArray = dataYearStr.split("@");
//		createCookieYear = dataArray[0].split("-")[0];
//		endCookieYear = __getCookieTime(date.getTime(), 2);
//		clientId = dataArray[1];
//		clientVisitNumber = parseInt(dataArray[2]) + 1;
//		if (parseInt(date.getTime() / 1000) > __getCookieTime(createCookieYear * 1000, 1)) {
//			newClient = "false";
//		}
//	}
//	firstVisitTime = __formatDate(createCookieYear);
//	requestColumn.push('NewClient=' + newClient);
//	requestColumn.push('FirstVisitTime=' + encodeURIComponent(firstVisitTime));
//	requestColumn.push('ClientId=' + clientId);
//	requestColumn.push('ClientVisitNumber=' + clientVisitNumber);
//	cookieColumnYear.push(String(createCookieYear) + "-" + String(endCookieYear));
//	cookieColumnYear.push(clientId);
//	cookieColumnYear.push(clientVisitNumber);
	
	var clientId = "";
	var clientVisitNumber = -1;
	var newClient = "none";
	var firstVisitTime = "none";
	if (__getCookie('clientac')!="") {
		clientId = __getCookie('clientac');
	}
	requestColumn.push('NewClient=' + newClient);
	requestColumn.push('FirstVisitTime=' + encodeURIComponent(firstVisitTime));
	requestColumn.push('ClientId=' + clientId);
	requestColumn.push('ClientVisitNumber=' + clientVisitNumber);

	// 鑾峰彇娴忚鍣ㄧ浉鍏�
	var browser = "unknow";
	var browserVersion = "unknow";
	var userAgent = window.navigator.userAgent;
	var browserArray = "netscape;se 1.;se 2.;saayaa;360se;tencent;qqbrowser;mqqbrowser;maxthon;myie;theworld;konqueror;firefox;chrome;safari;msie 5.0;msie 5.5;msie 6.0;msie 7.0;msie 8.0;msie 9.0;msie 10.0;mozilla;opera".split(";");
	userAgent = userAgent ? userAgent.toLowerCase().replace(/-/g, "") : "";
	for (i = 0; i < browserArray.length; i++) {
		if (userAgent.indexOf(browserArray[i]) != -1) {
			browser = browserArray[i];
			break;
		}
	}
	if (browser == "mozilla") {
		if (!!window.ActiveXObject || "ActiveXObject" in window) {
			browser = "msie";
		}
	}
	if (browser != "unknow") {
		if (browserVersion == "unknow") {
			if (userAgent.match(/rv:\d+(\.\d+)+/i) != null) {
				browserVersion = userAgent.match(/rv:\d+(\.\d+)+/i)[0].match(/\d+(\.\d+)+/i)[0];
			}
		}
		if (browserVersion == "unknow") {
			if (userAgent.match(new RegExp(browser + "\\/\\d+(\\.\\d+)*", "i")) != null) {
				browserVersion = userAgent.match(new RegExp(browser + "\\/\\d+(\\.\\d+)*", "i"))[0].match(/\d+\.\d+/i)[0];
			}
		}
	}
	if (browser == "msie") {
		browser = browser + " " + browserVersion;
	}
	requestColumn.push('Browser=' + encodeURIComponent(browser));
	requestColumn.push('BrowserVersion=' + encodeURIComponent(browserVersion));
	requestColumn.push('UserAgent=' + encodeURIComponent(userAgent));

	// 澶勭悊澶у皬绉戝鐩稿叧
	var pid = 0;
	var sid = 0;
	if (typeof (subject_pid) == 'number') {
		pid = subject_pid;
	} else {
		if (typeof (subject_pid) != 'undefined') {
			subject_pid = Number(subject_pid);
			if (subject_pid >= 0) {
				pid = subject_pid;
			}
		}
	}
	if (typeof (subject) == 'number') {
		sid = subject;
	} else {
		if (typeof (subject) != 'undefined') {
			subject = Number(subject);
			if (subject >= 0) {
				sid = subject;
			}
		}
	}
	requestColumn.push('Pid=' + pid);
	requestColumn.push('Sid=' + sid);

	// 澶勭悊鐧婚檰鐢ㄦ埛鐩稿叧
	var loginId = "";
	var userType = "";
	if (__getCookie("cookie_user") != "") {
		loginId = __getCookie("cookie_user");
	}
	if (__getCookie("cookie_usertype") != "") {
		userType = __getCookie("cookie_usertype");
	}
	requestColumn.push('LoginId=' + loginId);
	requestColumn.push('UserType=' + userType);

	// 澧炲姞浼犲叆鍙傛暟
	requestColumn.push('Params=' + encodeURIComponent(params));

	// 澶勭悊鍚勪釜缃戠珯鏉ョ殑鎼滅储鍏抽敭璇�
	var word = __getWord(redomain, ref);
	requestColumn.push('KeyWord=' + word);

	// 鑾峰彇鍚勭鏉傞」
	var title = document.title;
	var screen = window.screen.width + "x" + window.screen.height;
	var charset = document.charset;
	if (typeof (charset) == 'undefined') {
		charset = document.characterSet;
	}
	var color = window.screen.colorDepth + "-bit";
	var language = (navigator.language || navigator.browserLanguage)
			.toLowerCase();
	var jvmEnabled = navigator.javaEnabled() ? "true" : "false";
	var cookieEnabled = navigator.cookieEnabled ? "true" : "false";
	var flashVersion = __getFlashVersion();
	var appName = navigator.appName;
	requestColumn.push('Title=' + title);
	requestColumn.push('Screen=' + screen);
	requestColumn.push('Charset=' + encodeURIComponent(charset));
	requestColumn.push('Color=' + encodeURIComponent(color));
	requestColumn.push('Language=' + encodeURIComponent(language));
	requestColumn.push('JvmEnabled=' + jvmEnabled);
	requestColumn.push('CookieEnabled=' + cookieEnabled);
	requestColumn.push('FlashVersion=' + encodeURIComponent(flashVersion));
	requestColumn.push('AppName=' + encodeURIComponent(appName));

	// 澧炲姞闅忔満鍙傛暟
	requestColumn.push('RandomNum=' + Math.random());

//	__setCookie("XYWYDATA" + unitId, cookieColumnYear.join("@"), 2);

	var img = new Image;
	img.src = "http:\/\/stat-y.xywy.com\/odm.png?" + requestColumn.join('&');
}






function __sendClickOdm(unitId, item, params) {
	var requestColumn = [];
	var cookieColumnYear = [];
	var createCookieYear = "";
	var endCookieYear = "";
	var date = new Date();
	var dataYearStr = __getCookie("XYWYDATA" + unitId);
	var isIE = document.all ? true : false;
	var xPoint = item.offsetLeft;
	var yPoint = item.offsetTop;
	var height = item.offsetHeight;
	var width = item.offsetWidth;
	var itemId = item.id;
	var parent = item.parentNode;
	var message = "";
	var href = "";
	try{ 
		if(isIE)
		{ 
			href = item.getAttribute("href");
		}else{
			href = item.attributes["href"].nodeValue;
		} 
	} 
	catch(e){ 
	} 
	try{ 
		if(isIE)
		{ 
			message = parent.getAttribute("message");
		}else{
			message = parent.attributes["message"].nodeValue;
		} 
	} 
	catch(e){ 
	} 
	
	// 璁惧畾浜у搧id涓轰紶杩涙潵鐨勫€�
	// 璁惧畾璁块棶绫诲瀷涓簐isit
	requestColumn.push('UnitId=' + unitId);
	requestColumn.push('VisitType=click');
	
	// 鑾峰彇鍙楄鍦板潃鐩稿叧
	var url = document.location.href;
	var domain = document.domain;
	var cookieDomain = __getDomain(domain);
	requestColumn.push('Url=' + encodeURIComponent(url));
	requestColumn.push('Domain=' + domain);
	requestColumn.push('CookieDomain=.' + cookieDomain);

	// 鑾峰彇璁块棶鏉ユ簮鐩稿叧
	var ref = document.referrer;
	var redomain = "";
	if (ref) {
		var redomains = ref.match(/http[s]?:\/\/(.*?)([:\/]|$)/i);
		redomain = redomains[1];
	}
	requestColumn.push('Ref=' + encodeURIComponent(ref));
	requestColumn.push('Redomain=' + redomain);
	
//	// 鑾峰彇clientid鐩稿叧
//	var clientId = "";
//	var clientVisitNumber = 1;
//	var newClient = "true";
//	var firstVisitTime = "";
//	if (dataYearStr == "") {
//		var rand1 = parseInt(Math.random() * 1250);
//		var rand2 = parseInt(Math.random() * 2500);
//		var rand3 = parseInt(Math.random() * 3750);
//		var rand4 = parseInt(Math.random() * 5000);
//		clientId = String(rand1) + String(rand2) + String(rand3) + String(rand4);
//		createCookieYear = parseInt(date.getTime() / 1000);
//		endCookieYear = __getCookieTime(date.getTime(), 2);
//	} else {
//		var dataArray = dataYearStr.split("@");
//		createCookieYear = dataArray[0].split("-")[0];
//		endCookieYear = __getCookieTime(date.getTime(), 2);
//		clientId = dataArray[1];
//		clientVisitNumber = parseInt(dataArray[2]) + 1;
//		if (parseInt(date.getTime() / 1000) > __getCookieTime(createCookieYear * 1000, 1)) {
//			newClient = "false";
//		}
//	}
//	firstVisitTime = __formatDate(createCookieYear);
//	requestColumn.push('NewClient=' + newClient);
//	requestColumn.push('FirstVisitTime=' + encodeURIComponent(firstVisitTime));
//	requestColumn.push('ClientId=' + clientId);
//	requestColumn.push('ClientVisitNumber=' + clientVisitNumber);
//	cookieColumnYear.push(String(createCookieYear) + "-" + String(endCookieYear));
//	cookieColumnYear.push(clientId);
//	cookieColumnYear.push(clientVisitNumber);
	
	var clientId = "";
	var clientVisitNumber = -1;
	var newClient = "none";
	var firstVisitTime = "none";
	if (__getCookie('clientac')!="") {
		clientId = __getCookie('clientac');
	}
	requestColumn.push('NewClient=' + newClient);
	requestColumn.push('FirstVisitTime=' + encodeURIComponent(firstVisitTime));
	requestColumn.push('ClientId=' + clientId);
	requestColumn.push('ClientVisitNumber=' + clientVisitNumber);
	
	// 鑾峰彇娴忚鍣ㄧ浉鍏�
	var browser = "unknow";
	var browserVersion = "unknow";
	var userAgent = window.navigator.userAgent;
	var browserArray = "netscape;se 1.;se 2.;saayaa;360se;tencent;qqbrowser;mqqbrowser;maxthon;myie;theworld;konqueror;firefox;chrome;safari;msie 5.0;msie 5.5;msie 6.0;msie 7.0;msie 8.0;msie 9.0;msie 10.0;mozilla;opera".split(";");
	userAgent = userAgent ? userAgent.toLowerCase().replace(/-/g, "") : "";
	for (i = 0; i < browserArray.length; i++) {
		if (userAgent.indexOf(browserArray[i]) != -1) {
			browser = browserArray[i];
			break;
		}
	}
	if (browser == "mozilla") {
		if (!!window.ActiveXObject || "ActiveXObject" in window) {
			browser = "msie";
		}
	}
	if (browser != "unknow") {
		if (browserVersion == "unknow") {
			if (userAgent.match(/rv:\d+(\.\d+)+/i) != null) {
				browserVersion = userAgent.match(/rv:\d+(\.\d+)+/i)[0].match(/\d+(\.\d+)+/i)[0];
			}
		}
		if (browserVersion == "unknow") {
			if (userAgent.match(new RegExp(browser + "\\/\\d+(\\.\\d+)*", "i")) != null) {
				browserVersion = userAgent.match(new RegExp(browser + "\\/\\d+(\\.\\d+)*", "i"))[0].match(/\d+\.\d+/i)[0];
			}
		}
	}
	if (browser == "msie") {
		browser = browser + " " + browserVersion;
	}
	requestColumn.push('Browser=' + encodeURIComponent(browser));
	requestColumn.push('BrowserVersion=' + encodeURIComponent(browserVersion));
	requestColumn.push('UserAgent=' + encodeURIComponent(userAgent));
	
	// 澶勭悊鐧婚檰鐢ㄦ埛鐩稿叧
	var loginId = "";
	var userType = "";
	if (__getCookie("cookie_user") != "") {
		loginId = __getCookie("cookie_user");
	}
	if (__getCookie("cookie_usertype") != "") {
		userType = __getCookie("cookie_usertype");
	}
	requestColumn.push('LoginId=' + loginId);
	requestColumn.push('UserType=' + userType);
	
	// 澧炲姞浼犲叆鍙傛暟
	if(params.indexOf(":") == -1){
		params = message + ':' + params;
	}
	requestColumn.push('Params=' + encodeURIComponent(params));

	// 澶勭悊鍚勪釜缃戠珯鏉ョ殑鎼滅储鍏抽敭璇�
	var word = __getWord(domain, url);
	requestColumn.push('KeyWord=' + word);
	
	// 娣诲姞xPoint
	requestColumn.push('XPoint=' + xPoint);
	// 娣诲姞yPoint
	requestColumn.push('YPoint=' + yPoint);
	// 娣诲姞height
	requestColumn.push('Height=' + height);
	// 娣诲姞width
	requestColumn.push('Width=' + width);
	// 娣诲姞itemId
	requestColumn.push('ItemId=' + itemId);
	// 娣诲姞href
	requestColumn.push('Href=' + href);
	
	// 鑾峰彇鍚勭鏉傞」
	var title = document.title;
	var screen = window.screen.width + "x" + window.screen.height;
	var charset = document.charset;
	if (typeof (charset) == 'undefined') {
		charset = document.characterSet;
	}
	var color = window.screen.colorDepth + "-bit";
	var language = (navigator.language || navigator.browserLanguage).toLowerCase();
	var jvmEnabled = navigator.javaEnabled() ? "true" : "false";
	var cookieEnabled = navigator.cookieEnabled ? "true" : "false";
	var flashVersion = __getFlashVersion();
	var appName = navigator.appName;
	requestColumn.push('Title=' + title);
	requestColumn.push('Screen=' + screen);
	requestColumn.push('Charset=' + encodeURIComponent(charset));
	requestColumn.push('Color=' + encodeURIComponent(color));
	requestColumn.push('Language=' + encodeURIComponent(language));
	requestColumn.push('JvmEnabled=' + jvmEnabled);
	requestColumn.push('CookieEnabled=' + cookieEnabled);
	requestColumn.push('FlashVersion=' + encodeURIComponent(flashVersion));
	requestColumn.push('AppName=' + encodeURIComponent(appName));

	// 澧炲姞闅忔満鍙傛暟
	requestColumn.push('RandomNum=' + Math.random());
	
	var img = new Image;
	img.src = "http:\/\/stat-y.xywy.com\/odm.png?" + requestColumn.join('&');
}
