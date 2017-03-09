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
    
    <title>首页</title>
	<link rel="stylesheet" href="<%=basePath%>css/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="<%=basePath%>css/bootstrap/flat-ui.css">
	<link rel="stylesheet" href="<%=basePath%>css/index.css">
	<%-- <link rel="stylesheet" href="<%=basePath%>css/bootstrap/bootstrap-theme.min.css"> --%>
	<script src="<%=basePath%>js/jquery-1.11.3.js"></script>
	<script src="<%=basePath%>js/bootstrap.min.js"></script>

    <script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/exporting.js"></script>
	<script src="<%=basePath%>js/index.js"></script>

	<script type="text/javascript">
		/* $('#myTabs a').click(function (e) {
		  e.preventDefault();
		  $(this).tab('show');
		}) */

		function formatTen(num) { 
			return num > 9 ? (num + "") : ("0" + num); 
		} 
		function formatDate(date) { 
			var year = date.getFullYear(); 
			var month = date.getMonth() + 1; 
			var day = date.getDate(); 
			var hour = date.getHours(); 
			var minute = date.getMinutes(); 
			var second = date.getSeconds(); 
			return year + "/" + formatTen(month) + "/" + formatTen(day) + " "+ formatTen(hour)+":"+minute+":"+second; 
		} 

		function reportShow(){
			$.ajax({
				url:"report/report!reportShow.action",
				dataType:"text",	
				async:false,
				success:(function(tmpdata){
				/* data.eval(); */
				console.log("data:"+tmpdata);
				
				var selfdata = eval(tmpdata);
			//	console.log("selfdata[0]:"+selfdata[0]);
				/* console.log("selfdata[0]:"+selfdata[0].forEach(function(){
					console.log(this)
				})); */
				/*var scorecategories = new Array();
				
				
				for(var i=0;i<selfdata[0].length;i++){
					 datearray = parseInt(selfdata[0][i].time,10); 
					 scorecategories.push(formatDate(new Date(datearray))); 
					scorecategories.push(selfdata[0][i]);
				}*/
				//console.log("scorecategories:"+scorecategories);
				console.log("selfdata[0]:"+selfdata[0]);
				console.log("selfdata[1]:"+selfdata[1]);
				/* var scorecategories = [1,2,3,4,5,6,7,8]; */
				var onedata =selfdata[0];
				var fourdata = selfdata[1];
				var scorecategories=new Array();
				if(selfdata[0].length>selfdata[1].length){
					for(var i=0;i<selfdata[0].length+1;i++){
						scorecategories[i]=i;
					}
				}
			
				/* 	alert("用户成绩展示成功！"); */
				$(function () {
				  $('#container').highcharts({
				      chart: {
				          type: 'spline'
				      },
				      title: {
				          text: '历史成绩曲线图'
				      },
				      subtitle: {
				          text: '包含用户所有的模拟成绩'
				      },
				      xAxis: {
				          type: 'category',
				          categories:scorecategories
				      },
				      yAxis: {
				          title: {
				              text: '分数（满分100）'
				          },
				          min: 0,
				          max:100,
				          minorGridLineWidth: 0,
				          gridLineWidth: 0,
				          alternateGridColor: null,
				          plotBands: [{ // Light air
				              from: 0,
				              to: 60,
				              color: 'rgba(255, 0, 0, 0.1)',
				              label: {
				                  text: '不及格',
				                  style: {
				                      color: '#606060'
				                  }
				              }
				          }, { // Light breeze
				              from: 60,
				              to: 80,
				              color: 'rgba(205, 201, 201, 0.1)',
				              label: {
				                  text: '及格',
				                  style: {
				                      color: '#606060'
				                  }
				              }
				          }, { // Gentle breeze
				              from: 80,
				              to: 90,
				              color: 'rgba(0, 139, 139, 0.1)',
				              label: {
				                  text: '良好',
				                  style: {
				                      color: '#606060'
				                  }
				              }
				          }, { // Fresh breeze
				              from: 90,
				              to: 100,
				              color: 'rgba(144, 238, 144, 0.1)',
				              label: {
				                  text: '优秀',
				                  style: {
				                      color: '#606060'
				                  }
				              }
				          }]
				      },
				      tooltip: {
				          valueSuffix: ' 分'
				      },
				      plotOptions: {
				          spline: {
				              lineWidth:6,
				              states: {
				                  hover: {
				                      lineWidth: 5
				                  }
				              },
				              marker: {
				                  enabled: true
				              },
				             // pointInterval: 3600000*24, // one hour
              				  //pointStart: Date.UTC(2015, 11, 1, 0, 0, 0)
              				  pointStart:1
				              
				          }
				      },
				      series: [{
				          name: '科目一',
				          data: onedata
				
				      },{
				      	 name: '科目四',
				         data: fourdata
				      }]
				      ,
				      navigation: {
				          menuItemStyle: {
				              fontSize: '10px'
				          }
				      }
				  });
				});				
				})
			});
		}
		

	</script>
	<%-- <script src="<%=basePath%>js/datashow.js"></script> --%>
  </head>
  
  <body>
  	<div class="top">
  		<%-- <div class="logo" align="center" style="width:50%">
  			<img src="<%=basePath%>images/homepage/logo.jpg">
  		</div> --%>
  		<div class="titlelist">
  		
  		
  			
  			
	      
  		</div>
  		<div class="minimenu">
  			<a onclick="" href="javascript:void(0)" target="_self">设为首页</a>|
	        <a onclick="" href="javascript:void(0)" target="_self">加入收藏</a>|
	        <a onclick="" href='<%=basePath%>login/login!userLogout.action' target="_self">退出</a>    
	        <div><label>欢迎您，${user.userName }!^_^</label></div> 
	        
  		</div>
 		
  	</div>
  	<div class="homepage_right">
	    <div> <!--  role="navigation" -->
	    	<ul id="myTabs" class="nav nav-tabs" role="tablist">
			  <li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">科目一</a></li>
			  <li role="presentation"><a href="#four"  role="tab" id="four-tab" data-toggle="tab" aria-controls="four">科目四</a></li>
	 		  <li role="presentation"><a href="#score"  role="tab" id="score-tab" data-toggle="tab" aria-controls="score" onclick="reportShow();">历史成绩展示</a></li>
	 		  <s:if test="user.TDrivingUserGroup.id==1">
	 		  	<li role="presentation"><a href="#title"  role="tab" id="title-tab" data-toggle="tab" aria-controls="title">试题列表</a></li>
  				
  			</s:if> 
			</ul>
	    </div> 
    
	    <div id="myTabContent" class="tab-content">
	      <div role="tabpanel" class="tab-pane fade in active" id="home" aria-labelledBy="home-tab">
	        
	        <div class="container">
	        	<div class="row demo-row">
			        <div class="col-xs-3">
			          <a href="#fakelink" class="btn btn-block btn-lg btn-info">专项练习</a>
			        </div>
			        <div class="col-xs-3">
			         
			          <a href="<%=basePath%>beginexam/beginexam!beginExam.action" class="btn btn-block btn-lg btn-danger" target="_blank" >模拟考试</a>
			        </div>
	      		</div>
		         <div class="row demo-row">
			        <div class="col-xs-3">
			          <a href="#fakelink" class="btn btn-block btn-lg btn-primary">章节练习</a>
			        </div>
			        <div class="col-xs-3">
			          <a href="#fakelink" target="_blank" class="btn btn-block btn-lg btn-warning">错题练习</a>
			        </div>
			    </div>
			    
      		</div>
	      </div>
	      <div role="tabpanel" class="tab-pane fade" id="four" aria-labelledBy="four-tab">
	        <div class="container">
		         <div class="row demo-row">
			        <div class="col-xs-3">
			          <a href="#fakelink" class="btn btn-block btn-lg btn-primary">章节练习</a>
			        </div>
			        <div class="col-xs-3">
			          <a href="#fakelink" target="_blank" class="btn btn-block btn-lg btn-warning">错题练习</a>
			        </div>
			    </div>
			    <div class="row demo-row">
			        <div class="col-xs-3">
			          <a href="#fakelink" class="btn btn-block btn-lg btn-info">专项练习</a>
			        </div>
			        <div class="col-xs-3">
			          <a href="<%=basePath%>beginexam/beginexam!beginfourExam.action" class="btn btn-block btn-lg btn-danger" target="_blank">模拟考试</a>
			        </div>
	      		</div> 
      		</div>
	      </div>
	      <div role="tabpanel" class="tab-pane fade" id="score" aria-labelledBy="score-tab">
	       
	        <div id="container" style="min-width:80%;height:80%"></div>
	      </div>
	      <div role="tabpanel" class="tab-pane fade" id="title" aria-labelledBy="title-tab">
		      	<div class="row demo-row">
			         <div class="col-xs-3">
					         
					          <a class="btn btn-block btn-lg btn-primary" href="<%=basePath%>exam/exam!choiceList.action" target="_self" >试题列表</a>
					 </div>
				</div>
	        	
	      </div>
	      
	    </div>

    </div>
   
  </body>
</html>
