/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import ferreteria.Articulo;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import recursos.Utilidades;

/**
 *
 * @author andres
 * @version 1.0
 * Es la ventana donde se muestran los botones hacia todas las ventanas
 */
public class MenuPrincipal extends Application {
  private GridPane grid;
  private Button agregar, comprar, editar, inventario, eliminar, buscar, vender, ventas;
  private Image iAgregar, iComprar, iInventario, iBuscar, iVender, iVentas;
  private Tooltip lAgregar, lComprar, lEditar, lInventario, lEliminar, lBuscar, lVender, lVentas;
  private boolean admin;
  
  public MenuPrincipal (boolean admin) {
    this.admin = admin;
  }
  
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Menu principal");
    
    grid = new GridPane();
    agregar = new Button();
    comprar = new Button();
    editar = new Button();
    inventario = new Button();
    eliminar = new Button();
    buscar = new Button();
    vender = new Button();
    ventas = new Button();
    iAgregar = new Image("recursos/Add.png");
    iComprar = new Image("recursos/Buy.png");
    iInventario = new Image("recursos/Inventory.png");
    iBuscar = new Image("recursos/Search.png");
    iVender = new Image("recursos/Sell.png");
    iVentas = new Image("recursos/Sells.png");
    lAgregar = new Tooltip("Agregar artículo");
    lComprar = new Tooltip("Realizar compra");
    lEditar = new Tooltip("Editar artículo");
    lInventario = new Tooltip("Mostrar Inventario");
    lEliminar = new Tooltip("Eliminar artículo");
    lBuscar = new Tooltip("Buscar artículos");
    lVender = new Tooltip("Realizar venta");
    lVentas = new Tooltip("Mostrar ventas");
    
    if(!admin) {
      agregar.setDisable(true);
    }
   
    grid.setAlignment(Pos.CENTER_LEFT);
    grid.setHgap(20);
    grid.setVgap(20);
    grid.setPadding(new Insets(25,25,25,25));
    agregar.setGraphic(new ImageView(iAgregar));
    agregar.setTooltip(lAgregar);
    comprar.setGraphic(new ImageView(iComprar));
    comprar.setTooltip(lComprar);
    comprar.setDisable(true);
    editar.setTooltip(lEditar);
    inventario.setGraphic(new ImageView(iInventario));
    inventario.setTooltip(lInventario);
    eliminar.setTooltip(lEliminar);
    buscar.setGraphic(new ImageView(iBuscar));
    buscar.setTooltip(lBuscar);
    vender.setGraphic(new ImageView(iVender));
    vender.setTooltip(lVender);
    ventas.setGraphic(new ImageView(iVentas));
    ventas.setTooltip(lVentas);
    grid.add(agregar, 0, 0);
    grid.add(comprar, 1, 0);
    grid.add(inventario, 2, 0);
    grid.add(buscar, 0, 1);
    grid.add(vender, 1, 1);
    grid.add(ventas, 2, 1);
    
    agregar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        AgregarArticulo agregar = new AgregarArticulo();
        agregar.start(primaryStage);
      }
    });
    
    inventario.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        TablaInventario invent = new TablaInventario(Utilidades.getAdmin());
        invent.start(primaryStage);
      }
    });
    
    buscar.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        TextInputDialog busqueda = new TextInputDialog();
        busqueda.setTitle("Búsqueda de artículos");
        busqueda.setHeaderText("Introduzca el nombre o clave del aqrtículo que desee buscar");
        
        Optional<String> result = busqueda.showAndWait();
        if (result.isPresent()){
          boolean flag = false;
          for(int i = 0; i < Articulo.articulos.size(); i++) {
            if(Articulo.articulos.get(i).getNombre().equals(result.get().toUpperCase()) || 
              Articulo.articulos.get(i).getClave().equals(result.get().toUpperCase())) {
              MostrarUno muestra = new MostrarUno(Articulo.articulos.get(i));
              muestra.start(primaryStage);
              flag = true;
            }
          }
          if(!flag){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No se encontró lo que buscaba");
            alert.showAndWait();
          }
        }
      }
    });
    
    vender.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        RealizaVenta vende = new RealizaVenta();
        vende.start(primaryStage);
      }
    });
    
    ventas.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent t) {
        MostrarVentas muestraVentas = new MostrarVentas();
        muestraVentas.start(primaryStage);
      }
    });
    
    Scene escena = new Scene(grid, 300, 175);
    primaryStage.setScene(escena);
    primaryStage.show();
  }
}
