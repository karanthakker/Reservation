<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container-fluid" style="margin-top: 8%;">
	<div class="row-fluid">
		<div class="span12">
		<h3>Welcome to SecCharge</h3>
			<fieldset class="fset">
				<legend>Login</legend>

				<form method="POST"  action="/seccharge/loginUser"
					class="form-horizontal">
					<div class="alert alert-error" style="display: none;"></div>
					<div class="alert alert-success" style="display: none;"></div>
					
					<div class="control-group">
						<label class="control-label" for="username">Username</label>
						<div class="controls">
							<input type="text" path="userName" id="username" placeholder="Username"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
							
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="password">Password</label>
						<div class="controls">
							<input type="password" path="password" id="password"
								placeholder="Password" class="input-block-level" />
						</div>
						<div class="controls error_form">
							
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<button class="btn btn-primary" id="login_user"
								data-action="/seccharge/loginUser"
								data-success="User is successfully logged in!"
								data-failure="There was some problem logging in the user!">Login</button>

						</div>
					</div>

				</form>
			</fieldset>



<fieldset class="fset">
				<legend>Sign Up</legend>

				<form method="POST"  action="/seccharge/initRegisterUser"
					class="form-horizontal">
					<div class="alert alert-error" style="display: none;"></div>
					<div class="alert alert-success" style="display: none;"></div>
					
					<div class="control-group">
						<label class="control-label" for="newuser">New User? Sign Up:</label>
						
						<div class="controls">
						<button class="btn btn-primary" id="register_user"
								data-action="/seccharge/initRegisterUser"
								data-success="User is successfully sent to registration form!"
								data-failure="There was some problem sending the user to registration form!">Sign Up</button>
								</div>
						
					</div>
					
			
				</form>
			</fieldset>

		</div>
	</div>
</div>


<c:forEach var="secchuser" items="${mysecchuser}">
<br />
username: ${secchuser.username}<br />
firstname: ${secchuser.firstname}<br />
lastname: ${secchuser.lastname}<br />
companyname: ${secchuser.companyname}<br />
email: ${secchuser.email}<br />
<br />
	</c:forEach> 

<%@ include file="footer.jsp"%>