<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.coe692.workwise.model.Job" %>
<%@ page import="com.coe692.workwise.database.JobData" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>WorkWise | Jobs</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <script src="/scripts/tailwind.js"></script>
    </head>
    <body class="flex flex-col bg-background h-screen overflow-y-auto ">
        <%@include file="Components/Navigation/Navbar.jsp"%>
        <div class="flex-1 relative">
            <div class="flex flex-col justify-center items-center">
                <div class="flex items-center justify-center pt-10 pb-6">
                    <div class="flex rounded">
                        <input type="text" class="px-4 py-2 w-80 outline-none rounded-l" placeholder="Job title, keywords, or company">
                        <input type="text" class="px-4 py-2 w-80 outline-none" placeholder="City, province, or 'remote'">
                        <button class="px-8 rounded-r bg-accent text-white font-bold p-4">
                            Find jobs
                        </button>
                    </div>
                </div>
            </div>
            <div class="flex gap-4 m-auto max-w-6xl">
                <%
                    Map<String, Job> jobMap = JobData.retrieveJobList();
                    String jobId = request.getQueryString();
                    Job selectedJob = jobMap.get(jobId);

                %>
                <div class="flex flex-col gap-4 <% if (selectedJob == null) {%> w-full <%} else {%> w-[45%] <%}%> h-[5000px]">
                    <% for (Map.Entry<String, Job> set : jobMap.entrySet()) {
                        Job job = set.getValue();
                    %>
                    <a href="/jobs.jsp?<%=set.getKey()%>" class="block bg-white shadow-md rounded-lg p-4">
                        <div class="flex justify-between">
                            <h1 class="text-xl font-semibold <% if (job.getId().equals(jobId)) {%> text-accent <%}%>"><%= job.getTitle() %></h1>
                        </div>
                        <div class="text-gray-800"><%= job.getDescription() %></div>
                        <div class="flex justify-between items-center pt-2">
                            <div class="text-gray-600">Pay: <%= job.getPay() %> / hour</div>
                            <div class="text-gray-600"><%= job.getLocation() %></div>
                        </div>
                    </a>
                    <% } %>
                </div>
                <%
                    if (selectedJob != null) {

                %>
                    <div class="sticky bg-white top-5 h-fit w-[55%] border border-white rounded-md p-5">


                    </div>
                <%
                    }
                %>
            </div>
            <%@include file="Components/Navigation/Footer.jsp"%>
        </div>
    </body>
</html>