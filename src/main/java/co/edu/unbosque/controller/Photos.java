package co.edu.unbosque.controller;

import co.edu.unbosque.ejb_singleton.SessionBeanLocal;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Guardar", value = "/accion")
public class Photos extends HttpServlet {

    @EJB

    private SessionBeanLocal sessionBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String boton = request.getParameter("btnEnviar");
        String junto ="";
        String cookiedatos = null;

        if (boton.equalsIgnoreCase("Guardar")) {
            String descripcion = request.getParameter("txtNombre");
            String nombreFoto = request.getParameter("fileImagen");
            String nombreFotoDef = alphanumeric(nombreFoto);

            Cookie[] theCookies =request.getCookies();
            if(theCookies!=null){
                for(Cookie cookie_temporal:theCookies){
                    if("username".equals(cookie_temporal.getName())){
                        cookiedatos = cookie_temporal.getValue();
                        break;
                    }
                }
            }

             junto ="Nombre de la fotografia: "+ nombreFotoDef + "---" +"Descripcion: "+ descripcion+"---"+"Username: "+cookiedatos;
            sessionBean.agregar(junto);
            out.println("<h4> Nombre de foto agregado correctamente</h4>");
            out.println("<a href = 'photographs.jsp'>Volver</a>");
        } else {
            if (boton.equalsIgnoreCase("Mostrar")) {
                out.println("<h4>" + sessionBean.mostrar() + "</h4>");
            }
            out.println("<a href = 'photographs.jsp'>Volver</a>");
        }
    }

    public void destroy() {
    }
    int cont = 0;

    public String alphanumeric(String name_photo) {
        String result = null;

        if (cont >= 0) {

            if (isNumeric(name_photo) == true) {

                result = name_photo + "" + cont;
            } else {
                result = name_photo + "Photo" + cont;
            }
            cont++;
        }


        return result;
    }

    public boolean isNumeric(String chain) {
        boolean isNumeric = false;
        for (int i = 0; i < chain.length(); i++) {
            if (!Character.isDigit(chain.charAt(i))) {
                isNumeric = true;
            }
        }
        return isNumeric;
    }
}
