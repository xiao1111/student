<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<%
	Cookie c[] = request.getCookies();
	if(c != null){
		for(int i=0;i<c.length;i++){
			Cookie temp=c[i];
			if(temp.getName().equals("username") && (temp.getValue() != null)) 
			{ 
				session.setAttribute("username",temp.getValue());
				response.setHeader("Refresh","0;URL=user/jsp/index.jsp");
			}
			else{response.sendRedirect("user/html/index.html");}
		}
	}
	else{response.sendRedirect("user/html/index.html");}
%>
</body>
</html>
