package com.xinhua.manage.system.login.action;



import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.xinhua.log.model.Loggers;
import com.xinhua.manage.system.login.service.UserLoginService;
import com.xinhua.manage.system.user.model.TDrivingUser;
import com.xinhua.manage.system.user.model.TDrivingUserGroup;
import com.xinhua.util.Util;
import com.xinhua.util.action.UtilBaseAction;


@ParentPackage("struts-default")
@Namespace("/login")
@Action("login")
@Results({
		@Result(name = "success", location = "/drivingschool/homepage/homepage.jsp"),
		@Result(name = "input", location = "/drivingschool/login.jsp"),
		@Result(name = "image", location = "/drivingschool/image.jsp"),
		@Result(name = "error", location = "error.jsp"),
		@Result(name = "logout", type="redirect", location = "/drivingschool/login.jsp")
})
@SuppressWarnings("all")

public class LoginAction extends UtilBaseAction{
	
		private String username;		//用户名
		private String userpassword;	//密码
		
		private TDrivingUserGroup userGroup;
		private String rand;			//验证码
		
		private UserLoginService userLoginService;
		
		/**
		 * 刷新（点击）图片获得新的验证码
		 * @return 
		 */
		public String image(){
			return "image";
		}
		
		/**
		 * 管理用户登录
		 * @return
		 */
		public String userLogin(){

			
			TDrivingUser sessionUser = null;
			if(null != contextPvd.getSessionAttr(Util.SECCION_CLIENT_USER)){
				try {
					user = userLoginService.userLogin(username, userpassword);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sessionUser = (TDrivingUser)this.contextPvd.getSessionAttr(Util.SECCION_CLIENT_USER);
				user = sessionUser;
				if(sessionUser != null){//用户尚未退出
					return SUCCESS;
				}
			}
			/*判断是否从修改页面过来，若是则不让验证验证码*/
			String sessionRand = "";
			if(contextPvd.getSessionAttr("rand") != null){
				sessionRand = contextPvd.getSessionAttr("rand").toString();
			}
			
			
			
			if(null == rand || !rand.trim().equalsIgnoreCase(sessionRand)){
				this.addActionError("验证码错误，请重新输入！");
				return INPUT;
			}
			try {
				
				//通过用户名和密码来获得用户对象
				user = userLoginService.userLogin(username, userpassword);
				if(user != null && !"".equals(user)){ //判断所查的用户有没有
					this.contextPvd.setSessionAttr(Util.SECCION_CLIENT_USER, user);
					//用户操作保存到数据库
					Loggers.logToDB("用户登录成功", user.getId(), Util.LOGIN_IN);
					return SUCCESS;
				}else{
					this.addActionError("用户名不存在或密码错误！");
					return INPUT;
				}
			} catch (Exception e) {
				this.addActionError("用户名不存在或密码错误！");
				Loggers.error("-----UserLoginAction类userLogin方法错误:"+e.getMessage());
				e.printStackTrace();
			}
			return INPUT;
		}

		
		public String userSave(){
			try{
				System.out.println("用户开始保存！");
				userGroup = (TDrivingUserGroup) utilService.getObjectById(TDrivingUserGroup.class,2);
				user.setTDrivingUserGroup(userGroup);
				user.setIsDele(0);
				utilService.save(user);
				Loggers.logToDB("执行了用户注册操作", 0, Util.CREATE);
				return INPUT;
			}catch (Exception e) {
				Loggers.error("LoginAction类  userSave方法出错："+e.getMessage());
				e.printStackTrace();
			}
			return ERROR;	
		
		}
		
		
		public String userLogout() {
			HttpSession session = contextPvd.getSession();
			Integer userId = contextPvd.getSessionId(Util.SECCION_CLIENT_USER);
			if(userId != 0){
				Loggers.logToDB("用户退出成功",userId, Util.LOGIN_OUT);
			}
			session.removeAttribute(Util.SECCION_CLIENT_USER);
			//session.invalidate();
			return "logout";
		}
		

		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getUserpassword() {
			return userpassword;
		}

		public void setUserpassword(String userpassword) {
			this.userpassword = userpassword;
		}

		public String getRand() {
			return rand;
		}

		public void setRand(String rand) {
			this.rand = rand;
		}

		public UserLoginService getUserLoginService() {
			return userLoginService;
		}
		
		@Resource(name="userLoginService")
		public void setUserLoginService(UserLoginService userLoginService) {
			this.userLoginService = userLoginService;
		}

		public TDrivingUserGroup getUserGroup() {
			return userGroup;
		}

		public void setUserGroup(TDrivingUserGroup userGroup) {
			this.userGroup = userGroup;
		}
		
	/*	public String showArticleList(){
			try {
				int size = 10; // 单页记录条数
				int num = 1;// 当前页数
				int rowCount = 0;// 记录总数
				if(str_num != null && !"".equals(str_num)) {
					num = Integer.parseInt(str_num);
				}
				if (null != this.str_size && !"".equals(this.str_size)) {
					size = Integer.parseInt(this.str_size);
				}
				List<Param> params = new ArrayList<Param>();
				Param param1 = new Param("typeName","like",energytypeName.trim());
				params.add(param1);
				String orderStr = "d.ptime desc";//按ptime降序排列
				String[] objectMap = {"tlisttable"};
				rowCount = (Integer) utilService.getCollection("ArticleClass", null, orderStr, 0, 0,objectMap);
				Page page = new Page(size,num,rowCount);
				this.setPage(page);
				articleList = (List<ArticleClass>) utilService.getCollection("ArticleClass", null, orderStr,  page.getStartRow(), page.getSize(),objectMap);
				return "news_list";
			} catch (Exception e) {
				Loggers.error("SpiderAction类  showArticleList方法出错："+e.getMessage());
				e.printStackTrace();
			}
			return ERROR;	
		}*/
		/*//增量查询
		public String incrementList(){
			try{
				if(null==newsTList){
					newsTList = new HashSet<TListClass>();
				}
				if(null == newsArticleList){ 
					newsArticleList = new HashSet<ArticleClass>();
				}
				if(null == columnLinkDB) {
					columnLinkDB = new LinkDB();
				}
				if(null == articleLinkDB) {
					articleLinkDB = new LinkDB();
				}
				if(null==visitedColumnTId){
					visitedColumnTId = new HashSet<String>();
				}
				if(null==visitedArticleDocId){
					visitedArticleDocId = new HashSet<String>();
				}
				newsTList = spiderService.getTlistJson(newsTList,url,columnLinkDB,visitedColumnTId);
				newsArticleList = spiderService.getArticleListJson(newsTList,newsArticleList,columnLinkDB,articleLinkDB,visitedArticleDocId);
				return "index";                
			}catch (Exception e) {
				Loggers.error("SpiderAction类crawlerList方法出错："+e.getMessage());
				e.printStackTrace();
			}
			return ERROR;
			
		}*/
		
		

}
