var chenxk_browser = {
    versions: function () {
        var u = navigator.userAgent, app = navigator.appVersion;
        return {         //移动终端浏览器版本信息
            trident: u.indexOf('Trident') > -1, //IE内核
            presto: u.indexOf('Presto') > -1, //opera内核
            webKit: u.indexOf('AppleWebKit') > -1, //<a
                                                   // href="https://www.baidu.com/s?wd=%E8%8B%B9%E6%9E%9C&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1dBrHIWnvN9n1bLPHI-nHf0mv4YUWYYPj01rHD3n7qWTZc0IgF_5y9YIZ0lQzqlpA-bmyt8mh7GuZR8mvqVQL7dugPYpyq8Q1cknHm4rjf3PWnLn1bkPH64PjT"
                                                   // target="_blank" class="baidu-highlight">苹果</a>、<a
                                                   // href="https://www.baidu.com/s?wd=%E8%B0%B7%E6%AD%8C&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1dBrHIWnvN9n1bLPHI-nHf0mv4YUWYYPj01rHD3n7qWTZc0IgF_5y9YIZ0lQzqlpA-bmyt8mh7GuZR8mvqVQL7dugPYpyq8Q1cknHm4rjf3PWnLn1bkPH64PjT"
                                                   // target="_blank" class="baidu-highlight">谷歌</a>内核
            gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //<a
                                                                        // href="https://www.baidu.com/s?wd=%E7%81%AB%E7%8B%90&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1dBrHIWnvN9n1bLPHI-nHf0mv4YUWYYPj01rHD3n7qWTZc0IgF_5y9YIZ0lQzqlpA-bmyt8mh7GuZR8mvqVQL7dugPYpyq8Q1cknHm4rjf3PWnLn1bkPH64PjT"
                                                                        // target="_blank" class="baidu-highlight">火狐</a>内核
            mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
            ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
            android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或<a
                                                                           // href="https://www.baidu.com/s?wd=uc%E6%B5%8F%E8%A7%88%E5%99%A8&tn=44039180_cpr&fenlei=mv6quAkxTZn0IZRqIHckPjm4nH00T1dBrHIWnvN9n1bLPHI-nHf0mv4YUWYYPj01rHD3n7qWTZc0IgF_5y9YIZ0lQzqlpA-bmyt8mh7GuZR8mvqVQL7dugPYpyq8Q1cknHm4rjf3PWnLn1bkPH64PjT"
                                                                           // target="_blank" class="baidu-highlight">uc浏览器</a>
            iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器
            iPad: u.indexOf('iPad') > -1, //是否iPad
            webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
        };
    }(),
    language: (navigator.browserLanguage || navigator.language).toLowerCase()
};

