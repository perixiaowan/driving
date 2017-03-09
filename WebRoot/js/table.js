$(document).ready(function() {
	$(".mytable tr").mouseover(function() {
		// 鼠标移动到class为stripe的tr上时，执行函数
		$(this).addClass("over");
	})
	// 添加class值为over
	.mouseout(function() {
		// 鼠标移出的时候执行
		$(this).removeClass("over");
	});
	// 移除classover
	$(".mytable tr:even").addClass("alt");
	// 偶数行添加class值alt
});