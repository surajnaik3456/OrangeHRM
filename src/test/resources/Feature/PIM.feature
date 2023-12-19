@AddEditEmployee
Feature: Test adding and editing employee fuctionality in User management

  @CheckAddEmployee
  Scenario Outline: Verify adding employee fuctionality
    Given the user is on homepage
    And clicks on "PIM" in sidepanel
    Then PIM page is displayed
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
    And Check if the employee with <firstname>,<middlename> and <jobtitle> is added

    Examples: 
      | firstname | middlename | lastname | jobtitle          | subunit     | employmentstatus    | name             | reportingmethod |
      | Test      | s          | naik     | Account Assistant | Engineering | Full-Time Permanent | Cecil  Bonaparte | Direct          |

  @CheckEditEmployee
  Scenario Outline: Verify Editing added employee functionality
    Given the user is on homepage
    And clicks on "PIM" in sidepanel
    Then PIM page is displayed
    When Admin clicks on edit icon for the employee with first name "Test"
    Then "Personal Details" page is displayed
    And Update the <middlename> and <lastname>
    And Click on save botton
    Then success message is displayed
    And Click on "Job"
    And Job details page is displayed
    Then Update <jobtitle>and<subunit>
    When Clicks on the save button
    Then success message is displayed
    And Click on Employee list
    And Check if the employee with updated <middlename>,<lastname> and <jobtitle> is present

    Examples: 
      | middlename | lastname | jobtitle   | subunit |
      |         21 | nk       | IT Manager | TechOps |
