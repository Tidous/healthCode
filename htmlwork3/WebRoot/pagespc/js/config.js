$.extend({
    getServerURL: function (actionName) {
        if (actionName == null || actionName.trim() == '' || actionName.toLowerCase() == 'undefined') {
            actionName = '';
        }
        //return "http://5776920e23f5a.sh.cdb.myqcloud.com:4770/QiJian/" + actionName;
//        return "http://localhost:8080//QiJian/" + actionName;
        return "http://115.159.217.201:7001//QiJian/" + actionName;
    }

});

/**
 * Created by hujj on 2015/11/12.
 */
