	function selectAll(checkboxName) {
		var deleteVideo = document.getElementsByName(checkboxName);
		for(var i=0;i<deleteVideo.length;i++) {
		  if(!deleteVideo[i].disabled){
		    deleteVideo[i].checked=true;
		  }
		}
	}
	function selectReverse(checkboxName) {
		var deleteVideo = document.getElementsByName(checkboxName);			
		for(var i=0;i<deleteVideo.length;i++) {
		if(!deleteVideo[i].disabled){
		    deleteVideo[i].checked=!deleteVideo[i].checked;
		  }		
		}
	}
	function clearAll(checkboxName) {
		var deleteVideo = document.getElementsByName(checkboxName);			
		for(var i=0;i<deleteVideo.length;i++) {
			deleteVideo[i].checked= false;
		}
	}
	function checkAll(checkboxName,isdele) {
		var deleteVideo = document.getElementsByName(checkboxName);			
		var deleteVideoArray = new Array();
		var j=0;
    	var videoIds = "";
			
		for(var i=0;i<deleteVideo.length;i++) {
			if(deleteVideo[i].checked) {
				deleteVideoArray[j]=deleteVideo[i].value;
				j++;
			}
		}
		for(var i=0;i<deleteVideoArray.length;i++) {
			if(i!=deleteVideoArray.length-1) {
				videoIds+=deleteVideoArray[i]+",";
			}else {
				videoIds+=deleteVideoArray[i];
				break;
			}
		}
		if(videoIds == null || videoIds == ""){
			alert("请选择要操作的项!!");
			return false;
		}
		
		if(isdele == 1){
			var promptDele = confirm("删除后将不能再恢复，您确定删除以上选择吗？");
			if(promptDele){
				return true;
			}else{
				return false;
			}
		}else if(isdele == 2){
			var promptDele = confirm("您确定此操作吗？");
			if(promptDele){
				return true;
			}else{
				return false;
			}
		}else if(isdele == 3){
			var promptDele = confirm("删除后将不能再恢复，删除时请确保该文件未打开，您确定删除以上选择吗？");
			if(promptDele){
				return true;
			}else{
				return false;
			}
		}
	}
	function dAll(checkboxName,bhrf,isdele) {
		var deleteVideo = document.getElementsByName(checkboxName);			
		var deleteVideoArray = new Array();
		var j=0;
    	var videoIds = "";
			
		for(var i=0;i<deleteVideo.length;i++) {
			if(deleteVideo[i].checked) {
				deleteVideoArray[j]=deleteVideo[i].value;
				j++;
			}
		}
		for(var i=0;i<deleteVideoArray.length;i++) {
			if(i!=deleteVideoArray.length-1) {
				videoIds+=deleteVideoArray[i]+",";
			}else {
				videoIds+=deleteVideoArray[i];
				break;
			}
		}
		if(videoIds == null || videoIds == ""){
			alert("请选择要操作的项！");
			return ;
		}
		
		if(isdele == 1){
			var promptDele = confirm("删除后将不能再恢复，您确定删除以上选择吗？");
			if(!promptDele){
				return;
			}
			window.location.href=bhrf+videoIds;
		}else if(isdele == 2){
			var promptDele = confirm("您确定此操作吗？");
			if(!promptDele){
				return;
			}
			window.location.href=bhrf+videoIds;
		}
	}
	
	function Show(divid) {
		document.getElementById(divid).style.visibility = "visible"; 
	}
	function Hide(divid) {
		document.getElementById(divid).style.visibility = "hidden";
	} 