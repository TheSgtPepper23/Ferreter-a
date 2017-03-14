/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import ferreteria.Articulo;
import ferreteria.Venta;
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
import usuarioSistema.Usuario;

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
  
  public void leerUsuario() {
    
    try {
      FileInputStream fis = null;
      ObjectInputStream ois = null;
      if(archUsuarios.exists()) {
        fis = new FileInputStream(archUsuarios);
        ois = new ObjectInputStream(fis);
        Usuario.usuarios = (ArrayList<Usuario>) ois.readObject();
      }
      else {
        archUsuarios.createNewFile();
      }
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ClassNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void escribirUsuario () {
    try {
      if (archUsuarios.exists()) {
        FileOutputStream fos = new FileOutputStream(archUsuarios);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Usuario.usuarios);
        fos.close();
        oos.close();
      }
      else {
        archUsuarios.createNewFile();
      }
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  
  /**
   * Lee los datos del arcivo .dat donde se almacenan los artículos del inventario
   * @param archivo
   * @return Objetos leidos del archivo inventario.dat
   * 
   */
  public void leerInventario() {
   
    try {
      FileInputStream fis = null;
      ObjectInputStream ois = null;
      if(archInventario.exists()) {
        fis = new FileInputStream(archInventario);
        ois = new ObjectInputStream(fis);
        Articulo.articulos = (ArrayList<Articulo>) ois.readObject();
      }
      else {
        archInventario.createNewFile();
      }
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ClassNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Escribe los datos del arraylist en el archivo .dat
   * @param arreglo Arraylist de objetos tipo Articulo
   */
  public void escribirInventario () {
    try {
      if (archInventario.exists()) {
        FileOutputStream fos = new FileOutputStream(archInventario);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Articulo.articulos);
        fos.close();
        oos.close();
      }
      else {
        archInventario.createNewFile();
      }
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  
  public void leerVentas() {
    
    try {
      FileInputStream fis = null;
      ObjectInputStream ois = null;
      if(archVentas.exists()) {
        fis = new FileInputStream(archVentas);
        ois = new ObjectInputStream(fis);
        Venta.ventas = (ArrayList<Venta>) ois.readObject();
      }
      else {
        archVentas.createNewFile();
      }
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException | ClassNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void escribirVentas () {
    try {
      if (archVentas.exists()) {
        FileOutputStream fos = new FileOutputStream(archVentas);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Venta.ventas);
        fos.close();
        oos.close();
      }
      else {
        archVentas.createNewFile();
      }
      
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * Lee las líneas de texto en un arhivo
   * @return una cadena con la palabra FERRE mas el número de clave actual
   */
  public String generarClaves () {
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
    return "FERRE" + cont;
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
