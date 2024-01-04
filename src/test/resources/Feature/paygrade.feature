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
    And The "Edit Pay Grade" page is displayed successfully
    When Admin clicks on Add button
    Then "Add Currency" section shows up
    And Admin adds parameters in add currency section <currency>,<minimumsalary> and <maximumsalary>
    And Clicks on save button for add currency
    Then success message is displayed
    And currency created with parameters <addedcurrency>, <minimumsalary> and <maximumsalary> are added to the table
    When Admin clicks on cancel button
    Then Added paygrade with <paygradename> and <addedcurrency> gets listed in pay grade table

    Examples: 
      | paygradename | currency           | minimumsalary | maximumsalary | addedcurrency |
      | Grade 15     | INR - Indian Rupee |      10000.00 |      25000.00 | Indian Rupee  |
