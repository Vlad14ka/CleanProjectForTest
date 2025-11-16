// src/test/java/pages/HomePage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final By acceptCookiesButton = By.id("onetrust-accept-btn-handler");


    public static final By selectFirstCityButton = By.id("flightsOriginLocationbkmgLocationContainer");
    public static final By selectSecondCityButton = By.id("flightsOriginDestinationbkmgLocationContainer");

    public static final By inputFirstCityField = By.id("flightsOriginLocation");
    public static final By inputSecondCityField = By.id("flightsOriginDestination");

    public static final By inputFirstDate = By.id("bkmg-desktop_travelDates-formfield-1");
    public static final By inputSecondDate = By.id("bkmg-desktop_travelDates-formfield-2");
    public static final By confirmDatesButton = By.id("bkmg-desktop_travelDates_1_confirmDates");


    public static final By selectTravelersButton = By.xpath("//button[contains(., 'Adulte') or contains(., 'Adult')]");
    public static final By inputPeopleAmount = By.id("bkmg-desktop_selectTravelers_addTraveler_ADT");
    public static final By closeTravelersModalButton = By.id("bkmg-desktop_selectTravelers_confirmTravelers");

    public static final By searchButton = By.xpath("//button[contains(@class, 'type-primary') and .//span[contains(text(), 'Chercher')]]");



    public static final By check = By.id("ac-page-main");





    /** * Ищет и нажимает кнопку принятия Cookies. */
    public void acceptCookiesIfPresent() {
        System.out.println("Пытаемся принять Cookie...");
        try {
            // clickElement включает явное ожидание видимости элемента
            clickElement(acceptCookiesButton);
            System.out.println("Cookie приняты.");
        } catch (Exception e) {
            // Если кнопка не найдена в течение таймаута (15 сек), продолжаем.
            System.out.println("Баннер Cookie не найден или не появился вовремя. Продолжаем.");
        }
    }



}