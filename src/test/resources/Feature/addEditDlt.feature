@AddEditDltUser
Feature: Test Add User fuctionality in User management

  @CheckAddUser
  Scenario Outline: Verify Add user functionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When Admin clicks on add button
    Then Add user form is displayed
    When user saves with parameters for <user_role>, <status>, <password>, <employee_name>, <user_name> and <confirm_password>
    And Clicks on save button in add user page
    Then success message is displayed
    And user with <user_name> gets added to the list

    Examples: 
      | user_role | status  | password | employee_name   | user_name | confirm_password |
      | Admin     | Enabled | Admin123 | Charlie  Carter | Tester189 | Admin123         |

  @CheckEditUser
  Scenario Outline: Verify edit user functionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When Admin clicks on edit icon for the <username>
    Then edit user form is displayed
    When user updates the user name to <updatedname>
    And clicks on save button
    Then success messages should be displayed
    And redirected to user management screen

    Examples: 
      | user       | updatedname |
      | Tester189 | tester11    |

  @CheckDeleteUser
  Scenario Outline: Verify delete user functionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When user clicks on delete icon for the <username>
    Then confirmation pop-up shows up
    And user clicks on Yes,delete button
    Then Success message is displayed

    Examples: 
      | username |
      | Pauli    |
