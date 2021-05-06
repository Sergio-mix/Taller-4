package co.edu.unbosque.controller;

import co.edu.unbosque.model.singleton.SessionBeanLocal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.RandomStringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import javax.servlet.http.Part;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Class Photos
 */

@WebServlet(name = "accion", value = "/accion")
@MultipartConfig
public class Photos extends HttpServlet {
    // Instancias de clases
    @EJB
    private SessionBeanLocal sessionBean;
    private Save save;
    private String pathFiles = "C:\\Users\\SergioHZ\\IdeaProjects\\Taller-4\\src\\main\\resources\\images\\";
    private File uploads = new File(pathFiles);
    private String[] extens = {".png", ".jpg", ".PNG"};


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String json = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String boton = request.getParameter("btnEnviar");
        String cookiedatos = null;
        // validaciones para los botones
        if (boton.equalsIgnoreCase("Guardar")) {
            // se almacenan los datos recibidos para ser asociados a la cookie
            String descripcion = request.getParameter("txtNombre");

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


            try {
                Part part = request.getPart("fileImagen");

                if (part == null) {
                    System.out.println("No ha seleccionado un archivo");
                    return;
                }

                if (isExtension(part.getSubmittedFileName(), extens)) {
                    // se agregan los datos a el metodo de agregar del singleton
                    String photo = saveFile(part, uploads);
                    sessionBean.agregar(cookiedatos, date(), descripcion, photo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            Gson g = new GsonBuilder().setPrettyPrinting().create();
            for (int i = 0; i < sessionBean.mostrar().size(); i++) {
                json = g.toJson(sessionBean.mostrar().get(i));
                System.out.println(json);
                break;
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\SergioHZ\\IdeaProjects\\Taller-4\\src\\main\\webapp\\json\\data.json"))) {
                bw.write(json);
                System.out.println("Fichero creado");
            } catch (IOException ex) {

            }

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

    private String saveFile(Part part, File pathUploads) {
        String pathAbsolute = "";

        try {

            Path path = Paths.get(part.getSubmittedFileName());
            String fileName = path.getFileName().toString();
            InputStream input = part.getInputStream();

            if (input != null) {
                File file = new File(pathUploads, fileName);
                String type = "";
                if (fileName.contains("jpg")) {
                    type = "jpg";
                }
                if (fileName.contains("png")) {
                    type = "png";
                }
                File fileNew = new File(pathUploads, ALFA() + "." + type);
                file.renameTo(fileNew);
                pathAbsolute = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pathAbsolute;
    }

    private boolean isExtension(String fileName, String[] extensions) {
        for (String et : extensions) {
            if (fileName.toLowerCase().endsWith(et)) {
                return true;
            }
        }
        return false;
    }
}
