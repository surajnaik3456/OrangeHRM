@Usermanagement
Feature: feature to test the user management

  Scenario Outline: Verify search and reset functionality for user management in admin
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then <usermanagement> section is displayed
    And the user makes a note of the total number of records for the users
    When user search with search parameters for <username>, <user_role>, <employee_name> and <status>
    And clicks on Search button
    Then the searched user is displayed with the <message>
    When the user clicks on Reset button
    Then the search parameters values should be cleared
    And All the records should be displayed

    Examples: 
      | username | user_role | employee_name   | status  | message          | usermanagement |
      | Admin    | Admin     | Paul M Collings | Enabled | (1) Record Found | System Users  |
