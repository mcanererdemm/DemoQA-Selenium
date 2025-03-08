@Widgets
Feature: DemoQA.com Widgets Feature Testing

  Scenario: Using Widgets feature with Accordian button
    Given Reach demoqa home page
    When User click widgets link
    And Click First Accordian button and verify
    And Click Second Accordian button and verify
    Then Click Third Accordian button
