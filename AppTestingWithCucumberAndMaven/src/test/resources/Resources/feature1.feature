Feature: Calculator App Testing

   Scenario Outline: validate addition operation
    Given Launch app
    When enter first number as "<x>"
    And click plus
    And enter second number as "<y>"
    And click equels
    Then validate output
    And close app
     Examples: 
      | x   | y   |
      | 456 | 544 | 
      
      