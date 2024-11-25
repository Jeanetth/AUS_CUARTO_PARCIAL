package org.aus.ues.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import scala.Int;

import java.lang.Thread;
import java.time.Duration;

// Escenario: Simulación de compra
public class EscenarioTres_2 {
    WebDriver driver;
    private static final String URL = "https://www.walmart.com.sv/";
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Primer test: Acceso a la categoría de panadería
    @Test
    public void accesoCategoriaPanaderia() {
        driver.get(URL);
        WebElement botonCategoriaPanaderia = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.vtex-slider-layout-0-x-slide:nth-child(25) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")));
        botonCategoriaPanaderia.click();

        String URLActual = driver.getCurrentUrl();
        String URLEsperada = "https://www.walmart.com.sv/panaderia-y-tortilleria";
        Assert.assertEquals(URLActual, URLEsperada, "Las URLs no coinciden");
    }

    // Segundo test: Agregar producto al carrito
    @Test(dependsOnMethods = {"accesoCategoriaPanaderia"})
    public void agregarProductoAlCarrito() {
        WebElement botonAgregarProducto = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.vtex-search-result-3-x-galleryItem:nth-child(1) > section:nth-child(1) > a:nth-child(1) > article:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)")));
        botonAgregarProducto.click();

        WebElement numeroDeProductos = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".vtex-minicart-2-x-minicartQuantityBadge")));
        int numeroActual = Integer.parseInt(numeroDeProductos.getText());
        int numeroEsperado = 1;
        Assert.assertEquals(numeroActual, numeroEsperado, "El número de productos no coincide con el esperado.");
    }

    // Tercer test: Validación y acceso al carrito de compra
    @Test(dependsOnMethods = {"agregarProductoAlCarrito"})
    public void validarAccesoCarrito() {
        WebElement botonCarritoDeCompra = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".vtex-minicart-2-x-openIconContainer > button:nth-child(1)")));
        botonCarritoDeCompra.click();

        WebElement botonContinuarConLaCompra = wait.until(ExpectedConditions.elementToBeClickable(By.id("proceed-to-checkout")));
        Assert.assertTrue(botonContinuarConLaCompra.isDisplayed(), "El botón 'Continuar con la compra no está presente, pero debería estarlo.");

        botonContinuarConLaCompra.click();
        String URLdePagoEsperada = "https://www.walmart.com.sv/checkout/#/cart";
        String URLdePagoActual = driver.getCurrentUrl();
        Assert.assertEquals(URLdePagoActual, URLdePagoEsperada, "No nos encontramos en la página de verificación de la compra");
    }

    // Cuarto test: Finalización de la compra
    @Test(dependsOnMethods = {"validarAccesoCarrito"})
    public void finalizarCompra() throws InterruptedException {
        WebElement botonFinalizarCompra = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cart-to-orderform")));
        botonFinalizarCompra.click();

        WebElement etiquetaDeMetodoDeCompraActual = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mesagge")));
        String textoDeMetodoDeCompraActual = etiquetaDeMetodoDeCompraActual.getText();
        String textoDeMetodoDeCompraEsperado = "Elige como deseas continuar con tu compra";
        Assert.assertEquals(textoDeMetodoDeCompraActual, textoDeMetodoDeCompraEsperado, "No se muestra un mensaje de confirmación del método de compra");
        Thread.sleep(8000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

