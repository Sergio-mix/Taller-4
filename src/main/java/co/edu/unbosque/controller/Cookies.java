package co.edu.unbosque.controller;


import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "loginWithCookies", value = "/login-with-cookies")
public class Cookies extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String names=null;
        response.setContentType("text/html");
        String name = request.getParameter("username");
        PrintWriter out = response.getWriter();
        try {

            //Creating cookies
            Cookie cUsername = new Cookie("username", name);

            //Adding the cookies to response header
            response.addCookie(cUsername);
            out.println("<a href = 'photographs.jsp'>Uploading photos</a>");

        } catch (Exception e) {
            System.out.println(e);
        }

        Cookie[] theCookies =request.getCookies();
        if(theCookies!=null){
            for(Cookie cookie_temporal:theCookies){
                if("username".equals(cookie_temporal.getName())){
                        names = cookie_temporal.getValue();
                        break;
                }
            }

        }
        out.println(names);
    }


    public void destroy() {
    }
}