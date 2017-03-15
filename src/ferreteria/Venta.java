/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.util.ArrayList;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author José Andrés Domínguez González
 */
public class Venta implements java.io.Serializable {
  private Date fecha;
  private double gTotal;
  public static ArrayList<Venta> ventas = new ArrayList<>();
  ObservableList<Articulo> carrito = FXCollections.observableArrayList();
  /**
   * Constructor por de la clase Venta 
   */
  public Venta () {
    this.fecha = new Date();
    this.carrito = carrito;
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
  
  public void addToCarrito (Articulo articulo) {
    carrito.add(articulo);
  }
  
  public ObservableList getCarrito () {
    return this.carrito;
  }
}
