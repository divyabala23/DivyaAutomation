package com.salmon.test.step_definitions.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
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
    private String Location;
    private String contentType;
    private String serverType;
    private String acceptLanguage;
    private Headers allHeaders;



    @Given("^I requet GetWeatherDetails by location$")
    public void iRequetGetWeatherDetailsByLocation()  {
    RestAssured.baseURI = ENDPOINT_GET_WEATHERREPORT_CITY;
    }


    @When("^I request location by  \"([^\"]*)\"$")
    public void iRequestLocationBy(String city) throws Throwable {
        Location = "city";
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
      for(Header header : allHeaders){
          System.out.println("Key: "   + header.getName() + " Value:"   + header.getValue());
      }


    }
}
