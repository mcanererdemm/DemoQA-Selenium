@ElementsFeatures
Feature: DemoQA.com Functional Automation Testing

  Scenario: Using Text box feature with credentials
    Given Reach demoqa home page
    When Click Elements to reach elements page
    And Click Textbox to open form
    And Provide credentials
    Then Credentials shown in the same page

  @Checkboxes
  Scenario Outline: Using Check box feature
    Given Reach demoqa home page
    When Click Elements to reach elements page
    And Click checkbox link to open checkboxes
    And Click plus button to show all checkboxes
    And Select <Checkbox1>, <Checkbox2> and <Checkbox3>
    Then Verify selected checkboxes
    Examples:
      | Checkbox1 | Checkbox2   | Checkbox3   |
      | "<Notes>" | "<Angular>" | "<General>" |

  @RadioButton
  Scenario Outline: Using Radio Button feature
    Given Reach demoqa home page
    When Click Elements to reach elements page
    And Click Radio Button
    And Select a "<Choice>"
    Then Verify Selection
    Examples:
      | Choice         |
      | "<Impressive>" |

  @Wartable
  Scenario: Using War Table feature with credentials
    Given Reach demoqa home page
    When Click Elements to reach elements page
    And Click War Tables
    And Provide personal cridentials and submit
    Then Verify added cridentials

  @Buttons
  Scenario: Using buttons feature
    Given Reach demoqa home page
    When Click Elements to reach elements page
    And Click Buttons link
    And Double Click first button
    And Right Click second button
    And Click third button
    Then Verify button clicks

  @Links
  Scenario: Using links feature
    Given Reach demoqa home page
    When Click Elements to reach elements page
    And Click Links button
    And Click HomeDtej4 link
    Then Verify new tab

  @Links
  Scenario: Using links feature
    Given Reach demoqa home page
    When Click Elements to reach elements page
    And Click Links button
    And Click Not Found link
    Then Verify "Link has responded with staus 404 and status text Not Found" message