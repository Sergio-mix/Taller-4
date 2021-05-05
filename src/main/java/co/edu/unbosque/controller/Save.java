package co.edu.unbosque.controller;


import com.google.gson.Gson;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Save {


    public void writeJson(String json){
//        try {
//            System.out.println("entre1");
//            FileWriter file = new FileWriter("\\Taller-4\\src\\main\\webapp\\json\\datos.json");
//            file.write(json);
//            System.out.println("entre2");
//            file.close();
//
//        } catch (IOException e) {
//            //manejar error
//            System.out.println("entre3");
//        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("\\Taller-4\\src\\main\\webapp\\json\\datos.json"))) {
            System.out.println("entre1");
            bw.write(json);
            System.out.println("entre2");
            System.out.println("Fichero creado");
        } catch (IOException ex) {
            System.out.println("entre3");
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

