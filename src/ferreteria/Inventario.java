/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Contiene los metodos para manipular los elementos del inventario
 * @author José Andrés Domínguez González
 */
public class Inventario {
  
  Articulo articulo;
  Teclado leer = new Teclado();
  Archivo arxiu = new Archivo();
  static ArrayList<Articulo> articulos = new ArrayList<>();
  static ArrayList<Double> ventas = new ArrayList<>();
  final double IVA = 1.16;
  final double GANANCIA = 1.50;
  
  /**
   * Genera un clave de tipo String para un artículo
   * @return String compuesto por los caracteres FERRE más el número de líneas del archivo claves.txt
   */
  public String generarClave () {
    return "FERRE" + arxiu.leerClaves();
  }
  
  /**
   * Utiliza los métodos set de la clase Articulo para crear una nueva instancia y la guarda en un ArrayList llamado articulos
   * @throws IOException 
   */
  public void agregarArticulo() throws IOException {
    articulo = new Articulo();
    articulo.setClave(generarClave());
    System.out.println("¿Cuál es el nombre del articulo que desea agregar?");
    articulo.setNombre(leer.leerString().toUpperCase());
    System.out.println("Ingrese una pequeña descripción del artículo:");
    articulo.setDescripcion(leer.leerString().toUpperCase());
    System.out.println("¿Cuál es el precio de compra?:");
    articulo.setPrecioCompra(leer.leerDouble());
    System.out.println("¿Cuántos artículos está ingresando?:");
    articulo.setExistencia(leer.leerEntero());
    leer.salto();
    System.out.println("¿Qué tipo de unidad usa el artículo?:");
    articulo.setTipoUnidad(leer.leerString().toUpperCase());
    arxiu.escribirClaves(articulo.getClave());
    articulos.add(articulo);
    
  }
  
  /**
   * Muestra los datos de los objetos almacenados en el arraylist del archivo
   */
  public void mostrarArticulos() {
    for (int i = 0; i < articulos.size(); i++)
    {
      System.out.println("_____________________________________________________");
      System.out.println("Clave: "+articulos.get(i).getClave());
      System.out.println("Nombre: "+articulos.get(i).getNombre());
      System.out.println("Descripción: "+articulos.get(i).getDescripcion());
      System.out.println("Existencia: "+articulos.get(i).getExistencia());
      System.out.println("Precio de compra: "+articulos.get(i).getPrecioCompra());
      System.out.println("Tipo de unidad: "+ articulos.get(i).getTipoUnidad());
      System.out.println("_____________________________________________________");
    }
  }

  /**
   * 
   * @param buscar Es nombre o clave del archivo que se desea visualizar
   * Busca articulos por nombre o clave
   */
  public void buscarArticulo(String buscar) {
    buscar = buscar.toUpperCase();
    boolean flag = false;
    for(int i = 0; i < articulos.size(); i++) {
      if(articulos.get(i).getNombre().equals(buscar) || articulos.get(i).getClave().equals(buscar)) {
        System.out.println("Nombre: "+articulos.get(i).getNombre());
        System.out.println("Descripción: "+articulos.get(i).getDescripcion());
        System.out.println("Existencia: "+articulos.get(i).getExistencia());
        System.out.println("Precio de compra: "+articulos.get(i).getPrecioCompra());
        System.out.println("Tipo de unidad: "+articulos.get(i).getTipoUnidad());
        flag = true;
        break;
      }
    }
    
    if(!flag) {
       System.out.println("El artículo no se encuentra");
    }
  }
  
  /**
   * Eliminar un artíuclo de el ArrayList articulos (Su clave no desaparece del archivo claves)
   * @param eliminar El nombre o clave del archivo que se desea eliminar 
   */
  public void eliminarArticulo (String eliminar) {
    eliminar = eliminar.toUpperCase();
    boolean flag = false;
    for(int i = 0; i < articulos.size(); i++) {
      if(articulos.get(i).getNombre().equals(eliminar) || articulos.get(i).getClave().equals(eliminar)) {
        articulos.remove(i);
        flag = true;
        break;
      }
    }
    
    if(!flag){
      System.out.println("Ese artículo no existe");
    }
  }
  
