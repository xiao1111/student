<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻发布</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'>
<!-- jQuery file -->
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var $ = jQuery.noConflict();
$(function() {
$('#tabsmenu').tabify();
$(".toggle_container").hide(); 
$(".trigger").click(function(){
	$(this).toggleClass("active").next().slideToggle("slow");
	return false;
});
});
</script>
</head>
<body>
<div id="panelwrap">
  	
	<div class="header">
    <div class="title"><a href="#">新生入学指南后台</a></div>
    
    <div class="header_right">欢迎 Admin, <a href="#" class="logout">退出</a> </div>
    
    <div class="menu">
    <ul>
    <li><a href="#">主页</a></li>
    <li><a href="#" class="selected">发布新消息</a></li>
    <li><a href="#">修改主页背景</a></li>
    <li><a href="#">修改主页内容</a></li>
    <li><a href="#">新生交流平台</a></li>
    <li><a href="#">维护个人信息</a></li>
    </ul>
    </div> 
    </div>         
                    
    <div class="center_content">  
 
    <div id="right_wrap">
    <div id="right_content">             
     <ul id="tabsmenu" class="tabsmenu">
        <li class="active"><a href="#tab1">发&nbsp布&nbsp新&nbsp消&nbsp息</a></li>
    </ul>
    <div id="tab1" class="tabcontent">
        <div class="form">
           <form  action="../../FBXW" name="FBXW" method="post" autocomplete="on">
            <div class="form_row">
            <label>标&nbsp&nbsp题:</label>
            <input type="text" class="form_input" name="title" />
            </div>
             
             <div class="form_row">
            <label>内&nbsp&nbsp容:</label>
            <textarea class="form_textarea" name="content"></textarea>
            </div>
            <div class="form_row">
            <input type="submit" class="form_submit" value="发布" />
            </div> 
            </form>
            <div class="clear"></div>
        </div>
    </div>
     </div>
     </div><!-- end of right content-->
                     
                    
    <div class="sidebar" id="sidebar">
    <h2>其他功能</h2>
    
        <ul>
            <li><a href="#" class="selected">管理员修改密码</a></li>
            <li><a href="#">.....</a></li>
            <li><a href="#">.....</a></li>
            <li><a href="#">.....</a></li>
            <li><a href="#">.....</a></li>
            <li><a href="#">.....</a></li>
        </ul>
    </div>             
    
    
    <div class="clear"></div>
    </div> <!--end of center_content-->
</div>

    	
</body>
</html>