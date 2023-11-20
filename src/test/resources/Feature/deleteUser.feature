@DeleteUser
Feature: Test Delete User fuctionality in User management

  @tag1
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
