<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Note App</title>
</head>
<body>
<div class="main">
    <h2>Content:</h2>

    <%
        String noteContent = (String) request.getAttribute("noteContent");
        String imageUrl = (String) request.getAttribute("imageUrl");
    %>
    <p><%=noteContent%></p>
    <% if (!imageUrl.isEmpty()) { %>
    <img src="<%=imageUrl%>" alt="Image from note">
    <% } %>
</div>
</body>
</html>