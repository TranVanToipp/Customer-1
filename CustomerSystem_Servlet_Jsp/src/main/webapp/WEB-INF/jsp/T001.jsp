<style type="text/css">
  <%@include file="/WEB-INF/css/T001.css"%>
</style>
<title>Login - Training</title>
</head>
<body>
<%@page import="fjs.cs.dao.T003Dao,fjs.cs.common.Constants"%>  
<% String errorMessage = Constants.userNotERROR; %>
	<style type="text/jsp">
  		<%@include file="/WEB-INF/include/header.jsp"%>
	</style>
		<div class="content">
			<div class="content-text">Login</div>
			<div class="content-login">
				<form action="/CustomerSystem_Servlet_Jsp/T001" name="frmLogin" method="POST" onsubmit="return checkInput()" >
					<div class="content-login__header">
						<h3>LOGIN</h3>
						<label id="lblErrorMessage">
							<%
								if (request.getAttribute("message") != null) {
							%>
								<label><%=request.getAttribute("message")%></label> <%
							 }
							 %>
						
						</label>
					</div>
					<div class="content-login__container">

						<div class="form-group">
							<label for="fullname" class="form-label form-label__userID">User
								Id: </label> <input id="txtUserID" name="userName" maxlength="8"
								type="text" class="form-control">
						</div>
						<div class="form-group__password">
							<label for="password" class="form-label">Password: </label> <input
								id="txtPassword" name="password" type="password" maxlength="8"
								class="form-control">
						</div>
						<div class="form-group__btn">
							<button type="submit" id="btnLogin" class="form-submit">Login</button>
							<button type="button" id="btnClear" class="form-submit">Clear</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<footer class="footer">
		<div class="header-br"></div>
		<div class="footer-text__copyright">Copyright (c) 2000-2008
			FUJINET, All Rights Reserved.</div>
		</footer>
	</div>
</body>
<script type="text/javascript">
	<%@ include file="/WEB-INF/js/T001.js" %>
</script>
</html>