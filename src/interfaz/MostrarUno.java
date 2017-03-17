/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ferreteria.Articulo;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import recursos.Utilidades;

/**
 *
 * @author andres
 * @version 1.0
 * Muestra los detalles de un artículo
 */
public class MostrarUno extends Application {
  private Articulo articulo;
  private GridPane grid;
  private Label lNombre, lDescrip, lPrecio, lCantidad, lUnidad, tNombre, tDescrip, tPrecio, tCantidad, cUnidad;
  private Button beditar, bregresar;
  
  public MostrarUno (Articulo articulo) {
    this.articulo = articulo;
  }
  @Override
  public void start(Stage primaryStage) {
    grid = new GridPane();
    lNombre = new Label("Nombre: ");
    lDescrip = new Label("Descripción: ");
    lPrecio = new Label("Precio: ");
    lCantidad = new Label("Cantidad: ");
    lUnidad = new Label("Unidad: ");
    tNombre = new Label();
    tDescrip = new Label();
    tPrecio = new Label();
    tCantidad = new Label();
    cUnidad = new Label();
    beditar = new Button("Editar");
    bregresar = new Button("Regresar");
    
    tNombre.setText(articulo.getNombre());
    tDescrip.setText(articulo.getDescripcion());
    tPrecio.setText(Utilidades.doubleToString(articulo.getPrecioCompra()));
    tCantidad.setText(Utilidades.intToString(articulo.getExistencia()));
    cUnidad.setText(articulo.getTipoUnidad());
    grid.setAlignment(Pos.CENTER_LEFT);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25,25,25,25));
    grid.add(lNombre, 0, 0);
    grid.add(tNombre, 1, 0);
    grid.add(lDescrip, 0, 1);
    grid.add(tDescrip, 1, 1);
    grid.add(lPrecio, 0, 2);
    grid.add(tPrecio, 1, 2);
    grid.add(lCantidad, 0, 3);
    grid.add(tCantidad, 1, 3);
    grid.add(lUnidad, 0, 4);
    grid.add(cUnidad, 1, 4);
    grid.add(bregresar, 0, 6);
    grid.add(beditar, 1, 6);
    
    beditar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        Edicion edit = new Edicion(articulo);
        edit.start(primaryStage);
      }
    });
    
    bregresar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        MenuPrincipal menu = new MenuPrincipal(Utilidades.getAdmin());
        menu.start(primaryStage);
      }
    });
    
    Scene scene = new Scene(grid, 300, 400);
    primaryStage.setTitle("Artículo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
