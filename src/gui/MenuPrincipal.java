/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author andres
 */
public class MenuPrincipal extends Application {
  private GridPane grid;
  private Button agregar, comprar, editar, inventario, eliminar, buscar, vender, ventas;
  private Image iAgregar, iComprar, iInventario, iBuscar, iVender, iVentas;
  private Tooltip lAgregar, lComprar, lEditar, lInventario, lEliminar, lBuscar, lVender, lVentas;
  private Text titulo;
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
    
    if(admin) {
      agregar.disableProperty();
      editar.disableProperty();
      eliminar.disableProperty();
    }
   
    grid.setAlignment(Pos.CENTER_LEFT);
    grid.setHgap(20);
    grid.setVgap(20);
    grid.setPadding(new Insets(25,25,25,25));
    agregar.setGraphic(new ImageView(iAgregar));
    agregar.setTooltip(lAgregar);
    comprar.setGraphic(new ImageView(iComprar));
    comprar.setTooltip(lComprar);
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
    
    
    Scene escena = new Scene(grid, 350, 175);
    primaryStage.setScene(escena);
    primaryStage.show();
  }
}
