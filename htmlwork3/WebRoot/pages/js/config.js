$.extend({
    getServerURL: function (actionName) {
        if (actionName == null || actionName.trim() == '' || actionName.toLowerCase() == 'undefined') {
            actionName = '';
        }
        //return "http://localhost:8080/QiJian/" + actionName;
        return "../QiJian/" + actionName;
    }

});

/**
 * Created by hujj on 2015/11/12.
 */
