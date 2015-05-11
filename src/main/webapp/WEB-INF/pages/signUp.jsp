<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid" style="margin-top: 8%;">
	<div class="row-fluid">
		<div class="span12">
				<fieldset class="fset">
				<legend>Sign Up</legend>

				<form method="POST"  action="/seccharge/SignupUser"
					class="form-horizontal">
					<div class="alert alert-error" style="display: none;"></div>
					<div class="alert alert-success" style="display: none;"></div>
					
					
					<div class="control-group">
						<label class="control-label" for="name">Name</label>
						<div class="controls">
							<input type="text" path="name" id="name" placeholder="Name"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
							
						</div>
					</div>
					
					
					<div class="control-group">
						<label class="control-label" for="surName">SurName</label>
						<div class="controls">
							<input type="text" path="surName" id="surName" placeholder="surName"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
							
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="Country">Country</label>
						<div class="controls">
							<input type="text" path="Country" id="Country" placeholder="Country"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
							
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="City">City</label>
						<div class="controls">
							<input type="text" path="City" id="City" placeholder="City"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
							
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="streetL1">Street line 1</label>
						<div class="controls">
							<input type="text" path="streetL1" id="streetL1" placeholder="Street"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
							
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="streetL2">Street line 2</label>
						<div class="controls">
							<input type="text" path="streetL2" id="streetL2" placeholder="Street"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
							
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="postalCode">Postal Code</label>
						<div class="controls">
							<input type="text" path="postalCode" id="postalCode" placeholder="Postal Code"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
							
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="phone">Phone</label>
						<div class="controls">
							<input type="text" path="phone" id="phone" placeholder="Phone"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
							
						</div>
					</div>
					
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
						<label class="control-label" for="rePassword">Retype Password</label>
						<div class="controls">
							<input type="password" path="rePassword" id="rePassword"
								placeholder="Retype Password" class="input-block-level" />
						</div>
						<div class="controls error_form">
							
						</div>
					</div>


					<div class="control-group">
						<div class="controls">
							<button class="btn btn-primary" id="signUp_user"
								data-action="/seccharge/signUpUser"
								data-success="User is successfully Signed Up!"
								data-failure="There was some problem Signing Up user!">Sign Up</button>

						</div>
					</div>

				</form>
			</fieldset>



		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>