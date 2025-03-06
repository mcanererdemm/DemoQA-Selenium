@NavigationSuite
Feature: User can navigate through DemoQA website

  Scenario: User navigates to Elements page
    Given User reach home page
    When User click elements link
    Then User navigates to elements page

  Scenario Template: User navigates to Forms page
    Given User reach home page
    When User click forms link "<Forms>"
    Then User navigates to forms page
    Examples:
      | Forms |
      | Forms |

  Scenario: User navigates to Alerts page
    Given User reach home page
    When User click alerts link
    Then User navigates to alerts page

  Scenario: User navigates to Widgets page
    Given User reach home page
    When User click widgets link
    Then User navigates to widgets page

  Scenario: User navigates to Interactions page
    Given User reach home page
    When User click Interactions link
    Then User navigates to Interactions page

  @BookStore
  Scenario: User navigates to BookStore page
    Given User reach home page
    When User click bookStore link
    Then User navigates to bookStore page

  @CertificationPage
  Scenario: User navigates to Certification Training page
    Given User reach home page
    When User click banner link
    Then User navigates to certification page