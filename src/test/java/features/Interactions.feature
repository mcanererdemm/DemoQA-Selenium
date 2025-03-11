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

  Scenario: Using Alert feature with New Tab button
    Given Reach demoqa home page
    When User click Interactions link
    And Click Droppable button
    And Drag item at simple tab
    Then Verify changes Dropped at Simple tab

  @Droppable
  Scenario: Using Alert feature with New Tab button
    Given Reach demoqa home page
    When User click Interactions link
    And Click Droppable button
    And Click Accept tab
    And Drag acceptable item into drop here
    And Drag not acceptable item into drop here
    Then Verify changes Dropped at Accept tab

  @Dragabble
  Scenario: Using Alert feature with New Tab button
    Given Reach demoqa home page
    When User click Interactions link
    And Click Dragabble button
    And Click Axis Restricted tab
    And Drag Only X item
    And Drag Only Y item
    Then Verify changes at dragabbles