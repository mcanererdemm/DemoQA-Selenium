Feature: DemoQA.com Functional Automation Testing
  Scenario: Using text box feature with credentials
    Given Reach demoqa home page
    When Click Elements to reach elements page
    And Click Textbox to open form
    And Provide credentials
    Then Credentials shown in the same page