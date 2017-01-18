------------2017.1.16--------------
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
	问题：测试Hibernate数据库连接不上