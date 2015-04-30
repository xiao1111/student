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
        <link rel="stylesheet" type="text/css" href="../css/demo.css" />
        <link rel="stylesheet" type="text/css" href="../css/style.css" />
		<link rel="stylesheet" type="text/css" href="../css/animate-custom.css" />
    </head>
    <body>
        <div class="container">
            <!-- Codrops top bar -->
            <div class="codrops-top">
                <a href="../html/index.html">
                    <strong>&laquo; 返回主页 </strong>
                </a>
                <span class="right">
                    <a href="../../admin/jsp/dl.jsp">
                        <strong>点击进入管理员登陆界面</strong>
                    </a>
                </span>
                <div class="clr"></div>
           	</div><!--/ Codrops top bar -->
            <header>
                <h1>新生<span>入学指南系统</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                             <form  action="../../YZ1" name="YZ1" method="post" autocomplete="on">
                                <h1>登录</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 用户名： </label>
                                    <input id="username" name="username" required="required" type="text" placeholder="请输入你的用户名" maxlength="12"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> 密码： </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="请输入你的密码" maxlength="12" /> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="save" id="loginkeeping" value="save" /><label for="loginkeeping">记住登录状态</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="登录" /> 
								</p>
                                <p class="change_link">
									还没有注册用户 ?
									<a href="#toregister" class="to_register">注册</a>
								</p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                        
                            <form  action="../../YZ2" name="YZ2" method="post" autocomplete="on">
                                <h1> 注册 </h1> 
                                <center>
                                	<p style="color:red;">
				                        <%
				                         String a = request.getParameter("a"),b = request.getParameter("b");	
				                        		if(a!=null && a.equals("1")){out.print("该用户名已存在，请输入其他用户名！");}
				                        		else if(b!=null && b.equals("1")){out.print("两次输入的密码不一致，请重新输入！");}
				                        %>
			                        </p>
                        		</center>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">用户名：</label>
                                    <input id="usernamesignup" name="username1" required="required" type="text" placeholder="请输入你的用户名" maxlength="12" />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="mail" data-icon="e" >邮&nbsp;&nbsp;箱：</label>
                                    <input id="emailsignup" name="mail" required="required" type="email" placeholder="请输入你的邮箱" maxlength="20" /> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">密&nbsp;&nbsp;码： </label>
                                    <input id="passwordsignup" name="password1" required="required" type="password" placeholder="请输入你的密码" maxlength="12" />
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">确认密码： </label>
                                    <input id="passwordsignup_confirm" name="password2" required="required" type="password" placeholder="再次确认密码" maxlength="12"/>
                                </p>
								<p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="Q">密码保护： </label>
									<input id="passwordsignup_confirm" name="mmq" required="required" type="text" placeholder="请设置密码保护的问题" maxlength="20"/></br>
									<label for="passwordsignup_confirm" class="youpasswd" data-icon="A"></label>
                                </p> 
								<p> 
									<input id="passwordsignup_confirm" name="mma" required="required" type="text" placeholder="请设置密码保护的答案" maxlength="20"/>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="注册"/> 
								</p>
                                <p class="change_link">  
									已经有注册过 ?
									<a href="#tologin" class="to_register"> 点击登录 </a>
								</p>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>