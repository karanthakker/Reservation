<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid" style="margin-top: 8%;">
	<div class="row-fluid">
		<div class="span12">
				<fieldset class="fset">
				<legend>Sign Up</legend>

				<form:form method="POST"  action="/seccharge/signupUser" commandName="secchuser"
					class="form-horizontal">
					<div class="alert alert-error" style="display: none;"></div>
					<div class="alert alert-success" style="display: none;"></div>
					
					
					<div class="control-group">
						<label class="control-label" for="firstName">Name</label>
						<div class="controls">
							<form:input type="text" path="firstName" id="firstName" placeholder="Name"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="firstName" cssClass="error" />	
						</div>
					</div>
					
					
					<div class="control-group">
						<label class="control-label" for="lastName">SurName</label>
						<div class="controls">
							<form:input type="text" path="lastName" id="lastName" placeholder="surName"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="lastName" cssClass="error" />	
						</div>
					</div>
					
						<div class="control-group">
						<label class="control-label" for="companyName">company Name</label>
						<div class="controls">
							<form:input type="text" path="companyName" id="companyName" placeholder="company Name"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="companyName" cssClass="error" />		
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="email">Email</label>
						<div class="controls">
							<form:input type="text" path="email" id="email" placeholder="Email"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="email" cssClass="error" />	
						</div>
					</div>
					
					
					<div class="control-group">
						<label class="control-label" for="country">Country</label>
						<div class="controls">
							<form:input type="text" path="country" id="country" placeholder="Country"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="country" cssClass="error" />		
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="province">Province</label>
						<div class="controls">
							<form:input type="text" path="province" id="province" placeholder="Province"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="province" cssClass="error" />	
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="city">City</label>
						<div class="controls">
							<form:input type="text" path="city" id="city" placeholder="City"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="city" cssClass="error" />	
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="address1">Street</label>
						<div class="controls">
							<form:input type="text" path="address1" id="address1" placeholder="Street"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="address1" cssClass="error" />	
						</div>
					</div>
					
					
					<div class="control-group">
						<label class="control-label" for="postalCode">Postal Code</label>
						<div class="controls">
							<form:input type="text" path="postalCode" id="postalCode" placeholder="Postal Code"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="postalCode" cssClass="error" />	
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="homePhone">Home Phone</label>
						<div class="controls">
							<form:input type="text" path="homePhone" id="HomePhone" placeholder="Home Phone"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="homePhone" cssClass="error" />	
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="cellPhone">Cell Phone</label>
						<div class="controls">
							<form:input type="text" path="cellPhone" id="cellPhone" placeholder="Cell Phone"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="cellPhone" cssClass="error" />	
						</div>
					</div>
					
					<div class="control-group">
						<label class="control-label" for="userName">Username</label>
						<div class="controls">
							<form:input type="text" path="userName" id="userName" placeholder="Username"
								class="input-block-level" />
						</div>
						<div class="controls error_form">
						<form:errors path="userName" cssClass="error" />	
						</div>
					</div>
					
				<!-- 	<div class="control-group">
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
					</div> -->

					
					<div class="control-group">
						<div class="controls">
							<form:button class="btn btn-primary" id="signUp_user"
								data-action="/seccharge/signUpUser"
								data-success="User is successfully Signed Up!"
								data-failure="There was some problem Signing Up user!">Sign Up</form:button>

						</div>
					</div>

				 </form:form> 
				<!--<form:form action="/seccharge/signupUser" method = "post" commandName="secchuser">
<table>
<tr><td>Email:</td><td><form:input type="text" path ="email" name="email" /></td></tr>
<tr><td>Name:</td><td><form:input type="text" path="firstName" name="firstName" /></td></tr>


<tr><td><input type="submit" value="Create"/></td></tr>
</table>
</form:form> -->
				
			</fieldset>



		</div>
	</div>
</div>
<%@ include file="footer.jsp"%>