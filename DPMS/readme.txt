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
--------------------2017.1.24 上午-------------------------------------
	1.添加邮箱验证
--------------------2017.1.25 下午---------------------------------
	1.尝试使用Dialog对话框，放弃
	2.添加发送邮箱页面
	3.完成邮件发送
	4.完成忘记密码功能
	明天任务：添加密码加密、完成首次修改密码后自行修改密码的功能
-------------------2017.1.26 上午-----------------------------
	1.添加用户名唯一约束
	2.添加密码入库加密
	3.添加修改密码页面，完成页面级验证
	4.将所有检查类验证action整合为一个
-------------------2017.1.26 下午----------------------------
	1.修正登录界面提示bug
	2.添加session为接下来做准备
	3.完成修改密码功能的前后台交互
	
	至此：页面登录功能全部完成测试并通过，完成第一个里程碑
	
	
-------------------------第二个里程碑 完成系统用户模块-------------------------
-------------------------2017.2.4 上午---------------------
	1.添加登录和修改密码的过滤器，保证其他页面必须登录后访问，而登录和修改密码不需要
	下午任务:
		搭建root首页布局
-------------------------2017.2.4 下午-----------------------
	1.完成用户管理页面基本布局
-------------------------2017.2.6 上午---------------------
	1.页面显示数据
	2.部分分页代码
	3.完成分页
-------------------------2017.2.7 上午-----------------------
	1.添加删除数据选框
	2.完善页面布局
	3.添加按用户名查询功能
	3.添加选中数据样式(未完成)
------------------------2017.2.8 上午-----------------------
	任务：完成修改信息页面	
	1.配置完事务属性
	工作原因，未完成。
	周六做
------------------------2017.2.12 ------------------------
	1.完成选中时改变对应行的样式
	2.部分完成修改页面样式
	下星期完成布局
------------------------2017.2.15 ------------------------
	1.完成修改页面
	2.添加添加页面代码
	3.修改用户信息页面的布局
	接下来完成添加页面相关操作
-----------------------2017.2.16 ----------------------------
	1.修改页面整改，绑定相关action
	2.尝试修复调用hibernate的update方法失效的问题，失败
	3.改用hql更新
-----------------------2017.2.17 ---------------------------
	1.完成详情修改页面的相关验证
-----------------------2017.2.23-----------------------
	1.完成系统用户添加功能
	2.完成系统用户修改页面
	3.添加页面添加验证用户名是否存在功能
	4.调整系统用户模块页面目录
-----------------------2017.2.24----------------------
	1.修复系统用户添加页面bug
----------------------至此 第二个里程碑完成-----------------------------

--------------------------------------第三里程碑  楼盘信息管理模块-------------------------------------

-----------------------2017.3.7-----------------------------------
	1.修改系统用户管理访问action名字
	2.添加楼盘管理bean及对应hibernate文件
	3.搭建楼盘信息管理模块的框架
	4.测试完成楼盘信息管理模块的分页查询
	
----------------------2017.3.12----------------------------------
	1.楼盘管理页面显示
	2.完成楼盘信息修改页面

---------------------2017.3.13----------------------------------
	1.完成添加楼盘信息页面
	2.添加主页面通过楼盘编号搜索功能
	3.完成检查重复性功能
	4.完成添加楼盘信息操作
	5.完成修改楼盘信息功能
	
--------------------2017.3.14--------------------------------
	1.完成楼盘信息删除功能

---------------------至此完成第三个里程碑------------------------------

---------------------------------第四里程碑  住户信息管理模块-----------------------

	1.创建住户信息管理模块目录结构
	
--------------------2017.3.15---------------------------
	1.创建用户信息表
	2.创建填充service，dao代码
	3.完成用户信息分页查询功能
	4.添加展示用户信息页面代码
	遇到问题：
		分页越界
-------------------2017.3.16-----------------------
	1.修复分页显示bug
	2.修复越界问题
	3.添加住户信息修改页面
	4.完成修改功能
	5.完成按户主名称搜索功能
	6.为已完成的模块添加查询结果页面，修复查询结果分页bug
	7.完成删除功能
-----------------2017.3.17----------------------
	1.添加住户信息添加页面
	2.完成房间级联查询
	3.完成验证房间合理性
	4.完成添加功能
--------------------至此完成第四个里程碑------------------

--------------------2017.3.20----------------------
--------------------第五个里程碑 投诉管理模块------------------
	1.建立目录结构
	2.添加框架代码
	3.建立投诉信息bean
	4.在住户信息中添加一对多关联
	5.测试添加功能
	6.修改查询功能bug
	7.测试查询功能，完成查询功能
--------------------2017.3.21-------------------
	1.添加投诉时间和是否处理字段
	2.添加显示页面
	3.完成分页查询显示
	4.尝试修改table显示风格，未能完成
	5.增加显示详情页面
	6.完成通过id显示详情功能
	7.完成修改功能
	8.添加查询页面
	9.完成查询功能
	10.完成删除功能
	
------------------2017.3.22--------------
	1.添加增加方法
	2.将查询所属的楼栋等的方法移至SysAction
	
------------------2017.3.23--------------
	1.完成检查住户合法性功能
	2.建立添加页面
	3.完善添加功能，修复bug
	4.完成住户投诉信息管理
	5.增加备用电话字段并在页面增加输入框和显示
