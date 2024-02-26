<%@ page import="com.coe692.workwise.utils.OAuth" %>
<%@ page import="java.util.Optional" %>
<div class="bg-white p-8 rounded-lg shadow-md w-96">
    <h1 class="text-2xl font-bold mb-2 text-left">Sign in</h1>
    <p class="text-gray-600 text-base mb-6 text-left">Jobs search can never be wiser</p>
    <form class="space-y-5">
        <div>
            <input type="email" class="w-full px-3 py-2 border rounded-md outline-none" placeholder="Email">
        </div>
        <div>
            <input type="password" class="w-full px-3 py-2 border rounded-md outline-none" placeholder="Password">
        </div>

        <div>
            <a href="#" class="text-accent">Forgot password?</a>
        </div>

        <button disabled type="submit" class="w-full py-2 px-4 bg-background text-white rounded-md hover:bg-secondary transition-colors focus:outline-none">Sign in</button>

    </form>
    <div class="text-center text-sm text-gray-500 my-2">or</div>
    <a href="<%= OAuth.getClientRequestURL(Optional.empty())%>" class="block text-white text-center w-full py-2 px-4 bg-secondary text-gray-700 rounded-md hover:bg-background transition-colors focus:outline-none">
        Sign in with Google
    </a>
</div>

