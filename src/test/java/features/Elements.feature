@ElementsFeatures
Feature: DemoQA.com Functional Automation Testing

  Scenario: Using text box feature with credentials
    Given Reach demoqa home page
    When Click Elements to reach elements page
    And Click Textbox to open form
    And Provide credentials
    Then Credentials shown in the same page

  @Checkboxes
  Scenario Outline: Using Check box feature with credentials
    Given Reach demoqa home page
    When Click Elements to reach elements page
    And Click checkbox link to open checkboxes
    And Click plus button to show all checkboxes
    And Select <Checkbox1>, <Checkbox2> and <Checkbox3>
    Then Verify selected checkboxes
    Examples:
      | Checkbox1 | Checkbox2   | Checkbox3   |
      | "<Notes>" | "<Angular>" | "<General>" |