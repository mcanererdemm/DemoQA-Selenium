@Alerts
Feature: DemoQA.com Alerts Feature Testing

  Scenario: Using Alert feature with New Tab button
    Given Reach demoqa home page
    When User click alerts link
    And Click Browser Window Button
    And Click New Tab button
    Then Verify New Tab Message

  Scenario: Using Alert feature with New Window button
    Given Reach demoqa home page
    When User click alerts link
    And Click Browser Window Button
    And Click New Window button
    Then Verify New Window Message

#  @Alerts
#  Scenario: Using Alert feature with New Window button
#    Given Reach demoqa home page
#    When User click alerts link
#    And Click Browser Window Button
#    And Click New Window Message button
#    Then Verify New Window Messages


  Scenario: Using Alert feature with Alerts Page
    Given Reach demoqa home page
    When User click alerts link
    And Click Alerts Button
    And Click First Button and accept
    And Click Second Button and accept
    And Click Third Button and accept
    And Click Fourth Button, provide an input and accept
    Then Verify Alert Messages