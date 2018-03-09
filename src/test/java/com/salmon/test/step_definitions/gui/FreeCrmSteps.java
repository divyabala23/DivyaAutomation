package com.salmon.test.step_definitions.gui;

import com.salmon.test.page_objects.gui.FreeCrmPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FreeCrmSteps {

    private FreeCrmPage freeCrmpage;

public FreeCrmSteps(FreeCrmPage freeCrmpage){
    this.freeCrmpage = freeCrmpage;

}

    @When("^I click on signUp link from the home page$")
    public void iClickOnSignUpLinkFromTheHomePage()  {


    System.out.println("Link clicked");
       freeCrmpage.clickOnSignUpLink();
    }


    @When("^the user selects free edition from the drop down$")
    public void the_user_selects_free_edition_from_the_drop_down() {

    }

    @When("^the user fills in the registration form with all valid details$")
    public void the_user_fills_in_the_registration_form_with_all_valid_details(DataTable arg1)  {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }

    @When("^the user clicks on submit$")
    public void the_user_clicks_on_submit() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the user successfully registers in the freecrm site$")
    public void the_user_successfully_registers_in_the_freecrm_site() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }



}

