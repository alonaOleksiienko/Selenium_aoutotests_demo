package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
        WebDriver driver;

        // Locators
        private By emailField = By.id("input-email");
        private By passwordField = By.id("input-password");
        private By loginButton = By.xpath("//input[@value='Login']");
        private By warningMessage = By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible");
        private By forgotPasswordLink = By.linkText("Forgotten Password");

        // Constructor
        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        // Actions
        public void enterEmail(String email) {
            driver.findElement(emailField).clear();
            driver.findElement(emailField).sendKeys(email);
        }

        public void enterPassword(String password) {
            driver.findElement(passwordField).clear();
            driver.findElement(passwordField).sendKeys(password);
        }

        public void clickLogin() {
            driver.findElement(loginButton).click();
        }

        public String getWarningMessage() {
            return driver.findElement(warningMessage).getText();
        }

        public boolean isEmailFieldDisplayed() {
            return driver.findElement(emailField).isDisplayed();
        }

        public boolean isPasswordFieldDisplayed() {
            return driver.findElement(passwordField).isDisplayed();
        }

        public boolean isLoginButtonDisplayed() {
            return driver.findElement(loginButton).isDisplayed();
        }

        public boolean isForgotPasswordLinkDisplayed() {
            return driver.findElement(forgotPasswordLink).isDisplayed();
        }
    }

