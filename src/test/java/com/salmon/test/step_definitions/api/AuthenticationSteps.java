package com.salmon.test.step_definitions.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.salmon.test.framework.helpers.Props;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by ravuris on 19/04/2018.
 */



public class AuthenticationSteps {

    private RequestSpecification request;
    private Response response = null;


    @Given("^I navigate to restapi demoqa site$")
    public void i_navigate_to_restapi_demoqa_site()  {
        RestAssured.baseURI = Props.getProp("api.url");
        request = given().proxy(Props.getProp("WeatherApi.Proxy"),Integer.parseInt(Props.getProp("WeatherApi.Port")));
                  //given().auth().preemptive().basic("Props.Username", "Props.Password");


    }

    @When("^I request the check for authentication URI$")
    public void request_the_check_for_authentication_URI() {
        response = RestAssured.get();


    }

    @Then("^I get the success status code$")
    public void i_get_the_status_code()  {

        System.out.println("status code: "   +response.getStatusCode());
        System.out.println("Status message:"   +response.body().asString());

    }

    @Then("^I get the authorization error$")
    public void i_get_the_authorization_error()  {

    }

    @And("^I enter username and password$")
    public void iEnterUsernameAndPassword()  {
       given().proxy(Props.getProp("WeatherApi.Proxy"),Integer.parseInt(Props.getProp("WeatherApi.Port")));
               //.auth().preemptive().basic("Props.Username", "Props.Password");

    }

    @Then("^I get success message$")
    public void iGetSuccessMessage()  {

    }
}
