@smoke
Feature: Test Signup process

  Scenario Outline: Sign Up form should be shown
    Given that I navigate to sample app
    When I click Sign up now! button
    Then I will be redirected to signup page
    And I will see the Name input field
    And I will see the Email input field
    And I will see the Password input field
    And I will see the Password confirmation input field
    When I fill the username input with <name>
    And I fill the email input with <email>
    And I fill the password input with <password>
    And I fill the password confiration input with <password>
    And I click submit button
    Then I will see Welcome to the Sample App! alert

    Examples: 
      | name        | email                      | password       |
      | dummy_user2 | dummy_user2@dummy-mail.com | dummyPassword  |
      | dummy_user3 | dummy_user3@dummy-mail.com | dummyPassword1 |
