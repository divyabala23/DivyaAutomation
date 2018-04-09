Feature: F1 racing

  Scenario: verify the list of circuits are retrieved for the 2017 formula 1 season

    Given a user is on ergast site
    When the user calls get api request
    Then 2017 formula 1 season with 20 circuits are returned in the list

