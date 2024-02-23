<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.coe692.workwise.utils.ConcentURL" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorkWise</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="flex justify-center items-center h-screen">
.<%//@include file="Components/Nav.jsp"%>
<a href="<%= ConcentURL.URL() %>" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Login with Google</a>
</body>
</html>

