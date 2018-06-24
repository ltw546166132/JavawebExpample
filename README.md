# JavawebExpample
JavaEE的相关知识项目事例

1,将项目打包到本地随便一个目录位置，然后用tomcat部署该项目
配置tomcat–找到tomcat的conf下的server.xml文件，并在标签内创建配置信息
path:启动项目后访问的项目名   对应的虚拟路径一定要以/打头
docBase:该项目的实际放置位置的路径，注意到项目名称这一级而不是文件夹名这一级。 
运行tomcat.步骤同上，然后在浏览器中访问该项目。 
你还可以在server.xml中配置你的端口号和项目名称，从而改变访问的url。

2.最简单，常见的部署方法，直接将war包放到tomcat的wabapp目录下，运行tomcat就行。
a. 把项目打包到wabapp目录下。
b.在bin目录下运行命令 startup.bat 启动项目。（在bin目录里按 shift+右键 即可调出命令框。关闭项目 shutdown.bat）
你放在wabapp下的所有项目就会自启动，自启动伴随着解压缩包的动作，启动完成后在wabapp下会看到解压后的项目文件夹。

Servlet (interface)
  |
GenericServlet
  |
HttpServlet

Servlet生命周期: init方法   service方法   destroy方法

init方法提前执行：在web.xml的<servlet>标签中加<load-on-startup>3</load-on-startup> :标签中间数字越小服务器越先初始化，一般从2开始不写负数

ServletContext获取资源文件：this.getServletContext():getRealPath(""); ->获取给定文件在服务器上的绝对路径
ServletContext获取资源文件的流对象: public InputStream getResourceAsStream(String path)

通过类的类对象加载Web资源为流对象
this.getClass().getClassLoader().getResourceAsStream("../../fileconfig.properties"); ->资源相对路径默认根目录为WEB-INF\classes下

请求Web项目中的Servlet时路径为相对路径
例如：from表单中的action="Servlet相对路径"  或 a标签中 href="Servlet相对路径"  或重定向时的request.sendRedirect("Servlet相对路径");
如果要写绝对路径时应写  /项目名/Servlet名

ServletContext何时创建?合适销毁?
服务器启动的时候会为每一个web应用程序创建一个ServletContext对象
从服务器移除托管，或者是关闭服务器

获得请求中的中文数据：
如果是GET请求  tomcat默认请求为ISO-8859-1解码
可直接在tomcat里面配制，以后get请求过来的数据永远都是 utf-8编码  ->tomcat里面conf/server.xml
<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>

下载文件请求头：
//让浏览器收到这份资源的时候，以下载的方式提示用户，而不是直接展示。
response.setHeader("Content-Disposition","attachment; filename="+fileName);
