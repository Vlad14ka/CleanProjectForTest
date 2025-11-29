// src/test/java/pages/FlightSelectionPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSelectionPage extends BasePage {

    public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }

    public static final By economyTab = By.xpath(
            "//button[.//span[contains(text(), 'Économique') or contains(text(), 'Economy')]]"
    );

}