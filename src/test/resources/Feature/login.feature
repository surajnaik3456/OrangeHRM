@Smoke
 Feature: Test the login functionality of OrangeHRM

@First
  Scenario Outline: Test the valid login
    Given user is on login page
    When user enters valid <username> and <password>
    And click on Login button
    Then user should land on homepage

    Examples: 
      | username | password |
      | Admin    | admin123 |

  @Second
  Scenario Outline: Login with invalid username and valid password
    Given user is on login page
    When user enters invalid <username> and valid <password>
    And click on Login button
    Then the user should get an error message indicating Invalid Credentials

    Examples: 
      | username | password |
      | Adm      | admin123 |

  @Third
  Scenario Outline: Login with valid username and invalid password
    Given user is on login page
    When user enters valid <username> and invalid <password>
    And click on Login button
    Then the user should get an error message indicating Invalid Credentials

    Examples: 
      | username | password |
      | Admin    | Abcd     |

  @Fourth
  Scenario Outline: Login with empty username and password fields
    Given user is on login page
    When the user leaves both username and password fields empty
    And click on Login button
    Then the user should get an error message indicating required fields
    
  @Fifth
  Scenario: Forgot password flow
  Given user is on login page
  When user clicks on forgot your password link
  Then Reset password page is displayed
  And Enter username in username text field
  And click on Reset password button
  Then reset password link is sent via email
  
  
  @sixth
  Scenario Outline: Logout functionality
    Given the user is logged in
    When the user clicks on profile dropdown
    And clicks the logout
    Then the user should be logged out and redirected to the login page
