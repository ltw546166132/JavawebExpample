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
