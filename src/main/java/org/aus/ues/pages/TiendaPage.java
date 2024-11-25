package org.aus.ues.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TiendaPage extends BasePage {

    // Localizadores
    private By menuButton = By.cssSelector("span.nr2");
    private By departamenSelect = By.xpath("(//select[@class='o-0 absolute top-0 left-0 h-100 w-100 bottom-0 t-body pointer'])[1]");
    private By municipioSelect = By.xpath("(//select[@class='o-0 absolute top-0 left-0 h-100 w-100 bottom-0 t-body pointer'])[2]");
    private By distritoSelect = By.xpath("(//select[@class='o-0 absolute top-0 left-0 h-100 w-100 bottom-0 t-body pointer'])[3]");

    // Seleccionadores de <select>
    private By departamentoDropdown = By.cssSelector("select.o-0.absolute");
    private By municipioDropdown = By.xpath("(//select[@class='o-0 absolute top-0 left-0 h-100 w-100 bottom-0 t-body pointer'])[2]");
    private By distritoDropdown = By.xpath("(//select[@class='o-0 absolute top-0 left-0 h-100 w-100 bottom-0 t-body pointer'])[3]");
    private By walmartSantaAnaDiv = By.xpath("//div[@class='store-title' and contains(text(),'Walmart Santa Ana')]");
    private By aceptarDiv = By.xpath("//div[text()='Aceptar']");

    // Localizador del botón "Buscar tienda"
    private By buscarTiendaDiv = By.xpath("//div[text()='Buscar tienda']");
    private By direccionPartes = By.cssSelector("div.c-gray.elipsis");

    // Constructor
    public TiendaPage(WebDriver driver) {
        super(driver);
    }

    // Métodos para interactuar con la página
    public void clickMenuButton() {
        WebElement menu = driver.findElement(menuButton);
        menu.click();
    }

    public void clickDepartamento() {
        WebElement departamento = driver.findElement(departamenSelect);
        departamento.click();
    }

    public void clickMunicipio() {
        WebElement municipio = driver.findElement(municipioSelect);
        municipio.click();
    }

    public void clickDistrito() {
        WebElement distrito = driver.findElement(distritoSelect);
        distrito.click();
    }

    /**
     * Selecciona un departamento del menú desplegable.
     *
     * @param departamento Nombre del departamento a seleccionar (por ejemplo,
     * "Santa Ana").
     */
    public void seleccionarDepartamento(String departamento) {
        // Localizar el elemento <select> de Departamento
        WebElement dropdown = driver.findElement(departamentoDropdown);

        // Crear una instancia de Select
        Select select = new Select(dropdown);

        // Seleccionar la opción correspondiente al texto proporcionado
        select.selectByVisibleText(departamento);
    }

    /**
     * Selecciona un municipio del menú desplegable.
     *
     * @param municipio Nombre del municipio a seleccionar (por ejemplo, "Santa
     * Ana Centro").
     */
    public void seleccionarMunicipio(String municipio) {
        // Localizar el elemento <select> de Municipio
        WebElement dropdown = driver.findElement(municipioDropdown);

        // Crear una instancia de Select
        Select select = new Select(dropdown);

        // Seleccionar la opción correspondiente al texto proporcionado
        select.selectByVisibleText(municipio);
    }

    /**
     * Selecciona un distrito del menú desplegable.
     *
     * @param distrito Nombre del distrito a seleccionar (por ejemplo, "Santa
     * Ana").
     */
    public void seleccionarDistrito(String distrito) {
        // Localizar el elemento <select> de Distrito
        WebElement dropdown = driver.findElement(distritoDropdown);

        // Crear una instancia de Select
        Select select = new Select(dropdown);

        // Seleccionar la opción correspondiente al texto proporcionado
        select.selectByVisibleText(distrito);
    }

    /**
     * Hace clic en el botón "Buscar tienda".
     */
    public void clickBuscarTienda() {
        WebElement buscarTienda = driver.findElement(buscarTiendaDiv);
        buscarTienda.click();
    }

    public void clickWalmartSantaAna() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement walmartSantaAna = wait.until(ExpectedConditions.elementToBeClickable(walmartSantaAnaDiv));
        walmartSantaAna.click();
    }

    public void clickAceptar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement aceptarButton = wait.until(ExpectedConditions.elementToBeClickable(aceptarDiv));
        aceptarButton.click();
    }

    public List<String> getDirecciones() {
        List<WebElement> partes = driver.findElements(direccionPartes);
        List<String> direcciones = new ArrayList<>();

        for (WebElement parte : partes) {
            direcciones.add(parte.getText());
        }

        return direcciones;
    }

    public String getDireccionCompleta() {
        List<WebElement> partes = driver.findElements(direccionPartes);
        StringBuilder direccionCompleta = new StringBuilder();

        for (WebElement parte : partes) {
            direccionCompleta.append(parte.getText()).append(" ");
        }

        return direccionCompleta.toString().trim();
    }





}
