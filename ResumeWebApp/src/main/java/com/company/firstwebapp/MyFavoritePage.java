package com.company.firstwebapp;

import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import com.company.main.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyFavoritePage", urlPatterns = {"/MyFavoritePage"})
public class MyFavoritePage extends HttpServlet {

    private SkillDaoInter skillDao = Context.instanceSkillDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Skill> skills = skillDao.getAllSkills();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyFavoritePage</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>I got GET request</h1>");
            for (Skill s : skills) {
                out.println(s + "<br>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        try {
            String requestStr = getAllDataFromRequest(req);
            System.out.println("request=" + requestStr);

            String name = String.valueOf(req.getParameter("name"));
            Skill skill = new Skill(0, name);
            boolean b = skillDao.addSkill(skill);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MyFavoritePage</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>I got POST request</h1>");
                out.println("skill inserted: " + skill.getId() + "<br>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception ex) {
            Logger.getLogger(MyFavoritePage.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public static String getAllDataFromRequest(HttpServletRequest request) throws Exception {
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
        body = stringBuilder.toString();
        return body;
    }
}
