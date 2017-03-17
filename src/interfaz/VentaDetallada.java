/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ferreteria.Articulo;
import ferreteria.Venta;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author andres
 * @version 1.0
 * Muestra los detalles de una venta en específico
 */
public class VentaDetallada extends Application {
  private Label subtotal, total, date;
  private VBox vbox;
  private Button regreso;
  private Double tot, sub;
  private String fecha;
  private ListView<Articulo> listaDetalle;
  private ObservableList<Articulo> shop = FXCollections.observableArrayList();
  
  public VentaDetallada(Venta vendimia) {
    this.sub = vendimia.getGTotal()/1.16;
    this.tot = vendimia.getGTotal();
    this.fecha = vendimia.getFecha();
    this.shop = vendimia.getCarrito();
  }
  
  @Override
  public void start(Stage primaryStage) {
    date = new Label("Fecha: "+fecha);
    subtotal = new Label("Subtotal: "+sub);
    total = new Label("Total: "+tot);
    regreso = new Button("Regreso");
    listaDetalle = new ListView<>();
    vbox = new VBox();
    
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 10, 10, 10));
    vbox.getChildren().addAll(date, subtotal, total, listaDetalle,regreso);
    listaDetalle.setCellFactory(new Callback<ListView<Articulo>, ListCell<Articulo>>() {
      @Override
      public ListCell<Articulo> call(ListView<Articulo> p) {
        ListCell<Articulo> cell = new ListCell<Articulo>() {
          @Override
          protected void updateItem(Articulo item, boolean empty) {
            super.updateItem(item, empty); 
            if (item != null) {
              setText("NOMBRE:"+item.getNombre().toLowerCase()+"PRECIO: "+ item.getPrecioCompra()*1.50);
            }
          }
        };
      return cell;
      }    
    });
    listaDetalle.setItems(shop);
    regreso.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        shop.clear();
        MostrarVentas muestramelo = new MostrarVentas();
        muestramelo.start(primaryStage);
      }
    });
    
    Scene scene = new Scene(vbox, 300, 250);
    
    primaryStage.setTitle("Detalle de Venta");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
