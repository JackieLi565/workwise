<%--Render dynamically based on user role--%>
<nav class="px-8 py-3 flex justify-between items-center bg-background">
    <a href="/">
        <img src="/public/logo/logo.svg" alt="workwise logo" width="200">
    </a>
    <div class="flex gap-6 justify-between items-center text-text">
        <a>Saved Jobs</a>
        <a>My Profile</a>

        <div class="p-2 flex gap-2 justify-center items-center">
            <a href="/api/logout">Logout</a>
            <img src="">
        </div>
    </div>
</nav>
