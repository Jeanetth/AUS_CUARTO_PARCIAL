package org.aus.ues.pages;

import org.aus.ues.pages.BasePage;

import org.aus.ues.pages.TiendaPage;
import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Inicializar el WebDriver
            driver = BasePage.initDriver();

            // Navegar a la URL de Walmart
            TiendaPage homePage = new TiendaPage(driver);
            homePage.navigateTo("https://www.walmart.com.sv/");

            // Interactuar con la página
            homePage.clickMenuButton();
            homePage.clickDepartamento();

            // Imprimir el título de la página
            System.out.println("Título de la página: " + homePage.getPageTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
