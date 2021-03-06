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

  @Max
  Scenario Outline: Verify Max branch
    Then Verify "<numbers>" is displayed
    Examples:
      | link     |
      | 1   max  |
      | 2   max  |
      | 3   max |



  @Git
  Scenario Outline: Verify Git 
    Then Verify "<numGit>" is displayed
    Examples:
      | numGit     |
      | 1   git  |
      | 2   git  |
      | 3   git |
      
      The most important code line 50
