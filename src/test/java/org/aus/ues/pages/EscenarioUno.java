package org.aus.ues.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EscenarioUno {
    protected WebDriver driver;

    // URL definida directamente en el código
    private static final String URL = "https://www.walmart.com.sv/";

    @BeforeClass
    public void setup() {
        // Inicializar el WebDriver
        driver = BasePage.initDriver();

        // Navegar a la URL definida
        driver.get(URL);
    }
    
    //Test Case ID :TW_001
    //Descripcion:Seleccion de departamento y que las opciones sean las correctas 
    @Test
    public void testNavigateAndClick() throws InterruptedException {
       TiendaPage homePage = new TiendaPage(driver);

        // Interacciones en la página
         Thread.sleep(300);
       homePage.clickMenuButton();
      
       
       homePage.clickDepartamento();
       homePage.seleccionarDepartamento("Santa Ana");
       homePage.clickMunicipio();
       homePage.seleccionarMunicipio("Santa Ana Centro");
       homePage.clickDistrito();
       homePage.seleccionarDistrito("Santa Ana");
       homePage.clickBuscarTienda();
       homePage.clickWalmartSantaAna();
       Thread.sleep(30000);
       String direccion = homePage.getDireccionCompleta();
       System.out.println("Dirección completa: " + direccion);
       Thread.sleep(30000);
       homePage.clickAceptar();
       Thread.sleep(30000);
       
       

        // Verificar el título de la página
        String title = homePage.getPageTitle();
        System.out.println("Título de la página: " + title);

        // Validación
        assert title.contains("Walmart");
    }

    @AfterClass
    public void tearDown() {
        // Cerrar el navegador después de las pruebas
        if (driver != null) {
            driver.quit();
        }
    }
}
