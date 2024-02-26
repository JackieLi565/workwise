<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorkWise Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="/scripts/tailwind.js"></script>
</head>
<body class="h-screen flex flex-col bg-background">
    <nav class="px-8 py-3 flex justify-between items-center bg-background">
        <img src="/public/logo/logo.svg" alt="workwise logo" width="200">
    </nav>
    <main class="flex-1 flex flex-col items-center justify-center">
        <%@include file="Components/Forms/Login.jsp"%>
        <div class="mt-6 text-center">
            <p class="text-sm text-text">New to WorkWise? <a href="/register" class="text-accent">Join now</a></p>
        </div>
    </main>
    <footer class="h-16 bg-primary flex items-center justify-center gap-5 text-sm text-background">
        <p>
            WorkWise © 2024
        </p>
        <a>User Agreement</a>
        <a>Privacy Policy</a>
        <a>Community Guidelines</a>
        <a>Cookie Policy</a>
        <a>Copyright Policy</a>
        <a>Feedback</a>
        <a>Support</a>
    </footer>
</body>
</html>


