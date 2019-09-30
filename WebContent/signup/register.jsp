<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.8.8, mobirisethemes.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="/assets/images/logo2.png" type="image/x-icon">
  <meta name="description" content="">
  <title>Sign Up</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signup/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signup/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signup/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signup/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signup/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/signup/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signup/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signup/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/signup/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signup/css/util.css">
	<link rel="stylesheet" type="text/css" href="/signup/css/main.css">
<!--===============================================================================================-->
</head>
<body style="background-color: #999999;">
	<div class="limiter">
		<div class="container-login100">
			<div class="login100-more" style="background-image: url('/signup/images/bg-01.jpg');"></div>
			<div class="wrap-login100 p-l-50 p-r-50 p-b-50">
				<form class="login100-form validate-form" method="POST" action="/register">
					<span class="login100-form-title p-b-50">Sign Up</span>
					<div class="wrap-input100 validate-input" data-validate="Username is required">
						<span class="label-input100">Username</span>
						<input class="input100" type="text" name="username" placeholder="Username...">
						<span class="focus-input100"></span>
						<span class="field-error">${errors.usernameError}</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<span class="label-input100">Password</span>
						<input class="input100" type="text" name="password" placeholder="*************">
						<span class="focus-input100"></span>
						<span class="field-error">${errors.passwordError}</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Repeat Password is required">
						<span class="label-input100">Repeat Password</span>
						<input class="input100" type="text" name="confirm" placeholder="*************">
						<span class="focus-input100"></span>
						<span class="field-error">${errors.confirmError}</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Name is required">
						<span class="label-input100">Full Name</span>
						<input class="input100" type="text" name="name" placeholder="Name...">
						<span class="focus-input100"></span>
						<span class="field-error">${errors.nameError}</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<span class="label-input100">Email</span>
						<input class="input100" type="email" name="email" placeholder="Email addess...">
						<span class="focus-input100"></span>
						<span class="field-error">${errors.emailError}</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Phone number is require">
						<span class="label-input100">Phone</span>
						<input class="input100" type="text" name="phone" placeholder="Phone number...">
						<span class="focus-input100"></span>
						<span class="field-error">${errors.phoneError}</span>
					</div>
					<div class="wrap-input100 validate-input" data-validate = "Address is required">
						<span class="label-input100">Address</span>
						<input class="input100" type="text" name="address" placeholder="Addess...">
						<span class="focus-input100"></span>
						<span class="field-error">${errors.addressError}</span>
					</div>
					<div class="flex-m w-full p-b-33">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" checked name="active" value=true>
							<label class="label-checkbox100" for="ckb1">
								<span class="txt1">Active</span>
							</label>
						</div>						
					</div>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit">Sign Up</button>
						</div>
						<a href="/login" class="dis-block txt3 hov1 p-r-30 p-t-10 p-b-10 p-l-30">Sign in<i class="fa fa-long-arrow-right m-l-5"></i></a>
					</div>
				</form>
			</div>
		</div>
	</div>
<!--===============================================================================================-->
	<script src="/signup/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/signup/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="/signup/vendor/bootstrap/js/popper.js"></script>
	<script src="/signup/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/signup/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/signup/vendor/daterangepicker/moment.min.js"></script>
	<script src="/signup/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="/signup/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="/signup/js/main.js"></script>
</body>
</html>