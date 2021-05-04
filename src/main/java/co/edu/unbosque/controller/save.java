package co.edu.unbosque.controller;


import com.google.gson.Gson;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class save {


    public void writeJson(){
        String json="";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("datos_persona.json"))) {
            bw.write(json);
            System.out.println("Fichero creado");
        } catch (IOException ex) {
//            Logger.getLogger(LeerJsonEj3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public void readjson(){
      String fichero = "";

      try (BufferedReader br = new BufferedReader(new FileReader("datos.json"))) {
          String linea;
          while ((linea = br.readLine()) != null) {
              fichero += linea;
          }

      } catch (FileNotFoundException ex) {
          System.out.println(ex.getMessage());
      } catch (IOException ex) {
          System.out.println(ex.getMessage());
      }
  }

}

