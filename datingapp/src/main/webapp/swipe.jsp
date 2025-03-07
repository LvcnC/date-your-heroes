<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.project.datingapp.dao.*"%>
<%@ page import="com.project.datingapp.entities.HistoryCharacter" %>

<!-- IMPORTA MODEL -->
<% int idUser = (int) request.getAttribute("iduser"); %>
<% DaoUsers du = (DaoUsers) request.getAttribute("daousers");%>
<% ArrayList<HistoryCharacter> swipeableCharacters = (ArrayList<HistoryCharacter>) request.getAttribute("swipeableCharacters"); %>
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
        <p>
        <!-- SWIPEABLECHARACTERS è un ARRAY LIST !!!!!!!!!! -->
            <% for(HistoryCharacter character : swipeableCharacters){%>
                  <%=  character.getId() %>
                  <%=   character.getName() %>
                  <br>
            <% }%>
        </p>

    </body>


</html>

