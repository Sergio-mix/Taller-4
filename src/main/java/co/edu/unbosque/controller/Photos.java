package co.edu.unbosque.controller;

import co.edu.unbosque.model.Dao.UserDao;
import com.google.gson.Gson;
import org.apache.commons.lang3.RandomStringUtils;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "Guardar", value = "/accion")
public class Photos extends HttpServlet {

    private UserDao userDao;
    private Save save;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        String boton = request.getParameter("btnEnviar");


        if (boton.equalsIgnoreCase("Guardar")) {
            String cookiedatos = null;

            Cookie[] theCookies = request.getCookies();
            if (theCookies != null) {
                for (Cookie cookie_temporal : theCookies) {
                    if ("username".equals(cookie_temporal.getName())) {
                        cookiedatos = cookie_temporal.getValue();
                        break;
                    }
                }
            }
            String descripcion = request.getParameter("txtNombre");
            String photo = request.getParameter("fileImagen");

            userDao = new UserDao();
            userDao.add(cookiedatos, date(), descripcion, photo);


            Gson g = new Gson();
            for (int i = 0; i < userDao.getListUser().size(); i++) {
                System.out.println(g.toJson(userDao.getListUser().get(i)));
                save.writeJson(g.toJson(userDao.getListUser().get(i)));
            }
//            save.writeJson(g.toJson());
            response.sendRedirect("table.jsp");
        }
    }

    /**
     * Method to get the current date
     *
     * @return date
     */
    public String date() {
        String fecha;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        fecha = dateFormat.format(date);
        return fecha;
    }

    /**
     * Method of Generating a Random Alpha Numeric Sequence
     *
     * @return 12 character sequence
     */
    public String secuenciaALFA() {
        Long.toHexString(Double.doubleToLongBits(Math.random()));
        UUID.randomUUID().toString();
        return RandomStringUtils.randomAlphanumeric(12);
    }
}
