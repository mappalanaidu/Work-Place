Feature: Way2SMS Login

  @smoketest
  Scenario: validate site launching
    Given Launch site using "chrome"
    Then title contains "Free SMS"
    And close site

  Scenario Outline: validate login operation
    Given Launch site using "chrome"
    When enter mobile number as "<x>"
    And enter password as "<y>"
    And click login
    Then validate output for criteria "<z>"

    Examples: 
      | x          | y         | z            |
      | 9948838954 | bhagya530 | all_vlid     |
      | 9948838955 | bhagya530 | mbno_invalid |
      |            | bhagya530 | mbno_blank   |
      | 9948838954 |           | pwd_blank    |
      | 9948838954 | bhagya539 | pwd_invalid  |
