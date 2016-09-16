function recordVisitLink(link, action, category, position) {
	try {
		new Image().src="http://stat-y.xywy.com/club_click.png?k=" + category + "&p=" + position + "&num=" + Math.random();
		//im = new Image;
		//im.src = "http://g.xywy.com/v?a=" + action + "&k=" + category + "&p=" + position;
		if (link.target == '_blank')
			setTimeout("window.open('" + link.href + "')", 100);
		else
			setTimeout('document.location = "' + link.href + '"', 100);
	} catch (err) {
	}
}
function recordVisitLinks(link, action, category, position) {
	try {
		new Image().src="http://stat-y.xywy.com/club_click.png?k=" + category + "&p=" + position + "&num=" + Math.random();
		//im = new Image;
		//im.src = "http://g.xywy.com/v?a=" + action + "&k=" + category + "&p=" + position + "&num=" + Math.random();
	} catch (err) {
	}
}
document.writeln("<div id=\"stat-z\" style=\"display: none;\">");
//im_pv = new Image,
(function() {
	var td = new Date(), im = new Image, mk = Math, e = escape, ue = unescape, pa = parseInt, metas = document
			.getElementsByTagName("meta"), meta_descript = '', en = encodeURIComponent, de = decodeURIComponent, d = document, s = [], 
			pu = "push", su = "substring", gt = "getTime", st = "setTime", tg = "toGMTString", mr = "round", rm = "random", dr = "referrer", 
			i = "indexOf", c = "cookie", l = "length", j = "join", pu = "push", mt = "match", cn = 'clientID', ac = 'clientac', 
			wd = rf = rd = u = ds = "", ur = document.referrer.replace(/#/g, "~"), acl = encodeURI(document.location.href.replace(/#/g, "~")), r = /http[s]?:\/\/(.*?)([:\/]|$)/i, 
			r2 = /(?:baidu.+?wd=|baidu.+?word=|xywy.+?keyword=|sogou.+?query=|google.+?q=|so.+?q=|bing.+?q=|soso.+?w=|yisou.+?q=|yahoo.+?q=|yahoo.+?[\?|&]p=|360.+?q=)([^&]*)/;
	function P(n, v) {
		s[pu](n + '=' + v);
	}
	function S(n, v, s) {
		td[st](td[gt]() + (s * 24 * 3600 * 1000 * 365));
		if (acl.indexOf(".wenkang.cn") != -1){
			d[c] = n + "=" + e(v) + ((s == null) ? "" : "; expires=" + td[tg]())+ "; domain=.wenkang.cn ;path=/"
				+ "";
		}else{
			d[c] = n + "=" + e(v) + ((s == null) ? "" : "; expires=" + td[tg]())+ "; domain=.xywy.com ;path=/"
				+ "";
		}
	}
	function C(n) {
		if (d[c][l] > 0) {
			begin = d[c][i](n + "=");
			if (begin != -1) {
				begin += n[l] + 1;
				end = d[c][i](";", begin);
				if (end == -1)
					end = d[c][l];
				return ue(d[c][su](begin, end));
			}
		}
		return;
	}
	if (ur) {
		ds = ur[mt](r);
		rd = ds[1];
		P('redoman', rd);
		P('ref', ur);
	}
	if (!C(ac)) {
		u = td[gt]() + pa(mk[rm](10, 1) * 100);
		P('clientID', (u + 'clientID'));
		//将clientID存入cookie中 参数名为ac中  不在用clientID作为键值存储
		S(ac, u, '5');
	} else {
		P('clientID', (C(ac) + 'clientID'));
	}
	P('wd', wd);
	P('Tkt', (mk[mr](td[gt]() / 1000) + "Tkt"));
	if (typeof (subject_pid) == 'number') {
		P('Pid', subject_pid + 'Pid');
	} else {
		if (typeof(subject_pid) == 'undefined'){
			P('pid', 0 + 'Pid');
		}else{
			subject_pid = Number(subject_pid);
			if (subject_pid >= 0) {
				P('Pid', subject_pid + 'Pid');
			}else{
				P('pid', 0 + 'Pid');
			}
		}
	}
	if (typeof (subject) == 'number') {
		P('Sid', subject + 'Sid');
	} else {
		if (typeof(subject) == 'undefined'){
			P('sid', 0 + 'Sid');
		}else{
			subject = Number(subject);
			if (subject >= 0) {
				P('Sid', subject + 'Sid');
			}else{
				P('sid', 0 + 'Sid');
			}
		}
	}
	/** 从cookie里面取出用户id 放入z.png后面的参数  add by zhangyi**/
	/** 处理用户id **/
	if(C("cookie_user")) {
		P('loginID',C("cookie_user"));
	}else{
		P('loginID','');
	}
	if(C("cookie_usertype")) {
		P('usertype',C("cookie_usertype"));
	}else{
		P('usertype','');
	}
	/** 处理用户id结束  **/
	/** 取参数结束**/
	/** 处理恶意刷新 导致pv统计不准的问题 根据cookie中储存的上一个请求和请求时间 判断是否需要发出z.png请求 **/
		var canSendZpng = true;
		if(C("tj_lastUrl")){
			if(acl==C("tj_lastUrl")){				
				if(C("tj_lastUrl_time")){
					var offset = parseInt(new Date().getTime()) - parseInt(C("tj_lastUrl_time"));
					if(parseInt(offset)<120000){
						canSendZpng = false;
					}
				}
			}else{
				
			}
		}else{
			
		}
		//记载访问url和时间
		S('tj_lastUrl',acl, '5');
		S('tj_lastUrl_time',new Date().getTime(), '5');
	/** 处理完毕 **/
	//if (!C(ac) || (C(ac) != acl)) {
		P('AcT', (acl + 'AcT'));
		//S(ac, acl);
		//如果不是恶意刷新 则发出zpng请求
		//添加日志类型参数
		P('clickType','0');
		//抓取文章标题title
		P('title',document.title)
		if(canSendZpng){
			//处理cookie存储搜索词的问题
			if(wd!=""){				
				S('cookie_wd',wd,5)
				S('cookie_wd_redoman',rd,5)
			}
			P('cookie_wd',C('cookie_wd')+'cookie_wd')
			P('cookie_wd_redoman',C('cookie_wd_redoman')+'cookie_wd_redoman')
			P('tempid',Math.random())			
			//记录并处理新老访客cookie
			if(!C('visit_dt')){
				//用户访问网站的日期为空 说明之前没有存过这个cookie 那么这是一个新访客
				//计算用户访问的日期 以天为单位
				vd_day = new Date();
				vd_year= vd_day.getFullYear();//ie火狐下都可以  
				vd_month= vd_day.getMonth();  
				vd_day = vd_day.getDate();  
				vd_dt = vd_year+'-'+vd_month+'-'+vd_day;
				//把vd_dt的值 加入cookie
				S('visit_dt', vd_dt, '5');
				P('isNew_User','trueisNew_User');
			}else{
				//已经记录了访问网站的日期 那么需要比较一下当前日期和这个日期 如果不是同一天 说明是老访客 如果是一天 说明是新访客
				vd_day = new Date();
				vd_year= vd_day.getFullYear();//ie火狐下都可以  
				vd_month= vd_day.getMonth();  
				vd_day = vd_day.getDate();  
				vd_dt = vd_year+'-'+vd_month+'-'+vd_day;
				if(C('visit_dt')==vd_dt){
					//同一天 说明是新访客
					P('isNew_User','trueisNew_User');
				}else{
					//不是同一天 说明是老访客
					P('isNew_User','falseisNew_User');
				}
			}
			im.src = "http:\/\/stat-y.xywy.com\/z.png?" + s[j]('&');
		}		
		for (i = 0; i < metas.length; i++) {
			if (metas[i].getAttribute("name") == "description") {
				meta_descript = metas[i].getAttribute("content");
			}
		}
		//if (window.location.host != 'club.xywy.com') {
			//im_pv.src = "http:\/\/stat-w.xywy.com\/w.png?Xt" + d['title']
					//+ meta_descript + "Xt";
		//}
	//}
})();
document.writeln("<\/div>");