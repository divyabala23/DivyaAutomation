package com.salmon.test.step_definitions.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.salmon.test.framework.helpers.Props;
import com.salmon.test.models.api.BookModel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.List;

public class BookApiSteps {
    private RequestSpecification request;
    private Response response = null;
    private JsonPath jsonPathEvaluator;


    @Given("^I request all books api$")
    public void iRequestAllBooksApi() throws Throwable {
        RestAssured.baseURI = Props.getProp("api.url");

    }


    @When("^I request as a jsonpath$")
    public void iRequestAsAJsonpath()  {
        request = RestAssured.given().proxy(Props.getProp("WeatherApi.Proxy"),Integer.parseInt(Props.getProp("WeatherApi.Port")));
        response = request.get("");
        System.out.println("Response Body is =>  " + response.asString());
    }



    @And("^I call using http request as a list$")
    public void i_call_using_http_request() throws Throwable {

        jsonPathEvaluator = response.jsonPath();
        List<String> allbooks = jsonPathEvaluator.getList("books.title");
        for(String book : allbooks)
        {
            System.out.println("The book titles are : " +book);
        }


    }



    @Then("^Verify the (\\d+) responsecode is returned in the response$")
    public void verifyTheResponsecodeIsReturnedInTheResponse(int statusCode)  {
        statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println("The code displayed is "   + statusCode);

    }


    @And("^I read all the books as a list of string by using model class$")
    public void iReadAllTheBooksAsAListOfStringByUsingModelClass()  {

        jsonPathEvaluator = response.jsonPath();
        List<BookModel> allbooks = jsonPathEvaluator.getList("books", BookModel.class);
        for(BookModel book : allbooks)
        {
            System.out.println("The book titles are : " +book);
        }


    }
}

