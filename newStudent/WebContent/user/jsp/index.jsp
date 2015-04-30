<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="../css/index.css" rel="stylesheet" type="text/css" />
		<link href="../css/nx.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/top.js"></script>	
	</head>

	<body>
		<center>	
			<div id="navigation" style="position:absolute;height:35px; background-color:#85AA7B;">
		    		<div class="sidelist">
			    		<span><h3><a href="../xm2?username=<% out.print((String)session.getAttribute("username")); %>" >
			    		<% 
			    			out.print((String)session.getAttribute("username"));
			    		%></a></h3></span>
					</div>
					<div class="sidelist">
			    		<span><h3><a href="exit.jsp">退出登录</a></h3></span>
					</div>
					<div class="sidelist1"><marquee hspace="50" ><b>欢迎光临！</b></marquee></div>
					<div class="sidelist2"><hr/></div>
			</div>
			
			<header>
				<div class="t1">
				
				</div>
				<div class="t2">
					<span><br/><i>2015年新生入学指南<sub>-中山大学南方学院</sub></i></span>
				</div>
			</header>
	
			<div class="d1">
				<div class="d11">
					<div class="c1" onmouseover="change()" >
						<img src="../image/baodao.jpg" />
					</div>
					<div class="c1">
						<img src="../image/data.jpg" />
					</div>
					<div class="c1">
						<img src="../image/jiaofei.jpg" />
					</div>
					<div class="c1">
						<img src="../image/junxun.jpg" />
					</div>
					<div class="c1">
						<img src="../image/zhusu.jpg" />
					</div>
				</div>
				
				<div class="d12">
					<iframe id="frame" src="xinwen.jsp" height="560px" width="830px" scrolling="no"  frameborder="no" ></iframe>
					
				</div>
				
				<div class="d13">
					<div class="c1" onmouseover="change()" >
						<img src="../image/album.jpg" />
					</div>
					<div class="c1">
						<img src="../image/tijian.jpg" />
					</div>
					<div class="c1">
						<img src="../image/laixiao.jpg" />
					</div>
					<div class="c1">
						<img src="../image/zhuyi.jpg" />
					</div>
					<div class="c1">
						<img src="../image/zixun.jpg" />
					</div>
				</div>
			</div>
			
			<footer>
				<hr/><br/>
				<span>办学地址：广州市从化温泉镇中山大学南方学院 邮政编码：510970</span></br>
				<span>招生监督电话：020-61787331 E-mail：nfzsb@mail.sysu.edu.cn</span></br>
				<span>CopyRight@中山大学南方学院招生宣传工作部.2006-2012</span>
			</footer>
		</center>
	</body>
</html>