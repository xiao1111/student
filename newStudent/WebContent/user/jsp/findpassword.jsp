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
                        
                             <form  action="../../YZ3" name="YZ3" method="post" autocomplete="on">
                                <h1>找回密码</h1> 
                                <center>
	                                <p style="color:red;">
				                        <%
				                         String a = request.getParameter("a");	
				                        		if(a!=null && a.equals("0")){out.print("该用户名不存在，请重新输入用户名！");}
				                        		else if(a!=null && a.equals("1")){out.print("所输入的密码保护信息不正确，请重新输入！");}
				                        %>
				                   	</p>
                        		</center>
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 用户名： </label>
                                    <input id="username" name="username" required="required" type="text" placeholder="请输入你的用户名" maxlength="12"/>
                                </p>
	                                <label for="passwordsignup_confirm" class="youpasswd" data-icon="Q">密码保护： </label>
									<p><input id="passwordsignup_confirm" name="mmq" required="required" type="text" placeholder="请输入您设置密码保护的问题" maxlength="20"/></br>
									<label for="passwordsignup_confirm" class="youpasswd" data-icon="A"></label>
                                </p> 
								<p> 
									<input id="passwordsignup_confirm" name="mma" required="required" type="text" placeholder="请输入您设置密码保护的答案" maxlength="20"/>
                                </p>
                                <p class="login button"> 
                                   <input type="submit" value="确认" /> 
								</p>
                            </form>
                        </div>

                        <div id="register" class="animate form">
                        
                            <form  action="../../YZ4" name="YZ4" method="post" autocomplete="on">
                                <h1> 修改密码</h1> 
                                <center>
                                	<p style="color:red;">
		                                 <%
		                         			String b = request.getParameter("b");
		                                 	String c = request.getParameter("c");
		                        			if(b!=null && b.equals("1")){out.print("两次输入的密码不一致，请重新输入！");}
		      							 %>
		                           	</p>
                        		</center>
                                <input type="hidden" name="username" value="<%=c %>" />
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">密&nbsp;&nbsp;码： </label>
                                    <input id="passwordsignup" name="password1" required="required" type="password" placeholder="请输入你的新密码" maxlength="12" />
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">确认密码： </label>
                                    <input id="passwordsignup_confirm" name="password2" required="required" type="password" placeholder="再次确认新密码" maxlength="12"/>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="确认"/> 
								</p>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>