package com.example.Taller_4;


import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginWithCookies", value = "/login-with-cookies")
public class Cookies extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String name = request.getParameter("username");

        try {
            PrintWriter out = response.getWriter();
            //Creating cookies
            Cookie cUsername = new Cookie("username", name);

            //Adding the cookies to response header
            response.addCookie(cUsername);
            out.println("<a href = 'Photographs.html'>Uploading photos</a>");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void destroy() {
    }
}