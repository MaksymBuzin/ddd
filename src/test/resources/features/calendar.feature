@Calendar
Feature: Calendar related scenarios

  Background:
    Given User clicks on "Calendar" link on home page

  Scenario: Verify calendar displays correct today' date
    Then Verify user sees correct date on calendar page

  Scenario: Verify Date picker works correctly
    When User picks "Start date:"
    And  User picks "End date:"
    And User clicks on "Submit" button
    Then Verify message is correct