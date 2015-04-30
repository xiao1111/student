<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="../../user/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="../../user/css/style.css" />
		<link rel="stylesheet" type="text/css" href="../../user/css/animate-custom.css" />
    </head>
    <body>
        <div class="container">
            <!-- Codrops top bar -->
             <div class="codrops-top">
                <a href="../../user/jsp/register.jsp">
                    <strong>&laquo; 返回用户登录 </strong>
                </a>
                <div class="clr"></div>
            </div><!--/ Codrops top bar -->
            <header>
                <h1>新生<span>入学指南系统</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                             <form  action="../YZ5" name="YZ5" method="post" autocomplete="on">
                                <h1>管理员登录</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 用户名： </label>
                                    <input id="username" name="username" required="required" type="text" placeholder="请输入你的用户名" maxlength="12"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> 密码： </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="请输入你的密码" maxlength="12" /> 
                                </p>
                                <p class="login button"> 
                                    <input type="submit" value="登录" /> 
								</p>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>