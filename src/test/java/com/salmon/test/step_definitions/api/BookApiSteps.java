package com.salmon.test.step_definitions.api;


import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.salmon.test.enums.ServiceEndPoints;
import com.salmon.test.framework.helpers.Props;

import com.salmon.test.models.api.Book;
import com.salmon.test.models.api.Books;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class BookApiSteps {
    private RequestSpecification request;
    private Response response = null;
    private JsonPath jsonPathEvaluator;





    @Given("^I request all books api$")
    public void iRequestAllBooksApi() throws Throwable {
        RestAssured.baseURI = Props.getProp("api.url");

    }


    @When("^I request as a jsonpath$")
    public void iRequestAsAJsonpath() {

        request = RestAssured.given().log().all();
        //.proxy(Props.getProp("WeatherApi.Proxy"),Integer.parseInt(Props.getProp("WeatherApi.Port")));
        response = request.get(ServiceEndPoints.GET_ALLBOOKS.getUrl());
        System.out.println("Response Body is =>  " + response.asString());
    }


    @And("^I call using http request as a list$")
    public void i_call_using_http_request() throws Throwable {

        jsonPathEvaluator = response.jsonPath();
        List<String> allbooks = jsonPathEvaluator.getList("books.title");
        for (String book : allbooks) {
            System.out.println("The book titles are : " + book);
        }


    }


    @Then("^Verify the (\\d+) responsecode is returned in the response$")
    public void verifyTheResponsecodeIsReturnedInTheResponse(int statusCode) {
        statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("The code displayed is " + statusCode);

    }


    @And("^I read all the books as a list of string by using model class$")
    public void iReadAllTheBooksAsAListOfStringByUsingModelClass() {
        List<String> expTitleList = new ArrayList<String>();
        expTitleList.add("Learning JavaScript Design Patterns");
        expTitleList.add("Speaking JavaScript");
        expTitleList.add("Programming JavaScript Applications");
        expTitleList.add("Understanding ECMAScript 6");
        expTitleList.add("You Don't Know JS");
        expTitleList.add("Eloquent JavaScript, Second Edition");
        expTitleList.add("Git Pocket Guide");
        expTitleList.add("Designing Evolvable Web APIs with ASP.NET");




        jsonPathEvaluator = response.jsonPath();
        Gson gson = new Gson();
        Books booksList = gson.fromJson(response.asString(), Books.class);
        List<String> actTitleList = new ArrayList<String>();
        for(Book book : booksList.getBooks())
        {
            System.out.println("The book titles are : " + book.getTitle());
            actTitleList.add(book.getTitle());
        }
        assertThat(actTitleList).as("").isEqualToComparingFieldByFieldRecursively(expTitleList);
    }
}



