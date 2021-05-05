package co.edu.unbosque.controller;

import co.edu.unbosque.model.singleton.SessionBeanLocal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.RandomStringUtils;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Class Photos
 */

@WebServlet(name = "Guardar", value = "/accion")
public class Photos extends HttpServlet {
  // Instancias de clases
    @EJB
    private SessionBeanLocal sessionBean;
    private Save save;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String json = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String boton = request.getParameter("btnEnviar");
        String cookiedatos = null;
          // validaciones para los botones
        if (boton.equalsIgnoreCase("Guardar")) {
            // se almacenan los datos recibidos para ser asociados a la cookie
            String descripcion = request.getParameter("txtNombre");
            String nombreFoto = request.getParameter("fileImagen");

            Cookie[] theCookies = request.getCookies();
            if (theCookies != null) {
                for (Cookie cookie_temporal : theCookies) {
                    if ("username".equals(cookie_temporal.getName())) {
                        cookiedatos = cookie_temporal.getValue();
                        break;
                    }
                }
            }

            save = new Save();
            // se agregan los datos a el metodo de agregar del singleton
            sessionBean.agregar(cookiedatos, date(), descripcion, nombreFoto);

            Gson g = new GsonBuilder().setPrettyPrinting().create();
            for (int i = 0; i < sessionBean.mostrar().size(); i++) {
                json = g.toJson(sessionBean.mostrar().get(i));
                System.out.println(json);
                break;
//                save.writeJson(json);
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\SergioHZ\\IdeaProjects\\Taller-4\\src\\main\\webapp\\json\\data.json"))) {
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
     * Method to generate an alphanumeric sequence
     *
     * @return Random alphanumeric sequence
     */
    public String ALFA() {
        Long.toHexString(Double.doubleToLongBits(Math.random()));
        UUID.randomUUID().toString();
        return RandomStringUtils.randomAlphanumeric(12);
    }
}
