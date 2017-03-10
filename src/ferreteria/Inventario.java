/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import Informacion.Archivo;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Contiene los metodos para manipular los elementos del inventario
 * @author José Andrés Domínguez González
 */
public class Inventario {
  
  private Articulo articulo;
  private Venta nuevaVenta;
  private Teclado leer;
  private Archivo arxiu;
  public static ArrayList<Articulo> articulos = new ArrayList<>();
  public static ArrayList<Venta> ventas = new ArrayList<>();
  private final double IVA;
  private final double GANANCIA;

  /**
   * Constructor principal de la clase Inventario, inicializa instancias y variables de clase
   */
  public Inventario() {
    this.IVA = 1.16;
    this.GANANCIA = 1.50;
    leer = new Teclado();
    arxiu = new Archivo();
  }
  
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
    arxiu.escribirArchivo();
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
            arxiu.escribirArchivo();
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
   */
  public void realizarVenta () {
    nuevaVenta = new Venta();
    String carrito = "";
    int opcion = 0, cantidad, unidad, i;
    String nombre;
    double total, subtotal, gTotal = 0;
    
    do {
      System.out.println("Ingrese el nombre o la clave del producto que desea");
      nombre = leer.leerString().toUpperCase();
      for(i = 0; i < articulos.size(); i++) {
        if(articulos.get(i).getNombre().equals(nombre) || articulos.get(i).getClave().equals(nombre)) {
          unidad = determinaUnidad(articulos.get(i));
          System.out.println("¿Cuántos unidades del artículo desea comprar?");
          cantidad = leer.leerEntero();
          leer.salto();
          subtotal = cantidad * articulos.get(i).getPrecioCompra()*GANANCIA;
          total = subtotal*IVA;
          if(suficiente(articulos.get(i), cantidad)) {
            articulos.get(i).setExistencia(articulos.get(i).getExistencia()-(cantidad*unidad));
            carrito += "\nNombre: "+articulos.get(i).getNombre()+"\nCantidad: "+cantidad+
                "\nSubtotal: "+subtotal+"\nTotal: "+ total+"\n\n";
            gTotal += total;
          }
          else {
            System.out.println("Lo sentimos la vena no pudo llevarse a cabo");
          }
        }
        else {
          System.out.println("Lo sentimos la vena no pudo llevarse a cabo");
        }
        System.out.println("¿Desea comprar otro artículo?\nTeclee '1' para aceptar y cualquier otro"
          + "número para salir");
        opcion = leer.leerEntero();
        leer.salto();
      }
    }while(opcion == 1);
    nuevaVenta.setCarrito(carrito);
    nuevaVenta.setGTotal(gTotal);
    ventas.add(nuevaVenta);
  }
  
  /**
   * Muestra las ventas que se han realizado y la suma total de las mismas
   */
  public void mostrarVentas () {
    for(int i = 0; i < ventas.size(); i++) {
      System.out.println(simplificaFecha(ventas.get(i).getFecha()));
      System.out.println("---------------------------------");
      System.out.println(ventas.get(i).getCarrito());
      System.out.println("Gran total: "+ventas.get(i).getGTotal());
      System.out.println("*********************************");
    }
  }
  
  /**
   * Transforma la fecha a un formato simple
   * @param fecha Objeto del tipo Date
   * @return String con la fecha en el format D/M/A
   */
  public String simplificaFecha (Date fecha) {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
    return formato.format(fecha);
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
   * Muestra el valor del inventario en pesos
   * @return El valor total del invetario
   */
  public double valorInventario () {
    double suma = 0;
    for(int i =0; i < articulos.size(); i++) {
      suma += articulos.get(i).getPrecioCompra()*(articulos.get(i).getExistencia()/
          determinaUnidad(articulos.get(i)));
    }
    return suma;
  }
  
  /**
   * Devuelve las ventas que se realizaron en una fecha exacta
   * @param fecha String con el formato dd/MM/yyy de la fecha que se desea buscar
   */
  public void ventasFechaExacta (String fecha) {
    for(int i = 0; i < ventas.size(); i++) {
      if (simplificaFecha(ventas.get(i).getFecha()).equals(fecha)) {
        System.out.println(simplificaFecha(ventas.get(i).getFecha()));
        System.out.println("---------------------------------");
        System.out.println(ventas.get(i).getCarrito());
        System.out.println("Gran total: "+ventas.get(i).getGTotal());
        System.out.println("*********************************");
      }
      else {
        System.out.println("No hubo ventas en esa fecha");
      }
    }
  }
  
  /**
   * Permite filtrar las ventas por mes 
   * @param fecha el número del mes que se desea filtrar 
   */
  public void ventasMes (String fecha) {
    fecha = "/"+fecha+"/";
    for (int i = 0; i < ventas.size(); i++) {
      if(simplificaFecha(ventas.get(i).getFecha()).contains(fecha)) {
        System.out.println(simplificaFecha(ventas.get(i).getFecha()));
        System.out.println("---------------------------------");
        System.out.println(ventas.get(i).getCarrito());
        System.out.println("Gran total: "+ventas.get(i).getGTotal());
        System.out.println("*********************************");
      }
    }
  }
}

