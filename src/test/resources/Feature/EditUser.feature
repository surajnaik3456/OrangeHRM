@EditUser
Feature: Test Edit User fuctionality in User management

  @CheckEditUser
  Scenario Outline: Verify edit user functionality
    Given the user is on homepage
    And clicks on Admin in sidepanel
    Then user Management section is displayed
    When user clicks on edit icon for the <username>
    Then edit user form is displayed
    When user updates the user role from Admin to ESS<role>
    And clicks on save button
    Then success messages should be displayed
    And redirected to user management screen

    Examples: 
      | username    | role  |
      | Admin       | ESS   |
      | arica.ratke | Admin |
