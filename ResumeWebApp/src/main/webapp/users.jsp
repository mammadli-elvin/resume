<%@page import="com.company.dao.inter.UserDaoInter" %>
<%@page import="com.company.entity.User" %>
<%@page import="com.company.main.Context" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>JSP Page</title>
</head>
<body>
<%
    UserDaoInter userDao = Context.instanceUserDao();
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String phone = request.getParameter("phone");
    List<User> list = userDao.getUsersByCategory(name, surname, phone);
%>
<div class="container mycontainer">
    <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-6 col-sm-12">
            <form action="users.jsp" method="post">
                <input type="hidden" name="id" value="">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input class="form-control" placeholder="Enter name:" type="text" id="name" name="name" value=""/>
                </div>
                <br/>
                <div class="form-group">
                    <label for="surname">Surname:</label>
                    <input class="form-control" placeholder="Enter surname:" type="text" id="surname" name="surname"
                           value=""/>
                </div>
                <input class="btn btn-primary" type="submit" name="search" value="Search"/>
            </form>
        </div>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>name</th>
                <th>surname</th>
                <th>phone</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%
                for (User u : list) {
            %>
            <tr>
                <td><%=u.getName()%>
                </td>
                <td><%=u.getSurname()%>
                </td>
                <td><%=u.getPhone()%>
                </td>
                <td>
                    <button class="btn btn-danger" type="submit" value="delete" name="action">
                        <i class="fas fa-trash-alt"></i>
                    </button>
                    <button class="btn btn-secondary" type="submit" value="update" name="action">
                        <i class="fas fa-pen-square"></i>
                    </button>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
