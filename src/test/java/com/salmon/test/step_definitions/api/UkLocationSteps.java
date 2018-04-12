package com.salmon.test.step_definitions.api;

import com.salmon.test.services.UkLocationApi;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.assertj.core.api.Assertions;
import org.testng.Assert;

/**
 * Created by ravuris on 04/04/2018.
 */
public class UkLocationSteps {
    private HttpResponse response;
    String body;

    @Given("^I have UK location service available$")
    public void iHaveUKLocationServiceAvailable() throws Throwable {

    }

    @When("^I request GetUKLocationByCounty by \"([^\"]*)\"$")
    public void i_request_GetUKLocationByCounty_by_county(String county) throws Throwable {
        response = UkLocationApi.getUKLocationByCounty(county);
        ResponseHandler<String> handler = new BasicResponseHandler();
        body = handler.handleResponse(response);

    }

    @Then("^verify  the status code (\\d+) is returned$")
    public void verifyTheStatusCodeIsReturned(int arg0) throws Throwable {

        Assertions.assertThat(response.getStatusLine().getStatusCode()).isEqualTo(200);
        Assert.assertTrue(response.getHeaders("Content-Type")[0].getValue().contains("text/xml"));

    }

    @And("^verify that \"([^\"]*)\" is returned in the response$")
    public void verifyThatTownIsReturnedInTheResponse(String town) throws Throwable {
        Assert.assertTrue(body.contains(town));


    }
}
