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
  private String contrasenia;
  private boolean admin;
  
  public Usuario (String username, String contrasenia, boolean admin) {
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
  
  public void setContrasenia (String contrasenia) {
    this.contrasenia = contrasenia;
  }
  
  public String getContrasenia () {
    return contrasenia;
  }
  
  public boolean isAdmin () {
    return admin;
  }
  
  public void setAdmin (boolean admin) {
    this.admin = admin;    
  }
  
  public String cifrarContra (String contra) {
    return contra;
  }
  
  public String descifrarContra (String contra) {
    return contra;
  }
  
}
