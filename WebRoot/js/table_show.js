function chg(id_num){ 
	var basepath = getRootPath();
	var oa = document.getElementById(id_num); 
	var ob = document.getElementById("table_show_a"); 
	if(oa.style.display == "block"){ 
	oa.style.display = "none"; 
	ob.innerHTML = "<img src='"+basepath+"/images/right/dow.jpg'/>"; 
	}else{ 
	oa.style.display = "block"; 
	ob.innerHTML = "<img src='"+basepath+"/images/right/upp.jpg'/>"; 
	} 
	return false; 
} 

function chgtwo(id_num){ 
	var basepath = getRootPath();
	var oa = document.getElementById(id_num); 
	var ob = document.getElementById("table_show_b");
	if(oa.style.display == "block"){ 
	oa.style.display = "none"; 
	ob.innerHTML = "<img src='"+basepath+"/images/right/dow.jpg'/>"; 
	}else{ 
	oa.style.display = "block"; 
	ob.innerHTML = "<img src='"+basepath+"/images/right/upp.jpg'/>"; 
	} 
	return false; 
} 

function getRootPath() {
	var strFullPath = window.document.location.href;
	var strPath = window.document.location.pathname;
	var pos = strFullPath.indexOf(strPath);
	var prePath = strFullPath.substring(0, pos);
	var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
	return (prePath + postPath);
}