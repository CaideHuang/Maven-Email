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
.box {
	margin-top: 200px;
}
</style>

<body>

	<div class="container box">

		<div class="row valign-wrapper">
			<div class="col l4 offset-l4">
				<div class="row">
					<div class="input-field">
						<input id="email" type="email" class="validate"> <label
							for="email" data-error="error" data-success="success">邮件</label>
					</div>
					<div class="input-field">
						<input id="password" type="password" class="validate"> <label
							for="password">密码</label>
					</div>
					<div class="input-field center-align">
						<a class="btn waves-effect waves-light" id="btn">注册</a>
					</div>

				</div>
			</div>
		</div>

	</div>

</body>
<script src="js/materialize.min.js"></script>
<script src="js/index.js"></script>
<script>
		jQuery(function($) {
			
			$("#email").change(function(){
				
				var email = $("#email").val();
				
				 submit_email(email);
				
			})

			$("#btn").click(function() {

				var email = $("#email").val();
				var password = $("#password").val();
				
				if(email=="" || password==""){
					Materialize.toast('信息不能为空', 3000, 'rounded');
					return false;
				}else{
					submit(email,password);
				}
				
		
			})

		})
	</script>

</html>