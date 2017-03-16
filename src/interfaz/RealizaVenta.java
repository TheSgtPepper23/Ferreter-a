/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import accesoDatos.Archivo;
import ferreteria.Articulo;
import ferreteria.Venta;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import recursos.Utilidades;

/**
 *
 * @author andres
 * @version 1.0
 * Muestra una ventana donde permite realizar ventas
 */
public class RealizaVenta extends Application {
  private Archivo archivo;
  private Venta venta;
  private VBox vbox;
  private HBox hbox, hbox2;
  private Label selecciona, subtotal, total;
  private ComboBox <Articulo> cbArticulos;
  private Button bMas, bCompra, bRegreso;
  private ListView<Articulo> listaCompra;
  private Double sub, tot;
  private Spinner <Integer> cantidad;
  private SpinnerValueFactory<Integer> valueFactory;

  public RealizaVenta() {
    this.tot = 0.0;
    this.sub = 0.0;
  }
  
  @Override
  public void start(Stage primaryStage) {
    vbox = new VBox();
    hbox = new HBox();
    hbox2 = new HBox();
    bCompra = new Button("Comprar");
    bRegreso = new Button("Regresar");
    selecciona = new Label("Seleccione los artículos que desee agregar al carrito");
    final ObservableList<Articulo> oArticulos = FXCollections.observableArrayList(Articulo.articulos);
    cbArticulos = new ComboBox<>(oArticulos);
    bMas = new Button("+");
    listaCompra = new ListView<>();
    venta = new Venta();
    subtotal = new Label("Subtotal: 0.0");
    total = new Label("Total: 0.0");
    archivo = new Archivo();
    cantidad = new Spinner<>();
    valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
    
    hbox.setSpacing(5);
    cantidad.setValueFactory(valueFactory);
    hbox.setPadding(new Insets(10, 10, 10, 10));
    hbox.getChildren().addAll(cbArticulos, cantidad, bMas);
    hbox2.setSpacing(5);
    hbox2.setPadding(new Insets(10, 10, 10, 10));
    hbox2.getChildren().addAll(bRegreso, bCompra);
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 10, 10, 10));
    vbox.getChildren().addAll(selecciona, hbox, listaCompra, subtotal, total, hbox2);
    cbArticulos.setConverter(new StringConverter<Articulo>() {
      @Override
      public String toString(Articulo t) {
        return t.getNombre();
      }

      @Override
      public Articulo fromString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); 
      }
    });
    cbArticulos.setItems(oArticulos);
    listaCompra.setCellFactory(new Callback<ListView<Articulo>, ListCell<Articulo>>() {
      @Override
      public ListCell<Articulo> call(ListView<Articulo> p) {
        ListCell<Articulo> cell = new ListCell<Articulo>() {
          @Override
          protected void updateItem(Articulo item, boolean empty) {
            super.updateItem(item, empty); 
            if (item != null) {
              setText("NOMBRE:"+item.getNombre().toLowerCase()+" UNIDAD: "+
                      item.getTipoUnidad().toLowerCase()+" PRECIO: "+ item.getPrecioCompra()*1.50);
            }
          }
        };
      return cell;
      }    
    });
    
    bMas.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        subtotal.setText("Subtotal: ");
        total.setText("Total: ");
        if(cbArticulos.getSelectionModel().getSelectedItem().getExistencia()>=cantidad.getValue()) { 
          for (int i = 0; i < cantidad.getValue(); i++) {
            venta.addToCarrito(cbArticulos.getSelectionModel().getSelectedItem());
          }
          cbArticulos.getSelectionModel().getSelectedItem().venta(cantidad.getValue());
          listaCompra.setItems(venta.getCarrito());
          sub += cbArticulos.getSelectionModel().getSelectedItem().getPrecioCompra()*1.50*
                  cantidad.getValue();
          tot = sub*1.16;
          subtotal.setText("Subtotal: "+Utilidades.redondearDouble(sub));
          total.setText("Total: "+Utilidades.redondearDouble(tot));
        }
        else {
          Alert noHay = new Alert(AlertType.ERROR);
          noHay.setTitle("Error");
          noHay.setHeaderText("Lo sentimos");
          noHay.setContentText("Las existencias de este artículo se han agotado");
          noHay.showAndWait();
        }
      }
    });
    
    bRegreso.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        MenuPrincipal menu = new MenuPrincipal(Utilidades.getAdmin());
        menu.start(primaryStage);
      }
    });
    
    bCompra.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        venta.setGTotal(tot);
        Venta.ventas.add(venta);
        archivo.escribirVentas();
        archivo.escribirInventario();
        Alert confirmacion = new Alert(AlertType.INFORMATION);
        confirmacion.setTitle("Confirmación");
        confirmacion.setHeaderText("Venta realizada con éxito");
        confirmacion.showAndWait();
        MenuPrincipal menu = new MenuPrincipal(Utilidades.getAdmin());
        menu.start(primaryStage);
      }
    });
    
    Scene scene = new Scene(vbox, 500, 250);
    primaryStage.setTitle("Realizar venta");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
