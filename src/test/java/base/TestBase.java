// src/test/java/base/TestBase.java
package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;
import pages.BasePage;

import java.time.Duration;

public class TestBase {
    // Используем public, чтобы Page Objects имели к нему доступ
    public WebDriver driver;
    public BasePage basePage;

    @BeforeMethod
    public void setup() {
        // 1. Читаем из config.properties, какой браузер использовать
        String browserName = ConfigReader.getProperty("browser");


        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browserName);
        }

        // 2. Базовые настройки
        driver.manage().window().maximize();

        // 3. Неявное ожидание (Implicit Wait)
        long implicitWaitTime = Long.parseLong(ConfigReader.getProperty("implicit_wait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));

        // 4. Открытие URL
        driver.get(ConfigReader.getProperty("url"));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}