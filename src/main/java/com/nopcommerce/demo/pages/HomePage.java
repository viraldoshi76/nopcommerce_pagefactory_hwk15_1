package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    public static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBys({@FindBy(xpath = "//div[@class='header-menu']/ul[1]/li/a")})
    List<WebElement> menuList;
    @FindBy(xpath = "//div[@class='page-title']")
    WebElement titleText;
    @FindBy(xpath = "(//a[@href='/computers'])[1]")
    WebElement computerTab;


    public void selectMenu(String menu) {

        for (WebElement element : menuList) {
            if (element.getText().equalsIgnoreCase(menu)) {
                Reporter.log("Clicking on element "+element.toString()+"<br>");
                clickOnElement(element);
                log.info("Clicking on element "+element.toString());
                break;
            }
        }

    }

    public String getActualText() {
        Reporter.log("Getting text from element "+titleText.toString()+"<br>");
        log.info("Getting text from element "+titleText.toString());
        return titleText.getText();
    }

}
