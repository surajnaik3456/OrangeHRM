@AddUser
Feature: Test Add User fuctionality in User management

  @CheckAddUser
  Scenario Outline: Verify Add user functionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When user clicks on add button
    Then Add user form is displayed
    When user saves with parameters for <user_role>, <status>, <password>, <employee_name>, <user_name> and <confirm_password>
    And Clicks on save button
    Then user <user_name> gets added to the list
    And success message is displayed

    Examples: 
      | user_role | status  | password | employee_name  | user_name | confirm_password |
      | Admin     | Enabled | Admin123 | Paul  Collings | Pauli     | Admin123         |
      
     @CheckEditUser
  Scenario Outline: Verify edit user functionality
    Given the user is on homepage
    And clicks on Admin in sidepanel
    Then user Management section is displayed
    When user clicks on edit icon for the "Aaliyah.Haq"
    Then edit user form is displayed
    When user updates the user role from Admin to ESS<role>
    And clicks on save button
    Then success messages should be displayed
    And redirected to user management screen

    Examples: 
      | username    | role  |
      | Admin       | ESS   |
      | arica.ratke | Admin |
     
      @CheckDeleteUser
  Scenario Outline: Verify delete user functionality
    Given the user is on homepage
    And clicks on Admin in sidepanel
    Then User Management section is displayed
    When user clicks on delete icon for the <username>
    Then confirmation pop-up shows up
    And user clicks on Yes,delete button
    Then Success message is displayed

    Examples: 
      | username |
      | Pauli    |
