@Regression
Feature: Eduation, Setup, Subject Category operations

  Background: login to basqar
    Given user on home page
    And   user logged in to basqar

  Scenario: Subject Category operations, create with data table
    Given user navigate to subjects page
    When  user create a subject as follows
      | name     | subject5213 |
      | code     | sCode5213   |
      | category | 2           |
      | style    | 5           |

    Then  subject should be created

  Scenario: Subject Category operations, delete
    Given user navigate to subjects page
    When  user delete the subject name as "subject5213"
    Then  subject should be deleted

