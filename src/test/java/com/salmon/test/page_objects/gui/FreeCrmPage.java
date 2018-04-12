package com.salmon.test.page_objects.gui;

import com.salmon.test.framework.PageObject;
import com.salmon.test.framework.helpers.Props;
import com.salmon.test.framework.helpers.utils.RandomGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.salmon.test.enums.PermittedCharacters.ALPHABETS;
import static com.salmon.test.framework.helpers.utils.RandomGenerator.dateWithNoLeadingZero;
import static com.salmon.test.framework.helpers.utils.RandomGenerator.random;


public class FreeCrmPage extends PageObject {

    private String firstNameData = random(6, ALPHABETS);
    private String lastNameData = random(6, ALPHABETS);
    private String userNameData = random(6, ALPHABETS);
    private String passwordData = random(6, ALPHABETS);
    private String emailAddressData = RandomGenerator.randomEmailAddress(6);

    private By loginField = By.xpath("//input[@placeholder='Username']");
    private By firstName = By.name("first_name");

    private By signUpLink = By.xpath("//div[@id='navbar-collapse']/ul/li");

    private By editionSelection = By.id("payment_plan_id");

    private By lastName = By.name("surname");

    private By userName = By.name("username");

    private By emailAddress = By.name("email");

    private By confirmEmailAddress = By.name("email_confirm");

    private By passwordField = By.name("password");

    private By confirmPasswordField = By.name("passwordconfirm");

    private By iagreeCheckBox = By.xpath("//input[@type='checkbox'][@name='agreeTerms']");

    private By registrationConfirmationText = By.xpath("//div[@class='text_orange']");

    private By submitButtonRegistrationForm = By.id("submitButton");


    public void enterLoginName(){
        waitForExpectedElement(loginField).sendKeys();
    }

    public void clickOnSignUpLink() throws InterruptedException {

        List<WebElement> element = webDriver.findElements(signUpLink);

        {
            for (WebElement webElement : element) {
                // element.get(1).click();
                if (webElement.getText().equalsIgnoreCase("Sign Up")) {
                    elementToBeClickable(webElement);
                    Thread.sleep(2000);
                    webElement.click();
                    break;
                }
//
//                System.out.println(i);
//             String b = element.get(i).getText();
//                System.out.println("All the elements inside the a tag are: " + b);
//           }
            }


        }


    }

    public void selectEdition() {

        Select s = new Select(getWebDriver().findElement(editionSelection));
        s.selectByIndex(1);

       // waitForExpectedElement(editionSelection).sendKeys("Free Edition");

    }


    public void enterFirstNameData() {

        waitForExpectedElement(firstName).sendKeys(firstNameData);
    }


    public void enterLastNameData() {

        waitForExpectedElement(lastName).sendKeys(lastNameData);
    }


    public void enterEmailAddress() {

        waitForExpectedElement(emailAddress).sendKeys(emailAddressData);
    }

    public void enterconfirmEmailAddress() {

        waitForExpectedElement(confirmEmailAddress).sendKeys(emailAddressData);
    }

    public void enterUserNameData() {

        waitForExpectedElement(userName).sendKeys(userNameData);

    }


    public void enterPasswordData() {

        waitForExpectedElement(passwordField).sendKeys(passwordData);
    }


    public void confirmPasswordData() {
        waitForExpectedElement(confirmPasswordField).sendKeys(passwordData);

    }

    public void clickOnAgreeCheckBox() {
        waitForExpectedElement(iagreeCheckBox).click();

    }


    public void clickOnSubmitButton(){
        ((JavascriptExecutor) webDriver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        waitForExpectedElement(submitButtonRegistrationForm);
    }

    public Boolean formConfirmationMessageisDisplayed(){
             elementToBeVisible(registrationConfirmationText);
             return elementIsDisplayedOrNot(element(registrationConfirmationText));

    }

}







