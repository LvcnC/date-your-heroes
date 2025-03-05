<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.project.datingapp.dao.*"%>
<%@ page import="com.project.datingapp.entities.*" %>

<!-- IMPORTA MODEL -->
<% int idUser = (int) request.getAttribute("iduser"); %>
<% DaoUsers du = (DaoUsers) request.getAttribute("daousers");%>
<html>
    <head>
        <title>SWIPE</title>
    </head>
    <body>

        <p>
            <% for(Map<String,String> record : du.getMatchingCharacters(idUser)){%>
                  <%=  record.get("interest") %>
                  <%= record.get("character") %>
                  <br>
            <% }%>
        </p>

    </body>


</html>

