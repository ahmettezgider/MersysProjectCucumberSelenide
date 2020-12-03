
Feature: Setup, Parameters, Country are proceeds

  Scenario: Country create and logout

    Given user on home page
    And   user logged in to basqar
    And   user navigate to countries page

    When  user create a country name as "countryName1234" and code as "countryCode1"
    Then  country should be created

    And  user logout from basqar