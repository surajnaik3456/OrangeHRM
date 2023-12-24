@AddEditEmployee
Feature: Test adding and editing employee fuctionality in User management

  Background: 
    Given the user is on homepage
    And clicks on "PIM" in sidepanel
    Then PIM page is displayed

  @CheckAddEmployee
  Scenario Outline: Verify adding employee fuctionality
    When Admin clicks on Add button
    Then "Add Employee" page is displayed
    And Add profile picture
    And Fills all the parameters <firstname>,<middlename> and <lastname>
    And Click on save button
    Then "Personal Details" page gets displayed
    And Click on "Job"
    And Job details page is displayed
    Then Fill the parameters for <jobtitle>, <subunit> and <employmentstatus>
    And Click on save button
    Then success message is displayed
    And Click on the "Report-to"
    Then The "Report to" page is displayed
    And Click on add button
    And Add <name> and <reportingmethod>
    When Clicks on the save button
    Then success message is displayed
    And Click on Employee list
    And Check if the employee with <firstAndMiddleName>,<lastname>and <jobtitle> is added

    Examples: 
      | firstname | middlename | lastname | jobtitle                | subunit     | employmentstatus    | name           | reportingmethod | firstAndMiddleName |
      | Surajboi  | S          | Naik     | Chief Technical Officer | Engineering | Full-Time Permanent | Dominic  Chase | Direct          | Surajboi S         |

  @CheckEditEmployeeName
  Scenario Outline: Verify Editing added employee functionality
    When Admin clicks on edit for the employee with first and middle name "Surajboi S"
    Then "Personal Details" page is displayed
    And update <firstName>, <middleName> and <lastName>
    And Admin clicks on save button
    Then success message is displayed
    And Click on "Job"
    And Job details page is displayed
    Then Update <jobtitle>and<subunit>
    And Click on save button
    Then success message is displayed
    And Click on Employee list
    And Check if the employee with <firstAndMiddleName>,<lastName> and <jobtitle> is updated

    Examples: 
      | firstName | middleName | lastName | jobtitle           | subunit        | firstAndMiddleName |
      | Tester    | hii        | heyi     | Content Specialist | Administration | Teste hi           |
