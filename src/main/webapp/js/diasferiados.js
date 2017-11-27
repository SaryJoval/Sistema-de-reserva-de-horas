var disabledDays = ["2017-12-19", "2017-12-25"];
function disableAllTheseDays(date) {
	var m = date.getMonth(), d = date.getDate(), y = date.getFullYear();
	for (i = 0; i < disabledDays.length; i++) {
		if ($.inArray(y + '-' + (m + 1) + '-' + d, disabledDays) != -1) {
			return [ false ];
		}
	}
	return [ true ];
}

//beforeShowDay="disableAllTheseDays"