@Regression
Feature: Setup, Parameters, Bank Accounts process

  Background: login to basqar
    Given user on home page
    And   user logged in to basqar

  Scenario: Bank Accounts process, create
    Given user navigate to bank accounts page
    When  user create a bank account as follows
      | name            | account011             |
      | iban            | DE34567890123456789012 |
      | currency        | USD                    |
      | integrationCode | code01                 |

    Then  bank account should be created

  Scenario: Bank Accounts process, update
    Given user on bank accounts page
    When  user update the bank account named as "account011" as follows
      | name            | account012             |
      | iban            | TR34567890123456789012 |
      | currency        | 2                      |
      | integrationCode | Tr01                   |

    Then  bank account should be updated

  Scenario: Bank Accounts process, delete
    Given user on bank accounts page
    When  user delete the bank account named as "account012"
    Then  bank account should be deleted
