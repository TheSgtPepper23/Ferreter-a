/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author andres
 * @version 1.0
 * Contiene métodos sencillos que se pueden requerir por otra clase
 */
public class Utilidades {
  private static boolean admin;
  
  /**
   * Guarda el tipo de sesión, si es de un administrador o no
   * @param admin boolean determinada en la clase Login que indica si la sesión cuenta con permisos
   * de admin
   */
  public static void setAdmin (boolean admin) {
    Utilidades.admin =admin;
  }
  
  /**
   * Devuelve un booleano indicando si la sesión tiene permisos de admin ono
   * @return Si la sesión tiene permisos de admin devuelve true, de lo contrario devuelve false
   */
  public static boolean getAdmin () {
    return admin;
  }
  
  /**
   * Convierte un string en un Double (no hace validaciones)
   * @param cadena String que debe contener un número con punto decimal
   * @return Un valor del tipo Double
   */
  public static double stringToDouble (String cadena) {
    return Double.parseDouble(cadena);
  }
  
  /**
   * Convierte un string en un Integer (no hace validaciones)
   * @param cadena String que debe contener un número entero
   * @return Valor del tipo Integer
   */
  public static int stringToInt (String cadena) {
    return Integer.parseInt(cadena);
  }
  
  /**
   * Convierte un valor del tipo Double a una cadena de texto tipo String
   * @param doble número de tipo Double
   * @return Cadena de texto con el valor de "doble"
   */
  public static String doubleToString (Double doble) {
    return doble.toString();
  }
  
  /**
   * Convierte un valor del tipo Integer a una cadena de texto tipo String
   * @param entero numero de tipo Integer
   * @return Cadena de texto con el valor de "entero"
   */
  public static String intToString (Integer entero) {
    return entero.toString();
  }
  
  /**
   * Simplifica un objeto de tipo date a el formato dd/MM/YYY
   * @param fecha objeto de tipo Date que se desea simplificar
   * @return String con la fecha simplificada
   */
  public static String simplificaFecha (Date fecha) {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
    return formato.format(fecha);
  }
  
  public static Double redondearDouble (Double doble) {
    return Math.rint(doble*100)/100;
  }
  
}
