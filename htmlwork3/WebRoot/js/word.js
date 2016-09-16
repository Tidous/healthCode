document.domain="xywy.com";
var request_domain="http://page.xywy.com/";//http://p.xywy.com/j?
var d_url='';
var thekeyword=''; 
var art_title='';
var qdetail='';
var fromdomain='';
if(typeof(qtagname)=="undefined") {
	var qtagname='';
}

function randomString(len) {
	len = len || 16;
	var $chars = 'ABC1DEFGH2IJK3LMNOQP4RSTU5VWXYZab6cdef8ghij7kmlnopq9rest0uvwxyz';
	var maxPos = $chars.length;
	var pwd = '';
	for (i = 0; i < len; i++) {
		pwd += $chars.charAt(Math.floor(Math.random() * maxPos));
	}
	return pwd;
}

function getKeyword(type){
	if(type=="parent"){
		d_url=parent.location.href;
		fromdomain=parent.location.host;
		var the_url = parent.referrer;
		var qdetailcObj = parent.document.getElementById("qdetailc");
		art_title = parent.document.title;
		if(typeof(parent.qtagname)!="undefined"){
			qtagname=parent.qtagname;
		}
	}
	else{
		d_url=document.location.href;
		fromdomain=document.location.host;
		var the_url = document.referrer;
		var qdetailcObj = document.getElementById("qdetailc");
		art_title = document.title;
	}
	
	if( d_url )
	{
		if(d_url.indexOf('?')!='undefined'){
			var urlArr=d_url.split('?');
			d_url=urlArr[0];
		}
		d_url = encodeURIComponent(d_url);
	}
	
	var strDate = new Date(),wds_arr='',de=decodeURIComponent,c='gbk',host="",r=/http[s]{0,1}:\/\/([^\/]+)\//i,r2 = /(?:baidu.+?wd=|baidu.+?word=|xywy.+?keyword=|sogou.+?query=|google.+?q=|so.+?q=|bing.+?q=|soso.+?w=|yahoo.+?q=|yahoo.+?[\?|&]p=|360.+?q=)([^&]*)/;//,thekeyword='',the_url = doc.referrer
			//the_url ="http://www.baidu.com/s?wd=site%3Aclub.xywy.com+%E8%82%BF%E7%98%A4&rsv_spt=1&issp=1&rsv_bp=0&ie=utf-8&tn=baiduhome_pg&rsv_sug3=9&rsv_sug=0&rsv_sug4=458&rsv_sug1=3";
	if(r2.test(the_url)) //符合各种搜索
	{
		huachFlag = 1;
		//host = the_url.match(r);
		//spider = host[1];
		if(the_url.indexOf('ie=utf-8')>-1) c="utf";
		else if(the_url.indexOf('ie=gbk')>-1) c="gbk";
		else{
			host = the_url.match(r);
			if(typeof(host)!="undefined" && typeof(host[1])!="undefined"){
				if(host[1]=='www.sogou.com' || host[1]=='www.soso.com' || host[1]=='so.xywy.com' || host[1]=='www.baidu.com') //gbk
				{
					if(the_url.indexOf('ie=utf-8')>-1)
					{
						c = "utf";
					}				
				}
				else if(host[1]=='so.360.cn' || host[1]=='www.so.com')
				{
					if(the_url.indexOf('ie=gbk')>-1)
					{
						c = "gbk";
					}
					else c = "utf";
				}
				else{c = "utf";}
				
			}
			
		}
		wds_arr = the_url.match(r2);
		if(typeof(wds_arr)!="undefined" && typeof(wds_arr[1])!='undefined'){
			thekeyword = wds_arr[1];
			if (/(iPhone)/i.test(navigator.userAgent)){
				thekeyword = '';
			}
			if (c=="utf"){
				thekeyword = de(thekeyword);
			}
			if(thekeyword.indexOf('%')>-1){
				thekeyword = t_urlde(thekeyword);
			}
		}
	}
	
	if(qdetailcObj){
		qdetail=qdetailcObj.innerHTML;
		if( qdetail ){
			//qdetail=qdetail.replace(/</?[^>]*>/g,"");
			qdetail=qdetail.replace(/<script.*?>.*?<\/script>/ig, '');
			qdetail=qdetail.replace(/<\/?[^>]*>/g,"");  //html标签
			qdetail = qdetail.replace('曾经治疗情况及是否有过敏、遗传病史','');
			qdetail = qdetail.replace('病情描述（发病时间、主要症状、症状变化等）：','');
			qdetail = qdetail.replace('曾经治疗情况和效果：','');
			qdetail = qdetail.replace('想得到怎样的帮助：','');
			qdetail=qdetail.replace(/\s/g,"");	//过滤空格
			qdetail=qdetail.replace(/\r\n/g,"");		//换行
		}
	}	
	
	var title_arr = new Array();
	//if(d_url.indexOf('club.xywy.com')>-1){
	if(art_title.indexOf('-')>-1)
	{
		title_arr = art_title.split('-');
		art_title = title_arr[0];
	}
	if(art_title.indexOf('_')>-1)
	{
		title_arr = art_title.split('_');
		art_title = title_arr[0];
	}
	//}
}
function t_urlde(thekeyword)
{
	var ret; 
	try{ 
		ret = decodeURIComponent(thekeyword); 
	}catch(ex){ 
		ret = '';
	}
	return ret; 
}

