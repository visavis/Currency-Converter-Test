@smoke, @login
Feature: Test login

  Scenario Outline: User will be <expectation>
    Given that I navigate to sample app
    When I click login link
    Then I will be redirected to login page
    And I fill the Email input field with <email> on login page
    And I fill the Password input field with <password> on login page
    And I click sign in button

    Examples: 
      | expectation                                    | email                      | password       |
      | alert for wrong email and password combination | dummy_user1@dummy-mail.com | wrong_password |
