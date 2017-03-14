/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

/**
 *
 * @author andres
 * @version 1.0
 * Contiene métodos sencillos que se pueden requerir por otra clase
 */
public class Utilidades {
  private static boolean admin;
  
  public static void setAdmin (boolean admin) {
    Utilidades.admin =admin;
  }
  
  public static boolean getAdmin () {
    return admin;
  }
  
  public static double stringToDouble (String cadena) {
    return Double.parseDouble(cadena);
  }
  
  public static int stringToInt (String cadena) {
    return Integer.parseInt(cadena);
  }
  
  public static String doubleToString (Double doble) {
    return doble.toString();
  }
  
  public static String intToString (Integer entero) {
    return entero.toString();
  }
  
}
