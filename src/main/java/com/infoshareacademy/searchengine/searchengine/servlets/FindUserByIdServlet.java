package com.infoshareacademy.searchengine.searchengine.servlets;

import com.infoshareacademy.searchengine.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.searchengine.domain.User;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



    @WebServlet("/find-user-by-id")
    public class FindUserByIdServlet extends HttpServlet {

        @Inject
        private UsersRepositoryDao bean;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if (req.getParameter("id") == null) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            PrintWriter writer = resp.getWriter();
            User user = new User();
//            UsersRepositoryDao bean = new UsersRepositoryDaoBean();

            String id = req.getParameter("id");

            if (bean.getUserById(Integer.parseInt(id)) == null) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            else {
                writer.println("<!DOCTYPE html>");
                writer.println("<html>");
                writer.println("<body>");
                writer.println("Hello " + bean.getUserById(Integer.parseInt(id)).getSurname() + "!<br />");
                writer.println("</body>");
                writer.println("</html>");
            }
        }
}