getKeyword("self");

var word_xywy_param_arr={};
//word_xywy_param_arr['3g_brand_middle_img']={'width':'100%','height':'90px'};
//word_xywy_param_arr['3g_400_zixun']={'width':'100%','height':'68px'};
//word_xywy_param_arr['3g_400_wenzi']={'width':'100%','height':'26px'};
//word_xywy_param_arr['3g_hospital_imgtext']={'width':'100%','height':'78px'};
//word_xywy_param_arr['new_3g_ask_doctor']={'width':'92px','height':'42px'};
//word_xywy_param_arr['new_3g_400_new2']={'width':'100%','height':'79px'};
//word_xywy_param_arr['new_3g_400_wenzi2']={'width':'100%','height':'26px'};
word_xywy_param_arr['mobile_400_zixun']={'width':'100%','height':'68px'};
word_xywy_param_arr['mobile_hospital_zixun']={'width':'100%','height':'60px'};
word_xywy_param_arr['mobile_zhuanti_400_zixun']={'width':'100%','height':'68px'};
word_xywy_param_arr['mobile_zhuanti_400_zixun_lian']={'width':'100%','height':'68px'};
word_xywy_param_arr['mobile_jb_400_zixun']={'width':'100%','height':'68px'};
word_xywy_param_arr['mobile_400_wenzi']={'width':'100%','height':'26px'};
word_xywy_param_arr['mobile_400_wenzi_js']={'width':'100%','height':'26px'};
word_xywy_param_arr['mobile_zhuanti_400_wenzi']={'width':'100%','height':'26px'};
word_xywy_param_arr['mobile_jswz']={'width':'100%','height':'26px'};
word_xywy_param_arr['mobile_ask_doctor']={'width':'120px','height':'42px'};
word_xywy_param_arr['mobile_ask_dbfc']={'width':'100%','height':'40px'};
word_xywy_param_arr['mobile_move_bottom_float']={'width':'100%','height':'50px'};
word_xywy_param_arr['mobile_hospital_bottom_float']={'width':'100%','height':'50px'};
word_xywy_param_arr['mobile_hospital_bottom_float_window']={'width':'50px','height':'50px'};
word_xywy_param_arr['mobile_hospital_bottom_float_js']={'width':'50px','height':'50px'};
word_xywy_param_arr['mobile_bottom_float']={'width':'100%','height':'50px'};
//word_xywy_param_arr['mobile_ask_dbfc_test']={'width':'100%','height':'40px'};
//word_xywy_param_arr['mobile_ask_doctor2']={'width':'142px','height':'30px'};
word_xywy_param_arr['mobile_hospital_imgtext']={'width':'100%','height':'74px'};
word_xywy_param_arr['mobile_zhuanti_hospital_imgtext']={'width':'100%','height':'74px'};
//word_xywy_param_arr['mobile_hospital_imgtextv2']={'width':'100%','height':'82px'};
word_xywy_param_arr['mobile_brand_imgtext']={'width':'100%','height':'72px'};
word_xywy_param_arr['mobile_hotspot_wenzi']={'width':'100%','height':'80px'};
word_xywy_param_arr['mobile_shop_wenzi']={'width':'100%','height':'26px'};
word_xywy_param_arr['mobile_shop_imgtext1']={'width':'100%','height':'80px'};
word_xywy_param_arr['mobile_shop_imgtext2']={'width':'100%','height':'80px'};
word_xywy_param_arr['mobile_cqshop_imgtext1']={'width':'100%','height':'82px'};
//word_xywy_param_arr['mobile_cqshop_imgtext2']={'width':'100%','height':'82px'};
word_xywy_param_arr['mobile_hospital_shop']={'width':'100%','height':'85px'};
//word_xywy_param_arr['mobile_hospital_shop2']={'width':'100%','height':'85px'};
//word_xywy_param_arr['mobile_shop_imgtext1_test']={'width':'100%','height':'76px'};
//word_xywy_param_arr['mobile_shop_imgtext2_test']={'width':'100%','height':'76px'};

word_xywy_param_arr['club_v2_brand_yiping']={'width':'300px','height':'250px'};
word_xywy_param_arr['club_v2_doctor_activity2']={'width':'260px','height':'311px'};

word_xywy_param_arr['club_v2_left_float']={'width':'190','height':'326'};
word_xywy_param_arr['club_v2_doctor_activity']={'width':'300px','height':'311px'};
word_xywy_param_arr['club_v2_doctor_online']={'width':'665px','height':'87px'};
word_xywy_param_arr['club_ask_middle_imgtext']={'width':'665px','height':'87px'};
word_xywy_param_arr['club_v2_bottom_bantong']={'width':'662px','height':'75px'};
word_xywy_param_arr['club_v2_famous_doctor']={'width':'665px','height':'102px'};

