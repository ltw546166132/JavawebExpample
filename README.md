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
例如：from表单中的action="Servlet相对路径"  或<a href="Servlet相对路径"></a>  或重定向时的request.sendRedirect("Servlet相对路径");
如果要写绝对路径时应写  /项目名/Servlet名
