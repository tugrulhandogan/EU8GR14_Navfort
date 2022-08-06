
  Feature: Filter Menu
  User Story:
  As a user, I should be able to use FILTER option under Fleet-Vehicle page

  Background: For the scenarios in this feature file, the user is expected to be logged in as a Driver,
  Store Manager or Sales Manager
    Given The user is on the Fleet Vehicles page

    #passed
   Scenario: Manage Filter button visibility
    When user clicks on filter icon
    Then Manage Filter button should be visible

    #passed
   Scenario: Users can apply filters from 'Manage Filters' menu
     When user clicks on filter button
     And user clicks on Manage Filters menu
     Then user can apply any of the filters

      #passed
    Scenario: User can apply filters by typing the filter name, from 'Manage Filters' menu
      When the user clicks on filter menu icon
      And the user clicks on manage filters icon
      And user types a filter name
      Then user should be able to select that filter

      @wip
      Scenario: User can apply multiple filters at the same time
        When user clicks on filter menu icon
        And user clicks on manage filters menu icon
        Then user can select and apply multiple filters at the same time






      Scenario: User can remove all filters by clicking on the reset icon, under 'Fleet-Vehicles' page









