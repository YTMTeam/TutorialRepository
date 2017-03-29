$(document).ready(function () {
	initializeCarousel();
});

function initializeCarousel() {
	var item_width = $('#butForm .sideButton').outerWidth() + 10;
	var max_left = $('#butForm').outerWidth() - $('#butWrap').outerWidth();
	if ($('#butForm').outerWidth() > $('#butWrap').outerWidth()) {
//		$('#rightArrow').show();
//		$('#leftArrow').show();
		$('#rightArrow').css('visibility', 'visible');
		$('#leftArrow').css('visibility', 'visible');
	} else {
//		$('#rightArrow').hide();
//		$('#leftArrow').hide();
		$('#rightArrow').css('visibility', 'hidden');
		$('#leftArrow').css('visibility', 'hidden');
	}
    $('#rightArrow').click(function () {
    	$('#leftArrow').removeClass("disabledArrow");
    	
        var left_indent = parseInt($('#butForm').css('left')) - item_width;
		if (left_indent + max_left < 0) {
			left_indent = -max_left;
			$('#rightArrow').addClass("disabledArrow");
		} else {
			$('#rightArrow').removeClass("disabledArrow");
		} 

        $('#butForm').animate({
            'left': left_indent
        }, {
            queue: false,
            duration: 500
        });
    });

   $('#leftArrow').click(function () {
	   	$('#rightArrow').removeClass("disabledArrow");
	   
        var left_indent = parseInt($('#butForm').css('left')) + item_width;

		if (left_indent > 0) {
			left_indent = 0;
			$('#leftArrow').addClass("disabledArrow");
		} else {
			$('#leftArrow').removeClass("disabledArrow");
		} 

        $('#butForm').animate({
            'left': left_indent
        }, {
            queue: false,
            duration: 500
        });

    });
}