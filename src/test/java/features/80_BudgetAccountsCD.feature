@Regression
Feature: Budget, Budget Accounts operations

  Background: login to basqar
    Given user on home page
    And   user logged in to basqar


  Scenario: Budget Accounts operations, create
    Given user navigate to budget accounts page
    When  user create a budget account as follows
      | name               | name1234 |
      | code               | n12345    |
      | category           | 4        |
      | type               | Detail   |
      | parentAccountCode  | 1        |
      | closingAccountCode | 10       |
      | balanceType        | Credit   |
      | integrationCodes   | 1        |
      | currency           | EUR      |

    Then  budget account should be created

  Scenario: Budget Accounts operations, delete
    When  user navigate to budget accounts page
    And   user delete the budget account named as "name1234" under category 4
    Then  budget account should be deleted