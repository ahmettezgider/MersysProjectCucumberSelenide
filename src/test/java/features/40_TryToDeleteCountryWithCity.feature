@Regression
Feature: Setup, Parameters, Country and City combined operations

  Background: user login steps
    Given user on home page
    And   user logged in to basqar

  Scenario: Country and City operation, create a country
    Given user navigate to countries page
    When  user create a country name as "CountryName1235" and code as "CountryCode1235"
    Then  country should be created

  Scenario: Country and City operation, create a city to a country
    When  user navigate to cities page
    And   user create a city name as "CityName1235" that belong to the country "CountryName1235"
    Then  city should be created

  Scenario: Country and City operation, try to delete country
    When  user navigate to countries page
    And   user delete the country named as "CountryName1235"
    Then  country should not be deleted

  Scenario: Country and City operation, delete the city of a country before deleting the country
    When  user navigate to cities page
    And   user delete the city named as "CityName1235"
    Then  city should be deleted

  Scenario: Country and City operation, after deleting city delete the country
    When  user navigate to countries page
    And   user delete the country named as "CountryName1235"
    Then  country should be deleted

