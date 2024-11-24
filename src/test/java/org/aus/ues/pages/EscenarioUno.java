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
    
    
    @Test
    public void testNavigateAndClick() {
       TiendaPage homePage = new TiendaPage(driver);

        // Interacciones en la página
    
       homePage.clickMenuButton();
       homePage.clickDepartamento();

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
