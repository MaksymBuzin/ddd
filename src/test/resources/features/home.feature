Feature: Home page related scenarios

  @home
  Scenario Outline: Verify home page following links is displayed
    Then Verify "<link>" is displayed
    Examples:
      | link                |
      | PHP Travels         |
      | Mercury tours       |
      | Internet            |
      | E-commerce          |
      | Passion Tea Company |
      | Saucedemo           |
      | Shopping Cart       |

  Scenario Outline: Verify user is navigated to correct page after clicking on the following links
    When User clicks on "<link>"
    And User switches to the next window
    Then Verify title of the page is "<title>"
    Examples:
      | link                | title                                            |
      | PHP Travels         | Demo Script Test drive - PHPTRAVELS              |
      | Mercury tours       | demoaut.com - demoaut Resources and Information. |
      | Internet            | The Internet                                     |
      | E-commerce          | My Store                                         |
      | Passion Tea Company |                                                  |
      | Saucedemo           | Swag Labs                                        |
      | Shopping Cart       | Typescript React Shopping cart                   |

  Scenario: Verify home page header
    Then Verify "Automation with Selenium" header is displayed
    When I go
    And I sit
    Then Verify

     Scenario: Verify home page header
    Then Verify "Automation with Selenium" header is displayed
    When I gooo go
    And I sittt sit
    Then Verifyyy yy

  Scenario: Verify home page header
    Then Verify "Automation with Selenium" header is displayed
    When I gooo
    And I sittt
    Then Verifyyy
