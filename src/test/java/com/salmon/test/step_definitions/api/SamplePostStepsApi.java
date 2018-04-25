package com.salmon.test.step_definitions.api;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;
import com.salmon.test.enums.ServiceEndPoints;
import com.salmon.test.framework.helpers.Props;
import com.salmon.test.models.api.Books;
import com.salmon.test.models.api.RegistrationSuccessResponse;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by ravuris on 04/04/2018.
 */
public class SamplePostStepsApi {

    private RequestSpecification request;
    private Response response = null;
    private int statusCode;
    private String successCode;
    private  RegistrationSuccessResponse responseBody;
    private Map<String,String> requestParams;

    private static final org.slf4j.Logger LOGGER = getLogger(SamplePostStepsApi.class);

    @Given("^I send a request to demoqa customer register endpoint$")
    public void iSendARequestToDemoqaCustomerRegisterEndpoint(){
        RestAssured.baseURI = Props.getProp("api.url");
        request = RestAssured.given();
        System.out.println("the url displayed is " + RestAssured.baseURI);
         }

    @When("^I post the below details$")
    public void iPostTheBelowDetails(Map<String,String> requestParams) throws Throwable {
     //   request = RestAssured.given();
//        request = RestAssured.given().proxy(Props.getProp("WeatherApi.Proxy"),Integer.parseInt(Props.getProp("WeatherApi.Port")));
//        Gson gson = new Gson();
//        gson.fromJson() = gson.fromJson(response.asString(), Books.class);

        JSONObject jsonString = new JSONObject(requestParams);
        request.header("Content-Type", "application/json");
        request.body(jsonString.toString());
        response = request.post(ServiceEndPoints.POST_CUSTOMER.getUrl());
        System.out.println("The request body returned is :  " +  response);

    }

    @Then("^I get the success response with success code \"([^\"]*)\"$")
    public void iGetTheSuccessResponseWithSuccessCode(String successCode) throws Throwable {
         statusCode = response.getStatusCode();
         System.out.println("The status displayed is :"  + statusCode);
         Assert.assertEquals(statusCode,200);
         successCode = response.jsonPath().get("SuccessCode");
        LOGGER.debug("The code returned is "  + successCode);
        Assert.assertEquals("Correct Success Code was returned", successCode,"OPERATION_SUCCESS");
    }

    @And("^I Deserialise the response body into registration success response model class$")
    public void iDeserialiseTheResponseBodyIntoRegistrationSuccessResponseModelClass() {
       // request.body(requestParams.toString());
        //response = request.post("/register");
        ResponseBody body = response.getBody();
        RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);

    }


    @Then("^verify the response received in the response class$")
    public void verifyTheResponseReceivedInTheResponseClass()  {

         Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
         Assert.assertEquals("Operation completed successfully", responseBody.Message);
    }
}
