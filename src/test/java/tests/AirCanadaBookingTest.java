// src/test/java/tests/AirCanadaBookingTest.java
package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.FlightSelectionPage;
import pages.HomePage;
import utilities.ConfigReader;

public class AirCanadaBookingTest extends TestBase {

    @Test(description = "Scenario 1: Search and select lowest Economy Basic fare for round trip")
    public void searchForLowestFareRoundTrip() {


        HomePage homePage = new HomePage(driver);
        FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
        homePage.acceptCookiesIfPresent();

        Assert.assertTrue(homePage.isVisible(HomePage.selectFirstCityButton));
        Assert.assertTrue(homePage.isVisible(HomePage.selectSecondCityButton));



        homePage.clickElement(HomePage.selectFirstCityButton);
        Assert.assertTrue(homePage.isVisible(HomePage.inputFirstCityField));
        homePage.sendKeys(HomePage.inputFirstCityField,"Paris");

        homePage.clickElement(HomePage.selectSecondCityButton);
        homePage.sendKeys(HomePage.inputSecondCityField,"New York");


        homePage.clickElement(HomePage.inputFirstDate);
        homePage.sendKeys(HomePage.inputFirstDate,"20/11/2025");


        homePage.clickElement(HomePage.inputSecondDate);
        homePage.sendKeys(HomePage.inputSecondDate,"27/11/2025");


        homePage.clickElement(HomePage.confirmDatesButton);

        homePage.clickElement(HomePage.selectTravelersButton);
        homePage.clickElement(HomePage.inputPeopleAmount);
        homePage.clickElement(HomePage.closeTravelersModalButton);


        String currentUrl = driver.getCurrentUrl();
        System.out.println("Текущий URL до поиска: " + currentUrl);

        homePage.clickElement(HomePage.searchButton);//переходим на новую страницу


        String currentUrl2 = driver.getCurrentUrl();
        System.out.println("Текущий URL после поиска: " + currentUrl2);


        Assert.assertNotEquals(driver.getCurrentUrl(), ConfigReader.getProperty("url"));

        flightSelectionPage.clickElement(FlightSelectionPage.economyTab);



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}