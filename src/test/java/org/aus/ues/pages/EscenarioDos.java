/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aus.ues.pages;

import org.openqa.selenium.WebDriver;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 *
 * @author moises
 */
public class EscenarioDos {

    protected WebDriver driver;

    private static final String URL = "https://www.walmart.com.sv/";

    @BeforeClass
    public void setup() {

        driver = BasePage.initDriver();
        driver.get(URL);
    }
    //Test Case ID :TW_002
    //Descripcion: Buscar Productos y conteo de productos
    @Test
    public void BuscarYContarProductos() throws InterruptedException {

        BuscadorPage buscador = new BuscadorPage(driver);
        String productoBuscado = "Celular";
        Thread.sleep(30000);
        buscador.buscarProducto(productoBuscado);
        Thread.sleep(30000);
        String cantidadProductos = buscador.obtenerProductos();
        System.out.print("Productos encontrados " + cantidadProductos + "\n");
        assertEquals("250", cantidadProductos, "La cantidad de productos encontrados no es la esperada");
    }

    @AfterClass
    public void tearDown() {
        // Cerrar el navegador después de las pruebas
        if (driver != null) {
            driver.quit();
        }
    }
}