word_xywy_param_arr['jib_top_banner_single']={'width':'980px','height':'60px'};
word_xywy_param_arr['jib_top_banner_single_baidu']={'width':'980px','height':'60px'};
word_xywy_param_arr['jib_right_tjyy']={'width':'500px','height':'395px'};
word_xywy_param_arr['jib_right_tjyy2']={'width':'239px','height':'908px'};
word_xywy_param_arr['jib_right_tjyy_baidu']={'width':'239px','height':'908px'};
word_xywy_param_arr['jib_right_tjyy2_baidu']={'width':'239px','height':'912px'};
word_xywy_param_arr['jib_right_tjys']={'width':'500px','height':'420px'};
word_xywy_param_arr['jib_right_tjys2']={'width':'233px','height':'750px'};
word_xywy_param_arr['jib_right_tjys_baidu']={'width':'233px','height':'750px'};
word_xywy_param_arr['jib_right_tjys2_baidu']={'width':'233px','height':'750px'};
word_xywy_param_arr['jib_right_keyword']={'width':'744px','height':'73px'};
word_xywy_param_arr['jib_right_keyword2']={'width':'223px','height':'220px'};
word_xywy_param_arr['jib_right_keyword_baidu']={'width':'223px','height':'220px'};
word_xywy_param_arr['jib_right_keyword2_baidu']={'width':'223px','height':'220px'};
word_xywy_param_arr['jib_right_button_single']={'width':'237px','height':'75px'};
word_xywy_param_arr['jib_right_buttonw2_single']={'width':'237px','height':'75px'};
word_xywy_param_arr['jib_right_button_single_baidu']={'width':'237px','height':'75px'};
word_xywy_param_arr['jib_right_button2_single_baidu']={'width':'237px','height':'75px'};
word_xywy_param_arr['jib_right_big_image2']={'width':'235px','height':'360px'};
word_xywy_param_arr['jib_right_big_image2_baidu']={'width':'235px','height':'360px'};

word_xywy_param_arr['mobile_disease_text']={'width':'100%','height':'34px'};

word_xywy_param_arr['new_jib_right_keyword2_baidu']={'width':'731px','height':'77px'};
word_xywy_param_arr['jib_right_hos']={'width':'500px','height':'395px'};
word_xywy_param_arr['jib_right_doc']={'width':'500px','height':'395px'};
word_xywy_param_arr['jib_right_doc2']={'width':'500px','height':'395px'};
word_xywy_param_arr['jib_right_buttonimg']={'width':'280px','height':'91px'};
word_xywy_param_arr['jib_right_text']={'width':'500px','height':'395px'};

word_xywy_param_arr['flow_wenzhang_img']={'width':'300px','height':'250px'};
word_xywy_param_arr['flow_wenzhang_ypjd']={'width':'300px','height':'250px'};


word_xywy_param_arr['brands_jib_right_button']={'width':'280px','height':'185px'};
word_xywy_param_arr['brands_top_banner']={'width':'980px','height':'60px'};


word_xywy_param_arr['yimei_left_float_keyword']={'width':'190px','height':'326px'};
word_xywy_param_arr['mobile_free_consult']={'width':'50px','height':'50px'};
word_xywy_param_arr['mobile_consult_ua']={'width':'50px','height':'50px'};

/*word_xywy_param_arr['new_jib_top_banner_single_baidu']={'width':'980px','height':'60px'};
word_xywy_param_arr['new_jib_right_tjyy_baidu']={'width':'680px','height':'150px'};
word_xywy_param_arr['new_jib_right_tjys_baidu']={'width':'698px','height':'140px'};
word_xywy_param_arr['new_jib_right_keyword_baidu']={'width':'260px','height':'220px'};
word_xywy_param_arr['new_jib_right_button_single_baidu']={'width':'260px','height':'76px'};

word_xywy_param_arr['new_jib_right_tjyy2_baidu']={'width':'262px','height':'540px'};
word_xywy_param_arr['new_jib_right_tjys2_baidu']={'width':'262px','height':'490px'};
word_xywy_param_arr['new_jib_right_keyword2_baidu']={'width':'260px','height':'220px'};
word_xywy_param_arr['new_jib_right_button_single2_baidu']={'width':'260px','height':'76px'};*/
/*
 *@function:display custom's content
 *@page_xywy_param:position
 *@width
 *@height
*/
function display_keyword_content(obj){
	var page_xywy_param=obj.param;
	var width=obj.wh;
	var height=obj.ht;
	if(typeof(page_xywy_param)!="undefined" && typeof(word_xywy_param_arr[page_xywy_param])!="undefined"){
		if(typeof(width)=="undefined"){
			width=word_xywy_param_arr[page_xywy_param].width;
		}
		if(typeof(height)=="undefined"){
			height=word_xywy_param_arr[page_xywy_param].height;
		}
		if(typeof(Quan_X) == 'undefined') {
			Quan_X = 0;
		}
		if(typeof(Quan_Y) == 'undefined') {
			Quan_Y = 0;
		}
		keyword_show(page_xywy_param,thekeyword,qdetail,width,height,Quan_X,Quan_Y);
	}
}

function display_keyword_float_content(obj){
	var page_xywy_param=obj.param;
	var width=obj.wh;
	var height=obj.ht;
	var page_xywy_param_ks=obj.de;
	if(typeof(page_xywy_param)!="undefined" && typeof(word_xywy_param_arr[page_xywy_param])!="undefined"){
		if(typeof(width)=="undefined"){
			width=word_xywy_param_arr[page_xywy_param].width;
		}
		if(typeof(height)=="undefined"){
			height=word_xywy_param_arr[page_xywy_param].height;
		}
		if(typeof(page_xywy_param_ks)=="undefined")page_xywy_param_ks=0;
		if(typeof(Quan_X) == 'undefined') {
			Quan_X = 0;
		}
		if(typeof(Quan_Y) == 'undefined') {
			Quan_Y = 0;
		}
		keyword_show_leftfloat2(page_xywy_param,page_xywy_param_ks,thekeyword,qdetail,width,height,Quan_X,Quan_Y);
	}
}

