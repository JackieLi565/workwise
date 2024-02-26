<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.coe692.workwise.model.Job" %>
<%@ page import="com.coe692.workwise.database.JobData" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <style>
        table {
            width: 100%;
            table-layout: fixed;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            border: 1px solid #ffffff;
            text-align: left;
            word-wrap: break-word;
        }
    </style>

</head>
<body>
<% ArrayList<Job> jList = JobData.retrieveJobList(); %>
<h1>Available Jobs</h1>
<table>
    <tr>
        <th>Job Title</th>
        <th>Job Description</th>
        <th>Pay ($/hour)</th>
        <th>Location</th>
        <th> Save Job </th>
    </tr>

    <%for (Job job : jList) {%>
    <tr>
        <td><%= job.getTitle() %></td>
        <td><%= job.getDescription() %></td>
        <td><%= job.getPay() %></td>
        <td><%= job.getLocation() %></td>
        <td> <button id="<%job.getId();%>" onclick="toggleVisibility(id)">Save Job</button>
            <script>
                function toggleVisibility(id) {
                    var button = document.getElementById(id);
                    button.style.display = "none";
                }
            </script>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>

</html>