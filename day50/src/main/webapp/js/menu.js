$(function(){
	$('ul>li:eq(2)')
		//.click(function(){return false;})
		.mouseenter(function(){
			$(this).find('ol').show();
		})
		.mouseleave(function(){
			$(this).find('ol').hide();
		})
		;
});