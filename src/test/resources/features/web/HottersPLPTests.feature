@demo
Feature: Hotter plp Tests


  Scenario Outline: Verify the categorylisting pages
    Given the user is on the "Home" page
    When I click on "<CATEGORIES>" in the main page
#    Then I should see the page details

    Examples:
      | CATEGORIES  |
      | WOMEN       |
      | MEN         |
      | WIDEFIT     |
      | GORE-TEX    |
      | ORIGINALS   |
      | ACCESSORIES |
      | OUTLET      |


#  Scenario: Verify the user is able to sort the results
#    Given the user is on the "Home" page
#    When I click on My Account link from the header
#    And I enter valid login credentials and should be able to login
#    When I enter "Marlowe GTX® Boots" and click on search
#    And  I should see the product in the pdp page
#    And  I click on displayed product
#    And  I enter "shoes" in the search field and click on search
#    And user clicks on sort by dropdown
#    Then all the sort options are allowed to be selected





