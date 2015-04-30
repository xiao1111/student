<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<%
	session.removeAttribute("username");
	Cookie c[] = request.getCookies();
	if(c != null){
		for(int i=0;i<c.length;i++){
			Cookie temp=c[i];
			if(temp.getName().equals("username")) 
			{ 
				Cookie kill = new Cookie("username",null);
				kill.setMaxAge(0);
				kill.setPath("/");  //项目所有目录有效
				response.addCookie(kill);
			}
		}
	}
	response.sendRedirect("../html/index.html");
%>
</body>
</html>
