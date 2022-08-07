@PERF-1648
Feature: Grid settings

  Background: User is on Fleet-Vehicles page clicks on the gear icon
    Given user logged on as "Driver" and clicks "Fleet" module and "Vehicles" tab
    And clicks on the gear icon


  @PERF-1619
  Scenario: Grid Settings should be visible when user clicks on the gear icon
    Then user see Grid Settings panel


  @PERF-1639
  Scenario:
    Then user see Column names in grid settings panel as expected
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |


  @PERF-1640
  Scenario Outline:
    When user typing "<column name>" on Quick Search input box
    Then user see "<column name>" on result
    Examples:
      | column name  |
      | Seats Number |
      | Model Year   |
      | Tags         |


  @PERF-1641
  Scenario Outline:
    When user typing invalid "<column name>" on Quick Search input box
    Then user can't see "<column name>" on result
    Examples:
      | column name   |
      | invalid name  |
      | dasodikmansd  |
      | 168das35asd$$ |

  @PERF-1642
  Scenario Outline: User can select any column by clicking the column name
    When user deselect all the selected items
    And user clicks "<column name>"
    Then user see "<column name>" on result
    Examples:
      | column name  |
      | Seats Number |
      | Model Year   |
      | Tags         |


  @PERF-1644
  Scenario: User drag fifth item to top of the list
    When user drag fifth item to the top
    Then user see the item in first of the list

  @PERF-1645
  Scenario: user drag sixth item to the bottom of the list
    When user drag sixth item to the bottom
    Then user see the item in the last of the list


  @PERF-1646
  Scenario: User can see all corresponding changes under 'Fleet-Vehicles' page
    When user drag fifth item to the top
    And user drag the item to the bottom
    Then user see Location is the first column at Fleet-Vehicles page
    Then user see Location is the last column at Fleet-Vehicles page

  @PERF-1647
  Scenario: search with white space
    When user search "  Location" on Quick Search input box start with two white spaces
    Then Location should be displayed in result











