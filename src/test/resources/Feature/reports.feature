@AddReports
Feature: Test adding report functionality in user management 

 Background: 
    Given the user is on homepage
    And clicks on "PIM" in sidepanel
    Then PIM page is displayed
    
  @AddNewReports
  Scenario Outline: Verify add report functionality
    When Admin clicks on Reports in top bar
    Then "Employee Reports" page is displayed 
    And Click on add button
    Then "Add Report" page is displayed
    And Fill all the parameters <employeeDetails>,<selectionCriteria>,<include> and <displayFieldGroup>
    And Add <displayField> 
    Then Click on plus icon
    And Click on include header toggle button
    And Click on save button
    Then success message is displayed
    And Report is generated 

 Examples:
 |employeeDetails|selectionCriteria|include|displayFieldGroup|
 |Employee Details Report|Employee Name|Current Employees Only|Personal|