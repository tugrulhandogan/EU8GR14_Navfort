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





