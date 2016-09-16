//文本框输入文字时 显示消空按钮
function ClearText(inputid){
    $('#'+inputid).after('<span class="closeBtn  fr mr10" style="display: none;"></span>');
    $('.closeBtn').click(function(){
        	    $("input",$(this).parent()).val("");
        		$(this).hide();
        	})   
    $('#'+inputid).keyup(function(){
            if($(this).val().match(/^\s*$/)){
                $(".closeBtn",$(this).parent()).hide();
            }else{
                 $(".closeBtn",$(this).parent()).show();
            } 
    })
    
}
//清除字符串空白字符
String.prototype.trim=function()
{
    return this.replace(/^\s+|\s+$/g,"");
}
//清除字符串左空白字符
String.prototype.ltrim=function()
{
    return this.replace(/^\s+/g,"");
}
//清除字符串右空白字符
String.prototype.rtrim=function()
{
    return this.replace(/\s+$/g,"");
}
//获取字符串中汉字的个数，不包括中文标点符号
String.prototype.chineseLen=function()
{
    var chinesearr = this.match( /[\u4E00-\u9FA5]/gm);
    return chinesearr == null ? 0 :chinesearr.length ;
}
//判断字符串是否为合法的手机号
String.prototype.validateMobile=function()
{

    return /^(?:1[358]\d{9}|14[57]\d{8})+?$/.test(this); 
}
//判断字符串是否为空，包括连续空格组成的字符串
String.prototype.isEmpty = function()
{
    return /^\s*$/.test(this);
}
//清除字符串中所有的标签
String.prototype.stripTags=function()
{
    return this.replace(/<[^>].+?>/g,"");
}
//判断一个数值字符串是否在一定的范围内
String.prototype.inRange=function(strstart,strend)
{
    var start = parseFloat(strstart);
    var end = parseFloat(strend);
    var value = parseFloat(this);
    return value >= start && value <=end;
}
//判断一个字符串长度是否在一定的范围内
String.prototype.lengthRange=function(start,end)
{
    var value = this.length;
    return value >= start && value <=end;
}
//判断一个合法的用户名 即由6-16位字母、数字及下划线组成
String.prototype.validateUsername=function(start,end){
   return new RegExp('^\\w{'+start+','+end+'}$').test(this);
}
//判断一个合法的用户名 即由6-16位字母、数字及下划线组成
String.prototype.validatePassword=function(start,end){
   return new RegExp('^\\w{'+start+','+end+'}$').test(this);
}
