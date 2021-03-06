package com.salmon.test.step_definitions.gui.register;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import com.salmon.test.framework.helpers.Props;
import com.salmon.test.framework.helpers.UrlBuilder;
import com.salmon.test.page_objects.gui.WikipediaPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WikipediaSteps {


    private RequestSpecification request;
    private static String inputData;
    private static final Logger LOG = LoggerFactory.getLogger(WikipediaSteps.class);
    private WikipediaPage wikipediapage;
    public WikipediaSteps(WikipediaPage wikipediapage) {
        this.wikipediapage = wikipediapage;
    }



    @Given("^I navigate to the wikipedia \"([^\"]*)\" page$")
    public void iNavigateToTheWikipediaPage(String pageName) throws Throwable {
        if (pageName.equalsIgnoreCase("HOME")) {
            request = RestAssured.given().proxy(Props.getProp("WeatherApi.Proxy"),Integer.parseInt(Props.getProp("WeatherApi.Port")));
            UrlBuilder.startAtHomePage();

        }
    }



    @And("^I enter valid \"([^\"]*)\" in the input field$")
    public void iEnterValidInTheInputField(String searchTerm) {
        inputData = searchTerm;
        wikipediapage.enterDataInSearchField().sendKeys(searchTerm);
        LOG.debug("Search Term entered");
        System.out.println("Search Term entered");

    }


    @And("^I select \"([^\"]*)\" from the dropdown$")
    public void iSelectFromTheDropdown(String language) {
        wikipediapage.selectTheLanguage(language);

    }


    @When("^I click on search button$")
    public void iClickOnSearchButton() {
        wikipediapage.clickOnSearch();

    }


    @Then("^search results heading matches with input search data$")
    public void searchResultsHeadingMatchesWithInputSearchData() {
        Assertions.assertThat(wikipediapage.isSearchResultDataDisplayed()).isEqualToIgnoringCase(inputData);
    }

    @Then("^the Deutch results page contains English language link$")
    public void theDeutchResultsPageContainsEnglishLanguageLink() {
        Assertions.assertThat(wikipediapage.isEnglishLanglinkDisplayed());
    }


    @And("^I click on English Language link$")
    public void iClickOnEnglishLanguageLink() {
        wikipediapage.clickOnEnglishLanguageLink();
    }

    @Then("^the results displays heading in English language$")
    public void theResultsDisplaysHeadingInEnglishLanguage() {
        Assertions.assertThat(wikipediapage.isTextInEnglishDisplayed());
    }


}