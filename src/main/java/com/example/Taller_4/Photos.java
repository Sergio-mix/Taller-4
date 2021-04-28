package com.example.Taller_4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Guardar", value = "/photo_saved")
public class Photos extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String namePhoto1 = "photos";
        String namePhoto2 = alphanumeric(namePhoto1);
        String descripcion = "descripcion";
        PrintWriter out = response.getWriter();
        out.println(namePhoto2);
        out.println(descripcion);


    }

    public void destroy() {
    }

    public String alphanumeric(String name_photo) {
        int cont = 0;

        String result = null;
        if (cont >= 0) {
            cont ++;
            if (isNumeric(name_photo) == true) {

                result = name_photo + "" + cont;
            } else {
                result = name_photo + "Photo" + cont;
            }
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
