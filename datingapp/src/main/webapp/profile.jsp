<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.project.datingapp.dao.*" %>
<%@ page import="com.project.datingapp.Entities.*" %>

<% User user = (User) request.getAttribute("loggeduser");%>
<%  DaoUsers du = (DaoUsers) request.getAttribute("daousers");%>
<html>
    <head>
        <title>STO CAZZO</title>
    </head>
    <body>
        <h1>PROFILE</h1>
        <p>Username <%= user.getUsername() %></p>
        <p>Password <%= user.getPassword() %></p>
        <p>Sexuality <%= user.getSexualOrientation() %></p>
        <p>Interests</p>
        <p><% for(String interest : du.interests(user.getUsername()))
                {
                   
                    %>
                    <%= interest %>
                    <br>
               <% }
        %><p>
    </body>
</html>


