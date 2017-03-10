/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import Informacion.Archivo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Crea un interfaz con el usuario mostrando menús y leyendo opciones
 * @author José Andrés Domínguez González
 */
public class Menu {
  
  Inventario inv = new Inventario();
  Archivo file = new Archivo();
  Teclado lect = new Teclado();
  
  /**
   * Muestra el menú con las opciones disponibles
   */
  public void mostarOpciones ()
  {
    System.out.println("Bienvenido\n¿Qué acción desea realizar?\n\n1) Agregar artículo\n"
        + "2) Mostrar inventario\n3) Editar artículo\n4) Eliminar artículo\n5) Mostrar ventas"
        + "\n6) Buscar\n7) Ordenar por clave\n8) Ordenar por nombre\n9) Realizar venta\n"
        + "10) Valor del inventario\n11) Filtrar ventas\n12) Filtrar por mes\n13) Salir");
  }
  
  /**
   * Lee la opciones del usuario usando la clase Teclado
   * @return La opción leida del usuario, el valor es de tipo entero
   */
  public int leerOpcion ()
  {
    System.out.println("¿Qué acción desea realizar?\n");
    return lect.leerEntero();
  }
  
  /**
   * Ejecuta los métodos que necesarios para llevar a cabo la opción solicitada por elusuario
   * @param opcion Valor leido del susario del tipo entero, este valor define los métodos que se ejecutarán de la clase Inventario
   */
  public void realizarOpcion(int opcion)
  {
    switch(opcion)
    {
      case 1:
    {
      try {
        inv.agregarArticulo();
      } catch (IOException ex) {
        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
        break;
      case 2:
        inv.mostrarArticulos();
        break;
      case 3:
        System.out.println("Escriba el nombre o clave del artículo que desea editar");
        lect.salto();
        inv.editarArticulo(lect.leerString());
        break;
      case 4:
        System.out.println("Escriba el nombre o la clave del proucto que desea eliminar");
        lect.salto();
        inv.eliminarArticulo(lect.leerString());
        break;
      case 5:
        inv.mostrarVentas();
        break;
      case 6:
        System.out.println("Escriba el nombre o la clave del proucto que desea buscar");
        lect.salto();
        inv.buscarArticulo(lect.leerString());
        break;
      case 7:
        inv.ordenarClave();
        inv.mostrarArticulos();
        break;
      case 8:
        inv.ordenarNombre();
        inv.mostrarArticulos();
        break;
      case 9:
        inv.realizarVenta();
        break;
      case 10:
        System.out.println("El valor del inventario es de "+ inv.valorInventario());
        break;
      case 11:
        lect.salto();
        System.out.println("Escriba la fecha en el formato dd/mm/aa utilizando solo números");
        inv.ventasFechaExacta(lect.leerString());
        break;
      case 12:
        lect.salto();
        System.out.println("Escriba el número del mes que desea buscar, utilice dos números");
        inv.ventasMes(lect.leerString());
        break;
      case 13:
        file.escribirArchivo(Inventario.articulos);
        file.escribirVentas(Inventario.ventas);
        break;
      default:
        System.out.println("Esa no es una opción válida");
    }
  }
}
