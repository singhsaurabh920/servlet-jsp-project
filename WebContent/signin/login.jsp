<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.8.8, mobirisethemes.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="/assets/images/logo2.png" type="image/x-icon">
  <meta name="description" content="">
  <title>Sign In</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signin/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signin/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signin/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signin/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/signin/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signin/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/signin/css/util.css">
	<link rel="stylesheet" type="text/css" href="/signin/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-50 p-r-50 p-t-77 p-b-30">
				<form class="login100-form validate-form" method="POST" action="/login">
					<span class="login100-form-title p-b-55">Login</span>
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Valid username is require">
						<input class="input100" type="text" name="username" placeholder="username">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<span class="lnr lnr-user"></span>
						</span>
						<span class="field-error">${usernameError}</span>
					</div>

					<div class="wrap-input100 validate-input m-b-16" data-validate = "Valid password is required">
						<input class="input100" type="password" name="password" placeholder="password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<span class="lnr lnr-lock"></span>
						</span>
						<span class="field-error">${passwordError}</span>
					</div>
					<div class="container-login100-form-btn p-t-25">
						<button class="login100-form-btn">Login</button>
					</div>
					<div class="text-center w-full p-t-115">
						<span class="txt1"> Not a member?</span>
						<a class="txt1 bo1 hov1" href="/register">Sign up now</a>
					</div>
				</form>
			</div>
		</div>
	</div>
<!--===============================================================================================-->	
	<script src="/signin/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/signin/vendor/bootstrap/js/popper.js"></script>
	<script src="/signin/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/signin/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/signin/js/main.js"></script>
</body>
</html>