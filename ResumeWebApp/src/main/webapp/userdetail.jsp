<%@ page import="com.company.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User u = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Detail</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h4>User Details</h4>
        </div>
        <div class="card-body">
            <form action="userdetail" method="POST">
                <input type="hidden" name="id" value="<%=u.getId()%>">
                <input type="hidden" name="action" value="update"/>
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="<%=u.getName()%>"/>
                </div>
                <div class="form-group">
                    <label for="surname">Surname</label>
                    <input type="text" class="form-control" id="surname" name="surname" value="<%=u.getSurname()%>"/>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" value="<%=u.getAddress()%>"/>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" id="phone" name="phone" value="<%=u.getPhone()%>"/>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email" value="<%=u.getEmail()%>"/>
                </div>
                <div class="form-group">
                    <label for="birthdate">Birthdate</label>
                    <input type="text" class="form-control" id="birthdate" name="birthdate" value="<%=u.getBirthDate()%>"/>
                </div>
                <button type="submit" class="btn btn-primary" value="Save">Save</button>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
