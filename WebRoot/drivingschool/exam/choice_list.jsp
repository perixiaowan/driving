<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
    
    <title>试题列表</title>
    <link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=basePath%>css/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>css/bootstrap/flat-ui.css">
	<link rel="stylesheet" href="<%=basePath%>css/index.css">
	<%-- <link rel="stylesheet" href="<%=basePath%>css/bootstrap/bootstrap-theme.min.css"> --%>
	<script src="<%=basePath%>js/jquery-1.11.3.js"></script>
	<script src="<%=basePath%>js/bootstrap.min.js"></script>
	<script src="<%=basePath%>js/index.js"></script>
	<script src="<%=basePath%>plug-in-js/lhgdialog4.2.0/lhgdialog.min.js" type="text/javascript" ></script>
	<script type="text/javascript">
		$('#myTabs a').click(function (e) {
		  e.preventDefault();
		  $(this).tab('show');
		});
		
		function showchoice(ids){
			//var J = $.noConflict();
			
			lhgdialog({ 
				id:ids,
			    title:'信息查看',
			    content: 'url:<%=basePath%>exam/exam!choiceShow.action?ids='+ids, 
			    width:'750px',
			    hight:'500px',
			    min:false,
			    max:false,
			    lock:true,
			    cancelVal: '关闭',
    			cancel: true /*为true等价于function(){}*/
			});	
		}
		
		function showjudge(ids){
			//var J = $.noConflict();
			
			lhgdialog({ 
				id:ids,
			    title:'信息查看',
			    content: 'url:<%=basePath%>exam/exam!judgeShow.action?ids='+ids, 
			    width:'750px',
			    hight:'500px',
			    min:false,
			    max:false,
			    lock:true,
			    cancelVal: '关闭',
    			cancel: true /*为true等价于function(){}*/
			});	
		}
		
		
		function checkSelectAll(obj){
			var count = 0,countTrue = 0,countFalse= 0;
			
			$(".selectBox").each(function () {
				count++;
				console.log("checked:"+$(this).prop("checked"));
				if ($(this).prop("checked")){
					countTrue++;
				} else {
					countFalse++;
					$(".selectAll").prop("checked",true);
				}
			});
			if (count == countTrue){
				$(".selectAll").prop("checked",true);
				console.log("count1"+count);
				console.log("count1"+countTrue);
			} else {
				$(".selectAll").prop("checked",false);
				console.log("count2"+count);
				console.log("count2"+countTrue);
			}
		}
		
		function noSelectAll() {
			if ($(".selectAll").prop("checked")) {
				$(".selectBox").each(function() {
					$(this).prop("checked", true);
				});
			} else {
				$(".selectBox").each(function() {
					$(this).prop("checked", false);
				});
			}
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
		
		function getDeleteIds() {
			var ids = new Array();
			var deleteBox = $(".selectBox");
			var i = 0;
			console.log("deleteBox"+deleteBox);
			deleteBox.each(function() {
				if ($(this).prop("checked")) {
					ids[i] = $(this).val();
					i++;
				}
			});
			return ids;
		}
	
	
	</script>
	
	
		
	
  </head>
  
  <body>
  	<div class="top">
  		<div class="back_homepage"><h3><a href="<%=basePath%>login/login!userLogin.action">返回首页</a></h3></div>

  		<div class="minimenu">
  			<a onclick="" href="javascript:void(0)" target="_self">设为首页</a>|
	        <a onclick="" href="javascript:void(0)" target="_self">加入收藏</a>|
	        <a onclick="" href='<%=basePath%>login/login!userLogout.action' target="_self">退出</a>    
	        <div><label>欢迎您，${user.userName }!^_^</label></div> 
  		</div>
 		
  	</div>
  	<div>
	    <div> <!--  role="navigation" -->
	    	<ul id="myTabs" class="nav nav-tabs" role="tablist">
			  <li role="presentation" class="active"><a href="#choice" id="choice-tab" role="tab" data-toggle="tab" aria-controls="choice" aria-expanded="true">选择题列表</a></li>
			  <li role="presentation"><a href="#judge"  role="tab" id="judge-tab" data-toggle="tab" aria-controls="judge">判断题列表</a></li>
	 		  
			</ul>
	    </div> 
    
	    <div id="myTabContent" class="tab-content">
	      <div role="tabpanel" class="tab-pane fade in active" id="choice" aria-labelledBy="choice-tab">
	        
	        <div class="container">
	        	<table  border="0" cellpadding="0" cellspacing="0" class="table_info">
	        		<tr>
					    <th class="table_iconbutton">
					          <h1><input type="checkbox" id="checkbox" class="selectAll" onclick="noSelectAll()"/></h1><h2>全选</h2>
					        
					         <a href="<%=basePath%>exam/exam!choiceAdd.action">
					         	<h1><img src="<%=basePath%>images/title/tianjia_11.jpg" border="0"/></h1><h2>添加</h2>
					         </a>
					         
					         <a href="javascript:void(0)" onclick = "selectSubmit('<%=basePath%>exam/exam!choiceDel.action','将要删除题目信息，确定删除吗？')" >
	                           	<h1><img src="<%=basePath%>images/title/shanchu_13.jpg" /></h1><h2>删除</h2>
	                         </a>
					    </th>
					</tr>
					
					<tr>
					    <td id="table_show" style="display: block;width:100%" class="mytable">
					          <table border="0" align="center" cellpadding="0" cellspacing="0" class="table_list">
		                       	<tr>
		                       		<th>选择</th>
		                       		<th class="">序列</th>
		                       		<th class="">科目类型</th>
		                       		<th class="">题目</th>
		                    		<th class="">题目正确的人数</th>
		                    		<th class="">题目错误的人数</th>
		                    		<th class="">操作</th>
		                    	</tr>
		                       	<s:iterator value="choiceList1" var="item" status="x">
		                       		<tr>
		                       			<td align="center">
	                       					<input name="ids" id="deleteBox" class="selectBox" type="checkbox" onclick="checkSelectAll(this)" value="<s:property value="#item.id" />"/>
	                       				</td>
		                       			<td align="center">${x.index+1}</td>
		                       			<td align="center">
		                       				<s:if test="#item.examCatalog==1">	
		                       					科目一
		                       				</s:if>
		                       				<s:else>
		                       					科目四
		                       				</s:else>
		                       				
		                       			</td>
		                       			<td align="center">${item.examTitle}</td>

										<td align="center" class="">${item.examRightNum}</td>
		                       			<td align="center" class="">${item.examWrongNum}</td>
		                       			
		                       			<td align="center" class="">
		                       				<a href="javaScript:void(0);" onclick="javascript:showchoice(${item.id})">
			    								查看
			    							</a>
			    							<a href="<%=basePath%>exam/exam!choiceEdit.action?ids=${item.id}" >修改</a>
		                       			</td>
		                       		</tr>
		                       	</s:iterator>
		                    </table>
					      </td>
					  </tr>
					</table>
      			</div>
	      </div>
	      <div role="tabpanel" class="tab-pane fade" id="judge" aria-labelledBy="judge-tab">
	        <div class="container">
		        <table  border="0" cellpadding="0" cellspacing="0" class="table_info">
	        		<tr>
					    <th class="table_iconbutton">
					          <h1><input type="checkbox" id="checkbox" class="selectAll" onclick="noSelectAll()"/></h1><h2>全选</h2>
					        
					         <a href="<%=basePath%>exam/exam!judgeAdd.action">
					         	<h1><img src="<%=basePath%>images/title/tianjia_11.jpg" border="0"/></h1><h2>添加</h2>
					         </a>
					         
					         <a href="javascript:void(0)" onclick = "selectSubmit('<%=basePath%>exam/exam!judgeDel.action','将要删除题目信息，确定删除吗？')" >
	                           	<h1><img src="<%=basePath%>images/title/shanchu_13.jpg" /></h1><h2>删除</h2>
	                         </a>
					    </th>
					</tr>
					
					<tr>
					    <td id="table_show" style="display: block;width:100%" class="mytable">
					          <table border="0" align="center" cellpadding="0" cellspacing="0" class="table_list">
		                       	<tr>
		                       		<th>选择</th>
		                       		<th class="">序列</th>
		                       		<th class="">科目类型</th>
		                       		<th class="">题目</th>
		                       		<th class="">答案</th>
		                    		<th class="">题目正确的人数</th>
		                    		<th class="">题目错误的人数</th>
		                    		<th class="">操作</th>
		                    	</tr>
		                       	<s:iterator value="judgeList1" var="item" status="x">
		                       		<tr>
		                       			<td align="center">
	                       					<input name="ids" id="deleteBox" class="selectBox" type="checkbox" onclick="checkSelectAll(this)" value="<s:property value="#item.id" />"/>
	                       				</td>
		                       			<td align="center">${x.index+1}</td>
		                       			<td align="center">
		                       				<s:if test="#item.examCatalog==1">	
		                       					科目一
		                       				</s:if>
		                       				<s:else>
		                       					科目四
		                       				</s:else>
		                       				
		                       			</td>
		                       			<td align="center">${item.examTitle}</td>
		                       			<td align="center">${item.examAnswer }</td>
										<td align="center" class="">${item.examRightNum}</td>
		                       			<td align="center" class="">${item.examWrongNum}</td>
		                       			<td align="center" class="">
		                       				<a href="javaScript:void(0);" onclick="javascript:showjudge(${item.id})">
			    								查看
			    							</a>
			    							<a href="<%=basePath%>exam/exam!judgeEdit.action?ids=${item.id}" >修改</a>
		                       			</td>
		                       		</tr>
		                       	</s:iterator>
		                    </table>
					      </td>
					  </tr>
					</table>
      		</div>
	      </div>

	    </div>

    </div>
   
  </body>
</html>
