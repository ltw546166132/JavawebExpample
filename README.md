# JavawebExpample
## JavaEE的相关知识项目事例

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

### Servlet生命周期: init方法 service方法 destroy方法

init方法提前执行：在web.xml的<servlet>标签中加<load-on-startup>3</load-on-startup> :标签中间数字越小服务器越先初始化，一般从2开始不写负数</br>

ServletContext获取资源文件：this.getServletContext():getRealPath(""); ->获取给定文件在服务器上的绝对路径</br>
ServletContext获取资源文件的流对象: public InputStream getResourceAsStream(String path)

通过类的类对象加载Web资源为流对象</br>
<pre><code>
this.getClass().getClassLoader().getResourceAsStream("../../fileconfig.properties"); ->资源相对路径默认根目录为WEB-INF\classes下
</code></pre>
请求Web项目中的Servlet时路径为相对路径</br>
例如：from表单中的action="Servlet相对路径"  或 a标签中 href="Servlet相对路径"  或重定向时的response.sendRedirect("Servlet相对路径");</br>
如果要写绝对路径时应写  /项目名/Servlet名

### ServletContext何时创建?合适销毁?
> 服务器启动的时候会为每一个web应用程序创建一个ServletContext对象</br>
> 从服务器移除托管，或者是关闭服务器

### 获得请求中的中文数据：
> 如果是GET请求  tomcat默认请求为ISO-8859-1解码</br>
> 可直接在tomcat里面配制，以后get请求过来的数据永远都是 utf-8编码  ->tomcat里面conf/server.xml</br>
```xml
<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>
```

### 下载文件响应头：
让浏览器收到这份资源的时候，以下载的方式提示用户，而不是直接展示。</br>
<pre><code>
  response.setHeader("Content-Disposition","attachment; filename="+fileName);
</code></pre>

### 响应头中文情况：
> IE,Chrome 需要对汉字进行utf-8编码   URLEncoder.encode("汉字...","UTF-8")
> Firefox需要对汉字进行base64编码

### response重定向和request请求转发</br>
<pre><code>
response.sendRedirect("Servlet相对路径");</br>
request.getRequestDispatcher("Servlet相对路径").forward(request,response);
</code></pre>

### Cookie:</br>
<pre><code>
response.addCookie(new Cookie("name", "aaaaa"));//添加Cookie</br>
cookie.setDomain(".ltw.com");    //用于指定只有请求了指定的域名，才会带上该Cookie</br>
cookie.setPath("/CookieDemo");    //只有访问该域名下的CookieDemo的这个路径地址才会带cookie</br>

Cookie[] cookies = request.getCookies();    //获取Cookie
</code></pre>

### Session
> 会话,Session是基于Cooick的一种会话机制。Cooick是服务器返回一小份数据给客户端，而且存放在客户端上。 Session是数据存放在服务端。</br>
* HttpSession常用api:<br>
<pre><code>
  HttpSession session = request.getSession();
  //得到会话ID
  session.getId();
  //存值
  session.setAttribute(name,value);
  //取值
  session.getAttribute(name);
  //移除值
  session.removeAttribute(name);
</code></pre>

* Session何时创建，何时销毁?

* 创建
> 如果有在servlet里面调用了 request.getSession()

* 销毁
> session是存放在服务器的内存中的一份数据。当然可以持久化，Redis,即使关了浏览器，session也不会销毁
> 1.关闭浏览器
> 2.session会话时间过期。有效期过了，默认有效期:30分钟

### JSP内置对象
<pre><code>
pageContext
request
session
application
out
exception
page
config
response
</code></pre>
> request,session,application,pageContext是作用域对象

### EL表达式
* EL操作四大域的内置对象：它们是Map类型
<pre><code>
  pageScope
  requestScope
  sessionScope
  applicationScope

  ${pageScope.user}：输出pageContext.getAttribute("user")
  ${requestScope.user}：输出request.getAttribute("user");
  ${sessionScope.user}：输出session.getAttribute("user");
  ${applicationScope.user}：输出application.getAttribute("user");
</code></pre>
* JavaBean导航
<pre><code>
  ${requestScope.emp.address.stree}等同于
  <%request.getAttribute("emp").getAddress().getStreet()%>

  操作JavaBean
  <%
  User user = new User();
  user.setUsername("zhangSan");
  user.setPassword("123");
  pageContext.setAttribute("user", user);
  %>
  ${pageScope.user.username}
  ${pageScope.user.password}
</code></pre>
