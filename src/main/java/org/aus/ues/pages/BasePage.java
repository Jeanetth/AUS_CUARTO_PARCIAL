package org.aus.ues.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver initDriver() {
        // Configurar el WebDriver usando WebDriverManager
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        return new ChromeDriver(options);
    }

    // Método para navegar a una URL
    public void navigateTo(String url) {
        driver.get(url);
    }

    // Método para obtener el título de la página
    public String getPageTitle() {
        return driver.getTitle();
    }
}
