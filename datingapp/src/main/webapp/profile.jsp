<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.project.datingapp.dao.*" %>
<%@ page import="com.project.datingapp.entities.*" %>

<% User user = (User) request.getAttribute("loggeduser");%>
<%  DaoUsers du = (DaoUsers) request.getAttribute("daousers");%>
<% ArrayList<Image> images = (ArrayList<Image>) request.getAttribute("images"); %>
<html>
    <head>
        <title>STO CAZZO</title>
    </head>
    <body>
        <h1>PROFILE</h1>
        <a href="swipe">SWIPE</a>
        <p>Username <%= user.getId() %></p>
        <p>Username <%= user.getUsername() %></p>
        <p>Password <%= user.getPassword() %></p>
        <p>Sexuality <%= user.getSexualOrientation() %></p>
        <p>Interests</p>
        <p><% for(Interest interest : du.interests(user.getId()))
                {    
                    %>
                    <%= interest.getInterest() %>
                    <br>
               <% }
        %><p>
        <p>Image</p>
        <p><% for(Image im : images)
                {    
                    %>
                    <%= im.getImageUrl() %>
                    <br>
               <% }
        %><p>

    </body>
</html>


