package com.xinhua.manage.task.job;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@SuppressWarnings("all")
public class TaskJob extends QuartzJobBean{
	
	private Connection getConnection(){
		try {
			Properties pro = new Properties();
			InputStream ipt = new FileInputStream(new File(this.getClass().getResource("/jdbc.properties").toURI()));
			pro.load(ipt);
			// 装入数据库特定的驱动器  
	        Class.forName(pro.getProperty("jdbc.driverClassName"));  
	        // 与数据库建立连接  
	        return (Connection)DriverManager.getConnection(pro.getProperty("jdbc.url"),pro.getProperty("jdbc.username"), pro.getProperty("jdbc.password"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	protected void executeInternal(JobExecutionContext arg0)throws JobExecutionException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		System.out.println(sdf.format(System.currentTimeMillis())+"任务调度开始!");
		Connection conn = this.getConnection();
		PreparedStatement pst = null;
		try {
			if (conn != null){
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新错误！");
		} finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
