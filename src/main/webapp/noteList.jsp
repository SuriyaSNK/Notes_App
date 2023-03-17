<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Note App</title>
</head>
<body>
<div class="main">
  <h2>Notes:</h2>
  <ol>
    <%
      List<String> noteNames = (List<String>) request.getAttribute("noteNames");
      List<Integer> noteIds = (List<Integer>) request.getAttribute("noteIds");
      int size = noteIds.size();

      for (int i = 0; i <= size - 1; i++)
      {
        String href = "/viewnote.html?key1=" + noteIds.get(i);
    %>
    <li>
      <a href="<%=href%>"><%=noteNames.get(i)%></a>
    </li>
    <% } %>
  </ol>
</div>
</body>
</html>