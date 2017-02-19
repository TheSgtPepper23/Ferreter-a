/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Andrés Domínguez González
 * @version 1.0
 * Entraday salida de los archivos inventario.dat y claves.txt
 */
public class Archivo {
  File arkiv;
  File claves;
  File archivieren;
  
  public Archivo (){
    arkiv = new File("inventario.dat");
    claves = new File("claves.txt");
    archivieren = new File("ventas.dat");
  }
  
  /**
   * Lee los datos del arcivo .dat donde se almacenan los artículos del inventario
   */
  public void leerArchivo() {
   
    try {
      if(arkiv.exists()) {
        FileInputStream fis = new FileInputStream(arkiv);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Inventario.articulos = (ArrayList) ois.readObject();
      }
      else {
        arkiv.createNewFile();
      }
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ClassNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  /**
   * Escribe los datos del arraylist en el archivo .dat
   */
  public void escribirArchivo () {
    try {
      FileOutputStream fos = new FileOutputStream(arkiv);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(Inventario.articulos);
      fos.close();
      oos.close();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Lee las líneas de texto en un arhivo
   * @return El número de líneas del archivo
   */
  public int leerClaves () {
    int cont = 0;
    if(claves.exists()) {
      try {
        BufferedReader br = new BufferedReader(new FileReader(claves));
        
        while(br.readLine() != null) {
          cont ++;
        }
        br.close();
        
      } catch (FileNotFoundException ex) {
        Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
        Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    else {
      try {
        claves.createNewFile();
      } catch (IOException ex) {
        Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return cont;
  }
  
  /**
   * Escribe la clave del artículo en un archivo de texto
   * @param clave La clave del archivo
   */
  public void escribirClaves (String clave) {
     try {
      FileWriter fw = new FileWriter(claves, true);
      BufferedWriter bw = new BufferedWriter (fw);
      PrintWriter pw = new PrintWriter (bw);
      pw.write(clave+"\r\n");
      pw.close();
      bw.close();
    } catch (IOException e) {
      }
  }
  
  public void leerVentas () {
    try {
      if(archivieren.exists()) {
        FileInputStream fis = new FileInputStream(archivieren);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Inventario.ventas = (ArrayList) ois.readObject();
      }
      else {
        arkiv.createNewFile();
      }
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ClassNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void escribirVentas () {
    try {
      FileOutputStream fos = new FileOutputStream(archivieren);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(Inventario.ventas);
      fos.close();
      oos.close();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
