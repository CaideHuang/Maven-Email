<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>用户信息</title>
	</head>
	<link href="css/materialize.min.css" rel="stylesheet" type="text/css" />
	<script src="js/jquery-2.1.0.js"></script>

	<body>
		<div class="container">
			<table class="bordered highlight responsive-table">
				<thead>
					<tr>
						<th data-field="id">#</th>
						<th data-field="email">邮箱</th>
						<th data-field="password">密码</th>
						<th data-field="code">校验码</th>
						<th data-field="state">状态</th>
					</tr>
				</thead>

				<tbody>
                     <c:forEach items="${users}" var="user">
                        <tr>
                          <td>${user.id}</td>
                          <td>${user.email}</td>
                          <td>${user.password}</td>
                          <td>${user.code}</td>
                          <td>
                             <c:if test="${user.state==1}">
                                <p class="teal-text">激活</p>
                             </c:if>
                             <c:if test="${user.state==0}">
                                <p class="red-text">未激活</p>
                             </c:if>
                          </td>
                        </tr>
                     </c:forEach>
				</tbody>
			</table>
		</div>
	</body>
	<script src="js/materialize.min.js"></script>
</html>