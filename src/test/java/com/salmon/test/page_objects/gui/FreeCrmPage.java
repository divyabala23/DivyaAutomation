package com.salmon.test.page_objects.gui;

import com.salmon.test.framework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FreeCrmPage extends PageObject {

   // private By  signUpLink =By.xpath("//*[text()='Sign Up'][]");
            //By.cssSelector("//div ul li a[href='https://www.freecrm.com/register/']");
            //By.xpath("[text()='Sign Up']");



    public void clickOnSignUpLink(){

        List<WebElement> element = webDriver.findElements(By.tagName("a"));

        {

            for (int i = 0; i < element.size()-1; i++) {
                //element.get(7).click();


                System.out.println(i);
                String b = element.get(i).getText();
                System.out.println("All the elements inside the a tag are: " + b);
            }
        }

    }




}
