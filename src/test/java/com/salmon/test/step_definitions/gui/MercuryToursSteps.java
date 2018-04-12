package com.salmon.test.step_definitions.gui;


import com.salmon.test.framework.helpers.Props;
import com.salmon.test.framework.helpers.UrlBuilder;
import com.salmon.test.models.cucumber.MercuryLoginUserModel;
import com.salmon.test.models.cucumber.MercuryToursSignUpModel;
import com.salmon.test.page_objects.gui.MercuryToursRegistrationPage;
import com.salmon.test.page_objects.gui.MyAccountSummaryPage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MercuryToursSteps {

    private static final Logger LOG = LoggerFactory.getLogger(MercuryToursSteps.class);

 private MercuryToursRegistrationPage mercuryToursRegistrationPage;


    public MercuryToursSteps(MercuryToursRegistrationPage mercuryToursRegistrationPage){
        this.mercuryToursRegistrationPage = mercuryToursRegistrationPage;

    }

    @Given("^the user is on the \"(.*?)\" page$")
    public void the_user_is_on_the_page(String pageName) throws Throwable {
        if (pageName.equalsIgnoreCase("HOME")) {
            UrlBuilder.startAtHomePage();

        }
    }

    @When("^I enter valid data on page$")
    public void iEnterValidDataOnPage() throws Throwable {
        mercuryToursRegistrationPage.enterRegistrationFormDetails();

    }


    @And("^I click on submit button$")
    public void iClickOnSubmitButton() throws Throwable {
        mercuryToursRegistrationPage.clickOnSubmitButton();

    }


    @And("^I click on register link on home page$")
    public void iClickOnRegisterLinkOnHomePage() throws Throwable {
        mercuryToursRegistrationPage.clickOnRegisterButton();
        assertThat(mercuryToursRegistrationPage.isFirstNameFieldDisplayed());
    }


    @Then("^Thankyou for registration message is displayed$")
    public void thankyouForRegistrationMessageIsDisplayed() throws Throwable {
        assertThat(mercuryToursRegistrationPage.isFooterLinkDisplayed());


    }


    @Then("^the following fields are displayed in the registration form$")
    public void theFollowingFieldsAreDisplayedInTheRegistrationForm(List<MercuryToursSignUpModel> expectedvalues) throws Throwable {

        for(MercuryToursSignUpModel itr : expectedvalues) {

            switch (itr.getFieldName()){

                case "FirstName":
                    assertThat(mercuryToursRegistrationPage.isFirstNameFieldDisplayed());
                    System.out.println("FirstNameField displayed");
                    LOG.debug("This is first test logged");

                    break;
                case "LastName":
                    assertThat(mercuryToursRegistrationPage.isLastNameFieldDisplayed());
                    System.out.println("LastNameField displayed");
                    LOG.debug("This is second test logged");
                    break;
                case "Phone":
                    assertThat(mercuryToursRegistrationPage.isPhoneNumberFieldDisplayed());
                    System.out.println("PhoneNumber textfield displayed");
                    LOG.debug("This is third test logged");
                    break;
                case "Email":
                    assertThat(mercuryToursRegistrationPage.isEmailTextFieldDisplayed());
                    System.out.println("Email textfield displayed");
                    break;
                case "Address":
                    assertThat(mercuryToursRegistrationPage.isAddressTextFieldDisplayed());
                    System.out.println("Address textfield displayed");
                    break;
                case "City":
                    assertThat(mercuryToursRegistrationPage.isCityTextFieldDisplayed());
                    System.out.println("City textfield displayed");
                    break;
                case "State":
                    assertThat(mercuryToursRegistrationPage.isStateTextFieldDisplayed());
                    System.out.println("State textfield displayed");
                    break;
                case "Postalcode":
                    assertThat(mercuryToursRegistrationPage.isPostalCodeTextFieldDisplayed());
                    System.out.println("Postalcode textfield displayed");
                    break;
                case "Country":
                    assertThat(mercuryToursRegistrationPage.isCountrySelectFieldDisplayed());
                    System.out.println("Country textfield displayed");
                    break;
                case "UserName":
                    assertThat(mercuryToursRegistrationPage.isUserNameFieldDisplayed());
                    System.out.println("UserName textfield displayed");
                    break;
                case "Password":
                    assertThat(mercuryToursRegistrationPage.isPasswordTextFieldDisplayed());
                    System.out.println("Password textfield displayed");
                    break;
                case "ConfirmPassword":
                    assertThat(mercuryToursRegistrationPage.isConfirmPasswordTextDisplayed());
                    System.out.println("ConfirmPassword textfield displayed");
                    break;



            }


        }


    }

    @When("^I enter valid login credentials$")

   // public void iEnterValidLoginCredentials(DataTable usercredentials){


        //Method-3  creating as a Map making user name and password as a key value pair.
//        for (Map<String, String> data : usercredentials.asMaps(String.class,String.class))
//        {
//
//            mercuryToursRegistrationPage.userNameFieldInLoginPage().sendKeys(data.get("username"));
//            mercuryToursRegistrationPage.passwordFieldLoginPage().sendKeys(data.get("password"));
//            mercuryToursRegistrationPage.clickOnSubmitSignOnPage();
//            mercuryToursRegistrationPage.userNameFieldInLoginPage().clear();
//
//        }


        //public void iEnterValidLoginCredentials()  {

// Method -1 when you have different test environments
        public void iEnterValidLoginCredentials(){
        mercuryToursRegistrationPage.userNameFieldInLoginPage().sendKeys(Props.getProp("username"));
        mercuryToursRegistrationPage.passwordFieldLoginPage().sendKeys(Props.getProp("password"));
        mercuryToursRegistrationPage.clickOnSubmitSignOnPage();




 //Method-2 creating a model class and putting the header values and getting the data using modals
//         public void iEnterValidLoginCredentials(DataTable userCredentials){
//          List<Map<String, String >> data = userCredentials.asMaps(String.class,String.class);
//          mercuryToursRegistrationPage.userNameFieldInLoginPage().sendKeys(data.get(0).get("username"));
//          mercuryToursRegistrationPage.passwordFieldLoginPage().sendKeys(data.get(0).get("password"));
//          mercuryToursRegistrationPage.clickOnSubmitSignOnPage();
//          mercuryToursRegistrationPage.userNameFieldInLoginPage().clear();
//          mercuryToursRegistrationPage.userNameFieldInLoginPage().sendKeys(data.get(1).get("username"));
//          mercuryToursRegistrationPage.passwordFieldLoginPage().clear();
//          mercuryToursRegistrationPage.passwordFieldLoginPage().sendKeys(data.get(1).get("password"));
//          mercuryToursRegistrationPage.clickOnSubmitSignOnPage();

//      Method -3    Luckily there are easier ways to access your data than DataTable.
//          For instance you can create a Class-Object and have Cucumber map the data in a table to a list of these.
//           public void iEnterValidLoginCredentials(List<MercuryLoginUserModel> enterCredentials) throws Throwable {
//           for(MercuryLoginUserModel obj1 : enterCredentials) {
//            mercuryToursRegistrationPage.enterLoginCredentials(obj1);
//            mercuryToursRegistrationPage.clickOnSubmitSignOnPage();


//           //Method-4  public void iEnterValidLoginCredentials(DataTable usercredentials){
//            creating as a Map making user name and password as a key value pair.
//            for (Map<String, String> data : usercredentials.asMaps(String.class,String.class))
//            {
//
//                mercuryToursRegistrationPage.userNameFieldInLoginPage().sendKeys(data.get("username"));
//                mercuryToursRegistrationPage.passwordFieldLoginPage().sendKeys(data.get("password"));
//                mercuryToursRegistrationPage.clickOnSubmitSignOnPage();
//                mercuryToursRegistrationPage.userNameFieldInLoginPage().clear();
//
//            }

        }
      //        Col 0       Col 1
     // Row 0 | kumar    | ravuri     |
    //  Row 1 | testrav  | sasdsadasd |
    //  Row 2 | divya    | bala       |

    @When("^I enter valid login credentials as listoflist of string$")
    public void iEnterValidLoginCredentialsAsListoflistOfString(DataTable usercredentials)  {

        List<List<String>> data = usercredentials.raw();
        //This is to get the first data of the set (Zeroth Row +  Zeroth Column)
        mercuryToursRegistrationPage.userNameFieldInLoginPage().sendKeys(data.get(0).get(0));
        //This is to get the first data of the set (Zeroth Row + First  Column)
        mercuryToursRegistrationPage.passwordFieldLoginPage().sendKeys(data.get(0).get(1));
        mercuryToursRegistrationPage.clickOnSubmitSignOnPage();

        mercuryToursRegistrationPage.userNameFieldInLoginPage().sendKeys(data.get(1).get(0));
        mercuryToursRegistrationPage.passwordFieldLoginPage().sendKeys(data.get(1).get(1));
        mercuryToursRegistrationPage.clickOnSubmitSignOnPage();

        mercuryToursRegistrationPage.userNameFieldInLoginPage().sendKeys(data.get(2).get(0));
        mercuryToursRegistrationPage.passwordFieldLoginPage().sendKeys(data.get(2).get(1));
        mercuryToursRegistrationPage.clickOnSubmitSignOnPage();

     }


    @And("^I click on login button on MercuryTours Page$")
    public void iClickOnLoginButtonOnMercuryToursPage() throws Throwable {
        mercuryToursRegistrationPage.userNameFieldInLoginPage().sendKeys(Props.getProp("username"));
        mercuryToursRegistrationPage.passwordFieldLoginPage().sendKeys(Props.getProp("password"));
        mercuryToursRegistrationPage.clickOnSubmitSignOnPage();

    }

    @Then("^I should be able to login successfully$")
    public void iShouldBeAbleToLoginSuccessfully() throws Throwable {
        assertThat(mercuryToursRegistrationPage.isFlightFinderImageDisplayed());
        System.out.println("Image displayed");
    }

    @And("^I click on signon button$")
    public void iClickOnSignonButton() throws Throwable {
        mercuryToursRegistrationPage.clickOnSignOnButton();
    }

    @And("^the title is displayed as expected$")
    public void theTitleIsDisplayedAsExpected() throws Throwable {
       mercuryToursRegistrationPage.getCurrentPageTitle();

    }


}
