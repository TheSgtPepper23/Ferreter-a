/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

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
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author andres
 */
public class AgregarUsuario extends Application {
    
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Nuevo usuario");
    GridPane grid = new GridPane();
    Text titulo = new Text("Ingrese los datos del nuevo usuario");
    Label lNombreUs = new Label("Nombre: ");
    Label lContraUs = new Label("Contraseña: ");
    TextField tNombreUs = new TextField();
    PasswordField pContraUs = new PasswordField();
    CheckBox admin = new CheckBox("¿Administrador?");
    Button agregar = new Button("Agregar");
    Button regresar = new Button("<-");
    
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
        Loggin loguear = new Loggin();
        loguear.start(primaryStage);        
      }
    });
    
    Scene escena = new Scene(grid, 450, 175);
    primaryStage.setScene(escena);
    primaryStage.show();
  }
}
