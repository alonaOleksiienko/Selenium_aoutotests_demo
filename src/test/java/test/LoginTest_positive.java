package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest_positive extends BaseTest {

    @Test
    public void TC01_validLogin_shouldRedirectToAccountPage() {
        getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail("marta.marta3@gmail.com");
        loginPage.enterPassword("123456AB");
        loginPage.clickLogin();

        String expectedTitle = "My Account";
        Assert.assertTrue(getDriver().getTitle().contains(expectedTitle),
                "Expected page title to contain: " + expectedTitle);
    }

}
