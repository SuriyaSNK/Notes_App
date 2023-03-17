<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Note App</title>
</head>
<body>
<div class="main">
  <h1>Note:</h1>
  <%
    String noteContent = (String) request.getAttribute("content");
    String imageUrl = (String) request.getAttribute("imageUrl");
  %>
  <p><%=noteContent%></p>
  <% if (!imageUrl.isEmpty()) { %>
  <img src="<%=imageUrl%>" alt="Image from note">
  <% } %>
</div>
</body>
</html>