@AddEditDltJobTitle
Feature: Test adding job title fuctionality in User management

  @CheckAddJobTitle
  Scenario Outline: Verify adding job title fuctionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When Admin clicks on job dropdown
    And selects "Job Titles" in the dropdown
    Then "Job Titles" screen is displayed
    When user clicks on add button
    Then "Add Job Title" form is displayed
    And fills all the parameters <jobTitle>,<jobDescription> and <note>
    And clicks on save button
    Then success message is displayed
    And Check if title <jobTitle> and descrption got added to the table

    Examples: 
      | jobTitle          | jobDescription | note                                                      |
      | Automation Tester | .......        | I am a detail-oriented and highly analytical professional |

  @CheckEditJobTitle
  Scenario Outline: Verify Editing job title functionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When Admin clicks on job dropdown
    And selects "Job Titles" in the dropdown
    Then "Job Titles" screen is displayed
    When Admin clicks on edit icon for job title "Chief Financial Officer"
    Then "Edit Job Title" form displays
    When Admin updates <jobTitle>, <jobDescription> and <note>
    And Clicks on save button
    Then success message is displayed
    And <jobTitle> gets added to the table

    Examples: 
      | jobTitle          | jobDescription                                                    | note                                |
      | Financial Officer | A Software Tester is responsible for ensuring quality of software | I am a detail-oriented professional |

  @CheckDeleteJobTitle
  Scenario Outline: Verify Deleting job title functionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When Admin clicks on job dropdown
    And selects "Job Titles" in the dropdown
    Then "Job Titles" screen is displayed
    When Admin clicks on delete icon for the <jobTitle>
    Then confirmation <popup> shows up
    And user clicks on Yes button
    Then Success message is displayed
    And user with <jobTitle> job title gets deleted and is not in the table

    Examples: 
      | jobTitle        | popup         |
      | Finance Manager | Are you Sure? |
