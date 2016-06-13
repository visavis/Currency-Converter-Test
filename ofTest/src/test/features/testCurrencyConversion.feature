@smoke
Feature: Test currencies

  Scenario: Currencies should not change over the weekend
    Given that I navigate to Oanda converter page
    When I change the date to Friaday before last weekend
    And I store the exchange rates
    And I change the date by one day forward
    Then the exchange rate will be same as on Friday
    When I change the date by one day forward
    Then the exchange rate will be same as on Friday
