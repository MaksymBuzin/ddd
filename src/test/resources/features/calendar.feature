@Calendar
Feature: Calendar related scenarios

  Background:
    Given User clicks on "Calendar" link on home page

  Scenario: Verify calendar displays correct today' date
    Then Verify user sees correct date on calendar page

  Scenario: Verify start date drop down calendar is present
    When User clicks "Start date:" option
    Then Verify drop down calendar is present

  Scenario: Verify end date drop down calendar is present
    And  User clicks "End date:" option
    Then Verify drop down calendar is present

  Scenario: Verify submit button is enabled
    Then Verify "Submit" button is displayed

  Scenario: Verify Date picker works correctly
    When User picks Start date and End date
    And User clicks on "Submit" button
    Then Verify message is correct

