@AddEditDltJobTitle
Feature: Test adding job title fuctionality in User management

  @CheckAddJobTitle
  Scenario Outline: Verify adding job title fuctionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When Admin clicks on job dropdown
    And selects job titles
    Then job title screen is displayed
    When user clicks on add button
    Then job title form is displayed
    And fills all the parameters <jobTitle>,<jobDescription> and <note>
    And clicks on save button
    Then success message is displayed
    And job title gets added to the table

    Examples: 
      | jobTitle        | jobDescription                                                                          | note                                                      |
      | Software tester | A Software Tester is responsible for ensuring the quality and functionality of software | I am a detail-oriented and highly analytical professional |

  @CheckEditJobTitle
  Scenario Outline: Verify Editing job title functionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When Admin clicks on job dropdown
    And selects job titles
    Then job title screen is displayed
    When Admin clicks on edit icon for the <jobTitle>
    Then edit job title form is displayed
    When Admin updates the <updateJobTitle>, <jobDescription> and <note>
    And Clicks on save button
    Then success message is displayed
    And <updateJobTitle> gets added to the table

    Examples: 
      | jobTitle        | jobDescription                                                        | note                                |
      | Software tester | A Software Tester is responsible for ensuring the quality of software | I am a detail-oriented professional |

  @CheckDeleteJobTitle
  Scenario Outline: Verify Deleting job title functionality
    Given the user is on homepage
    And clicks on "Admin" in sidepanel
    Then User Management section is displayed
    When Admin clicks on job dropdown
    And selects job titles
    Then job title screen is displayed
    When Admin clicks on delete icon for the <jobTitle>
    Then confirmation <popup> shows up
    And user clicks on Yes button
    Then Success message is displayed
    And user with <jobTitle> gets deleted and is not in the table

    Examples: 
      | jobTitle        | popup         |
      | Software tester | Are you Sure? |
