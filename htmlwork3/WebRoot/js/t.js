//用于记录页面的加载时间 需要注意使用的前提是页面本身没有定义window.onload函数 否则会覆盖原有函数
var t_begin_time = new Date();
var t_end_time = null;	
var t_offset_time = 1;

function load_time(){
	t_end_time = new Date();
	t_offset_time = parseInt(t_end_time.getTime())-parseInt(t_begin_time.getTime());
	im = new Image;
	//im.src = "http://127.0.0.1:8888/saveTime?t="+t_offset_time+"&url="+window.location.href;
	im.src = "http:\/\/stat-y.xywy.com\/z.png?clickType=2&t_load_time="+t_offset_time+"&AcT="+window.location.href+"AcT";
}

var oldonload = window.onload;//得到上一个onload事件的函数
if (typeof window.onload != 'function') {//判断类型是否为'function',注意typeof返回的是字符串
		window.onload = function() {
			load_time();//调用当前事件函数
		}
} else {  
		window.onload = function() {
			oldonload();//调用之前覆盖的onload事件的函数---->由于我对js了解不多,这里我暂时理解为通过覆盖onload事件的函数来实现加载多个函数
			load_time();//调用当前事件函数
		}
}


