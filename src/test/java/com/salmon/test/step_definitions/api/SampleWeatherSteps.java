package com.salmon.test.step_definitions.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.*;
import com.jayway.restassured.specification.RequestSpecification;
import com.salmon.test.framework.helpers.Props;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static org.slf4j.LoggerFactory.getLogger;

public class SampleWeatherSteps {

    private RequestSpecification request;
    private Response response = null;
    private ValidatableResponse json;
    private String responseBody;
    private String Location;
    private String contentType;
    private String serverType;
    private String acceptLanguage;
    private Headers allHeaders;
    private ResponseBody body;
    private String bodyAsString;


    private static final Logger LOGGER = getLogger(SampleWeatherSteps.class);


    @Given("^I request GetWeatherDetails by location$")
    public void iRequestGetWeatherDetailsByLocation()  {
    RestAssured.baseURI = Props.getProp("api.url");
    }


    @When("^I request location by  \"([^\"]*)\"$")
    public void iRequestLocationBy(String city) throws Throwable {
       Location = "city";
       request = RestAssured.given();
     //  request = RestAssured.given().proxy(Props.getProp("WeatherApi.Proxy"),Integer.parseInt(Props.getProp("WeatherApi.Port")));
       response = request.get(city);
       //System.out.println("Response Body is =>  " + response.asString());
        LOGGER.info("response: " + response.asString());
    }


    @Then("^Verify the (\\d+) response in the request$")
    public void verifyTheResponseInTheRequest(int statusCode)  {

        json = response.then().statusCode(statusCode);
        Assert.assertEquals(statusCode,response.getStatusCode());
        LOGGER.debug("The status code displayed is : " + response.getStatusCode());
       // System.out.println("The status code displayed is : " + response.getStatusCode());
        }

    @And("^I get response with weather report$")
    public void iGetResponseWithWeatherReport() {

        responseBody = response.getBody().asString();
       // System.out.println("Response Body is => "  + responseBody);
        LOGGER.info("Response Body is => "  + responseBody);
    }

    @Then("^Verify the (\\d+) success response in the request$")
    public void verifyTheSuccessResponseInTheRequest(int statusCode) {

        response = request.get(Location);
        statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode/*actual value*/, 200 /*expected value*/, "correct status code displayed");
        System.out.println(" The response code returned is : " + response.getStatusCode());

    }



    @Then("^Verify the “HTTP (\\d+) OK” response is returned$")
    public void verifyTheHTTPOKResponseIsReturned(String statusLine) {

        statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine/*actual value */,"HTTP/1.1 200 OK" /*expected value*/,  "Correct status code returned");
        System.out.println("The reponse code returned is "  + response.getStatusLine());


    }

    @And("^Verify the content type in the response header$")
    public void verifyTheContentTypeInTheResponseHeader() {

        contentType = response.header("Content-Type");
        System.out.println("Content-Type value : " + contentType);


        serverType = response.header("Server");
        System.out.println("Server value : " + serverType);


        acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);

    }

    @And("^Verify all the headers$")
    public void verifyAllTheHeaders(){

      Headers allHeaders = response.headers();
        // Get all the headers. Return value is of type Headers.
        // Headers class implements Iterable interface, hence we
        // can apply an advance for loop to go through all Headers
        // as shown in the code below
      for(Header header : allHeaders){
          System.out.println("Key: "   + header.getName() + " Value:"   + header.getValue());
      }


    }

    @And("^Verify the reponse body$")
    public void verifyTheReponseBody()  {
        body = response.getBody();
        bodyAsString = body.asString();
        System.out.println("Response Body is converted as string: "  + body.asString());
        Assert.assertEquals(bodyAsString.contains("Delhi") /*Expected value*/, true /*Actual Value*/, "Response body contains Delhi");


    }
}
