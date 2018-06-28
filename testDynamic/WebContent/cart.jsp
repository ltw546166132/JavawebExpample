<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map" %> 
<%@page import="java.util.Set" %>
<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Map <String,Integer> map = (Map<String,Integer>)session.getAttribute("cart");
		if(map!=null){
		Set set = map.keySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			String key = (String)iterator.next();
			int number = map.get(key);
	%>		
			<h3><%=key %>数量为<%=number %></h3>
	<% 
			}
		}
	%>
	<a href="ClearCart">清空购物车</a>
</body>
</html>