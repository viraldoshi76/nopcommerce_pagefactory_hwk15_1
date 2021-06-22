package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.security.PublicKey;

public class ComputersPage extends Utility {

    private static final Logger log = LogManager.getLogger(ComputersPage.class.getName());

    @FindBy(xpath = "//h2[@class='title']/a[@href='/desktops']")
    WebElement desktopLink;
    @FindBy(xpath = "//h1[contains(text(),'Computers')]")
    WebElement computerText;

    public String getComputerNavigationText() {
        Reporter.log("Navigate to computer page and verify navigated page welcome text " + computerText.toString() + "<br>");
        log.info("Navigate to computer page and verify navigated page welcome text " + computerText.toString());
        return computerText.getText();
    }

    public void clickOnDesktop() {
        Reporter.log("Click on desktop option "+desktopLink.toString()+"<br>");
        mouseHoverToElementAndClick(desktopLink);
        log.info("Click on desktop option "+desktopLink.toString());
    }

}
