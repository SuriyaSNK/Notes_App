<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="refresh" content="1;url=index.html" />
</head>
<body>
    <%
        boolean success = (boolean) request.getAttribute("successful");
        if (success){
    %>
    <p>Note edited, redirecting...</p>
    <% } else {
    %>
    <p>Couldn't find index, redirecting...</p>
    <% } %>
</body>
</html>
