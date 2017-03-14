/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author José Andrés Domínguez González
 */
public class Venta implements java.io.Serializable {
  private Date fecha;
  private double gTotal;
  public static ArrayList<Venta> ventas = new ArrayList<>();
  public static ArrayList<Articulo> carrito = new ArrayList<>();
  /**
   * Constructor por de la clase Venta 
   */
  public Venta () {
    this.fecha = new Date();
  }
  
  public double getGTotal () {
    return gTotal;
  }
  
  public void setGTotal (double Gtotal) {
    this.gTotal = gTotal;
  }
  
  public Date getFecha () {
    return fecha;
  }
  
  public ArrayList getCarrito () {
    return carrito;
  }
  
  public void setCarrito (ArrayList carrito) {
    this.carrito = carrito;
  }
}
