@LoginControl

Feature: Control of unautorized users

  Scenario: Control of unautorized users

    Given user on home page

  Scenario Outline: Control of unautorized users read from excel file
    When  the users in the excel file "userPass.xls" in the order "<userRow>" try to login
    Then  login should not be successfull

    Examples:
      | userRow |
      | 1       |
      | 2       |
      | 5       |
      | 8       |
      | 10      |
      | 13      |
      | 15      |
