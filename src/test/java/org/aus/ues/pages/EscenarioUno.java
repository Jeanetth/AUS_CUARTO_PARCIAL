package org.aus.ues.pages;

import org.openqa.selenium.WebDriver;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EscenarioUno {
    protected WebDriver driver;


    private static final String URL = "https://www.walmart.com.sv/";

    @BeforeClass
    public void setup() {

        driver = BasePage.initDriver();
        driver.get(URL);
    }
    
    //Test Case ID :TW_001
    //Descripcion:Seleccion de departamento y que las opciones sean las correctas 
    @Test
    public void testNavigateAndClick() throws InterruptedException {
       TiendaPage homePage = new TiendaPage(driver);
       Thread.sleep(30000);
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
       String direccionEsperada = "Santa Ana, Santa Ana, Avenida Independencia Prolongación de Av. Indep. Sur, Loma Alta";
       assertTrue("La dirección no coincide con la esperada", direccion.equals(direccionEsperada));
       String title = homePage.getPageTitle();
       System.out.println("Título de la página: " + title);
       assert title.contains("Walmart");   
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
