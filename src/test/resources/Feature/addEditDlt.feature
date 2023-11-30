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
      | user_role | status  | password | employee_name       | user_name | confirm_password |
      | ESS       | Enabled | Admin123 | Charlie  Carter | Tester12   | Admin123         |

  @CheckEditUser
  Scenario Outline: Verify edit user functionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When Admin clicks on edit icon for the <username>
    Then edit user form is displayed
    When Admin updates the parameters <usernameupdate>, <userrole> and <status>
    And clicks on save button
    Then success messages should be displayed
    And redirected to <usermanagementscreen>
    And check if <userrole>, <status> for the <username> is updated

    Examples: 
      | username | usernameupdate | userrole | status  | usermanagementscreen |
      | Tester12  | tester123      | Admin    | Enabled | System Users         |

  @CheckDeleteUser
  Scenario Outline: Verify delete user functionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When user clicks on delete icon for the <username>
    Then confirmation <popup> shows up
    And user clicks on Yes button
    Then Success message is displayed
    And user with <username> gets delete and is not in the table

    Examples: 
      | username | popup         |
      | tester123  | Are you Sure? |
