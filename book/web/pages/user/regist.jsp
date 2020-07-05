<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%-- header base, css, jQuerry--%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("#code_img").click(function () {
			this.src = "${basePath}kaptcha.jpg?d=" + new Date();
			})

			$("#username").blur(function () {
			let username = this.value;
			$.getJSON("http://localhost:8080/book/userServlet","action=ajaxExistsUsername&username="+username,function (data) {
			if(data.existsUsername){
				$("span.errorMsg").text("用户名不可用");
			}else{
				$("span.errorMsg").text("用户名可用");
			}


			})
			})



		$("#sub_btn").click(function () {
			// 验证用户名：必须由字母，数字下划线组成，并且长度为5 到12 位
			let usernameText = $("#username").val();
			let usernamePatt = /^\w{5,12}$/;
			if(!usernamePatt.test(usernameText)){
				$("span.errorMsg").text("用户输入不合法");
				return false;
			}

			// 验证密码：必须由字母，数字下划线组成，并且长度为5 到12 位
			let passwordText = $("#password").val();
			let passwordPatt = /^\w{5,12}$/;
			if(!passwordPatt.test(passwordText)){
				$("span.errorMsg").text("密码不合法");
				return false;
			}

			// 验证确认密码：和密码相同
			let repwdText = $("#repwd").val();
			if(passwordText!=repwdText){
				$("span.errorMsg").text("确认密码和密码不一致");
				return false;
			}

			// 邮箱验证：xxxxx@xxx.com
			let emailText = $("#email").val();
			let emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
			if(!emailPatt.test(emailText)){
				$("span.errorMsg").text("邮箱格式不合法");
				return false;
			}
			// 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
			let codeText = $("#code").val();
			codeText = $.trim(codeText);
			if(codeText=="" || codeText==null){
				$("span.errorMsg").text("验证码不能为空");
				return false;
			}
			$("span.errorMsg").text("");

		})
		})

	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
<%--									<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
								${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post" >
									<input type="hidden" name="action" value="regist" />

									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username" value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
									value ="${requestScope.email}"
									/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>

		<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>