@AddReports
Feature: Test adding report functionality in user management

  Background: 
    Given the user is on homepage
    And clicks on "PIM" in sidepanel
    Then PIM page is displayed

  @AddNewReports
  Scenario Outline: Verify add report functionality
    When Admin clicks on Reports in top bar
    Then "Employee Reports" page is been displayed
    And Click on add button in reports page
    Then "Add Report" page is displayed successfully
    And Fill all the parameters <reportName>,<selectionCriteria>,<include> and <displayFieldGroup>
    And Admin adds first display field <displayField1> to be displayed in reports
    And Admin adds second display field <displayField2> to be displayed in reports
    And Admin adds second display field <displayField3> to be displayed in reports
    Then Click on plus icon
    And Click on include header toggle button
    And Admin clicks on save button for reports
    Then success message is displayed
    And Report is generated for <reportName>
    When Admin clicks on Reports in top bar
    Then check report with <reportName> is added

    Examples: 
      | reportName              | selectionCriteria | include                | displayFieldGroup | displayField1 | displayField2      | displayField3 |
      | Employee Details Report | Employee Name     | Current Employees Only | Personal          | Employee Id   | Employee Last Name | Gender        |
