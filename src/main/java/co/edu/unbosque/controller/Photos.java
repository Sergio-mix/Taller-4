package co.edu.unbosque.controller;

import co.edu.unbosque.ejb_singleton.SessionBeanLocal;
import co.edu.unbosque.model.Dao.UserDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.RandomStringUtils;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Guardar", value = "/accion")
public class Photos extends HttpServlet {

    @EJB
    private SessionBeanLocal sessionBean;

    private UserDao userDao;
    private Save save;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String json = null;
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
            save =  new Save();
            userDao.add(cookiedatos, date(), descripcion, nombreFoto);
            Gson g = new GsonBuilder().setPrettyPrinting().create();
            for(int i=0; i<userDao.getListUser().size();i++){
                json = g.toJson(userDao.getListUser().get(i));
                System.out.println(json);
               break;
//                save.writeJson(json);
            }
            String opcion = String.valueOf(getClass().getResourceAsStream("/json/data.json"));
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(opcion))) {
                bw.write(json);
                System.out.println("Fichero creado");
            } catch (IOException ex) {

            }

//            Writer writer = new FileWriter("data.json");
//            writer.write(json);
//            writer.close();
//
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
