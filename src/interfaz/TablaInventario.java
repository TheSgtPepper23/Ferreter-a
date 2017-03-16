/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import accesoDatos.Archivo;
import ferreteria.Articulo;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import recursos.Utilidades;

/**
 *
 * @author andres
 */
public class TablaInventario extends Application {
   private Archivo archivo;
   private VBox vbox;
   private HBox hBotones;
   private TableView <Articulo>tabla;
   private TableColumn<Articulo, String> cClave, cNombre, cDescripcion, cUnidad;
   private TableColumn<Articulo, Integer> cCantidad;
   private TableColumn<Articulo, Double> cPrecio;
   private Button bRegreso, bEditar, bEliminar;
   private boolean admin;
   
   public TablaInventario (boolean admin) {
     this.admin = admin;
   }
   
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Inventario");
    bRegreso = new Button("Regresa");
    bEditar = new Button("Editar");
    bEliminar = new Button("Eliminar");
    vbox = new VBox();
    hBotones = new HBox();
    tabla =  new TableView<>();
    archivo = new Archivo();
    cClave = new TableColumn("Clave");
    cNombre =  new TableColumn("Nombre");
    cDescripcion = new TableColumn("Descripción");
    cPrecio = new TableColumn("Precio");
    cCantidad = new TableColumn("Existencia");
    cUnidad = new TableColumn("Unidad");
    
    archivo.leerInventario();
    final ObservableList<Articulo> oArticulos = FXCollections.observableArrayList(Articulo.articulos);
    cClave.setCellValueFactory(new PropertyValueFactory<>("clave"));
    cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    cDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    cPrecio.setCellValueFactory(new PropertyValueFactory<>("precioCompra"));
    cCantidad.setCellValueFactory(new PropertyValueFactory<>("existencia"));
    cUnidad.setCellValueFactory(new PropertyValueFactory<>("tipoUnidad"));
    tabla.setItems(oArticulos);
    tabla.getColumns().addAll(cClave, cNombre, cDescripcion, cPrecio, cCantidad, cUnidad);
    hBotones.setSpacing(5);
    hBotones.setPadding(new Insets(10, 10, 10, 10));
    hBotones.getChildren().addAll(bRegreso, bEditar, bEliminar);
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 10, 10, 10));
    vbox.getChildren().addAll(tabla, hBotones);
    
 
    bRegreso.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        MenuPrincipal menu = new MenuPrincipal(Utilidades.getAdmin());
        menu.start(primaryStage);
      }
    });
    
    bEditar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        Edicion edicion = new Edicion(tabla.getSelectionModel().getSelectedItem());
        edicion.start(primaryStage);
      }
    });
    
    bEliminar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Diálogo de confirmación");
        alert.setHeaderText("Eliminar archivo");
        alert.setContentText("¿Está seguro de que desea eliminar el archivo?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
          Articulo.articulos.remove(tabla.getSelectionModel().getSelectedItem());
          archivo.escribirInventario();
          start(primaryStage);
        } else {
          try {
            this.finalize();
          } catch (Throwable ex) {
            Logger.getLogger(TablaInventario.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      }
    });
    
    if(!admin) {
      bEditar.setDisable(true);
      bEliminar.setDisable(true);
    }
    
    Scene scene = new Scene(vbox, 600, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
  }  
}
