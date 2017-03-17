/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andres
 */
public class InventarioTest {
  
  public InventarioTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of generarClave method, of class Inventario.
   */
  @Test
  public void testGenerarClave() {
    System.out.println("generarClave");
    Inventario instance = new Inventario();
    String expResult = "";
    String result = instance.generarClave();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of agregarArticulo method, of class Inventario.
   */
  @Test
  public void testAgregarArticulo() throws Exception {
    System.out.println("agregarArticulo");
    Inventario instance = new Inventario();
    instance.agregarArticulo();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of mostrarArticulos method, of class Inventario.
   */
  @Test
  public void testMostrarArticulos() {
    System.out.println("mostrarArticulos");
    Inventario instance = new Inventario();
    instance.mostrarArticulos();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of buscarArticulo method, of class Inventario.
   */
  @Test
  public void testBuscarArticulo() {
    System.out.println("buscarArticulo");
    String buscar = "";
    Inventario instance = new Inventario();
    instance.buscarArticulo(buscar);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of eliminarArticulo method, of class Inventario.
   */
  @Test
  public void testEliminarArticulo() {
    System.out.println("eliminarArticulo");
    String eliminar = "";
    Inventario instance = new Inventario();
    instance.eliminarArticulo(eliminar);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of editarArticulo method, of class Inventario.
   */
  @Test
  public void testEditarArticulo() {
    System.out.println("editarArticulo");
    String editar = "";
    Inventario instance = new Inventario();
    instance.editarArticulo(editar);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of ordenarClave method, of class Inventario.
   */
  @Test
  public void testOrdenarClave() {
    System.out.println("ordenarClave");
    Inventario instance = new Inventario();
    instance.ordenarClave();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of ordenarNombre method, of class Inventario.
   */
  @Test
  public void testOrdenarNombre() {
    System.out.println("ordenarNombre");
    Inventario instance = new Inventario();
    instance.ordenarNombre();
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of simplificaFecha method, of class Inventario.
   */
  @Test
  public void testSimplificaFecha() {
    System.out.println("simplificaFecha");
    Date fecha = null;
    Inventario instance = new Inventario();
    String expResult = "";
    String result = instance.simplificaFecha(fecha);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of determinaUnidad method, of class Inventario.
   */
  @Test
  public void testDeterminaUnidad() {
    System.out.println("determinaUnidad");
    Articulo elemento = null;
    Inventario instance = new Inventario();
    int expResult = 0;
    int result = instance.determinaUnidad(elemento);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of suficiente method, of class Inventario.
   */
  @Test
  public void testSuficiente() {
    System.out.println("suficiente");
    Articulo elemento = null;
    int venta = 0;
    Inventario instance = new Inventario();
    boolean expResult = false;
    boolean result = instance.suficiente(elemento, venta);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of valorInventario method, of class Inventario.
   */
  @Test
  public void testValorInventario() {
    System.out.println("valorInventario");
    Inventario instance = new Inventario();
    double expResult = 0.0;
    double result = instance.valorInventario();
    assertEquals(expResult, result, 0.0);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