function display_keyword_depart_content(obj){
	var page_xywy_param=obj.param;
	var width=obj.wh;
	var height=obj.ht;
	var doc=obj.doc;
	var tx=obj.tx;
	if(typeof(doc)!="undefined" && doc!="" && doc!="self"){
		getKeyword(doc);
	}
	var page_xywy_param_ks=obj.de;
	if(typeof(page_xywy_param)!="undefined" && typeof(word_xywy_param_arr[page_xywy_param])!="undefined"){
		if(typeof(width)=="undefined"){
			width=word_xywy_param_arr[page_xywy_param].width;
		}
		if(typeof(height)=="undefined"){
			height=word_xywy_param_arr[page_xywy_param].height;
		}
		if(typeof(page_xywy_param_ks)=="undefined")page_xywy_param_ks=0;

		if(typeof(tx)=="undefined")tx='';
		if(typeof(Quan_X) == 'undefined') {
			Quan_X = 0;
		}
		if(typeof(Quan_Y) == 'undefined') {
			Quan_Y = 0;
		}

		keyword_show_depart(page_xywy_param,page_xywy_param_ks,thekeyword,qdetail,width,height,tx,Quan_X,Quan_Y);
	}
}

function display_ajax_ad(obj,divid) {
	var page_xywy_param=obj.param;
	var width=obj.wh;
	var height=obj.ht;
	var doc=obj.doc;
	var tx=obj.tx;
	if(typeof(doc)!="undefined" && doc!="" && doc!="self"){
		getKeyword(doc);
	}
	var page_xywy_param_ks=obj.de;
	if(typeof(page_xywy_param)!="undefined" && typeof(word_xywy_param_arr[page_xywy_param])!="undefined"){
		if(typeof(width)=="undefined"){
			width=word_xywy_param_arr[page_xywy_param].width;
		}
		if(typeof(height)=="undefined"){
			height=word_xywy_param_arr[page_xywy_param].height;
		}
		if(typeof(page_xywy_param_ks)=="undefined")page_xywy_param_ks=0;
		if(typeof(tx)=="undefined")tx='';
        if(typeof(Quan_X) == 'undefined'){
            Quan_X = 0;
        }
        if(typeof(Quan_Y) == 'undefined'){
            Quan_Y = 0;
        }

		var subject = page_xywy_param_ks;
		var iwidth = width;
		var iheight = height;
		var lng = Quan_X;
		var lat = Quan_Y;

		var keyword=thekeyword+qtagname+"|"+art_title+qdetail;
		keyword=keyword.substr(0,110);
		keyword=encodeURIComponent(keyword);
		var lat_lng = '';
		if(lng !=0 && lat!=0 && lat!='' && lng !=''){
			lat_lng = '&lng='+lng+'&lat='+lat;
		}
		var rand = randomString();
		var addr = '';

		if( typeof(_RET_IP) != "undefined" ) {
			addr = "&addr="+encodeURIComponent(_RET_IP.data.area);
		}
		var theurl = request_domain+rand+"/shopad?a="+ page_xywy_param+"&d="+subject+"&k="+keyword+"&url="+d_url+"&tx="+tx+lat_lng+addr;

		$.ajax({
			type: "GET",
			url: theurl,
			dataType: "jsonp",
			jsonpCallback: "xywyback",
			success: function(json){
				if(json.result==1) {
					$("#"+divid).html(json.content)
				}
			}
		});

		//document.writeln('<div style="width:'+iwidth+'; height:'+iheight+'; overflow: hidden; position: static;"><iframe  style="border: none;" scrolling="no" width="'+iwidth+'"  height='+iheight+'  frameborder="0" marginheight="0" allowtransparency="true" marginwidth="0" border="0" src="' + theurl + '"></iframe></div>');

	}

}

function display_shop_content_random(obj){
	var page_xywy_param=obj.param;
	var width=obj.wh;
	var height=obj.ht;
	var doc=obj.doc;
	var tx=obj.tx;
	if(typeof(doc)!="undefined" && doc!="" && doc!="self"){
		getKeyword(doc);
	}
	var page_xywy_param_ks=obj.de;
	if(typeof(page_xywy_param)!="undefined" && typeof(word_xywy_param_arr[page_xywy_param])!="undefined"){
		if(typeof(width)=="undefined"){
			width=word_xywy_param_arr[page_xywy_param].width;
		}
		if(typeof(height)=="undefined"){
			height=word_xywy_param_arr[page_xywy_param].height;
		}
		if(typeof(page_xywy_param_ks)=="undefined")page_xywy_param_ks=0;
		if(typeof(tx)=="undefined")tx='';
        if(typeof(Quan_X) == 'undefined'){
            Quan_X = 0;
        }
        if(typeof(Quan_Y) == 'undefined'){
            Quan_Y = 0;
        }

		keyword_show_shop_random(page_xywy_param,page_xywy_param_ks,thekeyword,qdetail,width,height,tx,Quan_X,Quan_Y);
	}
}

