/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.util.Date;

/**
 *
 * @author José Andrés Domínguez González
 */
public class Venta {
  private Date fecha;
  private final String[][] carrito;
  private int tamanio;
  
  public Venta (String carrito [][], int tamaño) {
    this.fecha = new Date();
    this.tamanio = tamaño;
    this.carrito = carrito;
  }
  
  public Date getFecha () {
    return fecha;
  }
  
  public String getCarrito (int fila, int columna) {
    return carrito[fila][columna];
  }
  
  public int getTamanio () {
    return tamanio;
  }
}
