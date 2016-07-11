function scaleDropDownChoices() {
	$.each($('.btn-group.dropdownchoice'), function(index, element) {
		var choice = $(element);
		var links = $('.dropdown-menu li', choice);
		var maxWidth = 0;
		for (var i = 0; i < links.length; i++) {
			var curWidth = $(links[i]).width();
			maxWidth = Math.max(maxWidth, curWidth);
		}
		$('.selection', choice).width(maxWidth);
		$('.dropdown-menu', choice).attr("style", "");
	});
}
