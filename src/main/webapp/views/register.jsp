<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Register</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<form action="/ltwebct2/register" method="post">
		<h1>Create a New Account</h1>
		<label for="username">Username:</label>
		<input type="text" id="username" name="username" required><br>

		<label for="password">Password:</label>
		<input type="password" id="password" name="password" required><br>

		<label for="email">Email:</label>
		<input type="email" id="email" name="email" required><br>

		<label for="fullname">Full Name:</label>
		<input type="text" id="fullname" name="fullname" required><br>

		<label for="phone">Phone:</label>
		<input type="text" id="phone" name="phone" required><br>

		<button type="submit">Register</button>
	</form>
</body>
</html>
