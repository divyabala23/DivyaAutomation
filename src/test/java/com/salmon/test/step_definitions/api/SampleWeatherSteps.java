package com.salmon.test.step_definitions.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import com.salmon.test.services.SampleWeatherApi;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.salmon.test.services.SampleWeatherApi;
import org.apache.http.HttpRequest;
import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;

public class SampleWeatherSteps {

    private RequestSpecification request;
    private Response response = null;
    private String ENDPOINT_GET_WEATHERREPORT_CITY = "http://restapi.demoqa.com/utilities/weather/city";
    private ValidatableResponse json;
    private String responseBody;


    @Given("^I requet GetWeatherDetails by location$")
    public void iRequetGetWeatherDetailsByLocation()  {
    RestAssured.baseURI = ENDPOINT_GET_WEATHERREPORT_CITY;
    }


    @When("^I request location by  \"([^\"]*)\"$")
    public void iRequestLocationBy(String city) throws Throwable {
       request = RestAssured.given();
       response = request.get(city);

       System.out.println("Response Body is =>  " + response.asString());
        //System.out.println("response: " + response.prettyPrint());
    }


    @Then("^Verify the (\\d+) response in the request$")
    public void verifyTheResponseInTheRequest(int statusCode)  {

        json = response.then().statusCode(statusCode);
        Assert.assertEquals(statusCode,response.getStatusCode());
        System.out.println("The status code displayed is : " + response.getStatusCode());
        }

    @And("^I get response with weather report$")
    public void iGetResponseWithWeatherReport() {

        responseBody = response.getBody().asString();
        System.out.println("Response Body is => "  + responseBody);


    }
}
