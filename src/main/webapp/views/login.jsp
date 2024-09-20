<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
      <title>HTML Login Form</title>
      <link rel="stylesheet" href="style.css">
</head>
<body>
	<form action="/ltwebct2/login" method="post">
		<c:if test="${alert !=null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>
		<div class="main">
            <h1>LePhuongThao</h1>
            <h3>Enter your login credentials</h3>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" placeholder="Enter your Username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter your Password" required>
			
			<div class="checkbox">
				<label>
					<input type="checkbox" name="remember" value="yes"> Remember me
				</label>
			</div>

			<div class="wrap">
                  <button type="submit">Submit</button>
            </div>
            <p>Not registered?
                  <a href="register" style="text-decoration: none;">
                        Create an account
                  </a>
            </p>
			<p>
				<a href="/ltwebct2/forgotPassword" style="text-decoration: none;">Forgot
					Password?</a>
			</p>

		</div>
    </form>
</body>
</html>
