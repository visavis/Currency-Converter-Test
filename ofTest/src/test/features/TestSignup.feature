@smoke, @signup
Feature: Test Signup process failure

  Scenario Outline: Sign Up form should <expectation>
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
    And I fill the password confiration input with <password_confirmation>
    And I click submit button
    Then I will see the alert saying: <alert>

    Examples: 
      | expectation                | name | email                      | password | password_confirmation | alert               |
      | alert for lack of username |      | dummy_user1@dummy-mail.com | password | password              | Name can't be blank |
#      | alert for lack of email          | dummy_user |                            | password | password              | Email can't be blank                            |
#      | alert for password too short     | dummy_user | dummy_user@dummy-mail.com  | pass     | pass                  | Password is too short (minimum is 6 characters) |
#      | alert for password inconsistency | dummy_user | dummy_user@dummy-mail.com  | pass     | password              | Password confirmation doesn't match Password    |
