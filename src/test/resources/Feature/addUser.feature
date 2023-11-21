@AddUser
Feature: Test Add User fuctionality in User management

  @CheckAddUser
  Scenario Outline: Verify Add user functionality
    Given the user is on homepage
    And clicks on Admin in sidepanel
    Then User Management section is displayed
    When user clicks on add button
    Then Add user form is displayed
    When user saves with parameters for <user_role>, <status>, <password>, <employee_name>, <user_name> and <confirm_password>
    And Clicks on save button
    Then user gets added to the list
    And success message is displayed

    Examples: 
      | user_role | status  | password | employee_name  | user_name | confirm_password |
      | Admin     | Enabled | Admin123 | Paul  Collings | Pauli     | Admin123         |
