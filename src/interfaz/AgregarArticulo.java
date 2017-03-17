/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import accesoDatos.Archivo;
import ferreteria.Articulo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import recursos.Utilidades;

/**
 *
 * @author andres
 * @version 1.0
 * Ventana que muestra una interfaz para agregar nuevos artículos al inventario
 */
public class AgregarArticulo extends Application {
  
  private GridPane grid;
  private Articulo articulo;
  private Archivo archivo;
  private Text titulo;
  private Label lNombre, lDescrip, lPrecio, lCantidad, lUnidad;
  private TextField tNombre, tDescrip, tPrecio, tCantidad;
  private ChoiceBox cUnidad;
  private Button bagregar, bregresar;
  
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Agregar artículo");
    grid = new GridPane();
    grid.setAlignment(Pos.CENTER_LEFT);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25,25,25,25));
    titulo = new Text("Ingrese los datos del nuevo producto");
    lNombre = new Label("Nombre: ");
    lDescrip = new Label("Descripción: ");
    lPrecio = new Label("Precio: ");
    lCantidad = new Label("Cantidad: ");
    lUnidad = new Label("Unidad: ");
    tNombre = new TextField();
    tDescrip = new TextField();
    tPrecio = new TextField();
    tCantidad = new TextField();
    cUnidad = new ChoiceBox(FXCollections.observableArrayList("Pieza", "Decena", "Centena"));
    bagregar = new Button("Agregar");
    bregresar = new Button("Regresar");
    archivo = new Archivo();
    
    bagregar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        articulo = new Articulo(archivo.generarClaves(), tNombre.getText().toUpperCase(), 
                tDescrip.getText().toUpperCase(), Utilidades.stringToDouble(tPrecio.getText()), 
                Utilidades.stringToInt(tCantidad.getText()), 
                cUnidad.getSelectionModel().getSelectedItem().toString().toUpperCase());
        Articulo.articulos.add(articulo);
        archivo.escribirInventario();
        archivo.escribirClaves(articulo.getClave());
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Confirmación");
        alerta.setHeaderText(null);
        alerta.setContentText("El artículo se creo correctamente");
        alerta.showAndWait();
        tNombre.setText("");
        tDescrip.setText("");
        tPrecio.setText("");
        tCantidad.setText("");
      }
    });
    
    bregresar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        MenuPrincipal menu = new MenuPrincipal(Utilidades.getAdmin());
        menu.start(primaryStage);
      }
    });
    
    grid.add(titulo, 0, 0, 2, 1);
    grid.add(lNombre, 0, 1);
    grid.add(tNombre, 1, 1);
    grid.add(lDescrip, 0, 2);
    grid.add(tDescrip, 1, 2);
    grid.add(lPrecio, 0, 3);
    grid.add(tPrecio, 1, 3);
    grid.add(lCantidad, 0, 4);
    grid.add(tCantidad, 1, 4);
    grid.add(lUnidad, 0, 5);
    grid.add(cUnidad, 1, 5);
    grid.add(bregresar, 0, 7);
    grid.add(bagregar, 1, 7);
    
    
    Scene escena = new Scene(grid, 275, 275);
    primaryStage.setScene(escena);
    primaryStage.show();
    
  }
}
