package co.edu.unbosque.controller;

import co.edu.unbosque.ejb_singleton.SessionBeanLocal;
import co.edu.unbosque.model.Dao.UserDao;
import org.apache.commons.lang3.RandomStringUtils;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "Guardar", value = "/accion")
public class Photos extends HttpServlet {

    @EJB
    private SessionBeanLocal sessionBean;

    private UserDao userDao;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String boton = request.getParameter("btnEnviar");
        String cookiedatos = null;

        if (boton.equalsIgnoreCase("Guardar")) {
            String descripcion = request.getParameter("txtNombre");
            ImageIcon nombreFoto = new ImageIcon(request.getParameter("fileImagen"));
            nombreFoto.setDescription(SecuenciaALFA() + ".jpg");


            Cookie[] theCookies = request.getCookies();
            if (theCookies != null) {
                for (Cookie cookie_temporal : theCookies) {
                    if ("username".equals(cookie_temporal.getName())) {
                        cookiedatos = cookie_temporal.getValue();
                        break;
                    }
                }
            }

            userDao = new UserDao();
            userDao.add(cookiedatos, date(), descripcion, nombreFoto);
            response.sendRedirect("table.jsp");
        }
    }

    public String date() {
        String fecha;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        fecha = dateFormat.format(date);
        return fecha;
    }

    public String SecuenciaALFA() {
        Long.toHexString(Double.doubleToLongBits(Math.random()));
        UUID.randomUUID().toString();
        return RandomStringUtils.randomAlphanumeric(12);
    }
}
