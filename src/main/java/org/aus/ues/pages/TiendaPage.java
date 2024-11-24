package org.aus.ues.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TiendaPage extends BasePage {
    // Localizadores
    private By menuButton = By.cssSelector("span.nr2");
    private By departamenSelect = By.xpath("(//select[@class='o-0 absolute top-0 left-0 h-100 w-100 bottom-0 t-body pointer'])[1]");
    private By municipioSelect = By.xpath("(//select[@class='o-0 absolute top-0 left-0 h-100 w-100 bottom-0 t-body pointer'])[2]");
    private By distritoSelect = By.xpath("(//select[@class='o-0 absolute top-0 left-0 h-100 w-100 bottom-0 t-body pointer'])[3]");
    
    
    
    private By departamentoDropdown = By.cssSelector("select.o-0.absolute"); // Selector del elemento <select>

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
     * @param departamento Nombre del departamento a seleccionar (por ejemplo, "Santa Ana").
     */
    public void seleccionarDepartamento(String departamento) {
        // Localizar el elemento <select>
        WebElement dropdown = driver.findElement(departamentoDropdown);
        
        // Crear una instancia de Select
        Select select = new Select(dropdown);
        
        // Seleccionar la opción correspondiente al texto proporcionado
        select.selectByVisibleText(departamento);
    }
}

