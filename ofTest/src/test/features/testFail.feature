@smoke
Feature: Page test

  @tag1
  Scenario: Page should open
    Given that I navigate to Oanda converter page
    When I change the date to Friaday before last weekend
    And I store some dummy exchange rates
    Then the exchange rate will be same as on Friday
