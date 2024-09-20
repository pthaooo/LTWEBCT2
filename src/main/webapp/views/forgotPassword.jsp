<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <form action="/ltwebct2/forgotPassword" method="post">
        <div class="main">
            <h1>Forgot Password</h1>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>

            <label for="newPassword">New Password:</label>
            <input type="password" id="newPassword" name="newPassword" placeholder="Enter new password" required>

            <div class="wrap">
                <button type="submit">Reset Password</button>
            </div>
        </div>
    </form>
</body>
</html>
