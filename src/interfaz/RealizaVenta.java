/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ferreteria.Articulo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 *
 * @author andres
 * @version 1.0
 * Muestra una ventana donde permite realizar ventas
 */
public class RealizaVenta extends Application {
  private GridPane grid;
  private Label selecciona;
  private ComboBox <Articulo> opciones;
  private Button mas;
  
  @Override
  public void start(Stage primaryStage) {
    grid = new GridPane();
    selecciona = new Label("Seleccione los artículos que desee agregar al carrito");
    final ObservableList<Articulo> oArticulos = FXCollections.observableArrayList(Articulo.articulos);
    opciones = new ComboBox<>(oArticulos);
    opciones.setConverter(new StringConverter<Articulo>() {
      @Override
      public String toString(Articulo t) {
        return t.getNombre();
      }

      @Override
      public Articulo fromString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); 
      }
    });
    mas = new Button("+");
    
    grid.setAlignment(Pos.CENTER_LEFT);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25,25,25,25));
    grid.add(selecciona, 0, 0);
    grid.add(opciones, 0, 1);
    grid.add(mas, 1, 1);
    opciones.setItems(oArticulos);
    Scene scene = new Scene(grid, 500, 250);
    primaryStage.setTitle("Realizar venta");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
