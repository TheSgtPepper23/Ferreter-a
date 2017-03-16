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
import recursos.Utilidades;

/**
 *
 * @author José Andrés Domínguez González
 */
public class Venta implements java.io.Serializable {
  private String fecha;
  private double gTotal;
  public static ArrayList<Venta> ventas = new ArrayList<>();
  public static ObservableList<Articulo> carrito = FXCollections.observableArrayList();
  
  /**
   * Constructor por de la clase Venta 
   */
  public Venta () {
    this.fecha = Utilidades.simplificaFecha(new Date());
  }
  
  public double getGTotal () {
    return gTotal;
  }
  
  public void setGTotal (double gTotal) {
    this.gTotal = Utilidades.redondearDouble(gTotal);
  }
  
  public String getFecha () {
    return fecha;
  }
  
  /**
   * Agrega un objeto de tipo Artículo al carrito
   * @param articulo objeto tipo Articulo
   */
  public void addToCarrito (Articulo articulo) {
    carrito.add(articulo);
  }
  
  public void setCarrito (ObservableList carrito) {
    this.carrito = carrito;
  }
  
  public ObservableList getCarrito () {
    return this.carrito;
  }
}
