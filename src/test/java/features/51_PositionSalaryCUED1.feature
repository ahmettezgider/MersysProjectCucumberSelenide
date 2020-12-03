@Regression
Feature: Human Resourses, Setup, Position Salaries operations

  Background: login to basqar
    Given user on home page
    And   user logged in to basqar


  Scenario: Position Salaries operations, create a person
    Given user navigate to position salary page
    When  user create a person to position salary name as "posSal123"
    Then  person in position salary should be created


  Scenario: Position Salaries operations, create a position salary for a person
    Given user on position salary page
    When  user add position salary to the name "posSal123" as follows
      | experience | 3-5        |
      | fromDate   | 2019-05-05 |
      | salary     | 10000      |
      | currency   | USD        |
    Then position salary should be added


  Scenario: Position Salaries operations, update a position salary for a person
    Given user navigate to position salary page
    And   user update position salary to the name "posSal123" as follows
      | experience | 3-5        |
      | fromDate   | 2020-10-05 |
      | salary     | 12000      |
      | currency   | USD        |
    Then position salary should be updated


  Scenario: Position Salaries operations, delete a position salary for a person
    When  user navigate to position salary page
    And   user delete position salary belogs to person named "posSal123" with the text "3-5"
    Then  position salary should be deleted


  Scenario: Position Salaries operations, delete a person in position salary page
    When  user navigate to position salary page
    And   user delete the person in position salary named as "posSal123"
    Then  person in position salary should be deleted

