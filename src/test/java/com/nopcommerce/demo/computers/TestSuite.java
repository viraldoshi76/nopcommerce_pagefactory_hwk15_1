package com.nopcommerce.demo.computers;

import com.nopcommerce.demo.customListeners.CustomListener;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputersPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.retryAnalyzer.RetryAnalyzer;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListener.class)
public class TestSuite extends TestBase {



    SoftAssert softAssert;
    ComputersPage computersPage;
    DesktopsPage desktopPage;
    BuildYourOwnComputerPage buildYourOwnComputer;
    HomePage homePage;

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void setUP(){

        softAssert = new SoftAssert();
        computersPage = new ComputersPage();
        desktopPage = new DesktopsPage();
        buildYourOwnComputer = new BuildYourOwnComputerPage();
        homePage =new HomePage();
    }



    @Test(groups = {"smoke","regression"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {


        homePage.selectMenu("computers");
        Thread.sleep(1000);
        computersPage.clickOnDesktop();
        desktopPage.sortByZToA();

        Thread.sleep(1000);
        List<String> actualProductNameList = desktopPage.verifyProductSortedByZToAFilter();
        List<String> sortedProductNameList = new ArrayList<>(actualProductNameList);
        Collections.sort(sortedProductNameList,Collections.<String>reverseOrder());
        Assert.assertEquals(actualProductNameList,sortedProductNameList);
    }

    @Test(groups = {"sanity","regression"})
    public void  verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {


        homePage.selectMenu("computers");
        Thread.sleep(1000);
        computersPage.clickOnDesktop();

        desktopPage.sortByAtoZ();
        Thread.sleep(1000);
        desktopPage.addProductToCart();

        Thread.sleep(1000);
        String expectedBuildYourOwnComputerText = "Build your own computer";
        softAssert.assertEquals(buildYourOwnComputer.actualBuildYourOwnComputerText(),expectedBuildYourOwnComputerText);
        Thread.sleep(1000);
        buildYourOwnComputer.selectIntelPentiumProcessor();
        buildYourOwnComputer.select8BGRAM();
        Thread.sleep(1000);
        buildYourOwnComputer.clickOn400GBRadioButton();
        buildYourOwnComputer.clickOnVistaPremiumRadioButton();
        Thread.sleep(1000);
        buildYourOwnComputer.checkBoxTotalCommander();
        Thread.sleep(1000);
        String expectedTotalPrice = "$1,475.00";
        softAssert.assertEquals(buildYourOwnComputer.actualTotalPrice(),expectedTotalPrice);
        Thread.sleep(1000);
        buildYourOwnComputer.clickToAddBuildProductToCart();
        Thread.sleep(1000);
        String expectedTopGreenBarText = "The product has been added to your shopping cart";
        softAssert.assertEquals(buildYourOwnComputer.actualTopGreenBarText(),expectedTopGreenBarText);

        softAssert.assertAll();
    }

}