$.extend({
    doAjaxPostCall: function (actionName, data, callback) {//ajax请求
        $.ajax({
            url: $.getServerURL(actionName),
            type: "post",
            dataType: "json",
            //async: false,
            data: data,
            timeout: 60000
        }).done(function (json) {
            callback && callback.call(this, json);
        }).fail(function (jqXHR, textStatus, errorThrown) {
            $.stopLoading();
            $.doAlert(textStatus);
            console.log("jqXHR:" + jqXHR);
            console.log("textStatus:" + textStatus);
            console.log("errorThrown:" + errorThrown);

        });

    },

    doCallLocal: function (cmd) {
        //alert(cmd);
        console.log(cmd);
        //alert(str);
        if (chenxk_browser.versions.ios) {
            document.location = cmd;
        } else if (chenxk_browser.versions.android) {
            callfun.open(cmd);
        }
    },

    doOpenDlg: function (url, urlData, nativeData) {
        var str = 'opendlg://arg?htmlref=' + url + "?";
        if (urlData.length > 0) {
            urlData += '&';
        }
        if (chenxk_browser.versions.ios) {
            urlData += 'DEVICETYPE=2';
        } else if (chenxk_browser.versions.android) {
            urlData += 'DEVICETYPE=1';
        }
        //alert(urlData);
        var cmd = str + urlData.replace(/=/g, 'shanghaitrust1111').replace(/&/g, 'shanghaitrust2222') + '&' + nativeData;
        $.doCallLocal(cmd);

    },
    doOpenComwebview: function (url, urlData, nativeData) {
        var cmd = 'opencomwebview://arg?htmlref=' + url + "?";
        if (urlData.length > 0) {
            urlData += '&';
        }
        if (chenxk_browser.versions.ios) {
            urlData += 'DEVICETYPE=2';
        } else if (chenxk_browser.versions.android) {
            urlData += 'DEVICETYPE=1';
        }

        cmd = cmd + urlData.replace(/=/g, 'shanghaitrust1111').replace(/&/g, 'shanghaitrust2222') + '&' + nativeData;
        $.doCallLocal(cmd);


    },
    doOpenSimpleview: function (url, urlData, nativeData) {
        var cmd = 'opensimpleview://arg?htmlref=' + url + "?";
        if (urlData.length > 0) {
            urlData += '&';
        }
        if (chenxk_browser.versions.ios) {
            urlData += 'DEVICETYPE=01';
        } else if (chenxk_browser.versions.android) {
            urlData += 'DEVICETYPE=02';
        }

        cmd = cmd + urlData.replace(/=/g, 'shanghaitrust1111').replace(/&/g, 'shanghaitrust2222') + '&' + nativeData;
        $.doCallLocal(cmd);
    },

    doLocalJSONP: function (actionName, data, callback, localCmd) {//ajax请求
        var dataconv = data.replace(/=/g, 'shanghaitrust1111').replace(/&/g, 'shanghaitrust2222');
        var cmd = 'jsonp://arg?htmlref=' + $.getServerURL(actionName) + '&getdatafun=' + callback;
        if (dataconv != null && dataconv.length > 0) {
            cmd += "&postdata=" + dataconv;
        }
        if (localCmd != null && localCmd.length > 0) {
            cmd += "&" + localCmd;
        }

        $.doCallLocal(cmd);

    },

    doAlert: function (message) {
        alert(message);
    },
    doConfirm: function (message) {
        confirm(message);

    },
    startLoading: function (message) {
        var loadingDiv = '<div id="loading" class="loading loading2"><div class="loadingBg"></div><div class="loadingImg"><img id="myLoadingImg" src="images/loading2.gif"></div></div>';

        //'<div id="loading" class="loading"><img src="../images/loading3.gif" /></div>';
        if ($("#loading").length < 1) {
            $("body").append(loadingDiv);
            //if($("#myLoadingImg").fileSize<=0){
            //	$("#myLoadingImg").attr("src","/images/loading2.gif");
            //}
        } else {
            $("#loading").css({"display": "block"});
        }
    },

    stopLoading: function () {
        $("#loading").css({"display": "none"});
        //var argv = {"sdf": "sdf"};
        //$.UILoading("hide");
        //$.hsDo("stopLoading",argv);
    },
    //js工具类
    mytools: {
        isEmpty: function (param) {
            if (param === 0) {
                return false;
            }

            if (null == param || "" == param) {

                return true;
            }

            return false;
        }
        ,
        isNullLen0Undefined: function (param) {

            if (null == param || "" == param.trim()) {

                return true;
            }

            if (param.trim().toLowerCase() == 'undefined') {
                return true;
            }

            return false;
        }
        ,
        transNullUndefined: function (param) {
            if (param == null || param.trim().toLowerCase() == 'undefined') {
                return '';
            }
            return param.trim();
        }
        ,
        parseLocationSearch: function () {//解析本地url为对象
            var queryObject = {};
            var locationSearch = decodeURI(window.location.search);
            if (locationSearch != '') {
                var pairs = locationSearch.substring(1).split('&');
                for (var i in pairs) {
                    var pair = pairs[i];
                    var keyAndValue = pair.split('=');
                    var key = keyAndValue[0];
                    var value = keyAndValue[1];
                    queryObject[key] = value;
                }
            }
            return queryObject;
        }
    }

})
;

var FORMATER = {
    CURRENCY_SYMBOL_MAP: {"CNY": '¥', 'USD': '$', 'HKD': 'HK$', 'EUR': '€', 'GBP': '￡'},
    outputmoney: function (number) {
        number = number.replace(/\,/g, "");
        if (isNaN(number) || number == "")
            return "0.00";
        number = Math.round(number * 100) / 100;
        if (number < 0)
            return '-' + FORMATER.outputdollars(Math.floor(Math.abs(number) - 0) + '')
                + FORMATER.outputcents(Math.abs(number) - 0);
        else
            return FORMATER.outputdollars(Math.floor(number - 0) + '')
                + FORMATER.outputcents(number - 0);
    },
//格式化金额
    outputdollars: function (number) {
        if (number.length <= 3)
            return (number == '' ? '0' : number);
        else {
            var mod = number.length % 3;
            var output = (mod == 0 ? '' : (number.substring(0, mod)));
            for (i = 0; i < Math.floor(number.length / 3); i++) {
                if ((mod == 0) && (i == 0))
                    output += number.substring(mod + 3 * i, mod + 3 * i + 3);
                else
                    output += ','
                        + number.substring(mod + 3 * i, mod + 3 * i + 3);
            }
            return (output);
        }
    },
    outputcents: function (amount) {
        amount = Math.round(((amount) - Math.floor(amount)) * 100);
        return (amount < 10 ? '.0' + amount : '.' + amount);
    }

};


/**
 * Created by chenxk on 2015/11/12.
 */
