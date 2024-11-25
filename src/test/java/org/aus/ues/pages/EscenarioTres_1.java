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

import java.time.Duration;
import java.util.List;

// Validación de items en el carrito de compra
public class EscenarioTres_1 {
    WebDriver driver;
    private static final String URL = "https://www.walmart.com.sv/";
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void accesoCategoriaPanaderia() {
        driver.get(URL);

        WebElement botonCategoriaPanaderia = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.vtex-slider-layout-0-x-slide:nth-child(25) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")));
        botonCategoriaPanaderia.click();

        String URLActual = driver.getCurrentUrl();
        String URLEsperada = "https://www.walmart.com.sv/panaderia-y-tortilleria";
        Assert.assertEquals(URLActual, URLEsperada, "Las URLs no coinciden");
    }

    // ID: TWCC001
    @Test(dependsOnMethods = {"accesoCategoriaPanaderia"})
    public void agregarProductoAlCarrito() {
        WebElement botonAgregarProducto = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.vtex-search-result-3-x-galleryItem:nth-child(1) > section:nth-child(1) > a:nth-child(1) > article:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1)")));
        botonAgregarProducto.click();

        WebElement numeroDeProductos = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".vtex-minicart-2-x-minicartQuantityBadge")));
        int numeroActual = Integer.parseInt(numeroDeProductos.getText());
        int numeroEsperado = 1;
        Assert.assertEquals(numeroActual, numeroEsperado, "El número de productos no coincide con el esperado.");
    }

    // ID: TWCC002
    @Test(dependsOnMethods = {"agregarProductoAlCarrito"})
    public void modificarCantidadProducto() throws InterruptedException {
        WebElement botonCarritoDeCompra = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".vtex-minicart-2-x-openIconContainer > button:nth-child(1)")));
        botonCarritoDeCompra.click();

        WebElement botonAumentarProducto = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".undefined > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(1)")));
        botonAumentarProducto.click();

        WebElement cantidadDeProductos = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".w3")));
        int numeroAumentadoEsperado = 2;
        String valorAumentadoTexto = cantidadDeProductos.getAttribute("value");
        int numeroAumentado = (valorAumentadoTexto != null && !valorAumentadoTexto.isEmpty()) ? Integer.parseInt(valorAumentadoTexto) : 0;
        Assert.assertEquals(numeroAumentado, numeroAumentadoEsperado, "El número de productos no se actualizó.");
        Thread.sleep(5000);
    }

    // ID: TWCC003
    @Test(dependsOnMethods = {"modificarCantidadProducto"})
    public void eliminarProductoDelCarrito() throws InterruptedException {
        WebElement botonEliminarProducto = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".vtex-product-list-0-x-removeButton")));
        botonEliminarProducto.click();

        List<WebElement> listaDeProductos = driver.findElements(By.xpath("/html/body/div[9]/div/div[2]/div/div/div[2]/div"));
        Assert.assertTrue(listaDeProductos.isEmpty(), "Hay un elemento presente en la lista y no debería de estarlo");
        Thread.sleep(5000);
    }

    // ID: TWCC005N
    @Test(dependsOnMethods = {"eliminarProductoDelCarrito"})
    public void intentarCompraSinProductos() throws InterruptedException {
        List<WebElement> botonContinuarConLaCompra = driver.findElements(By.id("proceed-to-checkout"));

        Assert.assertTrue(botonContinuarConLaCompra.isEmpty(), "El botón 'Continuar con la compra' no está presente, pero si lo está.");

        Thread.sleep(5000);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
