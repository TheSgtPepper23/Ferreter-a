/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

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
 * @version 2.0
 * Entraday salida de los archivos inventario.dat y claves.txt
 */
public class Archivo {
  private final File archInventario;
  private final File archClaves;
  private final File archVentas;
  private final File archUsuarios;
  
  public Archivo (){
    archInventario = new File("inventario.dat");
    archClaves = new File("claves.txt");
    archVentas = new File("ventas.dat");
    archUsuarios = new File("usuarios.dat");
  }
  
  public File getArchInventario () {
    return archInventario;
  }
  
  public File getArchVentas () {
    return archVentas;
  }
  
  public File getArchClaves () {
    return archClaves;
  }
  
  public File getArchUsuarios () {
    return archUsuarios;
  }
  
  /**
   * Lee los datos del arcivo .dat donde se almacenan los artículos del inventario
   * @param archivo
   * @return Objetos leidos del archivo inventario.dat
   * 
   */
  public Object leerArchivo(File archivo) {
 
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    try {
      if(archivo.exists()) {
        fis = new FileInputStream(archivo);
        ois = new ObjectInputStream(fis);
        
        return ois.readObject();
      }
      else {
        archivo.createNewFile();
      }
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ClassNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
  /**
   * Escribe los datos del arraylist en el archivo .dat
   * @param arreglo Arraylist de objetos tipo Articulo
   */
  public void escribirArchivo (ArrayList arreglo, File archivo) {
    try {
      if (archivo.exists()) {
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(arreglo);
        fos.close();
        oos.close();
      }
      else {
        archivo.createNewFile();
      }
      
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
    if(archClaves.exists()) {
      try {
        BufferedReader br = new BufferedReader(new FileReader(archClaves));
        
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
        archClaves.createNewFile();
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
      FileWriter fw = new FileWriter(archClaves, true);
      BufferedWriter bw = new BufferedWriter (fw);
      PrintWriter pw = new PrintWriter (bw);
      pw.write(clave+"\r\n");
      pw.close();
      bw.close();
    } 
    catch (IOException e) {
    }
  }  
}
