### 基础
	1. apache支持静态页
	2. tomcat支持动态的，比如servlet等
	3. 一般使用apache+tomcat的话，apache只是作为一个转发，对jsp的处理是由tomcat来处理的。
	4. apache可以支持php\cgi\perl。但是要使用java的话，你需要tomcat在apache后台支撑，将java请求由apache转发给tomcat处理。
	5. apache是web服务器,Tomcat是应用（java）服务器，它只是一个servlet(jsp也翻译成servlet)容器，可以认为是apache的扩展，但是可以独立于apache运行。  
### 相同点
	1. 两者都是apache组织开发的
	2. 两者都有HTTP服务的功能
	3. 两者都是免费的
### 不同点
	1. Apache是专门用了提供HTTP服务的，以及相关配置的（例如虚拟主机、URL转发等等）
	2. Tomcat是Apache组织在符合J2EE的JSP、Servlet标准下开发的一个JSP服务器    
### 不同点
	1. APACHE是一个web服务器环境程序，启用它可以作为web服务器使用，不过只支持静态网页。 但asp,php,cgi,jsp等动态网页的就不行
	2. 如果要在APACHE环境下运行jsp 的话，就需要一个解释器来执行jsp网页 ，而这个jsp解释器就是TOMCAT, 为什么还要JDK呢？因为jsp需要连接数据库的话就要jdk来提供连接数据库的驱程，所以要运行jsp的web服务器平台就需要APACHE+TOMCAT+JDK
### 整合的好处
	1. 如果客户端请求的是静态页面，则只需要Apache服务器响应请求
	2. 如果客户端请求动态页面，则是Tomcat服务器响应请求。因为jsp是服务器端解释代码的，这样整合就可以减少Tomcat的服务开销    
### 其他
    1.apache:侧重于http server
    2.tomcat:侧重于servlet引擎，如果以standalone方式运行，功能上与apache等效 ， 支持JSP，但对静态网页不太理想；
    3.apache是web服务器，tomcat是应用（java）服务器
    4.Tomcat只是一个servlet容器(jsp也可翻译成servlet)，可以认为是apache的扩展，但是tomcat可以独立于apache运行。换句话说，apache是一辆卡车，上面可以装一些东西如html等。但是不能装水，要装水必须要有容器（桶），而这个桶也可以不放在卡车上。










