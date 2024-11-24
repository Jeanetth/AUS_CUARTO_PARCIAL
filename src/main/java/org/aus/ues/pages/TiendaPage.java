package org.aus.ues.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TiendaPage extends BasePage {
    // Localizadores
    private By menuButton = By.cssSelector("span.nr2");
    private By departamentoLabel = By.cssSelector("label.h-100");

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
        WebElement departamento = driver.findElement(departamentoLabel);
        departamento.click();
    }
}
