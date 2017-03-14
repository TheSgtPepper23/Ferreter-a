/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import usuarioSistema.Usuario;

/**
 *
 * @author andres
 */
public class MenuPrincipal extends Application {
  private GridPane grid;
  private Button agregar, comprar, editar, inventario, eliminar, buscar, vender, ventas;
  private Image iAgregar, iComprar, iEditar, iInventario, iEliminar, iBuscar, iVender, iVentas;
  private Tooltip lAgregar, lComprar, lEditar, lInventario, lEliminar, lBuscar, lVender, lVentas;
  private Usuario actual;
  
  public MenuPrincipal (Usuario actual) {
    this.actual =actual;
  }
  
  @Override
  public void start(Stage primaryStage) {
    primaryStage = new Stage(); 
    Scene escena = new Scene(grid, 400, 175);
    primaryStage.setScene(escena);
    primaryStage.show();
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
    iEditar = new Image("recursos/Edit.png");
    iInventario = new Image("recursos/Inventory.png");
    iEliminar = new Image("recursos/Remove.png");
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
   
    grid.setAlignment(Pos.CENTER_LEFT);
    grid.setHgap(20);
    grid.setVgap(20);
    grid.setPadding(new Insets(25,25,25,25));
    agregar.setGraphic(new ImageView(iAgregar));
    agregar.setTooltip(lAgregar);
    comprar.setGraphic(new ImageView(iComprar));
    comprar.setTooltip(lComprar);
    editar.setGraphic(new ImageView(iEditar));
    editar.setTooltip(lEditar);
    inventario.setGraphic(new ImageView(iInventario));
    inventario.setTooltip(lInventario);
    eliminar.setGraphic(new ImageView(iEliminar));
    eliminar.setTooltip(lEliminar);
    buscar.setGraphic(new ImageView(iBuscar));
    buscar.setTooltip(lBuscar);
    vender.setGraphic(new ImageView(iVender));
    vender.setTooltip(lVender);
    ventas.setGraphic(new ImageView(iVentas));
    ventas.setTooltip(lVentas);
    grid.add(agregar, 0, 0);
    grid.add(comprar, 1, 0);
    grid.add(editar, 2, 0);
    grid.add(inventario, 3, 0);
    grid.add(eliminar, 0, 1);
    grid.add(buscar, 1, 1);
    grid.add(vender, 2, 1);
    grid.add(ventas, 3, 1);
    
    if(!actual.isAdmin()) {
      agregar.isDisable();
      editar.isDisable();
      eliminar.isDisable();
    }
  }
}
