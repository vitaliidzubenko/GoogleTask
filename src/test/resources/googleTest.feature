Feature: UI Testing with Google search

  Background:
    Given Open Google and search for "automation"

  @google
  Scenario Outline: №1 Searching word
    When Open the first link on search results page
    Then Verify that title contains searched "<word>"
    Examples:
      | word       |
      | automation |

  @google
  Scenario Outline: №2 Searching domain
    Then Verify that there is expected "<domain>" on "<pageCount>" pages
    Examples:
      | domain                | pageCount |
      | testautomationday.com | 5         |

