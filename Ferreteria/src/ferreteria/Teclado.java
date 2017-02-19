/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.util.Scanner;

/**
 * Lee opciones del usuario de los tipos, int, String o double
 * @author andres
 * @version 1.0
 */
public class Teclado {
  
  private Scanner sc;
  
  /**
   * Constructor de la clase teclado, inicializa un objeto del tipo Scanner
   */
  public Teclado () {
    sc = new Scanner(System.in);
  }
  
  /**
   * Lee un valor del tipo entero del usuario
   * @return Retorna el valor que haya leido del usuario
   */
  public int leerEntero () {
    return sc.nextInt();
  }
  
  /**
   * Lee un valor del tipo String del usuario
   * @return Retorna el String leido del usuario
   */
  public String leerString() {
    return sc.nextLine();
  }
  
  /**
   * Lee un valor del tipo double del usuario
   * @return Retorna el valor leido del usuario
   */
  public double leerDouble() {
    return sc.nextDouble();
  }
  
  /**
   * Se utiliza para porder leer un String después de un entero
   */
  public void salto () {
    sc.nextLine();
  }
  
}
