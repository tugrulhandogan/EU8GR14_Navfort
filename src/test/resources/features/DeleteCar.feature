@PERF-1581  @PREF1615
Feature:As a 'Sales Manager' and 'Store Manager', I should be able to delete a car

  Background: User is on Fleet-Vehicles page
    Given "salesmanager" is logged in to the application and clicks "Fleet" module and "Vehicles" tab

  @PERF-1614
  Scenario: verify delete button by hovering over the three dot
    When the user hovering over the three dot
    Then The user see the Delete button

  @PERF-1616
  Scenario: "Delete Confirmation" pop up should be displayed
    When the user hovering over the three dot
    And the user clicks on the delete button
    Then the delete message should be displayed

  @PERF-1617
  Scenario:"You do not have permission to perform this action." message should be displayed
  when driver click the delete button
    When Driver on the Quick Lanched page
    When Driver click the Fleet option
    And Driver click the Vehicles option
    And the user hovering over the three dot
    And the user clicks on the delete button
    And the user click conform delete button on pop up
    Then You do not have permission to perform this action message should be displayed

  @PERF-1620
  Scenario: user can delete any car and "Item deleted" message should be displayed.
    When the user hovering over the three dot
    And the user clicks on the delete button
    And the user click conform delete button on pop up
    Then the "Item delete" should be displayed


  @PERF-1621
  Scenario:the "car delete message" should be displayed
    When The user clicks on any row on the Vehicle - All Cars page
    And The user is on the General Information page
    And  the user click Delete button
    And user click the confirm delete button on pop up
    Then the Item delete message should be displayed

  @PERF-1622
  Scenario: the corresponding deleted car should be removed from Fleet-Vehicle page
    When The user clicks on any row on the Vehicle - All Cars page
    And The user is on the General Information page
    And  the user click Delete button
    And user click the confirm delete button on pop up
    Then the corresponding deleted car should be removed


  @PERF-1638
  Scenario: User can delete the new created car
    When The user clicks on any row on the Vehicle - All Cars page
    And The user is on the General Information page
    And the user clicks on Create Car button
    And the user enters new Car information
    And the user clicks on save changes button
    And user click the delete button on the created car page
    Then the corresponding deleted car should be removed






