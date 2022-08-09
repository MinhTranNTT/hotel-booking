$(document).ready(function() {
	initLoading();
});

var initLoading() {
	loadListCalendar();
}


var loadListCalendar = function(showLoading) {
	var params = {};
    params.startDate = $('').val();
    params.endDate   = $('').val(); 
    params.isShowLoading = showLoading;
    params.limit = RANK_TOP_10;
    FunctionA('hotel-sales-rank-table', paramsChart);
}



