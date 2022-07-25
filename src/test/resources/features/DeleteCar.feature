@PERF-1581
Feature:As a 'Sales Manager' and 'Store Manager', I should be able to delete a car

  @PERF-1615
  Background:
    Given Users on the Fleet-Vehicle page

  @PERF-1614
  Scenario Outline: verify delete button by hovering over the three dot as a <userType>
    When the user as a "<userType>" hovering over the three dot
    Then The user see the  "<expected button>"

    Examples:
      | userType      | expected button |
      | Sales manager | delete button   |
      | Store manager | delete button   |
      | Driver        | delete button   |

  @PERF-1616
  Scenario Outline: "Delete Confirmation" pop up should be displayed
    When the user as a "<userType>" hovering over the three dot
    When the user as a "<userType>" clicks on the delete button
    Then the "<expected delete message>" should be displayed

    Examples:
      | userType      | expected delete message |
      | Sales manager | Delete Confirmation     |
      | Store manager | Delete Confirmation     |

  @PERF-1617
  Scenario:"You do not have permission to perform this action." message should be displayed
  when driver click the delete button
    When Driver hovering over the three dot
    When Driver click the delete button
    Then "You do not have permission to perform this action." message should be displayed





