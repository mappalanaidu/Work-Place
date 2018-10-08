Feature: Way2SMS Logout

  @smoketest
  Scenario: validate logout operation
    Given Launch site using "chrome"
    When do login with valid data
      | mbni       | pwd       |
      | 9948838954 | bhagya530 |
    And do lougout
    Then home page will be reopened
    And close site
