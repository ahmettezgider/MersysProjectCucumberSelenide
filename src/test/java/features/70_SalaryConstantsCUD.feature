@Regression
Feature: Human Resourses, Setup, Salary Constants operations

  Background: login to basqar
    Given user on home page
    And   user logged in to basqar

  Scenario: Salary Constants operations, create
    Given user navigate to salary constants page
    When  user create a salary constant as follows
      | name          | name1234   |
      | validFormDate | 2019-01-10 |
      | key           | name123key |
      | value         | 100        |
    Then  salary constant should be created

  Scenario: Salary Constants operations, update
    Given user on salary constants page
    When  user update the salary constant name as "name1234" as follows
      | name          | name1244   |
      | validFormDate | 2020-05-10 |
      | key           | name124key |
      | value         | 200        |
    Then  salary constant should be updated

  Scenario: Salary Constants operations, delete
    Given user on salary constants page
    When  user delete the constant type named as "name1244"
    Then  salary constant should be deleted