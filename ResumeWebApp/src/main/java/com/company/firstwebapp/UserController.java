/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.company.firstwebapp;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String birthDateStr = request.getParameter("birthdate");
            java.util.Date birthDateUtil = sdf.parse(birthDateStr);
            java.sql.Date birthDate = new java.sql.Date(birthDateUtil.getTime());

            User user = userDao.getUserById(id);
            user.setName(name);
            user.setSurname(surname);
            user.setAddress(address);
            user.setPhone(phone);
            user.setEmail(email);
            user.setBirthDate(birthDate);

            userDao.updateUser(user);

            response.sendRedirect("users.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
