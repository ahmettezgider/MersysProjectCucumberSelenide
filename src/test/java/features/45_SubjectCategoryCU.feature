@Regression
Feature: Eduation, Setup, Subject Category operations

  Background: login to basqar
    Given user on home page
    And   user logged in to basqar

  Scenario: Subject Category operations, create
    Given user navigate to subject categories page
    When  user create a subject category name as "sCategory3215" and code as "sCode3215"
    Then  subject category should be created

  Scenario: Subject Category operations, update
    Given user on subject categories page
    When  user update the subject category named "sCategory3215" to name as "sCategory3225" and code as "sCode3225"
    Then  subject category should be updated

  Scenario: Subject Category operations, delete
    Given user on subject categories page
    When  user delete the subject category name as "sCategory3225"
    Then  subject category should be deleted

