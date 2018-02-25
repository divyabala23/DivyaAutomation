package com.salmon.test.page_objects.gui;

import com.salmon.test.framework.PageObject;

import com.salmon.test.models.cucumber.PlpSortOptionsModel;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class HotterPLPPage extends PageObject {


private String searchShoes = "shoes";

private By womensCategoryLink = By.cssSelector("#menu > li:nth-of-type(1) > a");

private By priceRangeCheckBox = By.xpath("//input[type='checkbox'][@id='facet_checkbox-0.00 - 50.00']");
private By sortByDropDown = By.id("sortby");

private By newestIn = By.cssSelector("div.content > div:first-child > div.sorting_controls > select");

private By nameAZ = By.cssSelector("//*[text()='Newest In']");

private By searchTextField = By.cssSelector("#SimpleSearchForm_SearchTerm");

private By searchIcon = By.cssSelector("#search_submit");


private By searchResultsText = By.cssSelector("div span#search_results_msg[role='heading'][aria-level='1']");

private By termsAndConditions = By.cssSelector("div.footfleft.footterms > div:nth-of-type(1) > a");

private By privacyPolicy = By.cssSelector("div.footfleft.footterms > div:nth-of-type(3) > a");

private By cookiePolicy = By.cssSelector("div.footfleft.footterms > div:nth-of-type(5) > a");

private By glossary = By.cssSelector("div.footfleft.footterms > div:nth-of-type(7) > a");

private By modernSlaveryStatement = By.cssSelector("div.footfleft.footterms > div:nth-of-type(9) > a");

private By hottersLogo = By.cssSelector("div.desklogo > div > a > img.initial.loading");


private By termsAndCondTitle = By.cssSelector("div.main_content > div.widget_height > div:nth-of-type(1) > div:nth-of-type(1)");


private By privacyAndSecurityTitle = By.cssSelector("#right_content > div:nth-of-type(1)");

private By cookiePolicyTitle = By.cssSelector("div.widget_height > div > div:nth-of-type(1) > div:nth-of-type(5)");


private By glossaryPageTitle = By.cssSelector("#bod > div:nth-of-type(2) > div:nth-of-type(2)");

private By modernSlaveryTitle = By.cssSelector("div.main_content > div.widget_height > div:nth-of-type(1) > div > div");




public void clickOnWomensCategoryLink(){
    elementToBeClickable(womensCategoryLink).click();


}

public void clickOnPriceRangeCheckBox(){
    ((JavascriptExecutor) webDriver)
            .executeScript("window.scrollTo(0, document.body.scrollHeight)");
   waitForExpectedElement(priceRangeCheckBox);
    elementToBeClickable(priceRangeCheckBox).click();
}



public Boolean termsAndConditionsTitleIsDisplayed(){

    return waitForExpectedElement(termsAndCondTitle).isDisplayed();
}



public Boolean privacySecurityTitleIsDisplayed(){
    return waitForExpectedElement(privacyAndSecurityTitle).isDisplayed();
}


public Boolean cookiePolicyTitleIsDisplayed(){
    return waitForExpectedElement(cookiePolicyTitle).isDisplayed();

}


public Boolean glossaryPageTitleIsDisplayed(){
    return waitForExpectedElement(glossaryPageTitle).isDisplayed();
}




public Boolean modernSlaveryTitleIsDisplayed(){
    return waitForExpectedElement(modernSlaveryTitle).isDisplayed();
}


public WebElement sortByDropDownOptions(){
    return elementToBeClickable(sortByDropDown);

}


 public void enterSearchFieldShoeText() {
       waitForExpectedElement(searchTextField);
       elementToBeClickable(searchTextField).sendKeys(searchShoes);
    }

 public void clickSearchHomeIcon() {
        waitForExpectedElement(searchIcon).click();
    }


    public  Boolean searchResultsTextisDisplayed(){

    return  waitForExpectedElement(searchResultsText).isDisplayed();
    }





//public void clickOnSortBy(String sortoption){
//    switch (sortoption){
//
//        case "Most Relevant":
//            waitForExpectedElement(sortByDropDown).click();
//            break;
//        case "" :
//
//    }


    public void selectTheDropDown() {

        waitForExpectedElement(sortByDropDown).click();

        Select s = new Select(sortByDropDownOptions());
        s.selectByVisibleText("Newest In");

    }


    public void selectTheSecondOption(){
    Select s = new Select (sortByDropDownOptions());
        s.selectByVisibleText("Name (A-Z)");
    }



   public void selectTheThirdOption(){
       Select s = new Select (sortByDropDownOptions());
       s.selectByVisibleText("Name (Z-A)");

   }

   public void selectTheFourthOption(){
       Select s = new Select (sortByDropDownOptions());
       s.selectByVisibleText("Price (High to Low)");
   }



   public void selectTheFifthOption(){
       Select s = new Select (sortByDropDownOptions());
       s.selectByVisibleText("Price (Low to High)");
   }



   public void selectSortOptions(String sortOption) {
       waitForExpectedElement(sortByDropDown).click();
       switch (sortOption){
           case "Newest In":
               Select s = new Select(sortByDropDownOptions());
               s.selectByVisibleText("Newest In");
               Assertions.assertThat(searchResultsTextisDisplayed());
           case "Name (A-Z)":
               Select s1 = new Select (sortByDropDownOptions());
               s1.selectByVisibleText("Name (A-Z)");
               Assertions.assertThat(searchResultsTextisDisplayed());
           case "Name (Z-A)" :
               Select s2 = new Select (sortByDropDownOptions());
               s2.selectByVisibleText("Name (A-Z)");
               Assertions.assertThat(searchResultsTextisDisplayed());
           case "Price (High to Low)":
               Select s3 = new Select (sortByDropDownOptions());
               s3.selectByVisibleText("Price (High to Low)");
               Assertions.assertThat(searchResultsTextisDisplayed());
           case "Price (Low to High)":
               Select s4 = new Select (sortByDropDownOptions());
               s4.selectByVisibleText("Price (Low to High)");
               Assertions.assertThat(searchResultsTextisDisplayed());

       }


   }

//        List<WebElement> l = webDriver.findElements(By.tagName("div"));
//
//
//        int x = l.size();
//        System.out.println(x);//
//        for (int i = 0; i <= l.size() - 1; i++) {
//            System.out.println(i);
//            String b = l.get(i).getText();
//            System.out.println("All the elements inside the div tag are: " + b);
//
//        }



     public void scrollToTheBottom(){

         ((JavascriptExecutor) webDriver)
                 .executeScript("window.scrollTo(0, document.body.scrollHeight)");
     waitForExpectedElement(termsAndConditions);


}


    public void clickOnTermsAndConditionsLink(){

     waitForExpectedElement(termsAndConditions).click();

}

    public void clickOnPrivacyPolicyLink(){

        waitForExpectedElement(privacyPolicy).click();
    }


    public void clickOnCookiePolicyLink(){

        waitForExpectedElement(cookiePolicy).click();
    }



    public void clickOnGlossaryLink(){
        waitForExpectedElement(glossary).click();
    }



    public void clickOnModernSlaveryStatementLink(){
        waitForExpectedElement(modernSlaveryStatement).click();
    }



    public void clickOnHottersLogo(){
        waitForExpectedElement(hottersLogo).click();
    }


}
