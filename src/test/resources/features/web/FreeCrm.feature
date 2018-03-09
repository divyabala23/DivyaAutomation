@demo
Feature: This feature is to practice list and Maps and getting the user name and password from properties file dynamically

  Scenario: Verify the user is able to register in the site using (Model class)
    Given the user is on the "Home" page
    When I click on signUp link from the home page
#    And the user selects free edition from the drop down
#    And  the user fills in the registration form with all valid details
#      | userDetails             |
#      | Kumar                   |
#      | Ravuri                  |
#      | ravurikumar01@gmail.com |
#      | ravurikumar01@gmail.com |
#      | ravuri                  |
#      | Kumar2323!              |
#      | Kumar2323               |
#    When the user clicks on submit
#    Then the user successfully registers in the freecrm site
