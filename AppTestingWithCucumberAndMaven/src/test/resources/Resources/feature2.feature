Feature: Calculator App Testing

  Scenario: validate app launching
    Given Launch app
    Then app contains "9"
    And close app
   