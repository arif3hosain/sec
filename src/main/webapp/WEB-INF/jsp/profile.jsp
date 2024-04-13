<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Document   : Register
    Created on : Feb 29, 2024, 1:10:45 PM
    Author     : Sarveashwaran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script>
        tailwind.config = {
            theme: {
                fontFamily: {
                    "cursive": ['cursive', 'sans-serif'],
                }
            }
        }
    </script>
    <style>
        body {
            background-image: url('./img/bg.jpg');
            background-size: cover;
            backdrop-filter: blur(10px);
            /* Adjust the blur radius as needed */
        }
    </style>
</head>
<body>
<div>
    <br>
    <a style="margin-left: 20px;" class="bg-[#0059D6] text-white w-100 h-10 rounded-[5px]" href="http://localhost:8080/logout">Logout</a>
</div>
<div class="h-screen flex pt-0 md:pt-2 justify-center items-center bg-cover no-repeat">
    <form:form method="POST" modelAttribute="userForm"  action="/profile"
               class="p-6 w-[320px] md:w-[575px] bg-white shadow-xl rounded-[10px] h-[500px] flex flex-col items-center justify-center space-y-6">
        <h3 class="text-center text-3xl">Update Profile</h3>
        <input type="hidden" name="id" value="${userForm.id}" />
        <div class="flex flex-col justify-center items-start space-y-1 md:space-y-6">
            <div
                    class="flex flex-col md:flex-row justify-center md:justify-between items-start md:items-center space-y-4 md:space-y-0 space-x-0 md:space-x-4 w-[300px] md:w-[500px]">
                <label for="username" class="text-sm md:text-xl">Username</label>
                <input
                        class="placeholder:italic placeholder:text-slate-400 block bg-white w-[300px] md:w-[400px] border border-slate-300 rounded-md p-2 shadow-sm focus:outline-none focus:border-sky-500 focus:ring-sky-500 focus:ring-1"
                        placeholder="Username cannot be updated" type="text" name="username" id="username" readonly />
                <form:errors path="username"></form:errors>
            </div>
            <div
                    class="flex flex-col md:flex-row justify-center md:justify-between items-start md:items-center space-y-4 md:space-y-0 space-x-0 md:space-x-4 w-[300px] md:w-[500px]">
                <label for="password" class="text-sm md:text-xl">Password</label>
                <input
                        class="placeholder:italic placeholder:text-slate-400 block bg-white w-[300px] md:w-[400px] border border-slate-300 rounded-md p-2 shadow-sm focus:outline-none focus:border-sky-500 focus:ring-sky-500 focus:ring-1"
                        placeholder="Password cannot be updated." type="password" name="password" id="password" readonly/>
            </div>
            <div
                    class="flex flex-col md:flex-row justify-center md:justify-between items-start md:items-center space-y-4 md:space-y-0 space-x-0 md:space-x-4 w-[300px] md:w-[500px]">
                <label  class="text-sm md:text-xl">Gender</label>
                <div class="bg-white w-[300px] md:w-[400px]">
                    <div class="form-check">
                        <c:if test="${userForm.gender.equals('Male')}"><input class="form-check-input" type="radio" name="gender" id="flexRadioDefault2" value="Male" checked></c:if>
                        <c:if test="${!userForm.gender.equals('Male')}"><input class="form-check-input" type="radio" name="gender" id="flexRadioDefault2" value="Male"></c:if>
                        <label class="form-check-label" >
                            Male
                        </label>
                    </div>
                    <div class="form-check">
                        <c:if test="${userForm.gender.equals('Female')}"><input class="form-check-input" type="radio" name="gender" id="flexRadioDefault2" value="Female" checked></c:if>
                        <c:if test="${!userForm.gender.equals('Female')}"><input class="form-check-input" type="radio" name="gender" id="flexRadioDefault2" value="Female"></c:if>
                        <label class="form-check-label">
                            Female
                        </label>
                    </div>
                </div>
            </div>
            <div
                    class="flex flex-col md:flex-row justify-center md:justify-between items-start md:items-center space-y-4 md:space-y-0 space-x-0 md:space-x-4 w-[300px] md:w-[500px]">
                <label for="school" class="text-sm md:text-xl">School</label>
                <input
                        class="placeholder:italic placeholder:text-slate-400 block bg-white w-[300px] md:w-[400px] border border-slate-300 rounded-md p-2 shadow-sm focus:outline-none focus:border-sky-500 focus:ring-sky-500 focus:ring-1"
                        placeholder="Type your School..." type="text" name="school" id="school" value="${userForm.school}" />
            </div>
        </div>
        <button type="submit" class="bg-[#0059D6] text-white w-100 h-10 rounded-[5px]">
            Update Profile
        </button>
    </form:form>
</div>

<script>

    document.getElementById('password').addEventListener('input', function(event) {
        const inputValue = event.target.value;
        if (/^[0-9,]*$/.test(inputValue)) {
            event.target.value = inputValue;
        } else {
            event.target.value = inputValue.slice(0, -1);
        }
    });
</script>

</body>
</html>