function display_shop_content(obj){
	var page_xywy_param=obj.param;
	var width=obj.wh;
	var height=obj.ht;
	var doc=obj.doc;
	var tx=obj.tx;
	if(typeof(doc)!="undefined" && doc!="" && doc!="self"){
		getKeyword(doc);
	}
	var page_xywy_param_ks=obj.de;
	if(typeof(page_xywy_param)!="undefined" && typeof(word_xywy_param_arr[page_xywy_param])!="undefined"){
		if(typeof(width)=="undefined"){
			width=word_xywy_param_arr[page_xywy_param].width;
		}
		if(typeof(height)=="undefined"){
			height=word_xywy_param_arr[page_xywy_param].height;
		}
		if(typeof(page_xywy_param_ks)=="undefined")page_xywy_param_ks=0;
		if(typeof(tx)=="undefined")tx='';
        if(typeof(Quan_X) == 'undefined'){
            Quan_X = 0;
        }
        if(typeof(Quan_Y) == 'undefined'){
            Quan_Y = 0;
        }

		keyword_show_shop(page_xywy_param,page_xywy_param_ks,thekeyword,qdetail,width,height,tx,Quan_X,Quan_Y);
	}
}

function keyword_show(page_xywy_param,thekeyword,qdetail,iwidth,iheight,lng,lat){
	var keyword=thekeyword+qtagname+"|"+art_title+qdetail;
    keyword=keyword.substr(0,110);
	if(page_xywy_param.indexOf("mobile")>-1){
    keyword=keyword.substr(0,100);
	}
    /*if(page_xywy_param=='club_v2_bottom_bantong')
    {
        keyword=keyword.substr(0,55);
    }*/
	keyword=encodeURIComponent(keyword);

    var lat_lng = '';
	if(lng !=0 && lat!=0 && lat!='' && lng !=''){
        lat_lng = '&lng='+lng+'&lat='+lat;
    }

	//var theurl = request_domain+"gg?a="+ page_xywy_param +"&k="+keyword+"&url="+d_url+"";
	var theurl = request_domain+"leftfloat?a="+ page_xywy_param +"&d=0&k="+keyword+"&url="+d_url+lat_lng+"";
	document.writeln('<div style="width:'+iwidth+'; height:'+iheight+'; overflow: hidden; position: static;"><iframe  style="border: none;" scrolling="no" width="'+iwidth+'"  height='+iheight+'  frameborder="0" marginheight="0" allowtransparency="true" marginwidth="0" border="0" src="' + theurl + '"></iframe></div>');	
}

function keyword_show_depart(page_xywy_param,subject,thekeyword,qdetail,iwidth,iheight,tx,lng,lat){
	var keyword=thekeyword+qtagname+"|"+art_title+qdetail;
    keyword=keyword.substr(0,110);
	if(page_xywy_param.indexOf("mobile")>-1){
    keyword=keyword.substr(0,100);
	}
	keyword=encodeURIComponent(keyword);

    var lat_lng = '';
	if(lng !=0 && lat!=0 && lat!='' && lng !=''){
        lat_lng = '&lng='+lng+'&lat='+lat;
    }

	var addr = '';

	if( typeof(_RET_IP) != "undefined" ) {
		addr = "&addr="+encodeURIComponent(_RET_IP.data.area);
	}
	
	//var theurl = request_domain+"gg_depart?a="+ page_xywy_param+"&d="+subject+"&k="+keyword+"&url="+d_url+"";
	//var theurl = "http://page.xywy.com/gg_depart?a="+ page_xywy_param+"&d="+subject+"&k="+keyword+"&url="+d_url+"";
	var theurl = "http://page.xywy.com/leftfloat?a="+ page_xywy_param+"&d="+subject+"&k="+keyword+"&url="+d_url+"&tx="+tx+lat_lng+addr;
	document.writeln('<div style="width:'+iwidth+'; height:'+iheight+'; overflow: hidden; position: static;"><iframe  style="border: none;" scrolling="no" width="'+iwidth+'"  height='+iheight+'  frameborder="0" marginheight="0" allowtransparency="true" marginwidth="0" border="0" src="' + theurl + '"></iframe></div>');
}

function keyword_show_shop(page_xywy_param,subject,thekeyword,qdetail,iwidth,iheight,tx,lng,lat){
	var keyword=thekeyword+qtagname+"|"+art_title+qdetail;
    keyword=keyword.substr(0,110);
	if(page_xywy_param=="club_v2_brand_yiping" || page_xywy_param.indexOf("mobile")>-1){
    keyword=keyword.substr(0,80);
	}
	keyword=encodeURIComponent(keyword);
    var lat_lng = '';
	if(lng !=0 && lat!=0 && lat!='' && lng !=''){
        lat_lng = '&lng='+lng+'&lat='+lat;
    }

	var addr = '';

	if( typeof(_RET_IP) != "undefined" ) {
		addr = "&addr="+encodeURIComponent(_RET_IP.data.area);
	}

	var theurl = request_domain+"shopad?a="+ page_xywy_param+"&d="+subject+"&k="+keyword+"&url="+d_url+"&tx="+tx+lat_lng+addr;
	document.writeln('<div style="width:'+iwidth+'; height:'+iheight+'; overflow: hidden; position: static;"><iframe  style="border: none;" scrolling="no" width="'+iwidth+'"  height='+iheight+'  frameborder="0" marginheight="0" allowtransparency="true" marginwidth="0" border="0" src="' + theurl + '"></iframe></div>');
}

