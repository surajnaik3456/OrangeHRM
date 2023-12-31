@AddPayGrades
Feature: Test paygrades functionality in user management

  Background: 
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When Admin clicks on job dropdown
    And selects "Pay Grades" in the dropdown
    Then "Pay Grades" screen is displayed

  Scenario Outline: Verify adding pay grades and currency fuctionality
    When Admin clicks on Add button
    Then "Add Pay Grade" page is displayed
    And Admin enters <paygradename>
    And Clicks on save button
    Then success message is displayed
    And "Edit Pay Grade" page is displayed
    When Admin adds parameters in add currency section <currency>,<minimumsalary> and <maximumsalary>
    And Clicks on save button
    Then success message is displayed
    And currency created with parameters <currency>,<minimumsalary> and <maximumsalary> gets added to the table
    When Admin clicks on cancel button 
    Then Added paygrade with <paygradename> and <currency> gets listed in pay grade table
    

    Examples: 
      | paygradename | currency           | minimumsalary | maximumsalary |
      | Hey          | INR - Indian Rupee |         20000 |         30000 |
