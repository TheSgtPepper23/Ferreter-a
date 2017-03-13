/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarioSistema;

import java.util.ArrayList;

/**
 * Métodos para la creación de un nuevo usuario y cifrado/descifrado de contraseñas
 * @author andres
 */
public class Usuario implements java.io.Serializable{
  private String username;
  private String contrasenia;
  private boolean admin;
  public static ArrayList<Usuario> usuarios = new ArrayList<>();
  
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
}
