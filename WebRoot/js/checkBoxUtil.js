
/*全选按钮的class属性为selectAll，待选择项的checkbox的class属性为selectBox*/
//获得要删除的id
//var deleFlag = false;
function getDeleteIds() {
	var ids = new Array();
	var deleteBox = $(".selectBox");
	var i = 0;
	deleteBox.each(function() {
		if ($(this).attr("checked")) {
			ids[i] = $(this).val();
			i++;
		}
	});
	return ids;
}
// 提交验证
/**
 * url 请求路径
 * totalRootCode 权限总和值
 */
function selectSubmit(url,title) {
	// 获得待删除的id
	var ids = getDeleteIds();
	if (ids.length > 0) {
		if(title == null || title == "" || title.length == 0){
			if (url.indexOf("?")>0){
				window.location.href = url + "&ids=" + ids + "&";
			}else {
				window.location.href = url + "?ids=" + ids + "&";
			}
		} else {
			if (confirm(title)) {
				if (url.indexOf("?")>0){
					window.location.href = url + "&ids=" + ids + "&";
				}else {
					window.location.href = url + "?ids=" + ids + "&";
				}
			}
		}
	} else {
		alert("未选择任何数据");
	}
}
// 全选
function noSelectAll() {
	if ($(".selectAll").attr("checked")) {
		$(".selectBox").each(function() {
			$(this).attr("checked", true);
		});
	} else {
		$(".selectBox").each(function() {
			$(this).attr("checked", false);
		});
	}
}

function checkSelectAll(obj){
	var count = 0,countTrue = 0,countFalse= 0;
	$(".selectBox").each(function () {
		count++;
		if ($(this).attr("checked")){
			countTrue++;
		} else {
			countFalse++;
			$(".selectAll").attr("checked",true);
		}
	});
	if (count == countTrue){
		$(".selectAll").attr("checked",true);
	} else {
		$(".selectAll").attr("checked",false);
	}
}