function keyword_show_shop_random(page_xywy_param,subject,thekeyword,qdetail,iwidth,iheight,tx,lng,lat){
	var keyword=thekeyword+qtagname+"|"+art_title+qdetail;
    keyword=keyword.substr(0,110);
	if(page_xywy_param=="club_v2_brand_yiping" || page_xywy_param.indexOf("mobile")>-1){
    keyword=keyword.substr(0,80);
	}
	keyword=encodeURIComponent(keyword);
    var lat_lng = '';
	if(lng !=0 && lat!=0 && lat!='' && lng !=''){
        lat_lng = '&lng='+lng+'&lat='+lat;
    }
	var rand = randomString();
	var addr = '';

	if( typeof(_RET_IP) != "undefined" ) {
		addr = "&addr="+encodeURIComponent(_RET_IP.data.area);
	}
	var theurl = request_domain+rand+"/shopad?a="+ page_xywy_param+"&d="+subject+"&k="+keyword+"&url="+d_url+"&tx="+tx+lat_lng+addr;
	document.writeln('<div style="width:'+iwidth+'; height:'+iheight+'; overflow: hidden; position: static;"><iframe  style="border: none;" scrolling="no" width="'+iwidth+'"  height='+iheight+'  frameborder="0" marginheight="0" allowtransparency="true" marginwidth="0" border="0" src="' + theurl + '"></iframe></div>');
}

function display_shop_content2(obj){
	var page_xywy_param=obj.param;
	var width=obj.wh;
	var height=obj.ht;
	var doc=obj.doc;
	var tx=obj.tx;
	if(typeof(doc)!="undefined" && doc!="" && doc!="self"){
		getKeyword(doc);
	}
	var page_xywy_param_ks=obj.de;
	if(typeof(page_xywy_param)!="undefined" && typeof(word_xywy_param_arr[page_xywy_param])!="undefined"){
		if(typeof(width)=="undefined" || typeof(height)=="undefined"){
			width=word_xywy_param_arr[page_xywy_param].width;
			height=word_xywy_param_arr[page_xywy_param].height;
		}
		if(typeof(page_xywy_param_ks)=="undefined")page_xywy_param_ks=0;
		if(typeof(tx)=="undefined")tx='';
        if(typeof(Quan_X) == 'undefined'){
            Quan_X = 0;
        }
        if(typeof(Quan_Y) == 'undefined'){
            Quan_Y = 0;
        }
		keyword_show_shop2(page_xywy_param,page_xywy_param_ks,thekeyword,qdetail,width,height,tx,Quan_X,Quan_Y);
	}
}
function keyword_show_shop2(page_xywy_param,subject,thekeyword,qdetail,iwidth,iheight,tx,lng,lat){
	var keyword=thekeyword+qtagname+"|"+art_title+qdetail;
    keyword=keyword.substr(0,110);
	keyword=encodeURIComponent(keyword);
	
    var lat_lng = '';
	if(lng !=0 && lat!=0 && lat!='' && lng !=''){
        lat_lng = '&lng='+lng+'&lat='+lat;
    }
	var theurl = request_domain+"shopad?a="+ page_xywy_param+"&d="+subject+"&k="+keyword+"&url="+d_url+"&tx="+tx+lat_lng+"&time="+new Date().getTime()+"time";
	document.writeln('<div style="width:'+iwidth+'; height:'+iheight+'; overflow: hidden; position: static;"><iframe  style="border: none;" scrolling="no" width="'+iwidth+'"  height='+iheight+'  frameborder="0" marginheight="0" allowtransparency="true" marginwidth="0" border="0" src="' + theurl + '"></iframe></div>');
}

