------------2017.1.16--------------
	1.MavenĬ��JDK����(�޸�maven�İ�װĿ¼��setting�ļ�)��ʹ��WEB3.0
		Window->Preferences->maven->User setting->Global Setting
		1.1setting.xml�������
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
		 1.2�޸�web.xml
			 <web-app version="3.1"
	         xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd">
	2.��pom.xml�ļ����jar����
	3.���DpmsSysUser.java	