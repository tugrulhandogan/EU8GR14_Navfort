@PERF-1581
Feature:As a 'Sales Manager' and 'Store Manager', I should be able to delete a car

@PREF-1615
  Background: User is on Fleet-Vehicles page
    Given "salesmanager" is logged in to the application and clicks "Fleet" module and "Vehicles" tab


  @PERF-1614
  Scenario : verify delete button by hovering over the three dot
    When the user hovering over the three dot
    Then The user see the Delete button


  @PERF-1616
  Scenario : "Delete Confirmation" pop up should be displayed
    When the user hovering over the three dot
    And the user clicks on the delete button
    Then the "expected delete message" should be displayed


  @PERF-1617
  Scenario:"You do not have permission to perform this action." message should be displayed
  when driver click the delete button
    When Driver hovering over the three dot
    And Driver click the delete button
    Then "You do not have permission to perform this action." message should be displayed

@PERF-1620
Scenario : user can delete any car and "Item deleted" message should be displayed.
  When the user hovering over the three dot
  And the user clicks on the delete button
  And click the confirm button on the pop up
  Then the "item delete message" should be displayed


@PERF-1621
  Scenario :
  When the user go to'General Information'
  And  the user click 'Delete' button
  Then   the "car delete message" should be displayed

@PERF-1622
  Scenario : the corresponding deleted car should be removed from Fleet-Vehicle page
    When the user go to'General Information'
    And  the user click 'Delete' button
    Then the corresponding deleted car should be removed






