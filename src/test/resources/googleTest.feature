Feature: UI Testing with Google search

  Background:
    Given Open Google and search for "automation"

  @Run
  Scenario Outline: №1 Searching word
    When Open the first link on search results page
    Then Verify that title contains searched "<word>"
    Examples:
      | word       |
      | automation |

  @Run
  Scenario Outline: №2 Searching domain
    Then Verify that there is expected "<domain>" on 5 pages
    Examples:
      | domain                |
      | testautomationday.com |

