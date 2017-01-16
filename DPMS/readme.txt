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