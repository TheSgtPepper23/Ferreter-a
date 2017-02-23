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
  private String carrito;
  
  /**
   * Constructor por de la clase Venta
   * @param carrito Matriz de String que contiene el nombre del producto, la cantidad, el subtotal 
   * y total
   * @param tamaño Cantidad de artículos distintos que se incluyen en la venta 
   */
  public Venta () {
    this.fecha = new Date();
  }
  
  public Date getFecha () {
    return fecha;
  }
  
  public String getCarrito () {
    return carrito;
  }
  
  public void setCarrito (String carrito) {
    this.carrito = carrito;
  }
}
