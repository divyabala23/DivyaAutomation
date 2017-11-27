package com.salmon.test.page_objects.gui;

import com.salmon.test.framework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Sample page object class which defines all the elements for a specific page.
 * Every  page object class should extend "PageObject" class
 */


public class SignInOrRegisterPage extends PageObject {

    private By signInOrRegisterTitle = By.cssSelector(".sign_in h1");

    private By loginIdText = By.id("logonId");

    private By passwordText = By.name("logonPassword");

    private By signInButton = By.id("WC_AccountDisplay_links_2");

    private By registerButton = By.id("WC_AccountDisplay_links_3");

    private By errorMessage = By.id("ErrorMessageText");


    public String getSignInOrRegisterTitle() {
        return waitForExpectedElement(signInOrRegisterTitle).getText();
    }

    public WebElement loginIdText() {
        return waitForExpectedElement(loginIdText);
    }

    public WebElement passwordText() {
        return waitForExpectedElement(passwordText);
    }

    public void clickSignInButton() {
        waitForExpectedElement(signInButton).click();
    }

    public void clickRegisterButton() {
        waitForExpectedElement(registerButton).click();
    }

    public String getErrorMessage() {
        return waitForExpectedElement(errorMessage).getText();
    }
}
