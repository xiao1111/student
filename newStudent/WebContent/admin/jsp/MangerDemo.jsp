<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<link href="../css/MangerDemo.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript">
			function change(b,c){
				var a = document.getElementById("frame");
				a.src = b;
				a.height = c;
			}
			
		</script>
		
		

</head>
<body>
<div class="top">
 <div style="width:960px; margin:0 auto">
  <table cellpadding="0" cellspacing="0">
  
  <tr height="10"><td width="60" align="left" valign="bottom">
  <td valign="middle" width="155" align="left"><a href="#"><img src="../images/logo.jpg" width="155" height="120"/></a></td>
  <td width="610">
      <div>
      <p style="font-size:30px; color:#933; padding-top:40px; font-weight:bold">大二郎图书购物后台管理中心</p>
      </div>
  </td>
  </tr>
  </table>
  </div>
</div>
<!--顶部logo 结束-->
<!--导航 开始-->
<div class="topnav">
   <div class="nav">
     <div class="nav-1">
       <a href="#" onclick="change('admin.jsp','600px')"><h2>首页</h1></a>
       <span></span>
       <a href="#" onclick="change('book.jsp','1200px')"><h2>图书管理</h2></a>
       <span></span>
       <a href="#" onclick="change('dd.jsp','800px')"><h2>订单管理</h2></a>
       <span></span>
       <a href="#" onclick="change('user.jsp','800px')"><h2>用户管理</h2></a>
       <span></span>
       <a href="#" onclick="change('message.jsp','800px')"><h2>用户留言</h2></a>
       <span></span>
      </div>
   </div>
</div>
<div class="d11_right'">
				<iframe id="frame" src="admin.jsp" height="600px" width="1370px" scrolling="no"  frameborder="no" ></iframe>
			</div>
 <div class="bottomnav"></div>
 <div class="bottom" style="padding:10px">
      <p align="center" style="color:#666666; line-height:23px">软件 -    版权所有 @</p>
      <p align="center"  style="color:#666666; line-height:23px">地 址：中山大学南方学院   联系电话：666666
      </br>   邮箱：daerlang@qq.com</p>
   </div>
</div>


</body>
</html>