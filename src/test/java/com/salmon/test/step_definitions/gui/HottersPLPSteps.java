package com.salmon.test.step_definitions.gui;

import com.salmon.test.models.cucumber.PlpSortOptionsModel;
import com.salmon.test.models.cucumber.UserDetailsModel;
import com.salmon.test.page_objects.gui.AddToBasketPage;
import com.salmon.test.page_objects.gui.CreateAccountPage;
import com.salmon.test.page_objects.gui.HotterPLPPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.salmon.test.page_objects.gui.CreateAccountPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class HottersPLPSteps {
    private CreateAccountPage createAccountpage;
    private HotterPLPPage hotterPLPPage;
    private AddToBasketPage addToBasketPage;

    public HottersPLPSteps(CreateAccountPage createAccountpage, HotterPLPPage hotterPLPPage, AddToBasketPage addToBasketPage) {
        this.createAccountpage = createAccountpage;
        this.hotterPLPPage = hotterPLPPage;
        this.addToBasketPage = addToBasketPage;
    }


    @And("^I enter \"([^\"]*)\" in the search field and click on search$")
    public void iEnterInTheSearchFieldAndClickOnSearch(String arg0) throws Throwable {

        hotterPLPPage.enterSearchFieldShoeText();
        hotterPLPPage.clickSearchHomeIcon();

    }


//    @When("^I click on Womens category$")
//    public void iClickOnWomensCategory() throws Throwable {
//          hotterPLPPage.clickOnWomensCategoryLink();
//
//                }

    @And("^user clicks on sort by dropdown$")
    public void userclicksonsortbydropdown() throws Throwable {
        hotterPLPPage.selectTheDropDown();
        System.out.println("checkbox not selected");
        hotterPLPPage.clickOnPriceRangeCheckBox();
        System.out.println("checkbox selected");
        hotterPLPPage.selectTheDropDown();
        Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
        hotterPLPPage.selectTheSecondOption();
        Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
        System.out.println("The second option clicked");
        hotterPLPPage.selectTheThirdOption();
        Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
        hotterPLPPage.selectTheFourthOption();
        Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
        hotterPLPPage.selectTheFifthOption();
        Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
    }

    @Then("^all the sort options are allowed to be selected$")
    public void allTheSortOptionAreAllowedToBeSelected() throws Throwable {
        hotterPLPPage.selectTheSecondOption();
        Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
        //System.out.println("The second option clicked");
        hotterPLPPage.selectTheThirdOption();
        Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
        hotterPLPPage.selectTheFourthOption();
        Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
        hotterPLPPage.selectTheFifthOption();
        Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
    }

    @And("^Scroll down the page to bottom$")
    public void scrollDownThePageToBottom() throws Throwable {


    }

    @Then("^I will be navigated to the Respective footer links page after clicking footer links$")
    public void iWillBeNavigatedToTheRespectiveFooterLinksPageAfterClickingFooterLinks(List<UserDetailsModel>footerLinks) throws Throwable {

        hotterPLPPage.scrollToTheBottom();
        for(UserDetailsModel footerPages: footerLinks) {

            switch (footerPages.getFooterLink()){
                case "Terms & Conditions":
                    hotterPLPPage.clickOnTermsAndConditionsLink();
                    assertThat(hotterPLPPage.termsAndConditionsTitleIsDisplayed());
                    hotterPLPPage.clickOnHottersLogo();
                    break;
                case "Privacy Policy":
                    hotterPLPPage.clickOnPrivacyPolicyLink();
                    assertThat(hotterPLPPage.privacySecurityTitleIsDisplayed());
                    break;
                case "Cookie Policy" :
                    hotterPLPPage.clickOnCookiePolicyLink();
                    assertThat(hotterPLPPage.cookiePolicyTitleIsDisplayed());
                    hotterPLPPage.clickOnHottersLogo();
                    break;
                case "Glossary" :
                    hotterPLPPage.clickOnGlossaryLink();
                    assertThat(hotterPLPPage.glossaryPageTitleIsDisplayed());
                    hotterPLPPage.clickOnHottersLogo();
                    break;
                case "Modern Slavery Statement" :
                    hotterPLPPage.clickOnModernSlaveryStatementLink();
                    assertThat(hotterPLPPage.modernSlaveryTitleIsDisplayed());
                    break;


            }
        }




    }


    @Then("^I should see the page details$")
    public void iShouldSeeThePageDetails() {

    }

    @When("^I click on \"([^\"]*)\" in the main page$")
    public void iClickOnInTheMainPage(String CATEGORIES) throws Throwable {

        hotterPLPPage.clickOnWomensCategoryLink();
        System.out.println("link about to click");
        hotterPLPPage.clickOnMensCategoryLink();
        System.out.println("link about clicked");
        hotterPLPPage.clickOnWideFitCategoryLink();
        hotterPLPPage.clickOnGoreTexCategoryLink();
        hotterPLPPage.clickOnOriginalsLink();
        hotterPLPPage.clicOnOutLetLink();


    }
}



//    @And("^I select the \"([^\"]*)\"$")
//    public void iSelectThe(List<PlpSortOptionsModel> plpSortOptionsModel, String sortOption) throws Throwable {

        // hotterPLPPage.clickOnSortBy(sortOption);
       // hotterPLPPage.selectTheDropDown();

//        for (PlpSortOptionsModel xyz : plpSortOptionsModel) {
//
//            switch (xyz.getSortOption()) {
//                case "Newest In":
//                    Select s = new Select(hotterPLPPage.sortByDropDownOptions());
//                    s.selectByVisibleText("Newest In");
//                    Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
//                case "Name (A-Z)":
//                    Select s1 = new Select(hotterPLPPage.sortByDropDownOptions());
//                    s1.selectByVisibleText("Name (A-Z)");
//                    Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
//                case "Name (Z-A)":
//                    Select s2 = new Select(hotterPLPPage.sortByDropDownOptions());
//                    s2.selectByVisibleText("Name (A-Z)");
//                    Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
//                case "Price (High to Low)":
//                    Select s3 = new Select(hotterPLPPage.sortByDropDownOptions());
//                    s3.selectByVisibleText("Price (High to Low)");
//                    Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
//                case "Price (Low to High)":
//                    Select s4 = new Select(hotterPLPPage.sortByDropDownOptions());
//                    s4.selectByVisibleText("Price (Low to High)");
//                    Assertions.assertThat(hotterPLPPage.searchResultsTextisDisplayed());
//
//            }

            //hotterPLPPage.selectSortOptions(sortOption);




//    @Then("^verify the below options are displayed in Sortby Drop down \"([^\"]*)\"$")
//    public void theBelowOptionsAreDisplayedInSortbyDropDown(String arg0) throws Throwable {
//
//    }


