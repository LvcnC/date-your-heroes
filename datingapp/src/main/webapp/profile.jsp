<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.project.datingapp.dao.*" %>
<%@ page import="com.project.datingapp.entities.*" %>

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
        <p><% for(Interest interest : du.interests(user.getName()))
                {    
                    %>
                    <%= interest.getInterest() %>
                    <br>
               <% }
        %><p>
        <p>Shared interests</p>
        <p>
            
        </p>
    </body>
</html>