function keyword_show_leftfloat2(page_xywy_param,subject,thekeyword,qdetail,iwidth,iheight,lng,lat){
	if(typeof(iwidth)=="undefined")iwidth="200";
	var keyword=thekeyword+qtagname+"|"+art_title+qdetail;
	keyword=keyword.substr(0,110);
	keyword=encodeURIComponent(keyword);
    var lat_lng = '';
	if(lng !=0 && lat!=0 && lat!='' && lng !=''){
        lat_lng = '&lng='+lng+'&lat='+lat;
    }
	var theurl = request_domain+"leftfloat?a="+page_xywy_param+"&d="+subject+"&k="+keyword+"&url="+d_url+"&fromdomain="+fromdomain+lat_lng;
	var frm_str='<iframe id="ifm_leftfloat" name="ifm" style="border: none;" scrolling="no" width='+iwidth+'  height='+iheight+' frameborder="0" marginheight="0" allowtransparency="true" marginwidth="0" border="0" src="' + theurl + '"></iframe>';
	
	var boxstr = "<div id=\"ifm\" style=\"left:0;bottom:200px;width:"+iwidth+"px;height:194px;position:fixed;z-index:2147483646;_position:absolute;_bottom:auto;_top:expression(eval(document.documentElement.scrollTop+document.documentElement.clientHeight-this.offsetHeight-(parseInt(this.currentStyle.marginTop,10)||0)-(parseInt(this.currentStyle.marginBottom,10)||0)));zoom:1;\">"+frm_str+"</div>";
	boxstr=boxstr+'<div id="smallpanel" style="display:none;position:fixed;_position:absolute;left:0; bottom:200px;width:39px; height:116px;_top:expression(eval(document.documentElement.scrollTop+document.documentElement.clientHeight-this.offsetHeight*2.5 ));zoom:1;">'
		+'<div id="topS" class="tcpic" style="cursor:pointer;"><img src="http://gg.xywy.com/newclubkp/xt/old/mfzx.gif" width="39" height="116" /></div>'
		+'<span id="closeS" style=" width:20px; height:20px; position:absolute; top:-7px; right:-9px; cursor:pointer; background:url(http://gg.xywy.com/newclubkp/xt/old/cha.gif) no-repeat;"></span>'
	+'</div>'
	+'<script type="text/javascript">'
		+'(function(){'
		+'var bigPanel = document.getElementById(\'ifm\'),'
		+'    smallPanel = document.getElementById(\'smallpanel\'),'
		+'    smallbd = document.getElementById(\'topS\'),'
		+'    smallClose = document.getElementById(\'closeS\');'
		+'	smallClose.onclick = function(){'
		+'    smallPanel.style.display = \'none\';'
		+' };'
		+'  smallbd.onclick = function(){'
		+'    bigPanel.style.display = \'block\';'
		+'    smallPanel.style.display = \'none\';'
		+' };'
	+'})();'
	+'</script>';
	document.write(boxstr);
}

/*
function page_xywy_iframe_show_leftfloat(page_xywy_param,thekeyword,qdetail,iwidth,iheight){
	if(typeof(iwidth)=="undefined")iwidth="200";
	var keyword=thekeyword+qtagname+"|"+art_title+qdetail;
	keyword=keyword.substr(0,110);
	var theurl = request_domain+"gg?a="+page_xywy_param+"&k="+keyword+"&url="+d_url+"";
	var frm_str='<iframe id="ifm_leftfloat" name="ifm" style="border: none;" scrolling="no" width='+iwidth+'  height='+iheight+' frameborder="0" marginheight="0" allowtransparency="true" marginwidth="0" border="0" src="' + theurl + '"></iframe>';
	
	var boxstr = "<div id=\"ifm\" style=\"left:0;bottom:200px;width:"+iwidth+"px;height:194px;position:fixed;z-index:2147483646;_position:absolute;_bottom:auto;_top:expression(eval(document.documentElement.scrollTop+document.documentElement.clientHeight-this.offsetHeight-(parseInt(this.currentStyle.marginTop,10)||0)-(parseInt(this.currentStyle.marginBottom,10)||0)));zoom:1;\">"+frm_str+"</div>";
	boxstr=boxstr+'<div id="smallpanel" style="display:none;position:fixed;_position:absolute;left:0; bottom:200px;width:39px; height:116px;_top:expression(eval(document.documentElement.scrollTop+document.documentElement.clientHeight-this.offsetHeight*2.5 ));zoom:1;">'
		+'<div id="topS" class="tcpic" style="cursor:pointer;"><img src="http://gg.xywy.com/newclubkp/xt/old/mfzx.gif" width="39" height="116" /></div>'
		+'<span id="closeS" style=" width:20px; height:20px; position:absolute; top:-7px; right:-9px; cursor:pointer; background:url(http://gg.xywy.com/newclubkp/xt/old/cha.gif) no-repeat;"></span>'
	+'</div>'
	+'<script type="text/javascript">'
		+'(function(){'
		+'var bigPanel = document.getElementById(\'ifm\'),'
		+'    smallPanel = document.getElementById(\'smallpanel\'),'
		+'    smallbd = document.getElementById(\'topS\'),'
		+'    smallClose = document.getElementById(\'closeS\');'
		+'	smallClose.onclick = function(){'
		+'    smallPanel.style.display = \'none\';'
		+' };'
		+'  smallbd.onclick = function(){'
		+'    bigPanel.style.display = \'block\';'
		+'    smallPanel.style.display = \'none\';'
		+' };'
	+'})();'
	+'</script>';
	document.write(boxstr);
}
*/

function club_detail_left_business_single_js_show(page_xywy_param,thekeyword,qdetail,page_xywy_div){
	var keyword=thekeyword+qtagname+"|"+art_title+qdetail;
	keyword=keyword.substr(0,110);
	//var theurl = "http://"+domain+"/gc?a="+ page_xywy_param +"&k="+keyword+"&url="+d_url+"";
	if(typeof(Quan_X) == 'undefined'){
		Quan_X = 0;
	}
	if(typeof(Quan_Y) == 'undefined'){
		Quan_Y = 0;
	}
	lng = Quan_X;
	lat = Quan_Y;

	var lat_lng = '';
	if(lng !=0 && lat!=0 && lat!='' && lng !=''){
		lat_lng = '&lng='+lng+'&lat='+lat;
	}

	var theurl = "http://page.xywy.com/gg?a="+ page_xywy_param +"&k="+keyword+"&url="+d_url+lat_lng+"";
	var div = '.'+page_xywy_div;
	jQuery.ajax({
		type: "GET",
		url: theurl,//+"&callback=xywyback",
		dataType: "jsonp",
		//jsonp: "callback",
		jsonpCallback: "xywyback",
		success: function(json){
			if(json.result==1)
			{
				//var html_str = decodeURIComponent(json.content);
				var html_str = json.content;
				jQuery(div).html(html_str);
			}
		}
	});
}

