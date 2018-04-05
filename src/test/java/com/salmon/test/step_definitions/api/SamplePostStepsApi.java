package com.salmon.test.step_definitions.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.salmon.test.framework.helpers.Props;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.Map;

/**
 * Created by ravuris on 04/04/2018.
 */
public class SamplePostStepsApi {

    private SampleWeatherSteps sampleWeatherSteps;

    public SamplePostStepsApi(SampleWeatherSteps sampleWeatherSteps){
        this.sampleWeatherSteps = sampleWeatherSteps;

    }

    private RequestSpecification request;
    private Response response = null;
    private int statusCode;
    private String successCode;

    @Given("^I send a request to demoqa customer register endpoint$")
    public void iSendARequestToDemoqaCustomerRegisterEndpoint(){
        RestAssured.baseURI = Props.getProp("postapi.url");
        request = RestAssured.given();
        System.out.println("the url displayed is " + RestAssured.baseURI);
         }

    @When("^I post the below details$")
    public void iPostTheBelowDetails(Map<String,String> requestParams) throws Throwable {
        request = RestAssured.given().proxy(Props.getProp("WeatherApi.Proxy"),Integer.parseInt(Props.getProp("WeatherApi.Port")));
        JSONObject jsonString = new JSONObject(requestParams);

//        requestParams.put("FirstName", "kumar");
//        requestParams.put("LastName", "dfsfsd");
//        requestParams.put("UserName", "TestUser001");
//        requestParams.put("Password", "password1");
//        requestParams.put("Email", "kumarrav@gmail.com");



        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());
        response = request.post("/register");
        System.out.println("The request body returned is :  " +  response);

    }

    @Then("^I get the success response with success code \"([^\"]*)\"$")
    public void iGetTheSuccessResponseWithSuccessCode(String arg0) throws Throwable {
        statusCode = response.getStatusCode();
        Assert.assertEquals(201, response.getStatusCode());
        successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals("Correct Success Code was returned", successCode,"OPERATION_SUCCESS");



    }


}
