#@demo
Feature: Hotter plp Tests


  Scenario: Verify the user is able to sort the results
    Given the user is on the "Home" page
    When I click on My Account link from the header
    And I enter valid login credentials
    When I enter "Marlowe GTX® Boots" and click on search
    And  I should see the product in the pdp page
    And  I click on displayed product
    And  I enter "shoes" in the search field and click on search
    And user clicks on sort by dropdown
    Then all the sort options are allowed to be selected





