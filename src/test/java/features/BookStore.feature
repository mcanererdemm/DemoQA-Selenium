
Feature: DemoQA.com Alerts Feature Testing

  @BookStore
  Scenario: Using BookStore features
    Given Reach demoqa home page
    When User click bookStore link
    And Provide z into input bar
    Then Verify item in the table