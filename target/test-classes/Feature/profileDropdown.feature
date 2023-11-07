@profiledropdown
Feature: Testing the Profile Dropdown Module

  Scenario: Accessing About Information
    Given the user is on homepage
    When the user clicks on profile dropdown
    And the user selects About
    Then about dialogue box shows up on the application

  Scenario: Accessing Support Information
    Given the user is on homepage
    When the user clicks on profile dropdown
    And the user select Support
    Then user should be directed to the support page
    
  @Changepassword
  Scenario Outline: Changing Password
    Given the user is on homepage
    When the user clicks on profile dropdown
    And the user selects Change Password
    Then change password screen is displayed
    And the user enter <currentpassword>, <password> and <confirmpassword>
    And clicks on save botton
    Then Success flash message is displayed

    Examples: 
      | currentpassword | password   | confirmpassword |
      | admin123        | admin12345 | admin12345      |

  @logout
  Scenario: Logout functionality
    Given the user is logged in
    When the user clicks on profile dropdown
    And clicks the logout
    Then the user should be logged out and redirected to the login page
