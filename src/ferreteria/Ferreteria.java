/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import accesoDatos.Archivo;
import java.util.ArrayList;

/**
 *
 * @author José Andrés Domínguez González
 * @version 1.0
 */
public class Ferreteria {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    Menu menu = new Menu();
    Archivo archivo = new Archivo();
    Inventario.articulos = (ArrayList<Articulo>) archivo.leerArchivo(archivo.getArchInventario());
    Inventario.ventas = (ArrayList<Venta>) archivo.leerArchivo(archivo.getArchVentas());
    int opcion;
    do {
      menu.mostarOpciones();
      opcion = menu.leerOpcion();
      menu.realizarOpcion(opcion);
      }while (opcion != 13);
  }
  
}
