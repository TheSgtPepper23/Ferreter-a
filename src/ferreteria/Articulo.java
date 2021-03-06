/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.util.ArrayList;

/**
 * 
 * @author José Andrés Domínguez González
 * @version 2.0
 * Setters y getters de para la creación y modificación de "artículos" serializables
 */
public class Articulo implements java.io.Serializable {
  private String clave;
  private String nombre;
  private String descripcion;
  private double precioCompra;
  private int existencia;
  public static ArrayList<Articulo> articulos = new ArrayList<>();
  private String tipoUnidad;
    
  public Articulo () {}
  
  public Articulo(String clave, String nombre, String descripcion, double precioCompra, 
          int existencia, String tipoUnidad ) {
    this.clave = clave;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precioCompra = precioCompra;
    this.existencia = existencia;
    this.tipoUnidad = tipoUnidad;
  }
  
  public void setClave (String clave) {
    this.clave = clave;
  }
  
  public String getClave () {
    return clave;
  }
  
  public void setNombre (String nombre) {
    this.nombre = nombre;
  }
  
  public String getNombre () {
    return nombre;
  }
  
  public void setDescripcion (String descripcion) {
    this.descripcion = descripcion;
  }
  
  public String getDescripcion () {
    return descripcion;
  }
  
  public void setPrecioCompra (double precioCompra) {
    this.precioCompra = precioCompra;
  }
  
  public double getPrecioCompra () {
    return precioCompra;
  }
  
  public void setExistencia (int existencia) {
    this.existencia = existencia;
  }
  
  public int getExistencia () {
    return existencia;
  }
  
  public void setTipoUnidad (String tipoUnidad) {
    this.tipoUnidad = tipoUnidad;
  }
  
  public String getTipoUnidad () {
    return tipoUnidad;
  }
  
  public void venta (int cantidad) {
    this.existencia = existencia-cantidad;
  }
}
