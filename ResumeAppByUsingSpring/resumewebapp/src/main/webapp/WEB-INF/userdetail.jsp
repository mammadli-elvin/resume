<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Detail</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/users.css">
</head>
<body>
<div class="container mt-5">
    <form action="logout" method="GET" class="logout-form">
        <button type="submit" class="btn btn-danger logout-button">Logout</button>
    </form>
    <div class="card">
        <div class="card-header">
            <h4>User Details</h4>
        </div>
        <div class="card-body">
            <f:form action="userdetail" method="POST" modelAttribute="userdetail">
                <input type="hidden" name="id" value="${userdetail.id}">
                <input type="hidden" name="action" value="update"/>
                <div class="form-group">
                    <label for="name">Name</label>
                    <f:input path="name" id="name" class="form-control" value="${userdetail.name}"/>
                </div>
                <div class="form-group">
                    <label for="surname">Surname</label>
                    <f:input path="surname" id="surname" class="form-control" value="${userdetail.surname}"/>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <f:input path="address" id="address" class="form-control" value="${userdetail.address}"/>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <f:input path="phone" id="phone" class="form-control" value="${userdetail.phone}"/>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <f:input path="email" id="email" class="form-control" value="${userdetail.email}"/>
                </div>
                <div class="form-group">
                    <label for="birthdate">Birthdate</label>
                    <f:input path="birthdate" id="birthdate" class="form-control" value="${userdetail.birthdate}"/>
                </div>
                <button type="submit" class="btn btn-primary" value="Save">Save</button>
            </f:form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>


<%--source code mix java and html--%>

<%--<%@ page import="com.company.form.UserDetailForm" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%--%>
<%--    UserDetailForm u = (UserDetailForm) request.getAttribute("userdetail");--%>
<%--%>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>User Detail</title>--%>
<%--    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container mt-5">--%>
<%--    <div class="card">--%>
<%--        <div class="card-header">--%>
<%--            <h4>User Details</h4>--%>
<%--        </div>--%>
<%--        <div class="card-body">--%>
<%--            <form action="userdetail" method="POST">--%>
<%--                <input type="hidden" name="id" value="<%=u.getId()%>">--%>
<%--                <input type="hidden" name="action" value="update"/>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="name">Name</label>--%>
<%--                    <input type="text" class="form-control" id="name" name="name" value="<%=u.getName()%>"/>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="surname">Surname</label>--%>
<%--                    <input type="text" class="form-control" id="surname" name="surname" value="<%=u.getSurname()%>"/>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="address">Address</label>--%>
<%--                    <input type="text" class="form-control" id="address" name="address" value="<%=u.getAddress()%>"/>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="phone">Phone</label>--%>
<%--                    <input type="text" class="form-control" id="phone" name="phone" value="<%=u.getPhone()%>"/>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="email">Email</label>--%>
<%--                    <input type="text" class="form-control" id="email" name="email" value="<%=u.getEmail()%>"/>--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="birthdate">Birthdate</label>--%>
<%--                    <input type="text" class="form-control" id="birthdate" name="birthdate"--%>
<%--                           value="<%=u.getBirthDate()%>"/>--%>
<%--                </div>--%>
<%--                <button type="submit" class="btn btn-primary" value="Save">Save</button>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>
