@PERF-1588 @PERF-1591
Feature: As a user, I should be able to use "Last Odometer" filter under 'Fleet-Vehicles' page

  Background: User is on Fleet-Vehicles page and clicks 'Manage filter option'
    Given "Driver" is logged in to the application and clicks "Fleet" module and "Vehicles" tab
    And User clicks on Manage filter options filter button

  @PERF-1590
  Scenario: User can select "Last Odometer" filter under 'Fleet-Vehicles' page
    Then user should be able to click the "Last Odometer" filter

  @PERF-1592
  Scenario: "Last Odometer" filter should provide the methods shown as below
    When User clicks on Last Odometer filter checkbox
    And User clicks on the Last Odometer button
    Then User should be able to see the Last Odometer filter options as below list

      | Between             |
      | Not Between         |
      | Equals              |
      | Not Equals          |
      | More Than           |
      | Less Than           |
      | Equals Or More Than |
      | Equals Or Less Than |
      | Is Empty            |
      | Is Not Empty        |

  @PERF-1593
  Scenario: User selects "Between" method with numeric values, the results should be between the specified values
    When User clicks on Last Odometer filter checkbox
    And User clicks on the Last Odometer button
    And User selects "Between" method
    And User enters 10000 and 20000 in the filter fields
    Then User should be able to see the vehicles with last odometer between 10000 and 20000

  @PERF-1594
  Scenario: User selects "Equals" method with numeric values, the results should be between the specified values
    When User clicks on Last Odometer filter checkbox
    And User clicks on the Last Odometer button
    And User selects "Equals" method
    And User enters 10000 in the filter field
    Then User should be able to see the vehicles with last odometer equal to 10000

  @PERF-1595
  Scenario: When user selects "More than" method with numeric values, the results should be more than the specified value
    When User clicks on Last Odometer filter checkbox
    And User clicks on the Last Odometer button
    And User selects "More Than" method
    And User enters 25000 in the filter field
    Then User should be able to see the vehicles with last odometer more than 25000

  @PERF-1596
    Scenario: When user selects "Less than" method with numeric values, the results should be less than the specified value
      When User clicks on Last Odometer filter checkbox
      And User clicks on the Last Odometer button
      And User selects "Less Than" method
      And User enters 25000 in the filter field
      Then User should be able to see the vehicles with last odometer less than 25000

    @PERF-1597
    Scenario: When user selects "Is Empty" method, only empty values should be displayed.
      When User clicks on Last Odometer filter checkbox
      And User clicks on the Last Odometer button
      And User selects "Is Empty" method
      Then User should be able to see the vehicles with last odometer is empty