-----------------第五个里程碑完成-------------
--------------------------第六个里程碑   报修信息管理---------------------
	1.创建目录结构
	2.创建bean文件并加以映射
	3.配置spring的bean
	4.测试简易添加方法
	
---------------------2017.3.24-----------------------
	1.添加主页面
	2.添加分页查询功能
	3.添加查询页面
	4.完成查询功能
	5.将检查用户合法性修改为公用方法
	6.修复主页面显示bug
	7.增加添加页面
	8.完善添加功能
	10.添加显示详情功能
	11.添加详情页面
	12.完成修改功能
----------------------第六个里程碑完成---------------------------

--------------------2017.3.27-----------------------------
-------------------第七个里程碑 停车场信息管理----------------------------------
	1.创建目录结构
	2.创建bean文件
	3.配饰application。xml
	4.配置hibernate配置文件
	5.添加查找停车记录和历史记录方法
	6.向数据库插入测试数据
	7.测试分页查询方法
	8.修改显示页面按钮，分类显示
	9.修改查询方法，分别查询
	10.修改连接池大小
------------------2017.3.28-------------------------------
	1.增加离场方法
	2.添加户主表中车牌号字段
	3.将离场调用的js变为公用方法
	4.添加收费页面
	5.添加跳转到收费页面的方法
	6.设计收费算法
	7.完善收费算法
	8.完成收费功能
	
------------------2017.3.29-----------------------
	1.再次修正收费算法bug
	2.添加详情显示页面
	3.修复历史记录单位显示bug
	4.添加入库方法和页面
	5.修正离场时间显示格式
	6.修复收费计算bug
----------------2017.3.30------------------------
	1.修改查询方法返回类型
	2.修改调用的该方法的方法
	3.添加验证车牌方法
	4.添加删除方法
	5.修改部分页面删除后为重新加载该页面
---------------第七个里程碑完成---------------------

---------------2017.4.1-------------------
	1.添加个人信息修改页面
	2.添加上传照片前台代码
	3.完成图片上传功能
	4.将文件路径保存到数据库
	5.完成显示图片
---------------2017.4.5-----------------------
	1.添加跳转个人信息修改页面action
	2.修改个人信息的action改为异步
	3.修改修改密码方法，添加一个个人信息页面请求参数
	4.修改修改页面div的显示效果，添加密码验证
	5.修改图片显示效果
	6.为住户模块添加面积字段
	
------------------第八个里程碑 物业收费模块----------------
	1.添加收费项目bean
	2.添加收费记录bean
	3.搭建项目目录结构和文件结构
	4.在住户信息中添加关联收费记录映射
	5.添加spring映射文件
	6.添加分页查询方法
	7.分页查询action配置
	8.添加分页显示页面，完成分页显示
----------------2017.4.6-------------------
	1.添加页面，及相应需添加的字段，对收费标准进行拼接
	2.添加跳转
	3.添加通过项目名的查找方法
	3.验证项目名是否重复
---------------2017.4.7------------------
	1.完成添加
	2.添加显示详情方法
--------------2017.4.9------------------
	1.完成显示页面
	2.添加修改人和修改时间字段
	3.对收费周期所处于的两种场景(必要|非必要)做判断
	4.添加修改方法
	5.完成修改功能
	6.完成删除功能
--------------2017.4.10---------------------
	1.添加查询收费历史的方法
	2.主页面添加分情况(必要|非必要)跳转按钮
	3.添加显示收费列表
	4.完成收费列表显示功能
--------------2017.4.11-------------------
	1.完成比较项查询收费详情的方法
	2.在收费记录表中添加价格字段
	3.添加收费详情显示页面
	4.完成必要收费项收费
	5.查询用户时增加返回值(id,area)(checkHousehold);
	6.完成非必要的收费
	7.修复级联删除bug
	8.添加查询结果界面
	11.添加缴费记录显示页面及相关功能
	12.添加通过住户名查找缴费记录
	13.添加记录查询结果页面
	14.添加收费记录详情显示页面及功能
	15.统一跳转
---------------------完成项目所有功能点------------------

------------------2017.4.12-----------------------
	1.添加404和500错误页面
	2.添加系统级页面的标题和注脚
	3.每个页面添加显示头像的方法
	4.改造页面菜单显示顺序

-----------------2017.4.18 系统测试-----------------
	1.修复登录页面跳转修改密码页面bug
	2.修改拦截器拦截页面
	3.控制root跳转
---------------2017.4.19 -------------------------
	1.修复session设置bug
	2.添加页面通过session获取用户名
	3.修改资源访问路径为绝对路径
	4.修改拦截器，添加对css和js文件过滤
--------------2017.4.20--------------------------
	1.修复拦截器跳转bug
	2.添加注销功能
	3.删除错误页面的js文件
	4.对上传图片进行压缩
	5.页面上添加注销
	6.所有页面添加个人信息页面跳转
-------------2017.4.21------------------
	1.完善找回密码规则
	2.修复设置密码被拦截bug
	3.修改上传图片保存格式
	4.修复停车场信息删除bug
	5.修复删除系统用户bug
	
------------至此 基本完成系统测试-------------