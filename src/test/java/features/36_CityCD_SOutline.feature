@Regression
Feature: Setup, Parameters, City are proceeds

  Background: login and navigate to cities page
    Given user on home page
    And   user logged in to basqar


  Scenario Outline: create and delete city
    Given user navigate to cities page
    When  user create a city name as "<cityName>" that belong to the country "<countryName>"
    Then  city should be created

    When  user delete the city named as "<cityName>"
    Then  city should be deleted

    Examples:
      | countryName | cityName     |
      | Turkey      | Kasseria1    |
      | Greece      | Theseloniki1 |
