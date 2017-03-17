/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import accesoDatos.Archivo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import recursos.Utilidades;
import usuarioSistema.Usuario;

/**
 *
 * @author andres
 * @version 1.0
 * Despliega un cuestinario donde hay que colocar los datos de inicio de sesión
 */
public class Login extends Application {
    
  private Archivo archivo;
  private Usuario user;
  private GridPane grid;
  private Text titulo;
  private Label usuario, contra;
  private TextField usuarioTexto;
  private PasswordField contraTexto;
  private Button bIngresar;
  private HBox cajaBoton;
  private Hyperlink nuevo;
  /**
    * 
    * @param primaryStage 
    */
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Log In");
    archivo = new Archivo();
    grid = new GridPane();
    titulo = new Text("Ingrese su nombre de usuario y contraseña");
    usuario = new Label("Usuario: ");
    usuarioTexto = new TextField();
    contra = new Label("Contraseña: ");
    contraTexto = new PasswordField();
    bIngresar = new Button("Ingresar");
    cajaBoton = new HBox(10);
    nuevo = new Hyperlink("¿Nuevo usuario?");
        
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25,25,25,25));
    grid.add(titulo, 0, 0, 2, 1);
    grid.add(usuario, 0, 1);
    grid.add(usuarioTexto, 1, 1);
    grid.add(contra, 0, 2);
    grid.add(contraTexto, 1,2);
    cajaBoton.setAlignment(Pos.CENTER);
    cajaBoton.getChildren().add(bIngresar);
    grid.add(cajaBoton, 1, 4);
    grid.add(nuevo, 0, 4);
    archivo.leerUsuario();
    archivo.leerInventario();
    archivo.leerVentas();
      
    nuevo.setOnAction((ActionEvent t) -> {
      AgregarUsuario anadir = new AgregarUsuario();
      anadir.start(primaryStage);
    });
    
    bIngresar.setOnAction((ActionEvent t) -> {
      for (int i = 0; i < Usuario.usuarios.size(); i++) {
        if(Usuario.usuarios.get(i).getUsername().equals(usuarioTexto.getText())) {
          user = Usuario.usuarios.get(i);
        }
      }
      if(user.getContrasenia().equals(contraTexto.getText())) {
        Utilidades.setAdmin(user.isAdmin());
        MenuPrincipal menu = new MenuPrincipal(Utilidades.getAdmin());
        menu.start(primaryStage);
      }
      else {
        System.out.println("La contraseña es incorrecta");
      }
      
    }); 
    
    Scene escena = new Scene(grid, 450, 175);
    primaryStage.setScene(escena);
    primaryStage.show();
  }
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
}
