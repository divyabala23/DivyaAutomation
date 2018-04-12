package com.salmon.test.page_objects.gui;

import com.salmon.test.framework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AddToBasketPage extends PageObject {

   // private String SearchData = "shoes";
    private String SearchData = "Marlowe GTX® Boots";
    // use the below query to update the qty on above product
    // update receipt set QTYONHAND = 10010000 where VERSIONSPC_ID = 260716

    private By searchTextField = By.cssSelector("#SimpleSearchForm_SearchTerm");
    private By searchIcon = By.cssSelector("#search_submit");
    private By productImageIcon = By.cssSelector("img.roundel.b-lazy.loaded");
    private By addToShoppingBag = By.cssSelector("a.button_add_to_cart > div.button_text");
    private By sizeNumber4 = By.id("swatch_entitledItem_268401_5");
    private By inStockText = By.cssSelector("#InventoryStatus_OnlineStatus_268401");
    private By quickViewTotal = By.cssSelector("#minishopcart_total");
    private By checkOutButton = By.cssSelector("#miniShopCartBody > div.info > div.goToCheckout > a > div");
    private By proceedToCheckOutButton = By.cssSelector("#shopcartCheckout.button_primary .button_text");
    private By selectDelivery = By.cssSelector("#shipping_method_content > div:nth-child(1) > p.shipping_method_item_title > label");
    private By deliverHere = By.cssSelector("#selectAdddressLink > div.button_text");
    private By payByCard = By.cssSelector("#byCard");
    private By selectCardType = By.cssSelector("#payMethodId_1");
    private By cardNumberTextField = By.cssSelector("#account1_1");
    private By selectExpiresMonth = By.cssSelector("#expire_month_1");
    private By selectExpiresYear = By.cssSelector("#expire_year_1");
    private By nameOnCardTextField = By.cssSelector("#card_name_1");
    private By cvcNumberTextField = By.cssSelector("#cc_cvc_1");
    private By placeOrderButton = By.cssSelector("#confirmButton");
    private By orderNumberTextConfirmation = By.cssSelector("p.orderNumber > span.strong");
    private By productNameHeader = By.cssSelector("h1.main_header");

    public void enterSearchFieldText() {
        waitForExpectedElement(searchTextField);
        elementToBeClickable(searchTextField).sendKeys(SearchData);
    }


    public void clickSearchIcon() {
        waitForExpectedElement(searchIcon).click();
    }


    public Boolean checkProductIconisDisplayed() {

        waitForExpectedElement(productImageIcon);
        return elementIsDisplayedOrNot(element(productImageIcon));
    }


    public Boolean checkAddToShoppingBagisDisplayed() {
        ((JavascriptExecutor) webDriver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        waitForExpectedElement(addToShoppingBag);
        return elementIsDisplayedOrNot(element(addToShoppingBag));
    }


    public void clickOnDisplayedProduct() {
        elementToBeClickable(productImageIcon).click();

    }


    public void clickOnSizeFour() {

        waitForExpectedElement(sizeNumber4);
        elementToBeClickable(sizeNumber4).click();
    }

    public Boolean checkInStockTextIsDisplayed() {
        waitForExpectedElement(inStockText);
        return elementIsDisplayedOrNot(element(inStockText));

    }


//    public Boolean checkSizeOfTheProductIsDisplayed(){
//
//        waitForExpectedElement(sizeNumber4);
//        return elementIsDisplayedOrNot(element(sizeNumber4));
//    }


    public Boolean checkProductNameHeadingIsDisplayed(){
        waitForExpectedElement(productNameHeader);
        return elementIsDisplayedOrNot(element(productNameHeader));
    }

    public void clickOnAddToShoppingBagButton() {
        elementToBeClickable(addToShoppingBag);
        waitForExpectedElement(addToShoppingBag).click();

    }

    public Boolean quickViewBasketTotalisDispalyed() {

        waitForExpectedElement(quickViewTotal);
        return elementIsDisplayedOrNot(element(quickViewTotal));
    }



    public void clickOnCheckout() {
      waitForExpectedElement(checkOutButton);
        elementToBeClickable(checkOutButton).click();


    }

    public void selectDeliveryOption(){
        waitForExpectedElement(selectDelivery).click();
    }



    public void clickDeliverHereButton(){
        waitForExpectedElement(deliverHere);
       elementToBeClickable(deliverHere).click();
    }

    public void clickOnProceedToCheckout() {

        webDriver.manage().window().maximize();
        WebElement element = webDriver.findElement(proceedToCheckOutButton);
        ((JavascriptExecutor)webDriver).executeScript("scroll(0,1200)");
        waitForExpectedElement(proceedToCheckOutButton);
        element.click();





    }


    public void payByCardRadioButton(){
        waitForExpectedElement(payByCard);
        elementToBeClickable(payByCard).click();
    }



    public void enterCardDetails(){
        waitForExpectedElement(selectCardType).sendKeys("Visa Debit Card");
        waitForExpectedElement(cardNumberTextField).sendKeys("4444333322221111");
        waitForExpectedElement(selectExpiresMonth).sendKeys("12");
        waitForExpectedElement(selectExpiresYear).sendKeys("21");
        waitForExpectedElement(nameOnCardTextField).sendKeys("sadasdsadas");
        waitForExpectedElement(cvcNumberTextField).sendKeys("000");
        waitForExpectedElement(placeOrderButton).click();


    }


     public Boolean orderConfirmationOrderNumberTextDisplayed(){
        waitForExpectedElement(orderNumberTextConfirmation);
        return elementIsDisplayedOrNot(element(orderNumberTextConfirmation));
    }

}





