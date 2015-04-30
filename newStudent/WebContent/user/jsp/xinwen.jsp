<%@ page language="java" contentType="text/html; charset=utf-8" import="util.test.db.*,util.test.bean.news.*,java.sql.*"
    pageEncoding="utf-8"%>
<%
	int i;
	ResultSet rs;
	//每页显示的记录数
	int pageSize = 20;
	//总页数
	int pageCount;
	//当前页码
	int pageCurrent;
	//总记录数
	int totalRecord;
	//临时变量，获得页面参数
	String pages;

	String sql = "SELECT * FROM information ORDER BY time ASC";
	pages = request.getParameter("page");
	if(pages == null)
		pageCurrent = 1;
	else
		{
			pageCurrent = Integer.parseInt(pages);
			//当前页码最小只能为1
			if(pageCurrent < 1)
				pageCurrent = 1;
		}
	//连接数据库
	Connection con = DbConnection.getConnection();
	Statement s = con.createStatement();
	
	rs = s.executeQuery(sql);
	//获取总记录数
	rs.last();
	totalRecord = rs.getRow();
	//计算总页数
	pageCount = ((totalRecord % pageSize == 0) ? (totalRecord /pageSize) : (totalRecord / pageSize)+1);
	
	if(pageCurrent > pageCount)
		pageCurrent = pageCount;
%>
<html>
<head>
<title>新闻列表</title>
<script type="text/javascript">
	
	function change(b){
		var a = document.getElementById(b);
		a.style.background = "#85AA7B";
	}
	function change1(b){
		var a = document.getElementById(b);
		a.style.background = "white";
	}
	function a(a){
		var a1 = document.getElementById(a);
		var b = document.getElementById("c");
		var d = document.getElementById("c"+a);
		if(a1.checked){b.value = parseInt(b.value,0) + parseInt(d.value,0);
		a1.value = d.name;}
		else{b.value = parseInt(b.value,0) - parseInt(d.value,0);
		a1.value = null;}
	}

</script>
<style type="text/css">
	*{margin:0px;padding:0px;}
	a{text-decoration:none;;
	display:block;width:50px;height:30px;float:left;
	height:32px;line-height:32px;font-size:14px;}
	.d{margin-left:30%;}
	.d1{width:200px;height:30px;float:left;line-height:32px;font-size:14px;}
	.d2{width:50px;height:30px;float:left;line-height:32px;font-size:14px;}
	.c1{width:100px;height:100px;float:left;}
	.c2{width:250px;height:100px;float:left;text-align:center;}
	td{border-color:#DCDCDC; border-style: solid;text-align:center;}
	tr{border-color:#DCDCDC; border-style: solid;}
	table{margin-top:20px;}
</style>

</head>
<body>
<center>
<hr color="#DCDCDC">
<table cellspacing="0px" cellpadding="0px"  border="1" >
<th width="630px">新闻标题</th><th width="200px">发布时间</th>
<%
	if( pageCount > 0)
	{
		//使ResultSet的指针定位到当前页的第一条记录
		rs.absolute((pageCurrent - 1) * pageSize + 1);
		//显示该记录
		i = 0;
		while( i < pageSize && ! rs.isAfterLast())
		{
%>
<tr>
<td width="150px"><%=rs.getString("title") %></td>
</td>
<td width="150px"><%=rs.getString("time") %></td>
</td>

</tr>
<%
		 rs.next();
		 i++;
		}
	}
%>
</table>
</br>
<div class="d">
<div class="d1">当前第<%=pageCurrent %>页，共<%=pageCount %>页  </div>
<%
//以下实现翻页
//如果当前页码大于1，则为“上一页”加链接
if(pageCurrent > 1)
{
%>
<a href="xinwen.jsp?page=<%=pageCurrent-1 %>">上一页</a>	
<% for(i=1;i<pageCount+1;i++){
%>
<a id="b<%=i%>" onmouseover="change('b<%=i%>')" onmouseout="change1('b<%=i%>')" href="xinwen.jsp?page=<%=i %>"><%=i %></a>
<% }%>
<%
}
else
{
%>
<div class="d2">上一页</div>
<% for(i=1;i<pageCount+1;i++){
%>
<a id="b<%=i+pageCount%>" onmouseover="change('b<%=i+pageCount%>')" onmouseout="change1('b<%=i+pageCount%>')" href="xinwen.jsp?page=<%=i %>"><%=i %></a>

<% }%>
<%
}
//如果当前页码小于总页数，则为“下一页”加链接
if(pageCurrent < pageCount)
{	
%>
<a href="xinwen.jsp?page=<%=pageCurrent+1 %>">下一页</a>
<%
}
else		
{
%>
<div class="d2">下一页</div>
<%
}
%>
</div>

<%
	//关闭连结
	rs.close();
	con.close();
%>
</center>
</body>
</html>
