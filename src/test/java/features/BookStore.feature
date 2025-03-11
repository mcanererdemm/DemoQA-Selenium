Feature: DemoQA.com Alerts Feature Testing

  @BookStore
  Scenario: Using BookStore features
    Given Reach demoqa home page
    When User click bookStore link
    And Provide z into input bar
    Then Verify item in the table

  @Login
  Scenario: Using BookStore features
    Given Reach demoqa home page
    When User click bookStore link
    And User click Login Button
    And User provide credentials and click login
    Then Verify user is logged in

  @NewUser
  Scenario: Using BookStore features
    Given Reach demoqa home page
    When User click bookStore link
    And User click Login Button
    And User click new user button
    And User provide credentials and click register
    Then Verify user is registered