function display_keyword_ad_content(obj){
	var page_xywy_param=obj.param;
	var width=obj.wh;
	var height=obj.ht;
	if(typeof(page_xywy_param)!="undefined" && typeof(word_xywy_param_arr[page_xywy_param])!="undefined"){
		if(typeof(width)=="undefined"){
			width=word_xywy_param_arr[page_xywy_param].width;
		}
		if(typeof(height)=="undefined"){
			height=word_xywy_param_arr[page_xywy_param].height;
		}
		if(typeof(Quan_X) == 'undefined') {
			Quan_X = 0;
		}
		if(typeof(Quan_Y) == 'undefined') {
			Quan_Y = 0;
		}
		keyword_ad_show(page_xywy_param,thekeyword,qdetail,width,height,Quan_X,Quan_Y);
	}
}

function keyword_ad_show(page_xywy_param,thekeyword,qdetail,iwidth,iheight,lng,lat){
	var keyword=thekeyword+qtagname+"|"+art_title+qdetail;
    keyword=keyword.substr(0,110);
	if(page_xywy_param.indexOf("mobile")>-1){
    	keyword=keyword.substr(0,100);
	}
	keyword=encodeURIComponent(keyword);
    var lat_lng = '';
	if(lng !=0 && lat!=0 && lat!='' && lng !=''){
        lat_lng = '&lng='+lng+'&lat='+lat;
    }
	var theurl = request_domain+"gg?a="+ page_xywy_param +"&k="+keyword+"&url="+d_url+lat_lng+"";
	//var theurl = request_domain+"leftfloat?a="+ page_xywy_param +"&d=0&k="+keyword+"&url="+d_url+"";
	document.writeln('<div style="width:'+iwidth+'; height:'+iheight+'; overflow: hidden; position: static;"><iframe  style="border: none;" scrolling="no" width="'+iwidth+'"  height='+iheight+'  frameborder="0" marginheight="0" allowtransparency="true" marginwidth="0" border="0" src="' + theurl + '"></iframe></div>');	
}



function display_ztzixun_float_keyword_content(obj){
	var keyword=thekeyword+qtagname+"|"+art_title;
	keyword=keyword.substr(0,110);
	keyword=encodeURIComponent(keyword);
    var page_xywy_param=obj.param;
    var is_ajax=obj.is_ajax;
    var dname='';
    var dtitle='';
    var dgoodat='';
    var dimage='';
    var durl='';
    var custom_id=0;

	if(typeof(Quan_X) == 'undefined'){
		Quan_X = 0;
	}
	if(typeof(Quan_Y) == 'undefined'){
		Quan_Y = 0;
	}
	lng = Quan_X;
	lat = Quan_Y;

    var lat_lng = '';
	if(lng !=0 && lat!=0 && lat!='' && lng !=''){
        lat_lng = '&lng='+lng+'&lat='+lat;
    }

    if(typeof (obj.dname)!='undefined'){
        var custom_id=obj.custom_id;
        var dname=encodeURIComponent(obj.dname);
        var dtitle=encodeURIComponent(obj.dtitle);
        var dgoodat=encodeURIComponent(obj.dgoodat);
        var dimage=encodeURIComponent(obj.dimage);;
        var durl=encodeURIComponent(obj.durl);;
    }

    if(typeof(page_xywy_param)!="undefined" && typeof(word_xywy_param_arr[page_xywy_param])!="undefined"){
        if(typeof(width)=="undefined"){
            iwidth=word_xywy_param_arr[page_xywy_param].width;
        }
        if(typeof(height)=="undefined"){
            iheight=word_xywy_param_arr[page_xywy_param].height;
        }
        var theurl = "http://page.xywy.com/ztzixun?a="+ page_xywy_param+"&k="+keyword+"&d_url="+d_url+"&dname="+dname+"&dtitle="+dtitle+"&dgoodat="+dgoodat+"&dimage="+dimage+"&custom_id="+custom_id+"&durl="+durl+lat_lng;
        if(is_ajax==1){
            jQuery.ajax({
                type: "GET",
                url: theurl,//+"&callback=xywyback",
                dataType: "jsonp",
                //jsonp: "callback",
				jsonpCallback: "xywyback",
                scriptCharset:'UTF-8',
                success: function(json){
                    if(json.result==1)
                    {
                        //var html_str = decodeURIComponent(json.content);
                        var html_str = json.content;
                        jQuery("#"+obj.divname).html(html_str);
                    }
                }
            });
        }else{
            jQuery("#"+obj.divname).html('<div style="width:'+iwidth+'; height:'+iheight+'; overflow: hidden; position: static;"><iframe  style="border: none;" scrolling="no" width="'+iwidth+'"  height='+iheight+'  frameborder="0" marginheight="0" allowtransparency="true" marginwidth="0" border="0" src="' + theurl + '"></iframe></div>');
        }
    }
}

