<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>用户注册页面</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/regedit.css" />
	<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
  </head>
  
  <body>
    <div class="top">
		<div class="logo">
			<a href="http://www.jxedt.com"> <img src="http://j2.58cdn.com.cn/jxedt/user/images/ulogo.png" alt="驾校一点通" class="mypngbg" /></a>
		</div>
		<div class="minimenu">
			<a onclick="SetHome(this,'http://www.jxedt.com/')"
				href="javascript:void(0)" target="_self"> 设为首页</a>|<a
				onclick=""
				href="javascript:void(0)" target="_self">加入收藏</a>
		</div>
	</div>
	
	
	
	<div class="main" align="center">
		<div class="register">
			<div class="right">
				<div class="title">
					<div class="bg">
						<h2>
							学员注册<span class="jiantou"></span>
						</h2>
					</div>
				</div>
				<div class="content">
					<div class="bg">
						<form name="myform" id="myFrm" action="login/login!userSave.action" method="post">
						<s:token />
						<div>
							<table border="0" cellpadding="5px" cellspacing="0" style="padding-left: 120px;">
								<tr>
									<th>
										用 户 名：
									</th>
									<td>
										<input type="text" name="user.userName" id="userName" value="" maxlength="25"
										 class="inputtxt2" />
									</td>
								</tr>
								<tr>
									<th>
										昵称：
									</th>
									<td>
										<input type="text" name="user.userNickname"
									id="userNickname" maxlength="20" class="inputtxt2"
									autocomplete="off" />
									</td>
									<td>
										<span id="nickname_info"></span>
									</td>
								</tr>
								
								<tr>
									<th>密码：</th>
									<td>
										<input type="password" name="user.userPassword"
									id="userPassword" class="inputtxt2" />
									</td>
								</tr>
								
								<tr>
									<th>确认密码：</th>
									<td>
										<input type="password" name="chkpassword" id="chkpassword" class="inputtxt2" />
									</td>
								</tr>
								
								<tr>
									<th>邮箱：</th>
									<td>
										<input class="inputtxt2" name="user.userEmail" id="userEmail" />
									</td>
								</tr>
								
								<tr>
									<th>手机号码：</th>
									<td>
										<input class="inputtxt2" id="userTelephone" name="user.userTelephone" />
									</td>
								</tr>
								
								<tr>
									<th>性别：</th>
									<td>
										<input type="radio" name="user.userSex" value="1">男 
										<input type="radio" name="user.userSex" value="0">女
									</td>
									<td><span id="gender_info"></span></td>
								</tr>
								
								<%--<tr>
									<th>地区：</th>
									<td>
										<select name="drivingUser.province" id="province" onchange="getcity(this.value,'city')">
											<option value="0">==省份==</option>
										</select>&nbsp;
										<select name="drivingUser.city" id="city" onchange="getcity(this.value,'area')">
											<option value="0">==城市==</option>
										</select>&nbsp;
										<select id="section" name="drivingUser.section">
											<option value="0">==区/县==</option>
										</select>
									</td>
									<td><span id="regarea_info"> </span></td>
								</tr>
								
								--%><%--<tr>
									<th></th>
									<td>
									
									<label>
										<input type="checkbox" checked="checked" name="agree" id="agree" style="vertical-align: middle" />&nbsp;我已阅读并接受
									</label>
									<a style="cursor: pointer" class="b s4" href="#">注册条款</a>
									</td>
								</tr>
								
								--%><tr>
									<th></th>
									<td>
										<input type="submit" class="btn_tijiao" value="提交" />
										<input type="button" class="btn_quxiao" onclick="javascript:window.history.go(-1)" value="取消" />
									</td>
								</tr>
							</table>
							</div>
						</form>
						<div style="width: 440px; 
							border-top: 1px solid #E1DFDF; 
							margin-left: 200px; text-align: center; 
							height: 38px; clear: both; padding-top: 10px; 
							padding-bottom: 20px">
							已经注册了？<a href="http://user.jxedt.com/home/login">点击登录</a>

						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	
	
  </body>
  
  
<%--<script type="type="text/javascript">
	function checknickname(obj) {
    ispass[9] = true;
    if (obj.value != "") {
        $$(msgids[9]).className = "loading";
        $$(msgids[9]).innerHTML = "正在检测...";
        var xx = new ajax;
        xx.pURI = "/inc/canusenickname";
        xx.pMethod = "get";
        xx.pAsyn = true;
        xx.pDate = "nickname=" + obj.value + "&rd=" + Math.random();
        xx.Request(function(xmlhttp) {
            if (xmlhttp.responseText != "1") {
                ispass[9] = false;
                $$(msgids[9]).className = "wrong";
                $$(msgids[9]).innerHTML = "对不起,您输入的昵称含有非法信息."
            } else {
                $$(msgids[9]).className = "correct";
                $$(msgids[9]).innerHTML = ""
            }
        })
    }
}
</script>
  
--%></html>
