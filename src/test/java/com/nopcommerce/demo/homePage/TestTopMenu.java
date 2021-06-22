package com.nopcommerce.demo.homePage;

import com.nopcommerce.demo.customListeners.CustomListener;
import com.nopcommerce.demo.pages.ComputersPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.retryAnalyzer.RetryAnalyzer;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListener.class)
public class TestTopMenu extends TestBase {

    SoftAssert softAssert;
    HomePage homePage;
    ComputersPage computersPage;

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void setUP(){

        homePage = new HomePage();
        softAssert = new SoftAssert();
        computersPage = new ComputersPage();
    }

    @Test(groups = {"smoke","sanity","regression"})

    public void selectMenuAndClick(){

        homePage.selectMenu("Computers");

        String expectedComputerNavigationText = "Computers";
        String actualComputerNavigationText = computersPage.getComputerNavigationText();
        softAssert.assertEquals(expectedComputerNavigationText,actualComputerNavigationText);

        softAssert.assertAll();
    }

}
