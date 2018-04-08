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
import java.util.logging.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by ravuris on 04/04/2018.
 */
public class SamplePostStepsApi {

     private RequestSpecification request;
    private Response response = null;
    private int statusCode;
    private String successCode;

    private static final org.slf4j.Logger LOGGER = getLogger(SamplePostStepsApi.class);

    @Given("^I send a request to demoqa customer register endpoint$")
    public void iSendARequestToDemoqaCustomerRegisterEndpoint(){
        RestAssured.baseURI = Props.getProp("postapi.url");
        request = RestAssured.given();
        System.out.println("the url displayed is " + RestAssured.baseURI);
         }

    @When("^I post the below details$")
    public void iPostTheBelowDetails(Map<String,String> requestParams) throws Throwable {
        request = RestAssured.given();
//        request = RestAssured.given().proxy(Props.getProp("WeatherApi.Proxy"),Integer.parseInt(Props.getProp("WeatherApi.Port")));
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
        int statusCode = response.getStatusCode();
        System.out.println("The status displayed is :"  + statusCode);

     //   Assert.assertEquals(statusCode,"200");

        successCode = response.jsonPath().get("SuccessCode");
        LOGGER.debug("The code returned is "  + successCode);
        Assert.assertEquals("Correct Success Code was returned", successCode,"OPERATION_SUCCESS");



    }


}
