Feature: DemoQA.com Interactions Feature Testing

  Scenario: Using Alert feature with New Tab button
    Given Reach demoqa home page
    When User click Interactions link
    And Click Sortable button
    And Click Grid tab and click and hold six
    Then Verify attribute change in six element

  @Selectables
  Scenario: Using Alert feature with New Tab button
    Given Reach demoqa home page
    When User click Interactions link
    And Click Selectables button
    And Click Second and Third Items
    Then Verify attribute change in those two items

  @Resizable
  Scenario: Using Alert feature with New Tab button
    Given Reach demoqa home page
    When User click Interactions link
    And Click Resizable button
    And resize first shape
    Then Verify changes in first shape