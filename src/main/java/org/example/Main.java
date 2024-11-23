package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
 public static void main(String[] args) {
        // WebDriverManager descargará automáticamente el ChromeDriver
        WebDriverManager.chromedriver().setup(); // Esto maneja la configuración automáticamente

        // Opciones para el navegador
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Iniciar el navegador maximizado
        options.addArguments("--disable-blink-features=AutomationControlled"); // Evitar detección como bot
        // options.addArguments("--headless"); // Para modo sin interfaz gráfica (headless)

        // Inicializar el WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Abrir la URL de Walmart El Salvador
            String url = "https://www.walmart.com.sv/";
            driver.get(url);

            // Imprimir el título de la página
            System.out.println("Título de la página: " + driver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            driver.quit();
        }
    }
}