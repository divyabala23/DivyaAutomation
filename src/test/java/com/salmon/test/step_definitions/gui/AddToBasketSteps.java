package com.salmon.test.step_definitions.gui;

import com.salmon.test.page_objects.gui.AddToBasketPage;
import com.salmon.test.page_objects.gui.CreateAccountPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.testng.Assert;

public class AddToBasketSteps {

    private CreateAccountPage createAccountPage;
    private AddToBasketPage addToBasketPage;

    public AddToBasketSteps(AddToBasketPage addToBasketPage, CreateAccountPage createAccountPage){
        this.addToBasketPage = addToBasketPage;
        this.createAccountPage=createAccountPage;
    }

    @When("^I enter \"([^\"]*)\" and click on search$")
    public void iEnterAndClickOnSearch(String arg0) throws Throwable {

        addToBasketPage.enterSearchFieldText();
        addToBasketPage.clickSearchIcon();
    }

    @And("^I should see the product in the pdp page$")
    public void iShouldSeeTheProductInThePdpPage() throws Throwable {
        Assertions.assertThat(addToBasketPage.checkProductIconisDisplayed());
    }

    @And("^I click on displayed product$")
    public void iClickOnDisplayedProduct() throws Throwable {
        addToBasketPage.clickOnDisplayedProduct();
        Assertions.assertThat(addToBasketPage.checkAddToShoppingBagisDisplayed());
        addToBasketPage.clickOnSizeFour();
    }

//    @And("^I should be navigated to pdp page$")
//    public void iShouldBeNavigatedToPdpPage() throws Throwable {
//      Assertions.assertThat(addToBasketPage.checkAddToShoppingBagisDisplayed());
//
//    }
//
//    @And("^I select the required size$")
//    public void iSelectTheRequiredSize() throws Throwable {
//
//        addToBasketPage.clickOnSizeFour();
//
//    }

    @Then("^I should see the Available Online In-stock displayed$")
    public void iShouldSeeTheAvailbleOnlineInStockDisplayed() throws Throwable {

        Assertions.assertThat(addToBasketPage.checkInStockTextIsDisplayed());
    }

    @And("^I click on add to shopping bag button$")
    public void iClickOnAddToShoppingBagButton() throws Throwable {

       addToBasketPage.clickOnSizeFour();
       addToBasketPage.clickOnAddToShoppingBagButton();

    }

    @Then("^the product should be added to the basket successfully$")
    public void theProductShouldBeAddedToTheBasketSuccessfully() throws Throwable {
        Assertions.assertThat(addToBasketPage.quickViewBasketTotalisDispalyed());
    }

    @When("^I click on checkout button from the quick view basket$")
    public void iClickOnCheckoutButtonFromTheQuickViewBasket() throws Throwable {
           addToBasketPage.clickOnCheckout();

    }

    @And("^the shopping bag page is displayed$")
    public void iShouldBeAbleToViewShoppingBagPage() throws Throwable {

        addToBasketPage.clickOnProceedToCheckout();
        addToBasketPage.selectDeliveryOption();
        addToBasketPage.clickDeliverHereButton();
        addToBasketPage.payByCardRadioButton();

    }


    @And("^I should be able to fill in the payment details$")
    public void iShouldBeAbleToFillInThePaymentDetails() throws Throwable {
          addToBasketPage.enterCardDetails();


    }

    @Then("^the order placed successfully$")
    public void theOrderPlacedSuccessfully() throws Throwable {

        Assertions.assertThat(addToBasketPage.orderConfirmationOrderNumberTextDisplayed());
        //createAccountPage.signOutButtonClick();

    }

    @And("^I should be redirected to PDP page with product label displayed$")
    public void iShouldBeRedirectedToPDPPage() throws Throwable {
        Assertions.assertThat(addToBasketPage.checkProductNameHeadingIsDisplayed());
    }

    @And("^I select the size of the product$")
    public void iSelectTheSizeOfTheProduct() throws Throwable {
      addToBasketPage.clickOnSizeFour();

    }




}
