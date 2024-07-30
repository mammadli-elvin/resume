<%-- 
    Document   : user.jsp
    Created on : Jul 20, 2024, 12:03:04 AM
    Author     : elvin
--%>

<%@page import="com.company.dao.inter.UserDaoInter"%>
<%@page import="com.company.main.Context"%>
<%@page import="com.company.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            UserDaoInter userDao = Context.instanceUserDao();

//            if (request.getParameter("save") != null && request.getParameter("save").equals("Save")) {
//                int id = Integer.parseInt(request.getParameter("id"));
//                String name = request.getParameter("name");
//                String surname = request.getParameter("surname");
//
//                System.out.println("name=" + name);
//                System.out.println("surname=" + surname);
//
//                User user = userDao.getUserById(id);
//                user.setName(name);
//                user.setSurname(surname);
//
//                userDao.updateUser(user);
//            }
            User u = userDao.getUserById(6);
        %>

        <div>
            <form action="UserController" method="POST">
                <input type="hidden" name="id" value="<%=u.getId()%>">
                <label for="name">name:</label>
                <input type="text" name="name" value="<%=u.getName()%>"/>
                <br/>
                <label for="surname">surname:</label>
                <input type="text" name="surname" value="<%=u.getSurname()%>"/>
                <input type="submit" name="save" value="Save"/>
                
                <hr>
                
                <div>
                    <label for="address">Address</label>
                    <input type="text" name="address" value="<%=u.getAddress()%>"/>
                </div>
                <div>
                    <label for="phone">Phone</label>
                    <input type="text" name="phone" value="<%=u.getPhone()%>"/>
                </div>
                <div>
                    <label for="email">Email</label>
                    <input type="text" name="email" value="<%=u.getEmail()%>"/>
                </div>
                <div>
                    <label for="birthdate">Birthdate</label>
                    <input type="text" name="birthdate" value="<%=u.getBirthDate()%>"/>
                </div>       
            </form>
        </div>
        <hr>

    </body>
</html>
