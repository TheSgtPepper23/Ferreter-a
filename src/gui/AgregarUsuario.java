/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import accesoDatos.Archivo;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import usuarioSistema.Usuario;

/**
 *
 * @author andres
 */
public class AgregarUsuario extends Application {
  private Archivo archivo;
  private Usuario user;
  private CheckBox admin;
  private GridPane grid;
  private Text titulo;
  private Label lNombreUs, lContraUs;
  private TextField tNombreUs;
  private PasswordField pContraUs;
  private Button agregar, regresar;
  
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Nuevo usuario");
    grid = new GridPane();
    titulo = new Text("Ingrese los datos del nuevo usuario");
    lNombreUs = new Label("Nombre: ");
    lContraUs = new Label("Contraseña: ");
    tNombreUs = new TextField();
    pContraUs = new PasswordField();
    admin = new CheckBox("¿Administrador?");
    agregar = new Button("Agregar");
    regresar = new Button("<-");
    archivo = new Archivo();
    
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25,25,25,25));
    grid.add(titulo, 0, 0, 2, 1);
    grid.add(lNombreUs, 0, 1);
    grid.add(tNombreUs, 1, 1);
    grid.add(lContraUs, 0, 2);
    grid.add(pContraUs, 1, 2);
    admin.setSelected(false);
    grid.add(admin, 0, 3);
    grid.add(agregar, 1, 5);
    grid.add(regresar, 0, 5);
    
    regresar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        Login loguear = new Login();
        loguear.start(primaryStage);        
      }
    });
    
    agregar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        user = new Usuario(tNombreUs.getText(), pContraUs.getText(), administra());
        Usuario.usuarios.add(user);
        archivo.escribirArchivo(Usuario.usuarios, archivo.getArchUsuarios());
      }
    });
    
    Scene escena = new Scene(grid, 450, 175);
    primaryStage.setScene(escena);
    primaryStage.show();
  }
  
  public boolean administra () {
    return admin.isSelected();
  }
}
