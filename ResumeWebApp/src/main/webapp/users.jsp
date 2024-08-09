<%@ page import="com.company.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Users</title>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-xl-6 col-lg-8 col-md-10 col-sm-12">
            <div class="card">
                <div class="card-header">
                    <h4>Search Users</h4>
                </div>
                <div class="card-body">
                    <form action="users" method="GET">
                        <input type="hidden" name="id" value="">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input class="form-control" placeholder="Enter name" type="text" id="name" name="name" value=""/>
                        </div>
                        <div class="form-group">
                            <label for="surname">Surname:</label>
                            <input class="form-control" placeholder="Enter surname" type="text" id="surname" name="surname" value=""/>
                        </div>
                        <button type="submit" class="btn btn-primary" name="search">Search</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row justify-content-center mt-4">
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    <h4>User List</h4>
                </div>
                <div class="card-body">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Phone</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<User> users = (List<User>) request.getAttribute("users");
                            for (User u : users) {
                        %>
                        <tr>
                            <td><%=u.getName()%></td>
                            <td><%=u.getSurname()%></td>
                            <td><%=u.getPhone()%></td>
                            <td>
                                <div style="display: flex; gap: 10px;">
                                    <form action="userdetail" method="POST" style="display: inline-block;">
                                        <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                        <input type="hidden" name="action" value="delete"/>
                                        <button class="btn btn-danger" type="submit" value="delete">
                                            <i class="fas fa-trash-alt"></i>
                                        </button>
                                    </form>
                                    <form action="userdetail" method="GET" style="display: inline-block;">
                                        <input type="hidden" name="id" value="<%=u.getId()%>"/>
                                        <button class="btn btn-secondary" type="submit" value="update">
                                            <i class="fas fa-pen-square"></i>
                                        </button>
                                    </form>
                                </div>
                            </td>
                        </tr>
                        <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

