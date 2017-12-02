package com.infoshareacademy.searchengine.searchengine.servlets;

import com.infoshareacademy.searchengine.searchengine.cdibean.MaxPulse;
import com.infoshareacademy.searchengine.searchengine.cdibean.MaxPulseBean;
import com.infoshareacademy.searchengine.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.searchengine.domain.Gender;
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
        @Inject
        private MaxPulse maxPulse;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if (req.getParameter("id") == null) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            PrintWriter writer = resp.getWriter();

            String id = req.getParameter("id");
            User user = bean.getUserById(Integer.parseInt(id));

//            UsersRepositoryDao bean = new UsersRepositoryDaoBean();


            if (bean.getUserById(Integer.parseInt(id)) == null) {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            else {
                writer.println("<!DOCTYPE html>");
                writer.println("<html>");
                writer.println("<body>");
                writer.println("Hello " + user.getSurname() + "!<br />");

                if (user.getGender() == Gender.MAN) {
                    writer.println(maxPulse.getPulseMan(user.getAge()));
                }
                else if (user.getGender() == Gender.WOMAN) {
                    writer.println(maxPulse.getPulseWoman(user.getAge()));
                }

                writer.println("</body>");
                writer.println("</html>");
            }
        }
}
