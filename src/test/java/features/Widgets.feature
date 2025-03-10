Feature: DemoQA.com Widgets Feature Testing

  Scenario: Using Widgets feature with Accordian button
    Given Reach demoqa home page
    When User click widgets link
    And Click First Accordian button and verify
    And Click Second Accordian button and verify
    Then Click Third Accordian button

  Scenario: Using Widgets feature with Auto Complete
    Given Reach demoqa home page
    When User click widgets link
    And Click Auto Complete button
    And Provide color prefix i.e: bl and select blue
    And Provide color prefix i.e: wh and select white
    Then Verify selected color names

  Scenario: Using Widgets feature with Auto Complete
    Given Reach demoqa home page
    When User click widgets link
    And Click Auto Complete button
    And Provide single color prefix i.e: ye and select Yellow
    And Provide single color prefix i.e: gre and select Green
    Then Verify last selected color names

  Scenario: Using Widgets feature with Date Picker
    Given Reach demoqa home page
    When User click widgets link
    And Click Datepicker button
    And Click Datepicker text
    Then Verify selected date

  Scenario: Using Widgets feature with Date and Time Picker
    Given Reach demoqa home page
    When User click widgets link
    And Click Datepicker button
    And Click Date and Time picker text
    Then Verify selected date and time

  Scenario: Using Widgets feature with Slider
    Given Reach demoqa home page
    When User click widgets link
    And Click Slider button
    And Provide slider value
    Then Verify slider value


  Scenario: Using Widgets feature with Progress Bar
    Given Reach demoqa home page
    When User click widgets link
    And Click Progress Bar button
    And Click Start button
    And Click Stop button at 53 percent
    Then Verify progress bar percentage

  @Widgets
  Scenario: Using Widgets feature with Progress Bar
    Given Reach demoqa home page
    When User click widgets link
    And Click Tabs button
    And Click Demo tab
    Then Verify demo tab paragraph

  @ToolTips
  Scenario: Using Widgets feature with Tool Tips
    Given Reach demoqa home page
    When User click widgets link
    And Click Tool Tips button
    And Hover over first button and verify text
    And Hover over input and verify text
    And Hover over date and verify text