------------2017.1.16------------------------
	1.Maven默认JDK问题(修改maven的安装目录下setting文件)及使用WEB3.0
		Window->Preferences->maven->User setting->Global Setting
		1.1setting.xml添加内容
			<profile>
	
				<id>jdk-1.8</id>
				
				<activation>
				
					<activeByDefault>true</activeByDefault>
					
					<jdk>1.8</jdk>
				
				</activation>
				
				<properties>
				
				<maven.compiler.source>1.8</maven.compiler.source>
				
				<maven.compiler.target>1.8</maven.compiler.target>
				
				<maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
				
				</properties>
			
			</profile>
		 1.2修改web.xml
			 <web-app version="3.1"
	         xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd">
	2.向pom.xml文件添加jar依赖
	3.添加DpmsSysUser.java
	
-------------------------2017.1.17 上午----------------------------------------
	1.完成DpmsSysUser.hbm.xml文件
	2.创建dao及service java文件	
	
------------------------2017.1.18 上午-------------------------------------------
	1.修改pom.xml文件使spring测试通过
		问题原因猜测：jar包版本冲突
		修改如下:
		struts2:2.3.28.1
		hibernate:4.2.21.Final
		Spring:4.2.5.RELEASE
		
------------------------2017.1.18 下午----------------------------------------------
	配置applicationContext.xml
	配置hibernate.cfg.xml
	配置db.properties
	配置log4j。properties
	问题：测试Hibernate数据库连接不上
	
------------------------2017.1.19 上午----------------------------------------------
	1.解决hibernate数据库连接不上的问题：
		原因分析：由于在测试文件中先加载hibernate.cfg.xml后加载application.xml，而数据库连接是配置在IOC容器的数据源中的，所以导致始终无法连接数据库
	2.使用hibernate连接数据库并创建表
		问题：hibernate的SessionFactory创建失败
			原因分析：在读取配置文件时由于在application.xml中已经配置了sessionFactory,所以应该通过获取bean的方式获取sessionFactory，如果再获取一遍
			hibernate.cfg.xml会由于此配置文件信息不全而导致连接数据库失败
-----------------------2017.1.19 下午-----------------------------------------------
	1.配置struts.xml
	2.在Web.xml中添加Struts的拦截器
	3.将项目部署上Apache8，并启动成功
		问题:启动项目时无法加载log4j的日志
		原因分析：由于日志读写需要管理员权限，重新启动Eclipse并已管理员身份运行
	明日任务：完成登录界面,包括登录，忘记密码等功能
----------------------2017.1.20 上午--------------------------------------------
	1.完成LoginAction的书写,验证码图片的生成
		问题：hibernate查询数据空值报错（下午解决）
			原因分析：由于在测试中未添加action 所有bean未加载，需要单独加载
					IDpmsSysUserService dpmsSysUserService=(IDpmsSysUserService)context.getBean("dpmsSysUserService");
----------------------2017.1.20 下午------------------------------------------
	1.完成登录界面的布局
	
----------------------2017.1.22 下午-----------------------------------
	1.完成登录界面基础验证
	2.调用ajax
	问题：ajax返回json未完成
---------------------2017.1.23 上午------------------------------------
	1.完成json数据读取
	2.调整项目目录架构
	3.上传验证码图片
	下午任务:登录验证
---------------------2017.1.23 下午-----------------------------------------
	1.将生成验证码的action整合到SysAction中
	2.登录验证基础
	3.前后台交互验证，跳转页面
	遇到问题：form表单提交submit和button混用，导致数据传输出错