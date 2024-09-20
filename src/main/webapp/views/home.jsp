<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
</head>
<body>
    <h1>User's dashboard</h1>
    <a href="${pageContext.request.contextPath}/logout" style="text-decoration: none; padding: 10px; background-color: #4CAF50; color: white; border-radius: 5px; font-weight: bold;">Đăng xuất</a>
</body>
</html>
