function FunctionA(selectorID, params) {
    runAjaxGet(selectorID, params, '/abc/xyz');
}

function runAjaxGet(selectorID, params, URL) {
    $.ajax({
        url: URL,
        data: params,
        type: "GET",
        contentType: "application/json; charset=utf-8",
        async: true,
        cache: false,
        processData: true,
        success: function (data) {
            var date = params.date;
            if (date) {
	            $('#' + selectorID + ' .date').text(date);
            } else {
				var date2 = params.endDate || params.toDate;
	            var date1 = params.startDate || params.fromDate;
	            if (date1 && date2) {
        	    	$('#' + selectorID + ' .date').text(date1 + ' ~ ' + date2);
	            }
            }
            // date = moment(new Date()).format(DATE_FORMATTER);            
            $('#' + selectorID + ' tbody').html(data);
        },
        error: function (data) {
        },
        beforeSend: function() {
            if (params.isShowLoading) { showLoading(); }
        },
        complete: function() {
            if (params.isShowLoading) { hideLoading(); }
        }
    });
}

function showLoading(){
   /* $(".page-content").waitingLoadData({
        open: true,
        width: 56,
        bg: true
    });*/
}

function hideLoading(){
    /*$(".page-content").waitingLoadData({
        open: false
    });*/
}

function removeUrlParam(key, sourceURL) {
    var rtn = sourceURL.split("?")[0],
        param,
        params_arr = [],
        queryString = (sourceURL.indexOf("?") !== -1) ? sourceURL.split("?")[1] : "";
    if (queryString !== "") {
        params_arr = queryString.split("&");
        for (var i = params_arr.length - 1; i >= 0; i -= 1) {
            param = params_arr[i].split("=")[0];
            if (param === key) {
                params_arr.splice(i, 1);
            }
        }
        rtn = rtn + "?" + params_arr.join("&");
    }
    return rtn;
}

function replaceUrlParam(url, paramName, paramValue){
    var pattern = new RegExp('(\\?|\\&)('+paramName+'=).*?(&|$)');
    var newUrl=url;
    if(url.search(pattern)>=0){
        newUrl = url.replace(pattern,'$1$2' + paramValue + '$3');
    } else {
        newUrl = newUrl + (newUrl.indexOf('?')>0 ? '&' : '?') + paramName + '=' + paramValue;
    }
    return newUrl;
}