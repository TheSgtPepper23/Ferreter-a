/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javafx.application.Application;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author andres
 * @version 1.0
 */
public class Loggin extends Application {
    
    /**
     * 
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Log In");
        GridPane grid = new GridPane();
        Text titulo = new Text("Ingrese su nombre de usuario y contraseña");
        Label usuario = new Label("Usuario: ");
        TextField usuarioTexto = new TextField();
        Label contra = new Label("Contraseña: ");
        PasswordField contraTexto = new PasswordField();
        Button bIngresar = new Button("Ingresar");
        HBox cajaBoton = new HBox(10);
        Hyperlink nuevo = new Hyperlink("¿Nuevo usuario?");
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        titulo.setFont(Font.font("Liberation Mono", FontWeight.NORMAL, 13));
        grid.add(titulo, 0, 0, 2, 1);
        grid.add(usuario, 0, 1);
        grid.add(usuarioTexto, 1, 1);
        grid.add(contra, 0, 2);
        grid.add(contraTexto, 1,2);
        cajaBoton.setAlignment(Pos.CENTER);
        cajaBoton.getChildren().add(bIngresar);
        grid.add(cajaBoton, 1, 4);
        grid.add(nuevo, 0, 4);
        
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
