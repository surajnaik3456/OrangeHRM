@SearchFunctionality 
Feature: Check sidePanel search functionality

  Scenario Outline: Searching for a category in side panel
    Given the user is on homepage
    And the side panel is visible
    When user enters <category> in the side panel search field
    Then user should see search results related to <category>

    Examples: 
      | category  |
      | Admin     |
      | Leave     |
      | My Info   |
      | Dashboard |
