/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ferreteria.Articulo;
import ferreteria.Venta;
import java.util.Date;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import recursos.Utilidades;

/**
 *
 * @author andres
 */
public class MostrarVentas extends Application {
  private VBox vbox;
  private HBox hbox;
  private TableView <Venta> tablaVentas;
  private TableColumn<Venta, Double> cTotal;
  private TableColumn<Venta, String> cFecha; 
  private Button bRegresar, bDetallar;
  
  
  @Override
  public void start(Stage primaryStage) {
    vbox = new VBox();
    hbox = new HBox();
    tablaVentas = new TableView<>();
    cTotal = new TableColumn<>("Total");
    cFecha = new TableColumn<>("Fecha");
    bRegresar = new Button("Regresar");
    bDetallar = new Button("Detallar");
    
    
    final ObservableList<Venta> oVentas = FXCollections.observableArrayList(Venta.ventas);
    cTotal.setCellValueFactory(new PropertyValueFactory<>("gTotal"));
    cFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
    tablaVentas.setItems(oVentas);
    tablaVentas.getColumns().addAll(cFecha, cTotal);
    hbox.setSpacing(5);
    hbox.setPadding(new Insets(10, 10, 10, 10));
    hbox.getChildren().addAll(bRegresar, bDetallar);
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 10, 10, 10));
    vbox.getChildren().addAll(tablaVentas,hbox);
    bRegresar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        MenuPrincipal menu = new MenuPrincipal(Utilidades.getAdmin());
        menu.start(primaryStage);
      }
    });
    bDetallar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        VentaDetallada detalle = new VentaDetallada(tablaVentas.getSelectionModel().getSelectedItem());
        detalle.start(primaryStage);
      }
    });
    
    
    Scene scene = new Scene(vbox, 300, 250);
    primaryStage.setTitle("Ventas");
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
