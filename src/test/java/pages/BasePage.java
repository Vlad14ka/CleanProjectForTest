// src/test/java/pages/BasePage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private final Duration TIMEOUT = Duration.ofSeconds(15); // Явное ожидание
    private final Duration SHORT_TIMEOUT = Duration.ofSeconds(3); // Короткое ожидание для isVisible



    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Вспомогательные методы (Helpers) ---

    /** Кликает по элементу, используя явное ожидание видимости */
    public void clickElement(By locator) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator))
                .click();
    }

    /** Вводит текст в поле, используя явное ожидание */
    public void sendKeys(By locator, String text) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(text);
    }

    /** Ждет, пока элемент станет видимым */
    public void waitForVisibility(By locator) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /** Получает текст элемента, используя явное ожидание */
    public String getElementText(By locator) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator))
                .getText();
    }
    /**
     * Проверяет, видим ли элемент на странице в течение короткого таймаута (3 секунды).
     * @param locator Локатор элемента.
     * @return true, если элемент видим, иначе false.
     */
    public boolean isVisible(By locator) {
        try {
            // Используем короткое явное ожидание
            new WebDriverWait(driver, SHORT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            // Если возникло исключение (TimeoutException, NoSuchElementException),
            // значит, элемент не виден или отсутствует.
            return false;
        }
    }
}