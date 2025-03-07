@FormsFeatures
Feature: Testing Functionality of Forms Page

  Scenario: Using Forms feature with credentials
    Given Reach demoqa home page
    When User click forms link "<Forms>"
    And Click Practice Form
    And Provide Student credentials
    Then Verify Credentials