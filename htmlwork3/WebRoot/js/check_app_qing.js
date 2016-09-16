var aq_cookie_pre = '',
	aq_cookie_domain = 'xywy.com',
	aq_cookie_path = '/';
/* set qing tag */
function setAppQingTag(name, value)
{	name = aq_cookie_pre+name;
	document.cookie = name + "=" + escape(value) + ("; path=" + aq_cookie_path) + ((aq_cookie_domain == '') ? "" : ("; domain=" + aq_cookie_domain)) + ";expires=0";
}
/* get qing tag */
function getAppQingTag(name) 
{	name = aq_cookie_pre+name;
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
    if(arr != null) return unescape(arr[2]); return null;
}
/* get url tag */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}
/* running */ 
if(getQueryString('fromurl') == 'bdapp_qing' && navigator.userAgent.toLowerCase().indexOf('baiduboxapp') > -1) {
	if(!getAppQingTag('frombd_app')) {
		setAppQingTag('frombd_app','y');
	}
}
