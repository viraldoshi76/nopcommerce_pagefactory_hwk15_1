package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BuildYourOwnComputerPage extends Utility {

    private static final Logger log = LogManager.getLogger(BuildYourOwnComputerPage.class.getName());

    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement buildYourOwnComputerText;

    @FindBy(xpath = "//dd[@id='product_attribute_input_1']/select[@id='product_attribute_1']")
    WebElement processor;

    @FindBy(xpath = "//dd[@id='product_attribute_input_2']/select[@id='product_attribute_2']")
    WebElement rAM;

    @FindBy(xpath = "//ul[@class='option-list']/li[@data-attr-value='7']/input[@id='product_attribute_3_7']")
    WebElement radio400GB;

    @FindBy(xpath = "//li[@data-attr-value='9']/input[@id='product_attribute_4_9']")
    WebElement radioVistaPremium;

    @FindBy(xpath = "//input[@id='product_attribute_5_12']")
    WebElement totalCommander;

    @FindBy(xpath = "//div[@class='product-price']/span[@id='price-value-1']")
    WebElement totalPrice;

    @FindBy(xpath = "//div[@class='add-to-cart-panel']/button[@id='add-to-cart-button-1']")
    WebElement addToCart;

    @FindBy(xpath = "//body/div[@id='bar-notification']/div[1]/p[1]")
    WebElement topGreenBarText;


    public String actualBuildYourOwnComputerText() {
        Reporter.log("Getting build computer text " + buildYourOwnComputerText.toString() + "<br>");
        log.info("Getting build computer text" + buildYourOwnComputerText.toString());
        return buildYourOwnComputerText.getText();
    }

    public void selectIntelPentiumProcessor() {
        Reporter.log("Select processor option " + processor.toString() + "<br>");
        selectByValueFromDropDown(processor,"1");
        log.info("Select processor option " + processor.toString());
    }

    public void select8BGRAM() {
        Reporter.log("Select RAM option " + rAM.toString() + "<br>");
        selectByValueFromDropDown(rAM,"5");
        log.info("Select RAM option " + rAM.toString());
    }

    public void clickOn400GBRadioButton() {
        Reporter.log("Click on radio button " + radio400GB.toString() + "<br>");
        clickOnElement(radio400GB);
        log.info("Click on radio button " + radio400GB.toString());
    }

    public void clickOnVistaPremiumRadioButton() {
        Reporter.log("Click on radio button " + radioVistaPremium.toString() + "<br>");
        clickOnElement(radioVistaPremium);
        log.info("Click on radio button " + radioVistaPremium.toString());
    }

    public void checkBoxTotalCommander() {
        Reporter.log("Click on check box " + totalCommander.toString() + "<br>");
        clickOnElement(totalCommander);
        log.info("Click on check box " + totalCommander.toString());
    }

    public String actualTotalPrice() {
        Reporter.log("Getting total price from element " + totalPrice.toString() + "<br>");
        log.info("Getting total price from element " + totalPrice.toString());
        return totalPrice.getText();
    }

    public void clickToAddBuildProductToCart() {
        Reporter.log("Click on add to cart button " + addToCart.toString() + "<br>");
        clickOnElement(addToCart);
        log.info("Click on add to cart button " + addToCart.toString());
    }

    public String actualTopGreenBarText() {
        Reporter.log("Getting green bar message " + topGreenBarText.toString() + "<br>");
        log.info("Getting green bar message " + topGreenBarText.toString());
        return topGreenBarText.getText();
    }

}