  /**
   * Permite editar el nombre y la descripción de un artíuclo determinado
   * @param editar Es el nombre o la clave del artículo que el cliente desea editar 
   */
  public void editarArticulo (String editar) {
    editar = editar.toUpperCase();
    boolean flag = false;
    for(int i = 0; i < articulos.size(); i++) {
      if(articulos.get(i).getNombre().equals(editar) || articulos.get(i).getClave().equals(editar)) {
        System.out.println("¿Qué elemento desea modificar?\n1) Nombre\n2) Descripción\n");
        switch(leer.leerEntero()) {
          case 1:
            System.out.println("Ingrese el nuevo nombre para el artículo");
            leer.salto();
            articulos.get(i).setNombre(leer.leerString().toUpperCase());
            System.out.println("Los cambios se han realizado y se guardaran al salir");
            break;
          case 2:
            System.out.println("Ingrese la nueva descripción para el artículo");
            leer.salto();
            articulos.get(i).setDescripcion(leer.leerString().toUpperCase());
            System.out.println("Los cambios se han realizado y se guardaran al salir");
            break;
        }
        flag = true;
        break;
      }
    }
    
    if(!flag){
      System.out.println("Ese artículo no existe");
    }
  }
  
  /**
   * Ordena los elementos del array list en orden alfabético ascendente por la clave 
   */
  public void ordenarClave () {
    Collections.sort(articulos, new Comparator<Articulo>(){
      @Override
      public int compare(Articulo a1, Articulo a2){
        return new Integer(a1.getClave()).compareTo(new Integer(a2.getClave()));
      }
    });
  }
  
   /**
   * Ordena los elementos del array list en orden alfabético ascendente por el nombre
   */
  public void ordenarNombre () {
    Collections.sort(articulos, new Comparator<Articulo>(){
      @Override
      public int compare(Articulo a1, Articulo a2){
        return a1.getNombre().compareTo(a2.getNombre());
      }
    });
  }
  
  /**
   * Realiza una venta de productos en el inventario
   * @param vender El nombre del artículo que se dea vender
   * @return true si la venta se realizo con éxito y false si no se pudo llevar a cabo la transacción
   */
  public boolean realizarVenta (String vender) {
    vender = vender.toUpperCase();
    int unidad, cantidad;
    double total;
    for(int i = 0; i < articulos.size(); i++) {
      if(articulos.get(i).getNombre().equals(vender) || articulos.get(i).getClave().equals(vender)) {
        unidad = determinaUnidad(articulos.get(i));
        System.out.println("Cuantas 'unidades' desea vender");
        cantidad = leer.leerEntero();
        total = cantidad * articulos.get(i).getPrecioCompra()*IVA*GANANCIA;
        if(suficiente(articulos.get(i), cantidad)) {
          articulos.get(i).setExistencia(articulos.get(i).getExistencia()-(cantidad*unidad));
          ventas.add(total);
          return true;
        }
        else {
          return false;
        }
      }
    }
      return false;
  }
  
   /**
    * Determina cuantos elementos se pueden vender según el campo tipoUnidad
    * @param elemento Instancia de la clase Artículo
    * @return El número de elementos que se venden por 'unidad'
    */
  public int determinaUnidad (Articulo elemento) {
    if(elemento.getTipoUnidad().equals("DECENA")) {
      return 10;
    }
    if (elemento.getTipoUnidad().equals("PIEZA")) {
      return 1;
    }
    else {
      return 100;
    }
  }
  
  /**
   * Determina si existen suficientes elementos de un articulo para llevar a cabo una venta
   * @param elemento un objeto de tipo Articulo
   * @param venta La cantidad de producto que se desea vender
   * @return true si el producto es suficiente y false si la cantidad a vender es mayor que la existencia
   */
  public boolean suficiente (Articulo elemento, int venta) {
    return elemento.getExistencia()>=venta;
  }
  
  /**
   * Muestra las ventas que se han realizado y la suma total de las mismas
   */
  public void mostrarVentas () {
    double suma = 0;
    for(int i = 0; i < ventas.size(); i++) {
      System.out.println("$ "+ventas.get(i));
      suma += ventas.get(i);
    }
    System.out.println("El total es: "+suma);
  }
  
  /**
   * Muestra el valor del inventario en pesos
   * @return El valor total del invetario
   */
  public double valorInventario () {
    double suma = 0;
    for(int i =0; i < articulos.size(); i++) {
      suma += articulos.get(i).getPrecioCompra()*(articulos.get(i).getExistencia()/determinaUnidad(articulos.get(i)));
    }
    return suma;
  }
}

