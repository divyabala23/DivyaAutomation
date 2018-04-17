package com.salmon.test.page_objects.gui;
import com.salmon.test.framework.helpers.utils.RandomGenerator;
import com.salmon.test.models.cucumber.DeliveryAddressModel;
import org.openqa.selenium.*;
import com.salmon.test.framework.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.salmon.test.models.cucumber.UserDetailsModel;
import com.salmon.test.framework.helpers.Props;

import java.security.Key;
import java.util.List;

import static com.salmon.test.enums.PermittedCharacters.ALPHABETS;
import static com.salmon.test.framework.helpers.utils.RandomGenerator.random;
import static org.testng.AssertJUnit.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateAccountPage extends PageObject {


    private String titleData = "Dr";
    private String firstNameData = random(6, ALPHABETS);
    private String lastNameData = random(6, ALPHABETS);
    private String addressNameData= random(6,ALPHABETS);
    private String emailAddressData = RandomGenerator.randomEmailAddress(6);
    private String phoneNumberData = "00447932689587";
    private String passwordData = "Testing12345£";
    private String verifyPasswordData = "Testing12345£";
    private String dateOfBirthDateData = "23";
    private String monthData = "December";
    private String yearData = "1985";
    private String addressFinderData = "wd171da";
    private String loginEmailData =  "sravuri@salmon.com"; // "marcintest14@gmail.com";
    private String loginPasswodData = "London2323"; // "Pa55word14";


    private By myAccountLink = By.linkText("My Account");

    //private By myAccountLink = By.cssSelector("#ems_country_11253 > div:nth-child(6) > div:nth-child(1) > a");
    private By registerButton = By.xpath("//*[@id='WC_AccountDisplay_links_3']");
    private By titleList = By.name("personTitle");
    private By firstNameField = By.cssSelector("input[type='text'][name='firstName']");
    private By lastNameField = By.cssSelector("input[type='text'][name='lastName']");
    private By phoneNumberField = By.cssSelector("input[type='tel'][name='phone1']");
    private By emailAddressField = By.cssSelector("input[type='email'][name='logonId']");
    private By passwordField = By.cssSelector("input[type='password'][name='logonPassword']");
    private By verifyPasswordField = By.cssSelector("input[type='password'][name='logonPasswordVerify']");
    private By dateOfBirthDateField = By.name("dayOfBirth");
    private By monthField = By.name("monthOfBirth");
    private By yearField = By.name("yearOfBirth");
    private By addressSuggestions = By.cssSelector(".pnlResults .pcaContent div");
    private By submitButton = By.cssSelector("#WC_UserRegistrationAddForm_links_1 .button_text");
    private By addressField = By.cssSelector(".inputArea input");
    //private By enterAddressManuallyLink = By.partialLinkText("enter address manually");
    private By enterAddressManuallyLink = By.cssSelector("#HAddressFinderAlternate");
    private By addressSuggestField = By.cssSelector("input.search");
    private By addressContainer = By.cssSelector("div.pnlResults > div.pcaContent");

    private By addressLine1Field = By.cssSelector("input[type='text'][name='address1']");
    private By addressLine2Field = By.cssSelector("input[type='text'][name='address2']");
    private By cityField = By.cssSelector("input[type='text'][name='city']");
    private By postalCodeField = By.cssSelector("input[id='WC_UserRegistrationAddForm_AddressEntryForm_FormInput_zipCode_1']");
    private By countryField = By.cssSelector("#_country_1");
    private By firstAddress = By.cssSelector(".pnlResults .pcaContent div:nth-of-type(1)");
    private By loginEmailTextField = By.cssSelector("#WC_AccountDisplay_FormInput_logonId_In_Logon_1");
    private By passwordTextField = By.cssSelector("input[type='password'][name='logonPassword']");
    private By loginButton = By.cssSelector("a[role='button'][class='button_primary'][id='WC_AccountDisplay_links_2']");
    private By signOutButton = By.cssSelector(".section_list.bottom_border.sign-out>ul>li>a");
    private By myAccountHeaderText = By.cssSelector("#MyAccountBreadcrumbLink");
    private By logonErrorMessage = By.cssSelector("#logonErrorMessage");
    private By myAddressBookLink = By.cssSelector("div.content_section > div:nth-of-type(2) > ul > li:nth-of-type(3) > a");
    private By addNewAddressButton = By.linkText("+ Add New Delivery Address");
    private By addressNameTextField = By.cssSelector("#nickName");
    private By firstNameTextField = By.cssSelector("#firstName");
    private By lastNameTextField = By.cssSelector("#lastName");

    private By addressLine1TextField = By.cssSelector("div.HAddressBlock > div:nth-of-type(1) > div:nth-of-type(2) > input");
    private By cityTextField = By.cssSelector("[name='city']");
    private By postCodeTextField = By.cssSelector("[name='zipCode']");
    private By phoneNumberTextField = By.cssSelector("div > div:nth-of-type(6) > input");
    private By addAddressSubmitButton = By.linkText("Add Address");
    private By errorMessageOnFields = By.cssSelector("div.dijitTooltipContainer.dijitTooltipContents");
    private By addressBook = By.linkText("My Address BookModel");
    private By removeAddress = By.linkText("Remove Address");

    public void clickOnAddressSubmitButton(){
     WebElement element = waitForExpectedElement(addAddressSubmitButton);
     jsClick(element);
    }


    public void addressSelected(){
        waitForExpectedElement(addressContainer);
         WebElement element = waitForExpectedElement(addressContainer);
        Actions a = new Actions(getWebDriver());
        elementToBeVisible(addressContainer);
        a.moveToElement(element).click();
        a.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN);
        a.sendKeys(Keys.ENTER).build().perform();
        System.out.println("element successfully selected");






        }

    public void clickMyAddressLink() {

             waitForExpectedElement(myAddressBookLink).click();
    }


    public void clickOnRemoveAddressLink(){

        WebElement element = waitForExpectedElement(removeAddress);
        ((JavascriptExecutor) webDriver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
            if(element.isDisplayed())
            element.click();
    }

    public void clickOnAddNewAddressButton() {
        ((JavascriptExecutor) webDriver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        elementToBeClickable(addNewAddressButton).click();
    }


    public void clickMyAccountLink() {
       // System.out.println("Account link clicked" + myAccountLink);
              waitForExpectedElement(myAccountLink).click();
         //     System.out.println("account link");
    }

      /*  List<WebElement> l = webDriver.findElements(By.tagName("a"));

        l.get(8).click();*/
//          int x = l.size();
//          System.out.println(x);//
//          for(int i =0; i<=l.size()-1;i++)
//          {
//              System.out.println(i);
//            String b = l.get(i).getText();
//              System.out.println("All the elements inside the div tag are: " +b);



   /* public WebElement passwordText() {
        return waitForExpectedElement(passwordText);
    }*/


    public void clickOnRegisterbutton() {
        ((JavascriptExecutor) webDriver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        elementToBeClickable(registerButton).click();

    }


    public  void clickAddressBook(){
        waitForExpectedElement(addressBook).click();
    }


//        List<WebElement> l  = webDriver.findElements(By.tagName("a"));
//        int x = l.size();
//        System.out.println(x);
//        for (int i = 0; i <= l.size() - 1; i++) {
//            System.out.println(i);
//            String b = l.get(i).getText();
//            System.out.println("All the elements inside the div tag are: " + b);
//
//        }


    /*public void fillAccountForm() throws InterruptedException {
       waitForExpectedElement(titleField);
       element(titleField).sendKeys("Mr");
       new Select(waitForExpectedElement(titleField)).selectByVisibleText(titleData);


          }*/


    public Select selectTitle() {
        return new Select(waitForExpectedElement(titleList));
    }

    public Select seletDateofBirthDate() {
        return new Select(waitForExpectedElement(dateOfBirthDateField));
    }

    public WebElement firstNameText()

    {
        return getWebDriver().findElement(firstNameField);
    }

    public WebElement lastNameText()

    {
        return getWebDriver().findElement(lastNameField);
    }

    public WebElement phoneNumberText() {
        return getWebDriver().findElement(phoneNumberField);
    }


    public WebElement passwordText() {
        return getWebDriver().findElement(passwordField);
    }

    public WebElement verifyPasswordText() {
        return getWebDriver().findElement(verifyPasswordField);
    }

    public WebElement emailAddressText() {
        return getWebDriver().findElement(emailAddressField);
    }

    public WebElement addressSelection() {
        return waitForExpectedElement(addressField);
    }


    public void submitButton() {
        jsClick(waitForExpectedElement(submitButton));


    }

    public WebElement myAccountPageText() {
        return getWebDriver().findElement(myAccountHeaderText);
    }

   /* public void enterAddressManuallyLink() {

        scrollAndClick(waitForExpectedElement(enterAddressManuallyLink));

    }*/


    //List<WebElement> l = webDriver.findElements(By.tagName("a"));

    // int x = l.size();
    //l.get(298).click();
//        System.out.println(x);
//        for (int i = 0; i <= l.size() - 1; i++) {
//            System.out.println(i);
//            String b = l.get(i).getText();
//            System.out.println("All the elements inside the div tag are: " + b);
//
//        }


    public WebElement addressLine1() {
        return getWebDriver().findElement(addressLine1Field);
    }


    public WebElement addressLine2() {
        return getWebDriver().findElement(addressLine2Field);
    }


    public WebElement postalCode() {
        return getWebDriver().findElement(postalCodeField);
    }


    public WebElement city() {
        return getWebDriver().findElement(cityField);
    }


    public WebElement country() {
        return getWebDriver().findElement(countryField);
    }


    public WebElement enterAddressManual() {
        return getWebDriver().findElement(enterAddressManuallyLink);
    }

    public WebElement address() {

        return getWebDriver().findElement(firstAddress);
    }
    public WebElement addressFinderText()
    {
        return waitForExpectedElement(addressSuggestions);
    }



  /*  public WebElement dateOfBirthText()
    {
        return getWebDriver().findElement(dateOfBirthDateField);
    } */

    public void enterUserRegistrationDetails() {

        selectTitle().selectByVisibleText(titleData);
        waitForExpectedElement(firstNameField).sendKeys(firstNameData);
        waitForExpectedElement(lastNameField).sendKeys(lastNameData);
        waitForExpectedElement(phoneNumberField).sendKeys(phoneNumberData);
        waitForExpectedElement(emailAddressField).sendKeys(emailAddressData);
        waitForExpectedElement(passwordTextField).sendKeys(passwordData);
        waitForExpectedElement(verifyPasswordField).sendKeys(verifyPasswordData);

//        lastNameText().sendKeys(lastNameData);
//        phoneNumberText().sendKeys(phoneNumberData);
//        emailAddressText().sendKeys(emailAddressData);
//        passwordText().sendKeys(passwordData);
//        verifyPasswordText().sendKeys(verifyPasswordData);
//        seletDateofBirthDate().selectByVisibleText(dateOfBirthDateData);
//        addressFinderText().sendKeys(addressFinderData);


    }


    public void enterAddressManually()

    {
//        WebElement element = elementToBeVisible(enterAddressManuallyLink);
//        element.click();
        addressLine1().sendKeys("dfdsfsdsd");
        addressLine2().sendKeys("sdfsdfsdfs");
        city().sendKeys("London");
        postalCode().sendKeys("wd171da");
        country().sendKeys("United Kingdom");

        waitForExpectedElement(enterAddressManuallyLink);
    }


    public void selectDateOfBirth() {


        Select S = new Select(getWebDriver().findElement(dateOfBirthDateField));
        S.selectByIndex(4);

    }


    public void selectMonthOfBirth() {
        Select a = new Select(getWebDriver().findElement(monthField));

        a.selectByIndex(2);
        waitForExpectedElement(yearField);

    }


    public void selectYearOfBirth() {

        Select b = new Select(getWebDriver().findElement(yearField));
        b.selectByIndex(3);


    }


    public void addressFinder() {

        WebElement element = elementToBeVisible(enterAddressManuallyLink);
        jsClick(element);
    }






   public void enterAddressSuggestField() {
       WebElement element = webDriver.findElement(addressSuggestField);
       element.sendKeys(addressFinderData);
   }



      // waitForExpectedElement(addressSuggestField).sendKeys(addressFinderData);




        //WebElement addressTextBox = elementToBeVisible(addressField);
       /*addressTextBox.sendKeys("wd171da");
       elementToBeVisible(addressSuggestions);
       //jsClick(elementToBeVisible(firstAddress));
       Actions a = new Actions(getWebDriver());
       a.sendKeys(Keys.ARROW_DOWN).build().perform();
       a.click().build().perform();*/
        //a.build().perform();

/*
       Actions a = new Actions(webDriver);
      a.moveToElement(getWebDriver().findElement(addressSuggestions));
      waitForExpectedElement(addressField);
      element.sendKeys("wd171da");
      element = getWebDriver().findElement(addressSuggestions);
       waitForExpectedElement(addressSuggestions);
       scrollAndClick(waitForExpectedElement(firstAddress));
       address().click();
*/


//       WebElement element = getWebDriver().findElement(addressField);
//       element.sendKeys("wd171da");
//       waitForExpectedElement(addressSuggestions);
//       Actions a = new Actions(webDriver);
//       a.moveToElement(getWebDriver().findElement(addressSuggestions));
//       a.click(element).build().perform();
//       a.sendKeys(Keys.ARROW_DOWN).build().perform();
//       a.sendKeys(Keys.ENTER);
//       a.build().perform();
//       a.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ARROW_DOWN)).sendKeys(Keys.ENTER).perform();


      //  waitForExpectedElement(submitButton);
    //}


    public WebElement loginEmailAddress() {
        return waitForExpectedElement(loginEmailTextField);
    }

    public WebElement loginPassword() {
        return waitForExpectedElement(passwordTextField);

    }

   public void  loginButtonClick() {
       ((JavascriptExecutor) webDriver)
               .executeScript("window.scrollTo(0, document.body.scrollHeight)");
         elementToBeClickable(loginButton).click();

    }


    public void signOutButtonClick() {
        elementToBeClickable(signOutButton).click();
    }





    public void enterLoginCredentials() {
        waitForExpectedElement(loginEmailTextField).sendKeys(loginEmailData);
        waitForExpectedElement(passwordTextField).sendKeys(loginPasswodData);
        //waitForExpectedElement(loginButton).click();
    }




    public void enterEmailAddress(String Email) {

        waitForExpectedElement(loginEmailTextField).sendKeys(Email);
        //waitClearEnterText(loginEmailTextField,Email);


    }


    public void enterPassword(String Password) {

        waitForExpectedElement(passwordTextField).sendKeys(Password);
        // /waitClearEnterText(passwordTextField,Password);
    }


    public void enterInvalidLoginDetails(UserDetailsModel userDetails) {
        waitClearEnterText(loginEmailTextField, userDetails.getEmail());
        waitClearEnterText(passwordTextField, userDetails.getPassword());
        ((JavascriptExecutor) webDriver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        waitForExpectedElement(loginButton).click();

    }




/*
       loginEmailAddress()
       loginPassword().sendKeys(loginPasswodData);
       loginButtonClick().click();
       waitForExpectedElement(signOutButton);
       signOutButtonClick();
*/

    public String errorMessageInvalidLogin() {
        return waitForExpectedElement(logonErrorMessage).getText();

    }

    public void enterAutoAddressDetails(){
        waitForExpectedElement(addressNameTextField).sendKeys(addressNameData);
        waitForExpectedElement(firstNameTextField).sendKeys(firstNameData);
        waitForExpectedElement(lastNameTextField).sendKeys(lastNameData);

    }


    public  void enterAutoAddressPhoneNumber(){
        ((JavascriptExecutor) webDriver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        elementToBeVisible(phoneNumberTextField).sendKeys("07932689584");
    }

    public void enterNewAddressMandatoryDetails(DeliveryAddressModel deliveryAddressModel) {

        waitClearEnterText(addressNameTextField, deliveryAddressModel.getAddressName());
        waitClearEnterText(firstNameTextField, deliveryAddressModel.getFirstName());
        waitClearEnterText(lastNameTextField, deliveryAddressModel.getLastName());
        waitForExpectedElement(enterAddressManuallyLink).click();
        waitClearEnterText(addressLine1TextField, deliveryAddressModel.getAddressline1());
        waitClearEnterText(cityTextField, deliveryAddressModel.getCity());
        waitClearEnterText(postCodeTextField, deliveryAddressModel.getPostalcode());
        waitClearEnterText(phoneNumberTextField, deliveryAddressModel.getPhoneNumber());
        waitForExpectedElement(addAddressSubmitButton).click();

    }


    public String fieldValidationMessage(String fieldName) {
        if (fieldName.equalsIgnoreCase("addressName")) {
            return waitForExpectedElement(errorMessageOnFields).getText();
        } else if (fieldName.equalsIgnoreCase("firstName")) {
            return waitForExpectedElement(errorMessageOnFields).getText();
        } else if (fieldName.equalsIgnoreCase("lastName")) {
            return waitForExpectedElement(errorMessageOnFields).getText();
        } else if (fieldName.equalsIgnoreCase("addressLine1")) {
            return waitForExpectedElement(errorMessageOnFields).getText();
        } else if (fieldName.equalsIgnoreCase("city")) {
            return waitForExpectedElement(errorMessageOnFields).getText();
        } else if (fieldName.equalsIgnoreCase("postalCodeField")) {
            return waitForExpectedElement(errorMessageOnFields).getText();
        } else {
            return waitForExpectedElement(errorMessageOnFields).getText();

        }
       }



}





















