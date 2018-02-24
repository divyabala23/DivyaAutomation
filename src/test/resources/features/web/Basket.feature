@demo
Feature: Add to basket button on PDP
  As a customer
  I want to add a product to my basket
  so that I can purchase it

Background:

  Given the user is on the "Home" page
  When I click on My Account link from the header
  And I enter valid login credentials and should be able to login
  When I enter "Marlowe GTX® Boots" and click on search
  And  I should see the product in the pdp page
  And  I click on displayed product

  Scenario:Verify Available Online In stock is present in the pdp page
   And I should be redirected to PDP page with product label displayed
   And I select the size of the product
   Then I should see the Available Online In-stock displayed
   When I click on My Account link from the header
   And  I click on signout to logout of my account


Scenario: Verify the user is able to proceed to checkout page

     And  I click on add to shopping bag button
     Then the product should be added to the basket successfully
     When I click on checkout button from the quick view basket
     And the product should be added to the basket successfully
     And the shopping bag page is displayed
#     And I should be able to fill in the payment details
#     Then the order placed successfully







