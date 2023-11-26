@AddJobTitle
Feature: Test adding job title fuctionality in User management

  @CheckEditJobTitle
  Scenario Outline: Verify adding job title fuctionality
    Given the user is on homepage
    And clicks on Admin in sidepanel
    Then user Management section is displayed
    When user clicks on job dropdown
    And selects job titles
    Then job title screen is displayed
    When user clicks on add button
    Then job title form is displayed
    And fills all the parameters <jobTitle>,<jobDescription> and <note>
    And uploads a file in job specification
    And clicks on save button
    Then success message is displayed 
    And job title gets added to the table
    

    Examples: 
      | jobTitle        | jobDescription                                                                          | note                                                      |
      | Software tester | A Software Tester is responsible for ensuring the quality and functionality of software | I am a detail-oriented and highly analytical professional |
