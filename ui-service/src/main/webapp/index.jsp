<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorkWise | Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/tailwind.js"></script>
</head>
<body class="h-screen flex flex-col bg-background">
<nav class="px-8 py-3 flex justify-between items-center bg-background">
    <img src="${pageContext.request.contextPath}/public/logo/logo.svg" alt="workwise logo" width="200">
</nav>
<main class="flex-1 flex flex-col items-center justify-center">
    <%@include file="components/forms/login.jsp"%>
    <div class="mt-6 text-center">
        <p class="text-sm text-text">New to WorkWise? <a href="/register" class="text-accent">Join now</a></p>
    </div>
</main>
<%@include file="components/navigation/footer.jsp"%>
</body>
</html>
