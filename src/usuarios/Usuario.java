/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

/**
 *
 * @author andres
 */
public class Usuario {
  private String username;
  private int[] contrasenia;
  private boolean admin;
  
  public Usuario (String username, int[] contrasenia, boolean admin) {
    this.username = username;
    this.contrasenia = contrasenia;
    this.admin = admin;
  }
  
  public Usuario() {}
  
  public void setUsername (String username) {
    this.username = username;
  }
  
  public String getUsername () {
    return username;
  }
  
  public void setContrasenia (int[] contrasenia) {
    this.contrasenia = contrasenia;
  }
  
  public int[] getContrasenia () {
    return contrasenia;
  }
  
  public boolean isAdmin () {
    return admin;
  }
  
  public void setAdmin (boolean admin) {
    this.admin = admin;    
  }
  
  public int [] cifrarContra (String contra) {
    char[] passWd = new char [contra.length()];
    passWd = contra.toCharArray();
    int [] passASCII = new int [passWd.length];
    for (int i = 0; i < passWd.length; i++) {
      passASCII[i] = (int)passWd[i]; 
    }    
    return passASCII;
  }
  
  public String descifrarContra (int [] contra ) {
    String passWd = "";
    char aux;
    for(int i = 0; i < contra.length; i++) {
      aux = (char) contra[i];
      passWd += aux;
    }
    return passWd;
  }
  
}
