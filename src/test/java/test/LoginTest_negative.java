package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest_negative extends BaseTest {

    @Test
    public void TC02_invalidPassword() {
        getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail("marta.marta3@gmail.com");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();

        String warning = loginPage.getWarningMessage();
        Assert.assertTrue(warning.contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @Test
    public void TC03_invalidEmail() {
        getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail("invalid@domain.com");
        loginPage.enterPassword("123456AB");
        loginPage.clickLogin();

        String warning = loginPage.getWarningMessage();
        Assert.assertTrue(warning.contains("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
    }

    @Test
    public void TC04_emptyFields() {
        getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        String warning = loginPage.getWarningMessage();
        Assert.assertTrue(warning.length() > 0);
    }

    @Test
    public void TC05_UIElementsPresence() {
        getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isEmailFieldDisplayed(), "Email field not visible");
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field not visible");
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button not visible");
        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(), "Forgotten password link not visible");
    }
}