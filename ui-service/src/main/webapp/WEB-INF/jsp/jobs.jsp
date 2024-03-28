<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.Map" %>
<%@ page import="com.workwise.uiservice.service.JobService" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.workwise.uiservice.model.Job" %>
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
        <%@include file="../../components/navigation/navbar.jsp"%>
        <div class="flex-1 relative">
            <div class="flex flex-col justify-center items-center">
                <div class="flex items-center justify-center pt-10 pb-6">
                    <form action="/jobs" class="flex rounded">
                        <input type="text" name="title" class="px-4 py-2 w-80 outline-none rounded-l" placeholder="Job title, keywords, or company">
                        <input type="text" name="loc" class="px-4 py-2 w-80 outline-none" placeholder="City, province, or 'remote'">
                        <button type="submit" class="px-8 rounded-r bg-accent text-white font-bold p-4">
                            Find jobs
                        </button>
                    </form>
                </div>
            </div>
            <div class="flex gap-4 m-auto max-w-6xl">
                <%
                    Map<String, Job> jobMap = null;
                    try {
                        Optional<Map<String, Job>> jobsOptional = JobService.getJobs(request.getParameter("title"), request.getParameter("loc"));
                        if (jobsOptional.isPresent()) {
                            jobMap = jobsOptional.get();
                        } else {
                            throw new Exception("Jobs are empty");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    String jobId = request.getParameter("id");
                    Job selectedJob = jobMap.get(jobId);
                %>
                <div class="flex flex-col gap-4 <% if (selectedJob == null) {%> w-full <%} else {%> w-[45%] <%}%> mb-10">
                    <% for (Map.Entry<String, Job> set : jobMap.entrySet()) {
                        Job job = set.getValue();
                    %>
                    <a href="/jobs?id=<%=set.getKey()%>" class="block bg-white shadow-md rounded-lg p-4">
                        <h1 class="text-xl font-semibold mb-1 <% if (job.getId().equals(jobId)) {%> text-accent <%}%>"><%= job.getTitle() %></h1>
                        <div class="text-gray-600"><%= job.getCompany() %></div>
                        <div><%= job.getLocation() %></div>
                        <div class="text-gray-800 line-clamp-3"><%= job.getDescription() %></div>
                    </a>
                    <% } %>
                </div>
                <%
                    if (selectedJob != null) {

                %>
                    <div class="sticky space-y-2 bg-white top-5 h-fit w-[55%] border border-white rounded-md p-5">
                        <h1 class="text-2xl mb-1 font-semibold"><%=selectedJob.getTitle()%></h1>
                        <h2 class="text-base text-gray-800"><%=selectedJob.getLocation()%> &bull; $<%=selectedJob.getPay()%> per hour</h2>

                        <div class="p-4 flex items-center justify-between border-b-2 border-accent rounded-md shadow-sm">
                            <div class="flex items-center">
                                <div class="w-12 h-12 rounded-full bg-background flex items-center justify-center mr-4">
                                    <img class="rounded-full" alt="profile picture" src="https://lh3.googleusercontent.com/a/ACg8ocKhhhs_UnlSKN8Ug7_Y4EzOyhqav-q14DTG63SlIBd8Suw=s83-c-mo">
                                </div>
                                <div>
                                    <p class="font-semibold"><%=selectedJob.getRecruiter().getName()%></p>
                                    <p class="text-sm"><%=selectedJob.getCompany()%></p>
                                    <p class="text-xs">Job poster</p>
                                </div>
                            </div>
                            <button class="px-4 py-2 bg-background text-text text-xs font-semibold rounded-md hover:bg-accent transition-colors">
                                View Postings
                            </button>
                        </div>

                        <h1 class="text-xl pt-2 pb-1 font-semibold">Full Job Description</h1>
                        <p><%=selectedJob.getDescription()%></p>
                        <div class="flex justify-end gap-2 pt-1">
                            <a target="_blank" class="rounded-md block px-4 py-1 bg-background text-white">Save</a>
                            <a target="_blank" href="<%=selectedJob.getUrl()%>" class="rounded-md block px-4 py-1 bg-accent text-text">Apply</a>
                        </div>
                    </div>
                <%
                    }
                %>
            </div>
        </div>
        <%@include file="../../components/navigation/footer.jsp"%>

    </body>
</html>