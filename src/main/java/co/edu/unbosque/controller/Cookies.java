package co.edu.unbosque.controller;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Class Cokies
 */
//
@WebServlet(name = "loginWithCookies", value = "/login-with-cookies")
public class Cookies extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String names = null;
        response.setContentType("text/html");
        String name = request.getParameter("username");
        PrintWriter out = response.getWriter();
        try {
            //Creating cookies
            Cookie cUsername = new Cookie("username", name);
            //Adding the cookies to response header
            response.addCookie(cUsername);
        } catch (Exception e) {
            System.out.println(e);
        }
        // redirect to the photographs.jsp
        response.sendRedirect("photographs.jsp");
    }
}