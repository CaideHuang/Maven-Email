<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>注册</title>
	</head>
	<link href="css/materialize.min.css" rel="stylesheet" type="text/css" />
	<script src="js/jquery-2.1.0.js"></script>
	<style>
		.box{
			margin-top:200px;
		}
		
	</style>

	<body>

		<div class="container box">

			<div class="row valign-wrapper">
				<div class="col l4 offset-l4">
					<div class="row">
						<div class="input-field">
							<input id="email" type="email" class="validate">
							<label for="email" data-error="邮箱格式不正确" data-success="验证成功">邮件</label>
						</div>
						<div class="input-field">
							<input id="password" type="password" class="validate">
							<label for="password">密码</label>
						</div>
						<div class="input-field center-align" id="btn">
							<a class="btn waves-effect waves-light">注册</a>
						</div>
						
					</div>
				</div>
			</div>
			
	    </div>

	</body>
	<script src="js/materialize.min.js"></script>
	<script>
		jQuery(function($) {

			$("#btn").click(function() {

				var email = $("#email").val();
				var password = $("#password").val();
				
				$.ajax({
					
					url:"insertUser.do",
					type:"post",
					data:{
						email:email,
						password:password
					},
					success:function(data){
						
					}
					
				})

			})

		})
	</script>
	
</html>