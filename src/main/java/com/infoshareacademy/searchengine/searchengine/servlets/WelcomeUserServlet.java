package com.infoshareacademy.searchengine.searchengine.servlets;

import com.infoshareacademy.searchengine.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.searchengine.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome-user")
public class WelcomeUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UsersRepositoryDaoBean bean = new UsersRepositoryDaoBean();
//        User user = new User();
        PrintWriter writer = resp.getWriter();

        if (req.getParameter("name") == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("Hello " + req.getParameter("name") + "!<br />");
        writer.println("</body>");
        writer.println("</html>");

//        if (req.getParameter("name").equals(user.getName()))
//            writer.println("Hello " + req.ge);
//        else {
//            writer.println
//        }
    }

}
