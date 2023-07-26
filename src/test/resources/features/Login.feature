
# This file is contain scenarios to test for login feature

  Feature: User login

    @Regression1
    Scenario: User is able to login with valid credentials

      Given User enters a valid username in the username input
      And User enter a valid password in the password input
      When User clicks on login button
      Then User is logged successfully

    @Regression2
    Scenario Outline: User is not able to login with invalid credentials

      Given User enters an invalid <username> in the username input
      And User enter an invalid <password> in the password input
      When User clicks on login button
      Then User not logged successfully

    Examples:
    | username          | password         |
    | standard_user     | standard_user    |
    | locked_out_user   | locked_out_user  |
    | problem_user      | problem_user     |