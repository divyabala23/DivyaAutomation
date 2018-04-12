package com.salmon.test.page_objects.gui;

import com.salmon.test.framework.PageObject;
import com.salmon.test.models.cucumber.MercuryLoginUserModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.validation.constraints.AssertTrue;

public class MercuryToursRegistrationPage extends PageObject {

    private By registerButton = By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a");
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By phoneNumberField = By.name("phone");
    private By emailTextField = By.id("userName");
    private By address1 =  By.name("address1");
    private By cityTextField = By.name("city");
    private By stateTextField = By.name("state");
    private By postalCodeTextField = By.name("postalCode");
    private By countrySelectField = By.name("country");
    private By userNameTextField = By.name("email");
    private By passwordTextField = By.name("password");
    private By confirmPasswordTextField = By.name("confirmPassword");
    private By submitButton = By.name("register");
    private By registrationConfirmationMessage = By.cssSelector(".footer");
    private By loginButton = By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a");
    private By userNameFieldSignOn = By.name("userName");
    private By passwordFieldSignOn = By.name("password");
    private By submitButtonSignon = By.cssSelector("input[alt='Login'][value='Login'][type='image']");
    private By flightFinderPageImage = By.cssSelector("tbody tr td img[src='/images/masts/mast_flightfinder.gif']");




    public WebElement userNameFieldInLoginPage(){
        return waitForExpectedElement(userNameFieldSignOn);

    }

    public WebElement passwordFieldLoginPage(){
        return waitForExpectedElement(passwordFieldSignOn);
    }

    public WebElement firstNameTextField(){
        return  waitForExpectedElement(firstNameField);
    }


    public WebElement lastNameTextField(){
        return waitForExpectedElement(lastNameField);

    }


    public WebElement phoneNumberField(){
        return waitForExpectedElement(phoneNumberField);

    }

    public WebElement emailTextField(){
        return  waitForExpectedElement(emailTextField);
    }


    public WebElement address1TextField(){
        return waitForExpectedElement(address1);
    }

    public WebElement cityTextField(){
        return waitForExpectedElement(cityTextField);

    }

    public WebElement stateTextField(){
        return waitForExpectedElement(stateTextField);
    }



    public WebElement postalCodeTextField(){
        return waitForExpectedElement(postalCodeTextField);
    }


    public WebElement countrySelectField(){
        return waitForExpectedElement(countrySelectField);
    }


    public WebElement userNameTextField(){
        return waitForExpectedElement(userNameTextField);
    }


    public WebElement passwordTextField(){
        return waitForExpectedElement(passwordTextField);

    }


    public WebElement confirmPasswordTextField(){
        return waitForExpectedElement(confirmPasswordTextField);
    }




    public void enterLoginCredentials(MercuryLoginUserModel logindetails){
        waitClearEnterText(userNameFieldSignOn,logindetails.getUsername());
        waitClearEnterText(passwordFieldSignOn,logindetails.getPassword());
    }




    public void clickOnRegisterButton(){
        waitForExpectedElement(registerButton).click();
    }


    public void clickOnSignOnButton(){
        waitForExpectedElement(loginButton).click();
    }



    public void enterRegistrationFormDetails(){

        firstNameTextField().sendKeys("ddsfsdfdsf");
        lastNameTextField().sendKeys("dfsfdsfsd");
        phoneNumberField().sendKeys("4543543543");
        emailTextField().sendKeys("test@testkumar.com");
        address1TextField().sendKeys("18Maidavale");
        cityTextField().sendKeys("MiltonKeynes");
        stateTextField().sendKeys("London");
        postalCodeTextField().sendKeys("MK109RF");
        countrySelectField().sendKeys("UNITED KINGDOM");
        userNameTextField().sendKeys("testrav");
        passwordTextField().sendKeys("London2323");
        confirmPasswordTextField().sendKeys("London2323");

    }


    public void clickOnSubmitSignOnPage(){
        waitForExpectedElement(submitButtonSignon).click();
    }


    public  void clickOnSubmitButton(){
        waitForExpectedElement(submitButton).click();

    }

    public boolean isFirstNameFieldDisplayed(){
        return   waitForExpectedElement(firstNameField).isDisplayed();
    }


    public boolean isFooterLinkDisplayed(){
        return waitForExpectedElement(registrationConfirmationMessage).isDisplayed();
    }


    public boolean isLastNameFieldDisplayed(){
        return waitForExpectedElement(lastNameField).isDisplayed();
    }


    public  boolean isPhoneNumberFieldDisplayed(){
        return waitForExpectedElement(phoneNumberField).isDisplayed();
    }


    public boolean isEmailTextFieldDisplayed(){
        return waitForExpectedElement(emailTextField).isDisplayed();
    }


    public boolean isAddressTextFieldDisplayed(){
        return waitForExpectedElement(address1).isDisplayed();
    }


    public boolean isCityTextFieldDisplayed(){
        return waitForExpectedElement(cityTextField).isDisplayed();
    }

    public  boolean isStateTextFieldDisplayed(){
        return waitForExpectedElement(stateTextField).isDisplayed();
    }


    public boolean isPostalCodeTextFieldDisplayed(){
        return waitForExpectedElement(postalCodeTextField).isDisplayed();
    }

    public boolean isCountrySelectFieldDisplayed(){
        return  waitForExpectedElement(countrySelectField).isDisplayed();
    }


    public boolean isUserNameFieldDisplayed(){
        return waitForExpectedElement(userNameTextField).isDisplayed();
    }


    public boolean isPasswordTextFieldDisplayed(){
        return waitForExpectedElement(passwordTextField).isDisplayed();
    }

    public boolean isConfirmPasswordTextDisplayed(){
        return  waitForExpectedElement(confirmPasswordTextField).isDisplayed();
    }


    public boolean isFlightFinderImageDisplayed(){
        return waitForExpectedElement(flightFinderPageImage).isDisplayed();
    }



    public void getTitle(){
        getWebDriver().getTitle();
        if(getWebDriver().getTitle().contains("mercury")){
            System.out.println("testpass");
        }
    }


}



