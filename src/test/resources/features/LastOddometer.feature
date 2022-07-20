Feature: As a user, I should be able to use "Last Odometer" filter under 'Fleet-Vehicles' page

  Scenario Outline: User can select "Last Odometer" filter under 'Fleet-Vehicles' page
    Given "<User>" is logged in to the application and is on the Fleet-Vehicles page
    When User clicks on "Manage filter options" filter button
    Then user should be able to click the "Last Odometer" filter

    Examples:
      | User         |
      | Driver       |
      | SalesManager |
      | StoreManager |