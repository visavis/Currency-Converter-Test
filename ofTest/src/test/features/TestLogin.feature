@smoke, @login
Feature: Test login

  Scenario Outline: User will be <expectation>
    Given that I navigate to sample app
    When I click login link
    When I fill the username input with <name> in login form
    And I fill the password input with <password> in login form
    And I click login button
    Examples: 
      | expectation                      | name       | email                      | password | password_confirmation | alert                                           |
      | alert for lack of username       |            | dummy_user1@dummy-mail.com | password | password              | Name can't be blank                             |
      | alert for lack of email          | dummy_user |                            | password | password              | Email can't be blank                            |
      | alert for password too short     | dummy_user | dummy_user@dummy-mail.com  | pass     | pass                  | Password is too short (minimum is 6 characters) |
      | alert for password inconsistency | dummy_user | dummy_user@dummy-mail.com  | pass     | password              | Password confirmation doesn't match Password    |
