/**
 * 
 */
		function googleClick(){
			var parent, ink, d, x, y;
			$(".circleBell").click(function(e){
				parent2 =  $(this).parent().parent();
				$('.ui-diagram-element').each(function(index) {
					$(this).toggleClass('inActiveLabel',true);
				})
				parent2.toggleClass('inActiveLabel');
//				$('.outerDiv').css('overflow', 'hidden');
				parent = $(this).parent();
				if(parent.find(".ink").length == 0)
					parent.prepend("<span class='ink'></span>");
				ink = parent.find(".ink");
				ink.removeClass("animate");
				if(!ink.height() && !ink.width())
				{
					d = Math.max(parent.outerWidth(), parent.outerHeight());
					ink.css({height: d, width: d});
				}
				x = e.pageX - parent.offset().left - ink.width()/2;
				y = e.pageY - parent.offset().top - ink.height()/2;
				ink.css({top: y+'px', left: x+'px'}).addClass("animate");
//				setTimeout(function(){$('.outerDiv').css('overflow', 'visible');}, 640)
			})
		}