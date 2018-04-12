package com.salmon.test.step_definitions.api;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookApiSteps {
    @Given("^a book exists with an isbn of (\\d+)$")
    public void aBookExistsWithAnIsbnOf(int arg0)  {

    }

    @When("^a user retrieves the book by isbn$")
    public void aUserRetrievesTheBookByIsbn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the status code is (\\d+)$")
    public void theStatusCodeIs(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^response includes the following$")
    public void responseIncludesTheFollowing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^response includes the following in any order$")
    public void responseIncludesTheFollowingInAnyOrder() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
