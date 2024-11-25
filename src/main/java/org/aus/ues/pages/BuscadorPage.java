/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.aus.ues.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author moises
 */
public class BuscadorPage extends BasePage {

    public BuscadorPage(WebDriver driver) {
        super(driver);
    }
    private By inputBusqueda = By.cssSelector("input#downshift-0-input");
    private By botonBusqueda = By.cssSelector(".vtex-store-components-3-x-searchBarIcon");
    private By conteoProductos = By.cssSelector(".vtex-search-result-3-x-totalProducts--layout");

    public void buscarProducto(String texto) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(inputBusqueda));

        // Asegúrate de interactuar con el elemento
        input.clear(); // Limpia el campo si es necesario
        input.sendKeys(texto);
        input.sendKeys(Keys.RETURN);
    }

    public String obtenerProductos() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contenedorProductos = wait.until(ExpectedConditions.visibilityOfElementLocated(conteoProductos));

        String textoCompleto = contenedorProductos.getText(); // Esto devuelve "250 productos"
        return textoCompleto.split(" ")[0]; // Devuelve solo "250"
    }
}
