------------2017.1.16------------------------
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
	
-------------------------2017.1.17 ����----------------------------------------
	1.���DpmsSysUser.hbm.xml�ļ�
	2.����dao��service java�ļ�	
	
------------------------2017.1.18 ����-------------------------------------------
	1.�޸�pom.xml�ļ�ʹspring����ͨ��
		����ԭ��²⣺jar���汾��ͻ
		�޸�����:
		struts2:2.3.28.1
		hibernate:4.2.21.Final
		Spring:4.2.5.RELEASE
		
------------------------2017.1.18 ����----------------------------------------------
	����applicationContext.xml
	����hibernate.cfg.xml
	����db.properties
	����log4j��properties
	���⣺����Hibernate���ݿ����Ӳ���
	
------------------------2017.1.19 ����----------------------------------------------
	1.���hibernate���ݿ����Ӳ��ϵ����⣺
		ԭ������������ڲ����ļ����ȼ���hibernate.cfg.xml�����application.xml�������ݿ�������������IOC����������Դ�еģ����Ե���ʼ���޷��������ݿ�
	2.ʹ��hibernate�������ݿⲢ������
		���⣺hibernate��SessionFactory����ʧ��
			ԭ��������ڶ�ȡ�����ļ�ʱ������application.xml���Ѿ�������sessionFactory,����Ӧ��ͨ����ȡbean�ķ�ʽ��ȡsessionFactory������ٻ�ȡһ��
			hibernate.cfg.xml�����ڴ������ļ���Ϣ��ȫ�������������ݿ�ʧ��
-----------------------2017.1.19 ����-----------------------------------------------
	1.����struts.xml
	2.��Web.xml�����Struts��������
	3.����Ŀ������Apache8���������ɹ�
		����:������Ŀʱ�޷�����log4j����־
		ԭ�������������־��д��Ҫ����ԱȨ�ޣ���������Eclipse���ѹ���Ա�������
	����������ɵ�¼����,������¼����������ȹ���
----------------------2017.1.20 ����--------------------------------------------
	1.���LoginAction����д,��֤��ͼƬ������
		���⣺hibernate��ѯ���ݿ�ֵ������������
			ԭ������������ڲ�����δ���action ����beanδ���أ���Ҫ��������
					IDpmsSysUserService dpmsSysUserService=(IDpmsSysUserService)context.getBean("dpmsSysUserService");
----------------------2017.1.20 ����------------------------------------------
	1.��ɵ�¼����Ĳ���
	
----------------------2017.1.22 ����-----------------------------------
	1.��ɵ�¼���������֤
	2.����ajax
	���⣺ajax����jsonδ���
---------------------2017.1.23 ����------------------------------------
	1.���json���ݶ�ȡ
	2.������ĿĿ¼�ܹ�
	3.�ϴ���֤��ͼƬ
	��������:��¼��֤
---------------------2017.1.23 ����-----------------------------------------
	1.��������֤���action���ϵ�SysAction��
	2.��¼��֤����
	3.ǰ��̨������֤����תҳ��
	�������⣺form���ύsubmit��button���ã��������ݴ������