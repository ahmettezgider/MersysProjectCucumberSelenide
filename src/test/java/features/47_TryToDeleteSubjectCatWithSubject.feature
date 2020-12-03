@Regression
Feature: Try to delete subject category with subject

  Background: login to basqar
    Given user on home page
    And   user logged in to basqar

  Scenario: create a subject category
    Given user navigate to subject categories page
    When  user create a subject category name as "subjectCategory3214" and code as "sCode3214"
    Then  subject category should be created

  Scenario: create a subject under the existent category
    When user navigate to subjects page
    And  user create a subject as follows
      | name     | subject3214         |
      | code     | sb321               |
      | category | subjectCategory3214 |
      | style    | 5                   |

    Then  subject should be created

  Scenario: Try to delete subject category that have a subject
    When  user navigate to subject categories page
    And   user delete the subject category name as "subjectCategory3214"
    Then  subject category should not be deleted


  Scenario: Delete subject, before deletion of category
    Given user navigate to subjects page
    When  user delete the subject name as "subject321"
    And   subject should be deleted

  Scenario: Delete subject category, after deletion of subject
    Given user navigate to subject categories page
    When  user delete the subject category name as "subjectCategory321"
    Then  subject category should be deleted

