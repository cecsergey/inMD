package Pages.ForgotPassword;

import Pages.BasePage;
import Utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {
    //*********Constructor*********
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }


    //*********Page Variables*********


    //*********Web Elements*********
    // "Sign in" dropdown button
    final By signInButtonBy = By.id("btn-signin");
    // "Forgor password" link
    final By forgotPasswordLinkBy = By.cssSelector("a.forgot-link");
    // "Forgor password" form's email field
    final By emailBy= By.id("email");
    // "Forgor password" form's submit button
    final By submitButtonBy= By.cssSelector("div[class=\"login-content\"] button[type=\"submit\"]");
    // Error message if invalid username/email specified
    final By errorBy= By.cssSelector("div[role=\"alert\"]");

    public ForgotPasswordPage goToForgotPasswordPage() {
        driver.get(Properties.baseURL);
        click(signInButtonBy); // Click on "Sign In" button - will appear sign in dropdown form
        click(forgotPasswordLinkBy); // Click on "Forgot password" link - will open "Forgot password" page
        return new ForgotPasswordPage(driver);
    }

    public CheckYourEmailPage validUsername(final String username){
        click(emailBy);
        writeText(emailBy, username);
        click(submitButtonBy);
        return new CheckYourEmailPage(driver);
    }

    public ForgotPasswordPage invalidUsername(final String invalidUsername) {
        click(emailBy);
        writeText(emailBy, invalidUsername);
        click(submitButtonBy);
        return this;
    }

    public ForgotPasswordPage VerifyErrorMessage() {
        assertVisible(errorBy);
        return this;
    }
}
