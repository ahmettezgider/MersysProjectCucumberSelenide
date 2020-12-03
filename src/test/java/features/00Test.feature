Feature: Login

  @Test00
  Scenario: deneme

    Given user on home page
    And   user logged in to basqar
    And   the browser size is "max"
    When  user navigate to cities page
    And   user create a city name as "CityTr002" that belong to the country "Sumerler"
    Then  city should be created
    When  user delete the city named as "CityTr002"
    Then  city should be deleted
    And   user logout from basqar
