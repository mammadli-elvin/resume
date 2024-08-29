<%@ page import="com.company.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: elvin
  Date: 8/25/2024
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) session.getAttribute("loggedInUser");
%>
<%="Welcome, " + user.getName() + "!!!"%>