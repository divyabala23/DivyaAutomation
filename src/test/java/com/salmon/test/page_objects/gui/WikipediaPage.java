package com.salmon.test.page_objects.gui;

import com.salmon.test.framework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WikipediaPage extends PageObject {
    private By searchField = By.id("searchInput");

    private By languaugeSelectArrowKey = By.cssSelector("[id='searchLanguage'][name='language']");

    private By searchButton = By.cssSelector("[class='pure-button pure-button-primary-progressive']");

    private By searchResultsText = By.xpath("//h1[@id='firstHeading']");

    private By englishLangLink = By.xpath("//div[@id='p-lang']//a[text()='English']");



    public WebElement enterDataInSearchField(){
        return   waitForExpectedElement(searchField);

    }


    public void selectTheLanguage(String language){
        Select s = new Select(getWebDriver().findElement(languaugeSelectArrowKey));
        if(language.equalsIgnoreCase("English"))
            s.selectByValue("en");
        else if (language.equalsIgnoreCase("Deutsh"))
            s.selectByValue("de");
        else throw new RuntimeException("Please select English or Deutsh");


    }


    public void clickOnSearch(){

        waitForExpectedElement(searchButton).click();
    }



    public String isSearchResultDataDisplayed(){

        return waitForExpectedElement(searchResultsText).getText();

    }

    public  boolean isTextInEnglishDisplayed(){

        return waitForExpectedElement(searchResultsText).isDisplayed();
    }


    public String isEnglishLanglinkDisplayed(){
        waitForExpectedElement(englishLangLink).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        return waitForExpectedElement(englishLangLink).getText();
    }


    public void clickOnEnglishLanguageLink(){

        waitForExpectedElement(englishLangLink).click();
    }


}
