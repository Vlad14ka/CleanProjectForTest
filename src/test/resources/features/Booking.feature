# src/test/resources/features/Booking.feature

Feature: Flight Booking Scenarios on Air Canada
  As a user, I want to search and book a round trip flight
  In order to purchase a ticket

  Scenario: Search and select lowest Economy Basic fare for round trip
    Given I am on the Air Canada homepage
    When I accept cookies if present
    And I select a round trip flight from "New York" to "Paris"
    And I choose departure date "20/11/2025" and return date "27/11/2025"
    And I select 2 adults
    And I click the Search button
    Then I should be on the Flight Selection page
    When I select the lowest Economy Basic fare
    Then the booking process should proceed to the next step