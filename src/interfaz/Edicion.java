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
 * Permite editar los atributos de un objeto
 */
public class Edicion extends Application {
  private Articulo articulo;
  private Archivo archivo;
  private GridPane grid;
  private Label lNombre, lDescrip, lPrecio, lCantidad, lUnidad;
  private TextField tNombre, tDescrip, tPrecio, tCantidad;
  private ChoiceBox cUnidad;
  private Text titulo;
  private Button beditar, bregresar;
  
  public Edicion (Articulo articulo) {
    this.articulo = articulo;
  }
  @Override
  public void start(Stage primaryStage) {
    grid = new GridPane();
    titulo = new Text("Ingrese los datos que desee editar");
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
    beditar = new Button("Guardar cambios");
    bregresar = new Button("Regresar");
    archivo = new Archivo();
    
    tNombre.setText(articulo.getNombre());
    tDescrip.setText(articulo.getDescripcion());
    tPrecio.setText(Utilidades.doubleToString(articulo.getPrecioCompra()));
    tCantidad.setText(Utilidades.intToString(articulo.getExistencia()));
    cUnidad.getSelectionModel().select(articulo.getTipoUnidad());
    grid.setAlignment(Pos.CENTER_LEFT);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25,25,25,25));
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
    grid.add(beditar, 1, 7);
    
    beditar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        articulo.setNombre(tNombre.getText().toUpperCase());
        articulo.setDescripcion(tDescrip.getText().toUpperCase());
        articulo.setPrecioCompra(Utilidades.stringToDouble(tPrecio.getText()));
        articulo.setExistencia(Utilidades.stringToInt(tCantidad.getText()));
        articulo.setTipoUnidad(cUnidad.getSelectionModel().getSelectedItem().toString().toUpperCase());
        archivo.escribirInventario();
        TablaInventario invent = new TablaInventario(Utilidades.getAdmin());
        invent.start(primaryStage);
      }
    });
    
    bregresar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        TablaInventario invent = new TablaInventario(Utilidades.getAdmin());
        invent.start(primaryStage);
      }
    });
    
    Scene scene = new Scene(grid, 300, 250);
    primaryStage.setTitle("Editar artículo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
