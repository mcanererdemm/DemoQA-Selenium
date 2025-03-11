@Interactions
Feature: DemoQA.com Interactions Feature Testing

  Scenario: Using Alert feature with New Tab button
    Given Reach demoqa home page
    When User click Interactions link
    And Click Sortable button
    And Click Grid tab and click and hold six
    Then Verify attribute change in six element